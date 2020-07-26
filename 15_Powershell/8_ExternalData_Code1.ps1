# ExternalData-Code1

# Download Population Estimates from the US Census Bureau 
# http://www.census.gov/popest/data/datasets.html

$web = New-Object System.Net.WebClient

# Send to ConvertFrom-CSV to create objects.
$web.Downloadstring("http://www.census.gov/popest/data/national/asrh/2014/files/NC-EST2014-AGESEX-RES.csv") |
    ConvertFrom-csv

# Look at the objects members.
$web.Downloadstring("http://www.census.gov/popest/data/national/asrh/2014/files/NC-EST2014-AGESEX-RES.csv") |
    ConvertFrom-csv |
    Get-Member

# Get the esimated population of the United States
# for all 18 - 21 year olds for 2014.
$web.Downloadstring("http://www.census.gov/popest/data/national/asrh/2014/files/NC-EST2014-AGESEX-RES.csv") |
    ConvertFrom-csv | 
    Where {$_.Age -ge 18 -and $_.Age -lt 22} |
    Measure-Object -Property POPESTIMATE2014 -sum 


# Using a Web Service

# Create a new WebServiceProxy object
$Proxy = New-WebServiceProxy -Uri http://www.webservicex.net/airport.asmx

# Examin the methods of the object
$Proxy | Get-Member -MemberType Methods

# Execute the method
$Proxy.getAirportInformationByAirportCode("PHX")

# Convert the output into XML
$Result = [xml]$Proxy.getAirportInformationByAirportCode("PHX")

# Look at the XML Data
$Result | Format-Custom

# Step through the results until you have the data you want.
$Result
$Result.NewDataSet
$Result.NewDataSet.Table
$Result.NewDataSet.Table[0]

# Assign the members from the level in the object that your are 
# at for easy reference.
$AirportInfo = $Result.NewDataSet.Table[0]

# Use the information just as you would any other object,
$AirportInfo 
$AirportInfo.CityOrAirportName

 


