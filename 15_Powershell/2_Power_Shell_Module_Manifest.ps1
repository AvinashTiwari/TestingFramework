
$Path =  "$env:UserProfile\Documents\WindowsPowerShell\Modules\Mycode\MyCode.psd1" 

New-ModuleManifest -Path $Path `
                   -Author ="Avinash Tiwari" `
                   -CompanyName = "My PowerShell Module" `
                   -Description = "Mycode.psm1"`
                   -ModuleVersion 1.1
                   -PowerShellVersion 4.0 