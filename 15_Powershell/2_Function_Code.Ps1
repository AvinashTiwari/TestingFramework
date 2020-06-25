Function Do-Math {
param($Num1,
   $Num2,
   $Operation)

   switch($Operation){
     "Add" {   $Num1 + $Num2}
     "Subtract" {   $Num1 - $Num2}
     "Multiply" {   $Num1 * $Num2}
     "Divide" {   $Num1 / $Num2 }
   }



}