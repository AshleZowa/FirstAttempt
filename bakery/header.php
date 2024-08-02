<?php
//session_start();

echo <<<_INIT
<!DOCTYPE html>
<html>
    <head>
        <meta charset= 'utf-8'>
        <meta name= 'viewport' content= 'width=device-width, initial-scale=1'>
        <link rel= 'stylesheet' href= 'jquery.mobile-1.4.5.min.css'>
        <link rel= 'stylesheet' href= 'css/admin.css'>
        <style>
        body{
            font-family:  sans-serif;
            color: #fff;
            padding-top: 0px;
        }

        .center a{
            color: #ff7200;
            padding:1%;
        }
        
        .center{
            padding-top: 50px;
            text-align: center;
            font-size: 50px;
            padding:1%;
        
        }
        
        .center a:hover{
            color: #ffff;
            transition: 0.4s ease-in-out;
        }
        
        
        .info{
            text-align: center;
            font-style: italic;
            margin: 40px 0px;
           
        }

        .username{
            text-align: center;
            font-family: helvetica;
            font-size: 20pt;
            padding: 4px;
        }

        .wrapper{
            padding:1%;
            width: 80%;
            margin: 0 auto;
            
        }
        .wrapper h1{
            font-family: 'Times New Roman';
            font-size: 80px;
            padding-left: 10px;
            margin-top: 5%;
            letter-spacing: 2px;
        } 

        .text-center{
            text-align: center;
        }
        
        .content{
            width: 1200px;
            height: auto;
            margin: auto;
            color: #fff;
            position: relative;
            padding:3% 0;
            
        }
    </style>
        <script src= 'javascript.js'></script>
        <script src='jquery.mobile-1.4.5.min.js'></script>

_INIT;

    require_once 'bakery.php';
    include 'config/constants.php';

    $userstr = 'Welcome Guest';
    $randstr = substr(md5(rand()), 0, 7);

    if(isset($_SESSION['user'])){
        $user = $_SESSION['user'];
        $loggedin = TRUE;
        $userstr = "logged in as: $user";
    }
    else $loggedin = FALSE;

echo <<<_MAIN
    <title>John's Bakery: $userstr</title>
    </head>
    <body>
        <div class= 'main'>
            <div data-role= 'page'>
                <div data-role= 'header'>
                    <div id = 'logo'
                        class= 'center'>John's Bakery</div>
                     <div class= 'username'>$userstr</div>
                </div>
                <div  data-role= 'content'>
                <div class='food-menu-box'>

_MAIN;

    if ($loggedin){
        echo <<<_LOGGEDIN
            <div class= 'center' >
                <a data-role= 'button' data-inline= 'true' data-icon= 'home'
                    data-transition= "slide" href= 'main.php?view=$user&r=$randstr'>Home</a>
                <a data-role= 'button' data-inline= 'true' data-icon= 'user'
                    data-transition= "slide" href= 'menu.php?r=$randstr'>Menu</a>
                <a data-role= 'button' data-inline= 'true' data-icon= 'user'
                    data-transition= "slide" href= 'track.php?r=$randstr'>Track</a>
                <a data-role= 'button' data-inline= 'true' data-icon= 'action'
                    data-transition= "slide" href= 'logout.php?r=$randstr'>Log out</a>   
            </div>
            
        _LOGGEDIN;
    } 
    else{
        echo <<<_GUEST
            <div class= 'center'>
                <a data-role= 'button' data-inline= 'true' data-icon= 'home'
                     data-transition= "slide" href= 'index.php?r=$randstr''>Home</a>
                <a data-role= 'button' data-inline= 'true' data-icon= 'plus'
                     data-transition= "slide" href= 'signup.php?r=$randstr''>Sign up</a>
                <a data-role= 'button' data-inline= 'true' data-icon= 'check'
                     data-transition= "slide" href= 'login.php?r=$randstr''>Log in</a>
                <a data-role= 'button' data-inline= 'true' data-icon= 'check'
                     data-transition= "slide" href= 'Admin/admin-login.php?r=$randstr''>Admin</a>  
            </div>
            <p class= 'info'>(You must be logged in to use this app)</p>
            
        _GUEST;
    }  
?>