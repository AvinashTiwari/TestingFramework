Function Get-CounterData
{
Param($Data, 
      $MaxSample = 1,
      $SampleInterval = 1)
    Switch($Data) {
     1 {$Counter = "\Processor(_total)\% Processor Time"}
     2 {$Counter = "\PhysicalDisk(0*)\% Disk Time"}
     3 {$Counter = "\Memory\Page Fault/sec"}
    }

    Get-Counter -Counter $Counter -MaxSamples  $MaxSample  -SampleInterval  $SampleInterval
}