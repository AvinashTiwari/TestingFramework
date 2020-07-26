# BackgroundJobs-Code1

# Cmdlets used with Jobs
Get-Command -Noun Job | Select -ExpandProperty name

# Local Job
Start-Job -Name LocalSysLog -ScriptBlock {Get-EventLog -LogName System}

# WMI Job
Get-WmiObject -Class Win32_Service -AsJob

# Remote-Job
Invoke-Command -ComputerName SVR1, CL1 -AsJob -JobName Bios -ScriptBlock {
    Get-CimInstance -ClassName Win32_Bios
} 

# Manageing Jobs
# List all the jobs
Get-Job

# Receive a job
Receive-Job -Name LocalSysLog | Select-Object -First 5

# Notice the memory buffer is empty for LocalSysLog.
Get-Job

Receive-Job -Id 4 -Keep

# Notice the memory buffer for the WMI job is not empty.
Get-Job

# The Remote Job has 2 child jobs.
Get-Job -Name Bios -IncludeChildJob

# Notice the Remote-Job has a property called PSComputerName.
Receive-Job -Keep -Name Bios

# Objects are returned just as if you ran the command manually.
Receive-Job -Keep -Name Bios | Get-Member

# Job objects work the same as any other object
Get-Job | Where-Object HasMoreData -eq $False

Get-Job | Where-Object HasMoreData -eq $False | Remove-Job

Get-Job