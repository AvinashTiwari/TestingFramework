# PowerShell5Class-Part2-Code1


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

# Create a new instance of the class with the default settings.
$Ship = [Vehicle]::New()

# Display the current instance.
$Ship

# Turn the ship.
$Ship.TurnStarboard()

# Display the Ship's object
$Ship

