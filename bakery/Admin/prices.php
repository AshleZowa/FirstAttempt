<?php include('partials/menu.php');?>

        <div class="content">
           <div class="wrapper">
                <h1>Manage Prices</h1>

                <br/><br/><br/>


                 <!--Button to Add price-->
                <a href="<?php echo SITEURL; ?>Admin/add-price.php" class="btn-primary">Add Price</a>

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
                
                ?>

                <table class="tbl-full">
                        <tr>
                                <th> ID</th>
                                <th>Price</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Actions</th>

                        </tr>

                        <?php
                    //This code executes the query to get all admin data from database
                        $sql = "SELECT * FROM prices";
                        $result = mysqli_query($conn, $sql);

                        if($result==TRUE){
                            //This code retrieves all rows from database table
                            $count = mysqli_num_rows($result);

                            if($count > 0)
                            {
                                while($rows=mysqli_fetch_assoc($result)){
                                    //Using while loop to get data from database table
                                    $id = $rows['id'];
                                    $price = $rows['price'];
                                    $start_date = $rows['start_date'];
                                    $end_date = $rows['end_date'];

                                    //This code displays values in table on manage admin page
                                    ?>

                                        <tr>
                                                <td><?php echo $id; ?></td>
                                                <td><?php echo $price; ?></td> 
                                                <td><?php echo $start_date; ?></td>
                                                <td><?php echo $end_date; ?></td>
                                                <td >
                                                        <a href="<?php echo SITEURL; ?>Admin/delete-price.php?id=<?php echo $id; ?>&start_date=<?php echo $start_date; ?>&end_date=<?php echo $end_date; ?>" class="btn-tertiary">Delete price</a>
                                                </td>
                                        </tr>

                                         <?php
                                }
                            }
                            else{
                                echo "<tr><td colspan='6' class ='error'>Nothing Added yet.</td></tr>";
    

                            }
                        }
                     ?>

                 </table>

                

           </div>
        </div>
 <?php include('partials/footer.php');?>