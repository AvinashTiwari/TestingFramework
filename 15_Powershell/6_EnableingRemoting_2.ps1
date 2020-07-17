New-ADGroup -Name "Help_Desk_Members" -GroupCategory Security -GroupScope Global
Add-ADGroupMember -Identity Help_Desk_Members -Members JDoe