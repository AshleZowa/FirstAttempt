<?php

    include('../config/constants.php');

    //This code gets the data from database table
    $id = $_GET['id'];

    //This code performs a SQL Query to delete admin
    $sql = "DELETE FROM tbl_admin WHERE id=$id";

    $result = mysqli_query($conn, $sql);

    if($result==TRUE){

        //Create session variable to display message
        $_SESSION['delete'] = "<div class='success'>Admin deleted successfully.</div>";
        header("location:".SITEURL.'Admin/manage-admin.php');

    }
    else{

        $_SESSION['delete'] = "<div class='error'>Failed to delete admin.</div>";
        header("location:".SITEURL.'Admin/manage-admin.php');

    }

    //This code Redirects to manage admin page



?>