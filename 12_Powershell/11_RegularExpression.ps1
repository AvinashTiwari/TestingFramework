"Microsoft" -match "soft"
"Software" -match "soft"
"Software" -cmatch "soft"

$ip ="192.168.15.20"
$rx= "\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}"

$ip -match $rx