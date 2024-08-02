<?php include('partials/menu.php');?>

<div class="content">
           <div class="wrapper">
                <h1>Add Admin</h1>
                <br/><br/><br/>

                <?php
                    if(isset($_SESSION['add'])){
                        echo $_SESSION['add'];
                        unset($_SESSION['add']);
                    }
                
                ?>

                <form action="" method="POST">

                    <table class="tbl-small">
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
                                <input type="submit" name="submit" value="Add Admin" class="btn-secondary">
                            </td>
                        </tr>

                    </table>

                </form>

              

           </div>
 </div>

<?php include('partials/footer.php');?>

<?php
//This code processes the values in the form and saves it in the database
    $_SESSION['add']= $username = $password = "";
    if (isset($_POST['submit'])){

        //This code gets data from form
       $username = $_POST['username'];
       $password = md5($_POST['password']);//password encryption with MD5

        //SQL query to save data in database
        $sql = "INSERT INTO tbl_admin SET 
               username='$username' ,
               password='$password' 
        ";
         
         if($username == "" || $password == "")
         $_SESSION['add']= 'Please make sure to fill all fields<br><br>';
     else{
        
        //Execute query and saving to database
       $result = mysqli_query($conn, $sql) or die(mysqli_error());

      //Check if data is inserted
      if($result==TRUE){

        //Create session variable to display message
        $_SESSION['add'] = "<div class='success'>Admin Added Successfully</div>";
        header("location:".SITEURL.'Admin/manage-admin.php');
      }
      else{

        //Create session variable to display message
        $_SESSION['add'] = "<div class='error'>Failed to add admin";
        header("location:".SITEURL.'Admin/admin-signup.php');
      }

 }
}
  
    
?>
