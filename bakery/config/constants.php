<?php
//Start Session
    session_start();


    //Create constant value
    define('SITEURL', 'http://localhost:8080/bakery/');
    define('LOCALHOST', 'localhost:3306');
    define('DB_USER', 'root');
    define('DB_PASS', 'Password');
    define('DB_NAME', 'johns_bakery_db');

       
        $conn = mysqli_connect(LOCALHOST , DB_USER , DB_PASS) or die(mysqli_error());
        $db_select = mysqli_select_db($conn, DB_NAME) or die(mysqli_error());
  
    
?>