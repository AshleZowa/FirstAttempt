<?php include('partials/menu.php');?>
       
<div class="content">
           <div class="wrapper">
                <h1>Manage Menu</h1>
              
                <br/><br/><br/>


                 <!--Button to Add menu-->
                <a href="<?php echo SITEURL; ?>Admin/add-item.php" class="btn-primary">Add Item</a>

                <br/><br/><br/>
                <?php
                    if(isset($_SESSION['add'])){
                        echo $_SESSION['add'];
                        unset($_SESSION['add']);
                    }

                    if(isset($_SESSION['delete'])){
                        echo $_SESSION['delete'];
                        unset($_SESSION['delete']);
                    }

                    if(isset($_SESSION['upload'])){
                        echo $_SESSION['upload'];
                        unset($_SESSION['upload']);
                    }

                    
                    if(isset($_SESSION['unauthorise'])){
                        echo $_SESSION['unauthorise'];
                        unset($_SESSION['unauthorise']);
                    }

                    if(isset($_SESSION['update'])){
                        echo $_SESSION['update'];
                        unset($_SESSION['update']);
                    }

                
                ?>

                <table class="tbl-full">
                        <tr>
                                <th>ID</th>
                                <th>Item Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Image</th>
                                <th>Available</th>
                                <th>Actions</th>
                        </tr>
   
                        <?php
                    //This code executes the query to get all customer data from database
                        $sql = "SELECT * FROM menu_items";
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
                                    $item_name=$rows['item_name'];
                                    $description=$rows['description'];
                                    $price=$rows['price'];
                                    $image=$rows['image'];
                                    $available=$rows['available'];

                                    //This code displays values in table on customers page
                                    ?>

                                        <tr>
                                                <td><?php echo $idn++; ?></td>
                                                <td><?php echo $item_name; ?></td>
                                                <td><?php echo $description; ?></td>
                                                <td><?php echo $price; ?></td>
                                                <td>
                                                    <?php 
                                                        if($image!=="")
                                                        {
                                                            ?>
                                                                <img src="<?php echo SITEURL; ?>img/food/<?php echo $image; ?>" width="100px">

                                                            <?php
                                                        }else{

                                                            echo "<div class ='error'>No image added</div>";
                                                        }
                                                
                                                     ?>
                                                </td>
                                                <td><?php echo $available; ?></td>
                                                <td >
                                                    <a href="<?php echo SITEURL; ?>Admin/update-item.php?id=<?php echo $id; ?>" class="btn-secondary">Update item</a>
                                                    <a href="<?php echo SITEURL; ?>Admin/delete-item.php?id=<?php echo $id; ?>&image=<?php echo $image; ?>" class="btn-tertiary">Delete item</a>
                                                </td>
                                        </tr>

                                    <?php
                                }
                            }
                            else{
                                    echo "<tr><td colspan='7' class ='error'>Nothing Added yet.</td></tr>";

                            }
                        }
                     ?>
                 </table>

                

           </div>
        </div>

<?php include('partials/footer.php');?>