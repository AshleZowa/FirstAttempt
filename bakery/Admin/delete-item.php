<?php

    include('../config/constants.php');

    //This code gets the data from database table
    if(isset($_GET['id']) && (isset($_GET['image'])))
    {
        //This gets the ID and Image data
        $id = $_GET['id'];
        $image = $_GET['image'];

        if($image!=""){
            $path = "../img/food/".$image;
            
            //This image from folder
            $remove = unlink($path);

            if($remove == false)
            {
                $_SESSION['upload'] = "<div class='error'>Failed to remove image file</div>";
                header("location:".SITEURL.'Admin/menu-items.php');
                die();
            }

        }
            //This code performs a SQL Query to delete admin
        $sql = "DELETE FROM menu_items WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        if($result==TRUE){

            //Create session variable to display message
            $_SESSION['delete'] = "<div class='success'>Item deleted successfully.</div>";
            header("location:".SITEURL.'Admin/menu-items.php');

        }
        else{
                //This code Redirects to menu items page
            $_SESSION['delete'] = "<div class='error'>Failed to delete item</div>";
            header("location:".SITEURL.'Admin/menu-items.php');
        
        }



    }
    else
    {
        //This code Redirects to menu items page
        $_SESSION['unauthorise'] = "<div class='error'>Unauthorised Access</div>";
        header("location:".SITEURL.'Admin/menu-items.php');


    }


?>