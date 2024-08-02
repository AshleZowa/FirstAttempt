<?php include('partials/menu.php');?>


                <?php

                    if(isset($_SESSION['inventory'])){
                        echo  $_SESSION['inventory'];
                        unset( $_SESSION['inventory']);
                    }

                    if(isset($_SESSION['update-inventory'])){
                        echo  $_SESSION['update-inventory'];
                        unset( $_SESSION['update-inventory']);
                    }
                
                ?>

<div class="content">
        <div class="wrapper">
                <h1>Manage Inventory</h1>

                <br/><br/><br/>


                 <!--Button to Add to inventory-->
                 <a href="<?php echo SITEURL; ?>Admin/add-inventory.php" class="btn-primary">Add To Inventory</a>

                <br/><br/><br/>

                <table class="tbl-full">
                        <tr>
                                <th>Item ID</th>
                                <th>Quantity</th>
                                <th>Item Name</th>
                                <th>Available</th>
                                <th>Actions</th>
                        </tr>

                        <?php
                    //This code executes the query to get all admin data from database
                        $sql = "SELECT * FROM inventory";

                        $result = mysqli_query($conn, $sql);

                        if($result==TRUE){
                            //This code retrieves all rows from database table
                            $count = mysqli_num_rows($result);


                            if($count > 0)
                            {
                                while($rows=mysqli_fetch_assoc($result)){
                                    //Using while loop to get data from database table
                                    $item_id =$rows['item_id'];
                                    $quantity =$rows['quantity'];
                                    $item_name =$rows['item_name'];
                                    $available =$rows['available'];

                                    //This code displays values in table on manage admin page
                                    ?>

                                        <tr>
                                            <td><?php echo  $item_id; ?></td>
                                            <td><?php echo $quantity; ?></td>
                                            <td><?php echo $item_name ; ?></td>
                                            <td><?php echo $available ; ?></td>
                                            <td >
                                                <a href="<?php echo SITEURL; ?>Admin/update-inventory.php?item_id=<?php echo  $item_id; ?>" class="btn-secondary">Update inventory</a>
                                            </td>
                                        </tr>

                                         <?php
                                }
                            }
                            else{
                                echo "<tr><td colspan='5' class ='error'>Nothing Added yet.</td></tr>"; 

                            }
                        }
                        
                        ?>
   

                 </table>

                

           </div>
        </div>

        <?php include('partials/footer.php');?>