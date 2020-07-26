# ScheduledJobs-code1
Get-help Register-ScheduledJob | Select-Object -ExpandProperty Description

# Create job options.
Get-Help New-ScheduledJobOption -Detailed
$Options = New-ScheduledJobOption -RequireNetwork `
                                  -WakeToRun `
                                  -ContinueIfGoingOnBattery

# Create a job trigger.
Get-Help New-JobTrigger -Detailed
$Trigger =  New-JobTrigger -Once `
                           -At (Get-Date).AddMinutes(1)

# Register the job
Register-ScheduledJob -Name "SysLog" `
                      -ScheduledJobOption $Options `
                      -Trigger $Trigger `
                      -ScriptBlock {Get-EventLog -LogName System}


# Launch the Task Scheduler
Invoke-Expression -Command "c:\Windows\system32\taskschd.msc"

# Use PowerShell cmdlets to manage and monitor the job.
Get-ScheduledJob

# View the job status.
Get-job

# Receive the Job information.
Receive-Job -Keep -Name SysLog | Select-Object -First 5

# Remove the job from the task scheduler.
Unregister-ScheduledJob -Name SysLog

# All job objects are stored in the principals profile
# and can be recovered at any time.
Get-ChildItem C:\Users\Administrator\AppData\Local\Microsoft\Windows\PowerShell\ScheduledJobs
Receive-Job -name Syslog -Keep | Select -First 10

# Scheduled Tasks ---------------------------------------------------

Get-help Register-ScheduledTask | Select-Object -ExpandProperty Description

# Define the tasks actions.
Get-Help New-ScheduledTaskAction -ShowWindow
$Action = New-ScheduledTaskAction -Execute "mspaint.exe"

# Create the Task object
Get-Help Register-ScheduledTask -ShowWindow
Register-ScheduledTask -Action $Action -TaskName "Paint"

# Start the task
Start-ScheduledTask -TaskName "Paint"

# Unregister the task.
Unregister-ScheduledTask -TaskName "Paint"

# You can add triggers to tasks.
Get-Help New-ScheduledTaskTrigger -ShowWindow

# You can also add credentials so the task can run when the
# user is not logged in.
Get-Help New-ScheduledTaskPrincipal -ShowWindow






 

