# OneToMany-Code1

# Invoke-Command -ComputerName and -ScriptBlock parameters
Invoke-Command -ComputerName CL1, SVR1 -ScriptBlock {
    Get-CimInstance -ClassName Win32_Bios
}

# Parameters can be in any order.
Invoke-Command -ScriptBlock {
    Get-CimInstance -ClassName Win32_Bios
} -ComputerName CL1, SVR1

# Invoke-Command -FilePath parameter.
Invoke-Command -ComputerName CL1, SVR1 -FilePath "E:\ps\OneToMany-Code2.ps1"

# Invoke-Command -Credential parameter.
Invoke-Command -Credential PowerIT\Administrator `
               -ComputerName CL1, SVR1 `
               -FilePath "E:\ps\OneToMany-Code2.ps1"

# Invoke-Command -ThottleLimit parameter.
Invoke-Command -ThrottleLimit 10 `
               -ComputerName CL1, SVR1 `
               -FilePath "E:\ps\OneToMany-Code2.ps1"


# Providing the -ComputerName parameter with values
Get-Help Invoke-Command -Parameter ComputerName

# By List
Invoke-Command -ComputerName CL1, SVR1 -FilePath "E:\ps\OneToMany-Code2.ps1"

# By Text File
"CL1", "SVR1" | Out-File -FilePath e:\PS\ComputerNames.txt
Invoke-Command -ComputerName (Get-Content -Path E:\ps\ComputerNames.txt) `
               -FilePath "E:\ps\OneToMany-Code2.ps1"

# By CSV File
"ComputerName"| Out-File -FilePath e:\PS\ComputerNames.csv
"CL1", "SVR1" | Out-File -FilePath e:\PS\ComputerNames.csv -Append

Invoke-Command -ComputerName (Import-CSV -Path E:\ps\ComputerNames.csv |
                                Select-Object -ExpandProperty ComputerName) `
               -FilePath "E:\ps\OneToMany-Code2.ps1"

# By Active Directory
Invoke-Command -ComputerName (Get-ADComputer -filter * |
                                Select-Object -ExpandProperty Name) `
               -FilePath "E:\ps\OneToMany-Code2.ps1"


# Working with Object Methods and remote clients
# Methods are present on the remote client. 
Invoke-Command -ComputerName SVR1 -ScriptBlock {
    Get-WmiObject -Class Win32_OperatingSystem | 
    Get-Member -MemberType Methods
}

# Methods are not sent to the local client.
Invoke-Command -ComputerName SVR1 -ScriptBlock {
    Get-WmiObject -Class Win32_OperatingSystem 
} | 
    Get-Member -MemberType Methods

# Methods can be called on the remote client.
Invoke-Command -ComputerName SVR1 -ScriptBlock {
    Get-WmiObject -Class Win32_OperatingSystem |
    Invoke-WmiMethod -Name Reboot
}

# A remote clients methods cannot be called for a remote
# client from the local client.
Invoke-Command -ComputerName SVR1 -ScriptBlock {
    Get-WmiObject -Class Win32_OperatingSystem 
} |
    Invoke-WmiMethod -Name Reboot
 

