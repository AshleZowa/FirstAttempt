<?php

    include('../config/constants.php');

    //This code gets the data from database table
    if(isset($_GET['id']) && (isset($_GET['start_date'])) && (isset($_GET['end_date']))) 
    {
        //This gets the ID and Image data
        $id = $_GET['id'];
        $start_date = $_GET['start_date'];
        $end_date = $_GET['end_date'];
    
        //This code performs a SQL Query to delete admin
        $sql = "DELETE FROM discounts WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        if($result==TRUE){

            //Create session variable to display message
            $_SESSION['delete-discount'] = "<div class='success'>Discount deleted successfully.</div>";
            header("location:".SITEURL.'Admin/discounts.php');

        }
        else{
                //This code Redirects to menu items page
            $_SESSION['delete-discount'] = "<div class='error'>Failed to delete Discount</div>";
            header("location:".SITEURL.'Admin/discounts.php');
        
        }
    }


?>