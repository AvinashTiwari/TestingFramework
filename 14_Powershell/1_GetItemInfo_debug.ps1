function Get-ItemInfo($Path) {
    $itemProperties = Get-ChildItem -Path $Path | Select-Object Name, FullName, CreationTime, LastWriteTime
    $Owner = (Get-Acl -Path $Path).Owner

    $result = [PSCustomObject] @{
        Name         = $itemProperties.Name
        FullName     = $itemProperties.FullName
        CreationTime = $itemProperties.CreationTime
        ModifiedDate = $itemProperties.LastWriteTime
        Owner        = $Owner
    }

    return $result
    
}