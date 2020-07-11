# PowerShell5Class-Part1-Code3


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
    Vehicle([int]$Dir,[int]$Speed)
    {
        $This.Direction = $Dir
        $This.Speed = $Speed
    }

    # Properties
    [Course]$Direction = 2
    [Int]$Speed = 0
}

# Create a new instance of the class with the default settings.
[Vehicle]::New()

# Create a new instance of the class with a constructor.
[Vehicle]::New(5,10)

# List all constructors of the class.
[Vehicle]::new
