<?php include('../config/constants.php'); ?>


<html>
    <head>
        <meta charset= 'utf-8'>
        <meta name= 'viewport' content= 'width=device-width, initial-scale=1'>
        <link rel= 'stylesheet' href= 'jquery.mobile-1.4.5.min.css'>
        <link rel= 'stylesheet' href= '../css/admin.css'>

        <title>John's Bakery: Admin logIn</title>

        <script src= 'javascript.js'></script>
        <script src='jquery.mobile-1.4.5.min.js'></script>

        <style>
        
            form{
                width:500px;
                margin:0 auto;
                margin-top: 150px;
            }

        </style>

   
    </head>
      <body>
        <div class="main">
            <div class="navbar">
                <div class="icon">
                    <h2 class="logo">John's Bakery</h2>
                    <br><br>
               
                    
                </div>
             </div>
             

             <form action="" method="POST">
             <?php

                     if(isset($_SESSION['login'])){
                        echo $_SESSION['login'];
                        unset($_SESSION['login']);
                    }

                    if(isset($_SESSION['no-message'])){
                        echo $_SESSION['no-message'];
                        unset($_SESSION['no-message']);
                    }

                ?>

                    <table class="tbl-small">
                    <tr>
                        <th class="text-center">Log In</th>
                    </tr>

                        <tr>
                            <td>Username: </td>
                            <td><input type="text" name="username" placeholder="Enter username"></td>
                        </tr>

                        <tr>
                            <td>Password: </td>
                            <td><input type="password" name="password" placeholder="Enter password"></td>
                        </tr>

                        <tr>
                            <td colspan="2"> 
                                <input type="submit" name="submit" value="Log In" class="btn-secondary">
                            </td>
                        </tr>

                    </table>

                </form>

        </div>

        <footer>
            <p> 2023 All rights reserved, John's Bakery.  Developed By-<a href="#">Ashley Zowa </a>  04HA2101882</p>
        </footer>
        <script src="script.js"></script>   
      </body>
</html>

<?php
//This code processes the values in the form and compares it to  data in the database
    $_SESSION['login']= $username = $password = "";
    if (isset($_POST['submit'])){

        //This code gets data from form
       $username = $_POST['username'];
       $password =  md5($_POST['password']);//password encryption with MD5

        //SQL query to check data in database
        $sql = "SELECT * FROM tbl_admin
                WHERE username='$username' AND password='$password'";
        
         
         if($username == "" || $password == "")
         $_SESSION['login']= "<div class ='error text-center'>'Please make sure to fill all fields</div>";
     else{
        
                //Execute query and saving to database
            $result = mysqli_query($conn, $sql);

            //This code checks whether a user exists
            $count = mysqli_num_rows($result);

            //Check if data is inserted
            if($count==1){

                //Create session variable to display message
                $_SESSION['login'] = "<div class='success'>Log in successful</div>";
                $_SESSION['user'] = $username; //This piece of code checks whether a user is indeed logged in

                header("location:".SITEURL.'Admin/admin.php');
            }
            else{

                //Create session variable to display message
                $_SESSION['login'] = "<div class ='error text-center'>Failed to log in. Check username and password</div>";
                header("location:".SITEURL.'Admin/admin-login.php');
            }

 }
}
  
    
?>

