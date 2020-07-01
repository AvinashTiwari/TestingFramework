Get-WMIObject -Namespace "root" -Class "__Namespace" | select Name

Get-WmiObject -List

Get-CimInstance -ClassName Win32_OperatingSystem -ComputerName Svr1

Get-CimInstance -ClassName Win32_OperatingSystem -ComputerName Svr1 | 
                Get-Member

(Get-CimClass -ClassName Win32_OperatingSystem -ComputerName Svr1).CimClassMethods

Get-CimInstance -ClassName Win32_OperatingSystem -ComputerName Svr1 |
               Invoke-CimMethod -MethodName Reboot

