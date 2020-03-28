$a = 5,6,7,8,9
$a | ForEach {write-host $_}

ForEach($value in $a) {
  write-host $value
}

For ($a=1; $a -le 5; $a++) {
  write-host $a
}

$a = 1
do {write-host $a; $a++}
while ($a -lt 5 )

$a = 1
do {write-host $a; $a++}
until ($a -lt 5 )