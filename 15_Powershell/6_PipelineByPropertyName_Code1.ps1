# PipelineByPropertyName-Code1

# Explanation of ByValue from About_Pipelines
(Get-help About_Pipelines).split("`n")[301..306]


# Look at the pipeline information for the paramters of Office and City 
Get-Help New-ADUser -Parameter Name
Get-Help New-ADUser -Parameter GivenName
Get-Help New-ADUser -Parameter Surname
Get-Help New-ADUser -Parameter City
Get-Help New-ADUser -Parameter Office


# Create a CSV file that will contain the informaiton for the new accounts.\
"Name,GivenName,SurName,City,Office" | Out-File c:\ps\users.csv
"Patrick Miller, Patrick, Miller, Phoenix, HQ" | Out-File c:\ps\users.csv -Append
"Stan Myers, Stan, Myers, Phoenix, Logistics" | Out-File c:\ps\users.csv -Append
"Mike Smith, Mike, Smith, Indianapolis, International" | Out-File c:\ps\users.csv -Append

# Look at the ibjects created by importing the CSV file. Notice the property names.
Import-Csv -Path c:\ps\Users.csv

# Create the user accounts using the pipeline ByPropertyName.  Remember, the parameters
# Can only accept one value.
Import-Csv -Path c:\ps\Users.csv | 
    Select-Object -First 1 | 
    New-ADUser -Verbose

# Varify the creation of Patricks account
Get-ADUser -Filter {Name -eq 'Patrick Miller'} -Properties City, Office

# Remove Patrick for the next example.
Get-ADUser -Filter {Name -eq 'Patrick Miller'} | Remove-ADUser -Confirm:$False

# Use Foreach-Objec to to send all of the objects to New-ADUser
# in the pipeline.
Import-Csv -Path c:\ps\Users.csv | 
    ForEach-Object {
        $_ | New-ADUser -Verbose
    }

Get-ADUser -filter * -Properties Office, City | Select-Object -Last 3

