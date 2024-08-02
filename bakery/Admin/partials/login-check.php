<?php

    //This code check whether a user is logged in or not
    if (!isset($_SESSION['user']))
    {
        //Create session variable to display message
        $_SESSION['no-message'] = "<div class ='error text-center'>Please log in to use management system</div>";
        header("location:".SITEURL.'Admin/admin-login.php');

    }

    

?>