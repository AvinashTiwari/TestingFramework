Get-Process | Format-Wide

Get-Process | Format-Wide -column 1
Get-Process | Format-List
Get-Process -Name powershell | Format-List -Property ProcessName, FileVersion, StartTime, Id
Get-Process -Name powershell | Format-List -Property 

Get-Process | Format-Table
Get-Process -Name powershell | Format-Table
Get-Process -Name powershell | Format-Table -Property Path, Name, Id, Company
Get-Process -Name powershell | Format-Table -Property Path, Name, Id, Company -AutoSize
Get-Process -Name powershell | Format-Table -Property Company, Name, Id, Path -AutoSize
Get-Process -Name powershell | Format-Table -Wrap -Property Name, Id, Company, Path
Get-Process -Name powershell | Format-Table -Wrap -AutoSize -Property Name, Id, Path -GroupBy Company