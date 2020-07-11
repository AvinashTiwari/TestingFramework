# PowerShell5Class-Part1-Code2


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

# You can enumerate any ENUM type to
# see its valid values.
[Enum]::GetNames([Course])

Class Vehicle
{
    # Properties
    [Course]$Direction = 2
    [Int]$Speed = 0
}

[Vehicle]::New()

[Vehicle]::New() | Get-Member
