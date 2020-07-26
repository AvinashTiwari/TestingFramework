# Reporting-Code1

#region Out-Gridview

Get-EventLog -LogName System -Newest 10 |
    Select-Object -Property InstanceID, Source, TimeWritten, Message |
    Out-Gridview

# Using PassThru parameter allows the user to send selected 
# objects back into the pipeline.
Get-EventLog -LogName System -Newest 10 |
    Select-Object -Property InstanceID, Source, TimeWritten, Message |
    Out-Gridview -PassThru 

Get-EventLog -LogName System -Newest 10 |
    Select-Object -Property InstanceID, Source, TimeWritten, Message |
    Out-Gridview -PassThru |
    Select-Object -ExpandProperty Message
#endregion Out-Gridview

#region HTML
# ConvertTo-HTML will only work with objects.
Get-ADUser -filter * | ConvertTo-Html

# Send to Out-File to create a web page.
Get-ADUser -filter * | 
    ConvertTo-Html |
    Out-File -FilePath c:\ps\users.html

Invoke-Expression -Command "c:\ps\users.html"

# Properties that can contain multiple values are not good candidates 
# for HTML.  Filter these values out.

Get-ADUser -filter * -Properties MemberOf | 
    Select-Object -Property SamAccountName, MemberOf |
    ConvertTo-Html |
    Out-File -FilePath c:\ps\users.html

Invoke-Expression -Command "c:\ps\users.html"

# Add headers.

$Title = "All users in the Domain"
$PreContent = "This is a list of all users in the domain."
$PostContent  = "---- Confidential information ----"

Get-ADUser -filter * | 
    Select-Object -Property SamAccountName, GivenName, Surname |
    ConvertTo-Html -Title $Title -PreContent $PreContent -PostContent $PostContent |
    Out-File -FilePath c:\ps\users.html

Invoke-Expression -Command "c:\ps\users.html"


# Add CSS data to make the report more visually appealing.

#endregion HTML

#region Email

# Send a message to your email.
$String = "Hello,"
$String += "I am your email."

Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Test Message" `
                    -Body $String `
                    -SmtpServer Ex1.PowerIT.com


# Use `n  (back Tick + N) to inject new lines.
$String = "Hello,`n"
$String += "I am your email."

Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Test Message - Take Two" `
                    -Body $String `
                    -SmtpServer Ex1.PowerIT.com

# Raw objects do not email well.
$Data = Get-ADUser -filter * | 
    Select-Object -Property SamAccountName, GivenName, Surname 

Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Daily User Report - Does not look good." `
                    -Body "$($Data)" `
                    -SmtpServer Ex1.PowerIT.com 


# Convert your objects to HTML.
$PreContent = "This is a list of all users in the domain."
$PostContent  = "---- Confidential information ----"

$Data = Get-ADUser -filter * | 
    Select-Object -Property SamAccountName, GivenName, Surname |
    ConvertTo-Html -PreContent $PreContent `
                   -PostContent $PostContent

Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Daily User Report - Better, but could be improved." `
                    -Body "$Data" `
                    -SmtpServer Ex1.PowerIT.com `
                    -BodyAsHtml
                    

# Add CSS to improve readability.
$Head = '
<style>
table, th, td {
   border: 1px solid black;
}
th {
    background-color: green;
    color: white;
}
</Style>
'

$Data = Get-Process |
    Select-Object -First 5 |
    ConvertTo-html -Head $Head 

Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Daily User Report - Looks good." `
                    -Body "$Data" `
                    -SmtpServer Ex1.PowerIT.com `
                    -BodyAsHtml

# Add Attachments
Get-ADUser -filter * | Out-file c:\PS\Users.txt

Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Daily User Report - See Attachment" `
                    -Body "User Report is in the attachment" `
                    -SmtpServer Ex1.PowerIT.com `
                    -Attachments "C:\ps\Users.txt"

# Setting Priority
Send-MailMessage -To Administrator@PowerIT.com `
                    -From PowerShell@PowerIT.com `
                    -Subject "Daily User Report - Priority" `
                    -Body "You had better read this" `
                    -SmtpServer Ex1.PowerIT.com `
                    -Priority High

#endregion Email