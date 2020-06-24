Function Get-CounterData
{
Param(
      [Parameter(Mandatory=$true)]
      [ValidateSet("Processor", "Disk", "Memory")]
      [string]
      $Data, 
      [ValidateRange(1,10)]
      [int]$MaxSample = 1,
      [ValidateRange(1,10)]
      [int]$SampleInterval = 1)
    Switch($Data) {
     "Processor" {$Counter = "\Processor(_total)\% Processor Time"}
     "Disk" {$Counter = "\PhysicalDisk(0*)\% Disk Time"}
     "Memory" {$Counter = "\Memory\Page Fault/sec"}
    }

    Get-Counter -Counter $Counter -MaxSamples  $MaxSample  -SampleInterval  $SampleInterval
}