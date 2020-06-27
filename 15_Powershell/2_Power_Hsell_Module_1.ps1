Function Get-BiosInfo {
  Get-CimInstance -ClassName Win32_Bios
}

Function Get-OSInfo {

  Get-CimInstance -ClassName Win32_OperatingSystem
}