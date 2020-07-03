# Help File - Code 1

Function DO-CoolThings
{
<#
.SYNOPSIS
Does something cool

.DESCRIPTION
Does Something really cool.

.PARAMETER Name
The name of the cool person.

.PARAMETER Age
The age of the cool person.

.PARAMETER Phone
The phone number of the cool person.

.EXAMPLE
DO-CoolThings -Name "Jason" -Age 25 -Phone 123-456-7890

Makes this person really cool!

.EXAMPLE
DO-CoolThings -Name "Jason" -Age 30 -Phone 123-456-7890 | Select-Object -Property Phone

Displays the cool persons number.


#>
Param (

    [parameter(Mandatory=$true)]
    [String[]]
    $Name,
    
    [parameter(Mandatory=$true,
    ValueFromPipelineByPropertyName=$true)]
    [int]
    $Age,

    
    [ValidatePattern("[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")]
    [String]
    $Phone
)

}
Get-Help DO-CoolThings -full