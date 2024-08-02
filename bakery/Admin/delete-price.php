<?php

    include('../config/constants.php');

    //This code gets the data from database table
    if(isset($_GET['id']) && (isset($_GET['start_date'])) && (isset($_GET['end_date']))) 
    {
        //This gets the ID 
        $id = $_GET['id'];
        $start_date  = $_GET['start_date '];
        $end_date  = $_GET['end_date '];
    
        //This code performs a SQL Query to delete admin
        $sql = "DELETE FROM prices WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        if($result==TRUE){

            //Create session variable to display message
            $_SESSION['delete'] = "<div class='success'>Price deleted successfully.</div>";
            header("location:".SITEURL.'Admin/prices.php');

        }
        else{
                //This code Redirects to menu items page
            $_SESSION['delete'] = "<div class='error'>Failed to delete price</div>";
            header("location:".SITEURL.'Admin/prices.php');
        
        }
    }


?>