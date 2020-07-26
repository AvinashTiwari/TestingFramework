# ScheduledJobs-code2

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




