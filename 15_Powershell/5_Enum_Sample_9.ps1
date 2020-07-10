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

[Enum]::GetName([Course])

Class Vehicle{
  [Course] $Direction = 2
  [Int] $Speed = 0

}

[Vehicle]::New()
[Vehicle]::New() | GM
