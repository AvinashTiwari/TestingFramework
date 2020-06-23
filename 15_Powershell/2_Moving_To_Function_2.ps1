Function Get-CounterData
{
Param($Data)
    Switch($Data) {
     1 {$Counter = "\Processor(_total)\% Processor Time"}
     2 {$Counter = "\PhysicalDisk(0*)\% Disk Time"}
     3 {$Counter = "\Memory\Page Fault/sec"}
    }

    Get-Counter -Counter $Counter -MaxSamples 1
}