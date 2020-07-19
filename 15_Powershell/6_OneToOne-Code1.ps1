# OneToOne-Code1

# Load all the modules.
Get-Module -ListAvailable |
    Select-Object -ExpandProperty Name |
    Import-Module

# Get all Cmdlets that have a -ComputerName parameter.
$All =  Get-Command |
    Where-Object {$_.Parameters.Keys -eq "ComputerName"} |
    Select-Object -Property Name
$All | FW -Column 2

# Cmdlets that do not use PowerShell Remoting.
$NoWsMan = Get-Command | 
    Where {$_.Parameters.keys -contains "ComputerName"} |
    ForEach-Object {
        $Data = Get-Help -Name $_.Name -Parameter ComputerName 
        If ($Data.description -like "*This parameter does not rely on Windows PowerShell remoting.*")
        {
            $_ | Select-Object -Property Name
        } 
    }  
$NoWsMan | Format-Wide -Column 3


# Enter a One-to-One remote session
Get-CimInstance -Query "Select Caption FROM Win32_OperatingSYstem" |
    Select-Object -Property Caption

# Connect to the remote computer
Enter-PSSession -ComputerName CL1

# Get the OS Caption from the remote computer.
Get-CimInstance -Query "Select Caption FROM Win32_OperatingSYstem" |
    Select-Object -Property Caption

# Echo the remote computers name.
Hostname

# Exit the remote connection
Exit-PSSession

# Echo the local computers name.
Hostname


# Using alternate credentials
$Cred = Get-Credential -Credential PowerIT\Administrator
Enter-PSSession -ComputerName CL1 -Credential $Cred
Exit-PSSession
