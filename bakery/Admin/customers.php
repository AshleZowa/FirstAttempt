<?php include('partials/menu.php');?>

        <div class="content">
           <div class="wrapper">
                <h1>Manage Customers</h1>

                <br/><br/><br/>

                <table class="tbl-full">
                        <tr>
                                <th>ID</th>
                                <th>Order ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Phone number</th>
                        </tr>

                       
                    <?php
                    //This code executes the query to get all customer data from database
                        $sql = "SELECT * FROM customers";
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
                                    $order_id=$rows['order_id'];
                                    $name=$rows['name'];
                                    $email=$rows['email'];
                                    $address=$rows['address'];
                                    $phone_number=$rows['phone_number'];

                                    //This code displays values in table on customers page
                                    ?>

                                        <tr>
                                                <td><?php echo $idn++; ?></td>
                                                <td><?php echo $order_id; ?></td>
                                                <td><?php echo $name; ?></td>
                                                <td><?php echo $email; ?></td>
                                                <td><?php echo $address; ?></td>
                                                <td><?php echo $phone_number; ?></td>
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