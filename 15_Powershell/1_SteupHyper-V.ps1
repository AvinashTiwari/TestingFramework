#region Setup Virtual Switches
New-VMSwitch -Name PSTestss -SwitchType Private -Notes "Switch for the Sandbox"

# Get a list of all NICs that have a Gateway address.
Get-WmiObject win32_networkAdapterConfiguration |
    Where defaultipgateway -ne $null |
    Select-Object -Property Description |
    Out-GridView -PassThru |
    ForEach-Object -Process {
        $Splat = @{
            NetAdapterInterfaceDescription = $_.Description
            Name = "PSExternalss"
            AllowManagementOS = $True
            Notes = "External Switch for the Sandbox"
            Verbose = $True
        }
        New-VMSwitch @Splat  
}

$ISOPath = "d:\9600.16384.iso"
$VHDPath = "D:\VM"

 # Create the VM.
 $Names = "DC", "SVR1"
 ForEach ($Name in $Names)
 {
   $VMHash = @{BootDevice = "CD"
               MemoryStartupBytes = 512MB
               Name = $Name
               SwitchName = "PSTest"
               NewVHDPath = "$($VHDPath)\$($Name).vhdx";
               NewVHDSizeBytes = 10GB
               Verbose = $True
               }

   New-VM @VMHash 


}

# Configure the DVD drive to point to the ISO file.
 Set-VMDvdDrive -VMName DC -Path $ISOPath -Verbose
  Set-VMDvdDrive -VMName SVR1 -Path $ISOPath -Verbose

# You can adjust the MaximumBytes and MinimumBytes
# to better fit your available RAM.  The settings below
# are for a system with 4 GB of RAM.
$VMMemoryHash = @{
    DynamicMemoryEnabled = $True
    MaximumBytes = 1024MB
    MinimumBytes = 512MB
}
Get-VM -Name DC, SVR1 |
    Set-VMMemory @VMMemoryHash

# If the external NIC was created, run this code.
Get-VM DC, SVR1 | Add-VMNetworkAdapter –Name PSExternal -Verbose
Get-VMSwitch -Name PSExternal |
Connect-VMNetworkAdapter -VMName DC, SVR1 -Name PSExternal -Verbose
#endregion