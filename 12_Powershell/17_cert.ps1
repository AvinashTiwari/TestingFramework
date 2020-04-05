set-location cert:
Get-ChildItem
Get-ChildItem -Recurse -Path Cert:\LocalMachine | Export-csv "d:\mlcert.csv"
Invoke-Item "d:\mlcert.csv"