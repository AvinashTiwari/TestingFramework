# PipelineByValue-Code1

# Explanation of ByValue from About_Pipelines
(Get-help About_Pipelines).split("`n")[292..300]

# Different ways to see the Pipeline information in a help file.
Get-Help Test-Path -Full
Get-Help Test-Path -ShowWindow
Get-Help Test-Path -Online
Get-Help Test-Path -Parameter path

# Take note the the -Path parameter is of data type String and
# accepts pipeline information ByValue
(Get-Help Test-Path -Parameter path).type.name
(Get-Help Test-Path -Parameter path).PipelineInput

"C:" | Test-path
"C:", "C:\Windows", "C:\BadPath", "C:\Windows\System32" | Test-path

# This will not work
"C:" | Test-path -Path "c:\Windows"
