Get-AdUser -Filter {Name -eq 'Administrator'} -Properties MemberOf

Get-ADUser -Filter {Name -eq 'Administrator'} -Properties MemberOf |
            Export-Csv C:\PowerShell\Admin.csv

Import-Csv -Path C:\PowerShell\Admin.csv


Get-ADUser -Filter {Name -eq 'Administrator'} -Properties MemberOf |
     Export-Clixml -Path C:\PowerShell\Admin.Xml

Import-Clixml -Path C:\PowerShell\Admin.Xml