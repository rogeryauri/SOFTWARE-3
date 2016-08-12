<?php include ('funciones.php');
$nombres=$_GET['nombres'];
$email=$_GET['email'];
$contrasenia=$_GET['contrasenia'];
$usuario=$_GET['usuario'];
$dni=$_GET['dni'];

ejecutarSQLCommand("INSERT INTO `login` (nombres, email, contrasenia, usuario, dni)
VALUES ('$nombres', '$email','$contrasenia','$usuario','$dni')
ON DUPLICATE KEY UPDATE `nombres`='$nombres', `email`='$email',`contrasenia`='$contrasenia',`usuario`='$usuario',`dni`='$dni';");
?>