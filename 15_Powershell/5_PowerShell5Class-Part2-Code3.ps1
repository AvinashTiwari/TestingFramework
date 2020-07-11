# PowerShell5Class-Part2-Code3


Enum Course {
    North
    NorthEast
    East
    SouthEast
    South
    SouthWest
    West
    NorthWest

}


Class Vehicle
{
    # Constructors
    Vehicle() {}
    Vehicle($Dir,$Speed)
    {
        $This.Direction = $Dir
        $This.Speed = $Speed
    }

    # Properties
    [Course]$Direction = 2
    [Int]$Speed = 0
    [String]$Name = $Null
    [String]$ShipClass


    # Methods
    TurnStarboard ()
    {
        If ($This.Direction -eq 7)
        {$This.Direction = 0}
        Else  {$This.Direction += 1 }
    }
    TurnPort()
    {
        If ($This.Direction -eq 0)
        {$This.Direction = 7}
        Else  {$This.Direction -= 1 }
    }
}

Class Destroyer : Vehicle
{

    # Constructors
    Destroyer () {}
    Destroyer ($NAME)
    {
        $This.Name = $Name
    }

    # Properties
    [Boolean]$SonarOn = $False
    Hidden[Int]$NumberOfTorpedoes = 50
    [String]$ShipClass = "Destroyer"

    # Methods
    TurnOnSonar () {$This.SonarOn = $True}
    TurnOffSonar () {$This.SonarOn = $False}
} 

Class Carrier : Vehicle
{
    # Constructors
    Carrier () {}
    Carrier ($NAME)
    {
        $This.Name = $Name
    }

    # Properties
    Hidden[Int]$NumberOfAircraft = 85
    [Int]$MaxAircraft = 85
    [String]$ShipClass = "Carrier"

    # Methods
    LaunchAircraft ($Num)
    {
        If ($This.NumberOfAircraft -ge $Num)
        {$This.NumberOfAircraft -= $Num}
        Else 
        {Write-Warning "Not enough aircraft."}
    }
    RecoverAircraft ($Num)
    {
        If (($This.NumberOfAircraft + $Num) -le $This.MaxAircraft)
        {$This.NumberOfAircraft += $Num}
        Else
        {Write-Warning "To many aircraft on board."}
    }
}

# Create a new instance of both ship classes.
$ShipA = [Destroyer]::New("USS Zumwalt")
$ShipB = [Carrier]::New("USS Ford")

# Take a look at the ship objects.
$ShipA
$ShipB

$ShipA | Get-Member 
$ShipB | Get-Member

# Both have inherited members from the base class
$ShipA.TurnStarboard()
$ShipB.TurnPort()

$ShipA
$ShipB

# Launch Aircraft.
$ShipB.LaunchAircraft(10)

# We still do not know how many aircraft the ship has
$ShipB

# The object knows.
$ShipB.RecoverAircraft(20)

# You can ask for this value.
$ShipB.NumberOfAircraft

# Force the hidden members to be shown.
$ShipA | Get-Member -Force 
$ShipB | Get-Member -Force
