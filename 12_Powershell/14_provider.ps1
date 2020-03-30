Get-PSProvider

Get-PSDrive

new-psdrive -name mkdocs -PSProvider filesystem -Root (resolve-path ~/*documents)