<?php include('partials/menu.php');?>

                    <?php 
                       
                       if(isset($_SESSION['update-status'])){
                            echo $_SESSION['update-status'];
                            unset($_SESSION['update-status']);
                        }


                    ?>

 <div class="content">
     <div class="wrapper">
                <h1>Manage Orders</h1>

                <br/><br/><br/>
                
                <table class="tbl-full">
                <tr>
                                <th>ID</th>
                                <th>Order Date</th>
                                <th>Order Items</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Order Status</th>
                                <th>Actions</th>
                        </tr>

                       
                    <?php
                    //This code executes the query to get all customer data from database
                        $sql = "SELECT * FROM orders ORDER BY id DESC";
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
                                    $order_date=$rows['order_date'];
                                    $order_items=$rows['order_items'];
                                    $price=$rows['price'];
                                    $qty=$rows['qty'];
                                    $total=$rows['total'];
                                    $order_status=$rows['order_status'];

                                    //This code displays values in table on customers page
                                    ?>

                                        <tr>
                                                <td><?php echo $idn++; ?></td>
                                                <td><?php echo $order_date; ?></td>
                                                <td><?php echo $order_items; ?></td>
                                                <td><?php echo $price; ?></td>
                                                <td><?php echo $qty; ?></td>
                                                <td><?php echo $total; ?></td>
                                                <td>
                                                    <?php
                                                            if($order_status=="ordered")
                                                            {
                                                                echo "<label>$order_status </label>";
                                                            }
                                                            elseif($order_status=="In-Transit")
                                                            {
                                                                echo "<label style='color: orange;'>$order_status </label>";
                                                            }
                                                            elseif($order_status=="Delivered")
                                                            {
                                                                echo "<label style='color: green;'>$order_status </label>";
                                                            }
                                                            
                                                        ?>
                                                </td>
                                                <td>
                                                    <a href="<?php echo SITEURL; ?>Admin/update-orders.php?id=<?php echo $id; ?>" class="btn-secondary">Update Order</a>
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