<?php 
	header('Content-Type: text/html;charset-utf-8');
	$us=$_REQUEST["txtuser"];
	$co=$_REQUEST["txtpass"];




	include ('funciones.php');
	$con=conectar();
	
 if ($us!="" || $co!="" ){
	$sql="SELECT usuario,contrasenia FROM `login` WHERE usuario='$us' and contrasenia='$co'";
	$rs=mysqli_query($con , $sql);
	$row = mysqli_fetch_array($rs, MYSQLI_NUM);
	$num=$row[0];
	$clv=$row[1];
	
	if($num!=""|| $clv!=""){
		echo "logeado";		
	}else{
			echo "incerrecto";
		}
	
	
  }else{
     echo "sin-datos";
   }

  
   
?>