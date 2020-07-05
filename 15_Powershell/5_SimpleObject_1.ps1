Get-Process |
   Select-Object -First 5 -Property Name, CPU, VM, WS



Get-Process |
    Select-Object -First 5 -Property Name, CPU ,
      @{
      
         Name="VMWS"
         Expression = {$_.VM + $_.WS}
      }


$Obj = New-Object -TypeName PSObject -Property @{

    Name = $null
    Date = Get-Date -Format ddmmyy
    City = $null
}

$obj.Name = "Avinash"
$obj.City =  "denver"

$obj

$obj |Get-Member

$obj.PSObject.TypeNames.Insert(0, 'MyObject.UserInfo')
$obj | Get-Member


