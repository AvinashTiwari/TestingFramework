Param( [Parameter(Mandatory=$true)] [string]$Path,
 [Parameter(Mandatory=$true)] [Datetime]$LastWrite )
gci $Path | Where-object -FilterScript {($_.LastWriteTime -gt $LastWrite)}
