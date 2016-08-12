<?php
    header('Content-Type: text/html;charset-utf-8');

        function ejecutarSQLCommand($commando){
         $mysqli = new mysqli("localhost", "root", "","turismo");
    
            if($mysqli->connect_errno){
                printf("Error al conectar: %s\n",$mysqli->connect_error);
                exit();
            }
                if($mysqli->multi_query($commando)){
                    if($resultset = $mysqli->store_result()){
                        while ($row = $resultset->fetch_array(MYSQLI_BOTH)) {
            
                        }
                            $resultset->free();
                    }
                }
            $mysqli->close();
        }    

    //-----------------------   
      function conectar(){

        $host="localhost";
        $user="root";
        $pasword="";
        $nombrebd="turismo";
        $con=mysqli_connect("$host","$user","$pasword","$nombrebd");
     if (mysqli_connect_errno())
        {
            echo "fallo la conexion a MySQL: " . mysqli_connect_error();
        }else
     return $con;
      }
?>