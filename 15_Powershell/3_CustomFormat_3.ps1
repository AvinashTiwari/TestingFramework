# CustomFormat - Code 7

# Create our module.

$ModPath = "C:\Users\Administrator\Documents\WindowsPowerShell\Modules\OSModule"

Copy-Item -Path "C:\PowerShell\3_CustomFormat_2.ps1" `
          -Destination "$ModPath\OSModule.psm1"

# Copy our view to the module.
Copy-Item -Path "C:\PowerShell\3_CustomFormat_2.ps1xml" `
          -Destination "$ModPath\3_CustomFormat_2.ps1xml"

# Create a Module Manifest.
New-ModuleManifest -Path "$ModPath\OSModule.psd1" `
                   -Author "Avinash Tiwari" `
                   -ModuleVersion 1.0 `
                   -RootModule "OSModule.psm1" `
                   -FormatsToProcess "3_CustomFormat_2.ps1xml"
                   