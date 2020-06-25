Function Do-Math {
param($Num1,
   $Num2,
   $Operation)

   Function Addition {
     Param ($N1, $N2)
     Write-Output ($N1 + $N2)
   }

     Function Subtraction {
     Param ($N1, $N2)
     Write-Output ($N1 + $N2)
   }


    Function Multiplication {
     Param ($N1, $N2)
     Write-Output ($N1 * $N2)
   }

    Function Division {
     Param ($N1, $N2)
     Write-Output ($N1 / $N2)
   }



   switch($Operation){
     "Add" { $Data = Addition -N1 $Num1  -N2 $Num2}
     "Subtract" {$Data = Subtraction -N1 $Num1  -N2 $Num2}
     "Multiply" {$Data = Multiplication -N1 $Num1  -N2 $Num2}
     "Divide" {$Data = Division -N1 $Num1  -N2 $Num2}
   }

   Write-Output $Data



}