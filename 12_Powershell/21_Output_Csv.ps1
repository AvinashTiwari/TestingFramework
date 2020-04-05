Get-Service | Export-Csv E:\TestingFrameWork\12_Powershell\svc.csv
$s = Import-Csv  E:\TestingFrameWork\12_Powershell\svc.csv
$s