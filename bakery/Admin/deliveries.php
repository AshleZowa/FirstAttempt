<?php include('partials/menu.php');?>

                    <?php 
                        if(isset($_SESSION['update-status'])){
                            echo $_SESSION['update-status'];
                            unset($_SESSION['update-status']);
                        }

                        if(isset($_SESSION['add-status'])){
                            echo $_SESSION['add-status'];
                            unset($_SESSION['add-status']);
                        }


                    ?>


<div class="content">
           <div class="wrapper">
                <h1>Manage Deliveries</h1>

                    <br/><br/><br/>

                    <a href="<?php echo SITEURL; ?>Admin/add-status.php " class="btn-primary">Add Status</a>
                    <br/><br/><br/>

                <table class="tbl-full">
                        <tr>
                                <th>ID</th>
                                <th>Order Id</th>
                                <th>Delivery Date</th>
                                <th>Delivery Time</th>
                                <th>Delivery Status</th>
                                <th>Actions</th>
                        </tr>

                        <?php
                    //This code executes the query to get all admin data from database
                        $sql = "SELECT * FROM deliveries";

                        $result = mysqli_query($conn, $sql);

                        if($result==TRUE){
                            //This code retrieves all rows from database table
                            $count = mysqli_num_rows($result);

                            $idn=1; //This value allows the displayed ID number to increase by 1

                            if($count > 0)
                            {
                                while($rows=mysqli_fetch_assoc($result)){
                                    //Using while loop to get data from database table
                                    $id =$rows['id'];
                                    $order_id =$rows['order_id'];
                                    $delivery_date =$rows['delivery_date'];
                                    $delivery_time =$rows['delivery_time'];
                                    $delivery_status =$rows['delivery_status'];

                                    //This code displays values in table on manage admin page
                                    ?>

                                        <tr>
                                            <td><?php echo $idn++; ?></td>
                                            <td><?php echo $order_id ; ?></td>
                                            <td><?php echo $delivery_date; ?></td>
                                            <td><?php echo $delivery_time; ?></td>
                                            <td>
                                                    <?php
                                                        if($delivery_status=="ordered")
                                                        {
                                                            echo "<label>$delivery_status </label>";
                                                        }
                                                        elseif($delivery_status=="In-Transit")
                                                        {
                                                            echo "<label style='color: orange;'>$delivery_status </label>";
                                                        }
                                                        elseif($delivery_status=="Delivered")
                                                        {
                                                            echo "<label style='color: green;'>$delivery_status </label>";
                                                        }
                                                        
                                                    ?>
                                                </td>
                                            <td>
                                                <a href="<?php echo SITEURL; ?>Admin/update-status.php?id=<?php echo $id; ?>" class="btn-tertiary">Update Status</a>
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