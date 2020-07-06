$Names = "DC1", "Svr1"

$Data = forEach($N in $Names)
{
   $OS = Get-CimInstance -ComputerName $N -ClassName Win32_OperatingSystem
   $Bios = Get-CimInstance -ComputerName $N -ClassName Win32_Bios

   $Obj = New-Object -TypeName PSObject -Property @{
      Caption = $OS.Caption
      OSVersion = $OS.Version
      BiosSerial = $Bios.SerialNumber
   }

   Write-Output $Obj 

}
$Data | Select-Object -Property Caption, @{

          Name = "Version"
          Expression = {$_.OSversion.Remove(3)}
}