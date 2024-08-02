<?php include('partials/menu.php');?>

<div class="content">
           <div class="wrapper">
                <h1>Update Admin</h1>
                <br/><br/><br/>

                <?php
                    //This code retrives the data from database
                    $id = $_GET['id'];

                    
                    //This code performs a SQL Query to get admin username
                    $sql = "SELECT * FROM tbl_admin WHERE id=$id";

                    $result = mysqli_query($conn, $sql);

                    if($result==TRUE){
                        //This code retrieves all rows from database table
                        $count = mysqli_num_rows($result);

                        if($count==1)
                        {
                            $row=mysqli_fetch_assoc($result);

                            $username = $row['username'];

                        }else{

                            header("location:".SITEURL.'Admin/manage-admin.php');

                        }
                    }
                
                ?>

                <form action="" method="POST">

                    <table class="tbl-small">
                        <tr>
                            <td>Username: </td>
                            <td><input type="text" name="username" value="<?php echo $username; ?>"></td>
                        </tr>

                        <tr>
                            <td colspan="2"> 
                                <input type="hidden" name="id" value="<?php echo $id; ?>">
                                <input type="submit" name="submit" value="Update Admin" class="btn-secondary">
                            </td>
                        </tr>

                    </table>

                </form>


           </div>
        </div>

<?php
//This code processes the values in the form and updates the database
    $_SESSION['update']= $username = "";
    if(isset($_POST['submit'])){

    //This code gets data from form
       $id = $_POST['id'];
       $username = $_POST['username'];
      
        //SQL query to update data in database
        $sql = "UPDATE tbl_admin SET 
               username='$username' 
               WHERE id='$id'    
        ";

        if($username == "" )
        $_SESSION['Update']= 'Please make sure to fill all fields<br><br>';
    else{

         //Execute query and saving to database
       $result = mysqli_query($conn, $sql);

        //Check if data is updated
      if($result==TRUE){

        //Create session variable to display message
        $_SESSION['update'] = "<div class='success'>Admin Updated Successfully</div>";
        header("location:".SITEURL.'Admin/manage-admin.php');
      }
      else{

        //Create session variable to display message
        $_SESSION['update'] = "<div class='error'>Failed to update admin</div>";
        header("location:".SITEURL.'Admin/manage-admin.php');
      }

    }
}




?>
    

<?php include('partials/footer.php');?>