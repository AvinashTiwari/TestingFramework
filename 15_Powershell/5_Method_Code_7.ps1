$env:PSModulePath
$env:PSModulePath | Get-Member -MemberType Method
($env:PSModulePath).Split(";")

Get-Date | Get-Member

(Get-Date).DayOfWeek

(Get-Date).AddDays(5)
(Get-Date).AddDays(-10)

$Date = (Get-Date).AddDays(-2)
Get-EventLog -LogName System -After $Date

$obj = New-Object -TypeName PSObject -Property @{
   CurrentSpeed = 0
}

$Obj | Format-Table -AutoSize

$Obj | Get-Member

$Obj | Add-Member -MemberType ScriptMethod
                  -Name "Accelerate"
                  -Value {This.CurrentSpeed += 5}
$Obj | GM

$Obj.Accelerate()