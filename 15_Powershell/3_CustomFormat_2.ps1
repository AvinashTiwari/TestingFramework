Function Get-OSInfo
{
  Function New-OSObject
        {
          $Obj = New-Object -TypeName PSObject -Property @{
           Caption = $Null
           TotalVM = $Null
           MaxProcessorMS = $Null
           InstallDate = $Null
           Locale = $Null
           Language = $Null
           CreationClass = $Null
           OSType = $Null
          
          }

          $Obj.PSObject.TypeNames.Insert(0, 'OSInfo')
          Write-Output $Obj
         
        }

        $Obj = New-OSObject
        $OS = Get-CimInstance -ClassName Win32_OperatingSystem
        $Obj.Caption = $OS.Caption
        $Obj.TotalVM = $OS.TotalVirtualMemorySize
        $Obj.MaxProcessorMS = $OS.MaxProcessMemorySize
        $Obj.InstallDate = $OS.InstallDate
        $Obj.Locale = $OS.Locale
        $Obj.Language = $OS.MUILanguages
        $Obj.CreationClass = $OS.CreationClassName
        $Obj.OSType = $OS.OSType

        Write-Output $Obj


}

Update-FormatData -PrependPath C:\PowerShell\3_CustomFormat_2.ps1xml