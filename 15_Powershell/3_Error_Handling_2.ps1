$Clients = "DC1" , "BadName" , "Svr1"

Foreach($C in $Clients)
{

Try {
   Invoke-Command -ComputerName $C -ErrorAction Stop -ScriptBlock {
      Get-CimInstance -ClassName Win32_Bios
   }
 
}
Catch{
   Write-Warning "Client $C Offline"
  
}
Finally {
   Write-Host "Done with Client : $C" -ForegroundColor Green
}
}


$Error[0]
$Error[0] | GM
$Error[0].Exception.GetType().fullname

