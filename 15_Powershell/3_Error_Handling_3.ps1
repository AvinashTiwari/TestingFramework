$Clients = "DC1" , "BadName" , "Svr1"

Foreach($C in $Clients)
{

Try {
   Invoke-Command -ComputerName $C -ErrorAction Stop -ScriptBlock {
      Get-CimInstance -ClassName Win32_Bios
   }
 
}
Catch [System.Management.Automation.Remoting.PSRemotingTransportException]{
   Write-Warning "Client $C Offline"
  
}
Catch{
   Write-Warning "Unknow error"
  
}
Finally {
   Write-Host "Done with Client : $C" -ForegroundColor Green
}
}



