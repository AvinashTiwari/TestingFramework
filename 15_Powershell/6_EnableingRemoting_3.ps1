New-PSSessionConfigurationFile -Path C:\HelpDesk.pssc -SessionType RestrictedRemoteServer

Get-Help Register-PSSessionConfiguration -ShowWindow

Register-PSSessionConfiguration -Path C:\HelpDesk.pssc `
   -Name "HelpDesk" `
   -ShowSecurityDescriptorUI

Get-PSSessionConfiguration