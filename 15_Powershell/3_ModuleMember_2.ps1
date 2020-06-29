$ModPath = "C:\Users\Administrator\Documents\WindowsPowerShell\Modules\DoStuff"
New-Item -Path $ModPath -ItemType Directory

Copy-Item -Path "C:\PowerShell\3_ModuleMember.ps1" `
                 -Destination "$Modpath\DoStuff.psm1"