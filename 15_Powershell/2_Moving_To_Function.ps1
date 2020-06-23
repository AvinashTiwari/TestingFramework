Function Get-ProcessorInfo
{
   Get-Counter -Counter "\Processor(_total)\% Processor Time" -ComputerName DC1,SVR1 -MaxSamples 2 -SampleInterval 1
}

Function Get-DiskInfo
{
   Get-Counter -Counter "\PhysicalDisk(0*)\% Disk Time" -ComputerName DC1,SVR1 -MaxSamples 2 -SampleInterval 1
}


Function Get-MemoryInfo
{
   Get-Counter -Counter "\Memory\Page Faults/sec" -ComputerName DC1,SVR1 -MaxSamples 2 -SampleInterval 1
}