#Update-TypeData -PrependPath 'C:\PowerShell\3_CustomCodeType_1.ps1xml'
#Update-TypeData -PrependPath 'C:\PowerShell\3_CustomCodeType_1.2.ps1xml'
#Update-TypeData -PrependPath 'C:\PowerShell\3_CustomCodeType_1.3.ps1xml'
Update-TypeData -PrependPath 'C:\PowerShell\3_CustomCodeType_1.3.ps1xml'

Function  Do-Anything 
{
    $Obj = New-Object -TypeName PSObject -Property @{
      Num1 = 5
      Num2 = 10
      
    }

    $Obj.PSObject.TypeNames.Insert(0,'FunStuff')

    Write $Obj

}



# Set the Path to the module
$Path = "$env:USERPROFILE\Documents\WindowsPowerShell\Modules\CustomType"

# Create the directory structure to support a module.
New-Item -Path $Path -ItemType Directory

# Copy the origional code to the module location.  Rename it to match the
# module location.
Copy-Item -Path 'C:\PowerShell\3_CustomCodeType_1.ps1' `
          -Destination "$Path\CustomType.psm1"
          
# Copy the Types.ps1xml file to the module and rename it
Copy-Item -Path C:\PowerShell\3_CustomCodeType_1.3.ps1xml `
          -Destination "$Path\CustomType.Types.ps1xml"


# Create the manifest.
 New-ModuleManifest -Path "$Path\CustomType.psd1" `
                   -RootModule CustomType `
                   -TypesToProcess CustomType.Types.ps1xml 
