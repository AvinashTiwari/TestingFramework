Get-windowsFeature -Name Hyper-V |
  Select-Object -Property Name, Installed

Add-WindowsFeature -Name Hyper-V -IncludeAllSubFeature  -IncludeManagementTools -Restart

$Splat = @{
Name ="Hyper-V"
IncludeAllSubFeature = $True
IncludeManagementTool = $True
Restart = $True
}

Add-WindowsFeature @Splat