$OS = Get-CimInstance -Class Win32_OperatingSystem

$OS | Get-Member

$OS.InstallDate | Get-Member

$OS.InstallDate | Select-object -ExpandProperty DayOfYear

$OS.InstallDate.DayOfYear

$User =  Get-ADUser -Filter {Name -eq "Administrator" } -Properties MemberOf
$User
$User.MemberOf