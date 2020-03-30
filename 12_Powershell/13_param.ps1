Param (
[Parameter(Mandatory=$true)]
[string]$username
)

$a = $username
Write-Host "Hello $a"