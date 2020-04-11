function Get-ItemInfo($Path) {
    $itemProperties = Get-ChildItem -Path $Path | Select-Object Name, FullName, CreationTime, LastWriteTime
    $Owner = (Get-Acl -Path $Path).Owner
    $enabled = (Get-LocalUser -Name ($Owner -split '\\')[1])
    Write-Output $enabled
    $result = [PSCustomObject] @{
        Name         = $itemProperties.Name
        FullName     = $itemProperties.FullName
        CreationTime = $itemProperties.CreationTime
        ModifiedDate = $itemProperties.LastWriteTime
        Owner        = $Owner
        OwnerEnabled = $enabled.enabled
    }

    return $result
    
}