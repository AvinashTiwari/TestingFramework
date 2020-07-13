# PipelineOverview-code1

# Get an object
Get-CimInstance -ClassName Win32_LogicalDisk

# Pipeline the object to work with it.
Get-CimInstance -ClassName Win32_LogicalDisk |
    Where-Object DriveType -eq 3

# As long as you have an object, you can continue to pipe it.
Get-CimInstance -ClassName Win32_LogicalDisk |
    Where-Object DriveType -eq 3 |
    Select-Object -Property DeviceID, Size, 
    @{N="FreeSpaceGB";E={$_.FreeSpace/1GB}}

# There is a hidden piped cmdlet at the end of all commands.
# it ensures that any information left at the end of the
# pipeline is sent to the screen.
Get-CimInstance -ClassName Win32_Bios

Get-CimInstance -ClassName Win32_Bios | Out-Default

Get-CimInstance -ClassName Win32_LogicalDisk |
    Where-Object DriveType -eq 3 |
    Select-Object -Property DeviceID, Size, 
    @{N="FreeSpaceGB";E={$_.FreeSpace/1GB}} | Out-Default

# Some cmdlets do not place informaiton in the pipeline so nothing will appear
# on the screen.

Get-CimInstance -ClassName Win32_Bios | Export-Csv -Path c:\ps\Data.csv





