<?php include('partials/menu.php');?>

<div class="content">
           <div class="wrapper">
                <h1>Manage Admin</h1>
                <br/><br/>

                <?php
                    if(isset($_SESSION['add'])){
                        echo $_SESSION['add'];
                        unset($_SESSION['add']);
                    }

                    if(isset($_SESSION['delete'])){
                        echo $_SESSION['delete'];
                        unset($_SESSION['delete']);
                    }

                    if(isset($_SESSION['update'])){
                        echo $_SESSION['update'];
                        unset($_SESSION['update']);
                    }
                
                ?>
                <br/><br/><br/>

                <!--Button to Add admin-->
                <a href="admin-signup.php" class="btn-primary">Add admin</a>

                <br/><br/><br/>

                <table class="tbl-full">
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Actions</th>
                    </tr>

                    <?php
                    //This code executes the query to get all admin data from database
                        $sql = "SELECT * FROM tbl_admin";
                        $result = mysqli_query($conn, $sql);

                        if($result==TRUE){
                            //This code retrieves all rows from database table
                            $count = mysqli_num_rows($result);

                            $idn=1; //This value allows the displayed ID number to increase by 1

                            if($count > 0)
                            {
                                while($rows=mysqli_fetch_assoc($result)){
                                    //Using while loop to get data from database table
                                    $id=$rows['id'];
                                    $username=$rows['username'];

                                    //This code displays values in table on manage admin page
                                    ?>

                                        <tr>
                                        <td><?php echo $idn++; ?></td>
                                        <td><?php echo $username; ?></td>
                                        <td >
                                                <a href="<?php echo SITEURL; ?>Admin/update-admin.php?id=<?php echo $id; ?>" class="btn-secondary">Update admin</a>
                                                <a href="<?php echo SITEURL; ?>Admin/delete-admin.php?id=<?php echo $id; ?>" class="btn-tertiary">Delete admin</a>
                                        </td>
                                        </tr>

                                    <?php
                                }
                            }
                            else{
                                echo "<tr><td colspan='3' class ='error'>Nothing Added yet.</td></tr>"; 
                            }
                        }
                     ?>

                </table>

           </div>
 </div>


 <?php include('partials/footer.php');?>