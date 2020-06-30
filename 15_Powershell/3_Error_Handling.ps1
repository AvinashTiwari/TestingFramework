$Clients = "DC1" , "BadName" , "Svr1"

Try {
   Invoke-Command -ComputerName $Clients -ErrorAction Stop -ScriptBlock {
      Get-CimInstance -ClassName Win32_Bios
   }
 
}
Catch{
   Write-Warning "Client Offline"
  
}