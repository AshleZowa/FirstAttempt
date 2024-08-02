<?php  include( 'header.php');?>


<div class="content">
    <div class="wrapper">
        <h2 class="text-center">Track Order</h2>  

    <?php 
            if(isset($_GET['order_id']))
            {
                //This gets the ID  data
                $order_id= $_GET['order_id'];
                $sql = "SELECT * FROM deliveries WHERE order_id=$order_id";

                $result = mysqli_query($conn, $sql);

                $row=mysqli_fetch_assoc($result);

                //This code gets individual
                $order_id = $row['order_id'];
                $delivery_date = $row['delivery_date'];
                $delivery_time = $row['delivery_time'];
                $delivery_status = $row['delivery_status'];
                

            }else{
                
                //This code redirects to menu item page

            }

    ?>

<form action="" method="POST" class="track">

<fieldset>
    <legend>Delivery Details</legend>
    <br>
    <div class="btn success">Order ID</div>
    <br>
    <select name="order_id">
                                    <?php
                                         //This code retrives the data from database

                                        //This code displays prices from database
                                        $sql2= "SELECT * FROM deliveries";

                                        $result2 = mysqli_query($conn, $sql2);

                                        //This code checks whether an item id is available in the database
                                        $count = mysqli_num_rows($result2);

                                        $idn=1;

                                        if($count > 0)
                                        {
                                            while($rows=mysqli_fetch_assoc($result2)){
                                                //This code gets the data from table
                                                $order_id=$rows['order_id'];
                                                

                                                ?>

                                                <option value="<?php echo $order_id; ?>"><?php echo $order_id; ?></option>

                                                <?php
                                            }
                                            
                                        }else{
                                            ?>
                                             <option value="0">No id available</option>

                                             <?php

                                        }

                                    ?>
                                       
                                </select>
                                <br>
                                <div class="btn success">Delivery Date</div>
                                <br>
                                <?php
                                         //This code retrives the data from database

                                        //This code displays prices from database
                                        $sql2= "SELECT * FROM deliveries";

                                        $result2 = mysqli_query($conn, $sql2);

                                        //This code checks whether an item id is available in the database
                                        $count = mysqli_num_rows($result2);

                                        $idn=1;

                                        if($count > 0)
                                        {
                                            while($rows=mysqli_fetch_assoc($result2)){
                                                //This code gets the data from table
                                                $delivery_date =$rows['delivery_date'];
                                                

                                                ?>

                                                <option value="<?php echo  $delivery_date; ?>"><?php echo  $delivery_date; ?></option>

                                                <?php
                                            }
                                            
                                        }else{
                                            ?>
                                             <option value="0">No date available</option>

                                             <?php

                                        }

                                    ?>
                                
                                <br>
                                <div class="btn success">Delivery Time</div>
                                <br>
                                <?php
                                         //This code retrives the data from database

                                        //This code displays prices from database
                                        $sql2= "SELECT * FROM deliveries";

                                        $result2 = mysqli_query($conn, $sql2);

                                        //This code checks whether an item id is available in the database
                                        $count = mysqli_num_rows($result2);

                                        $idn=1;

                                        if($count > 0)
                                        {
                                            while($rows=mysqli_fetch_assoc($result2)){
                                                //This code gets the data from table
                                                $delivery_time =$rows['delivery_time'];
                                                

                                                ?>

                                                <option value="<?php echo  $delivery_time; ?>"><?php echo  $delivery_time; ?></option>

                                                <?php
                                            }
                                            
                                        }else{
                                            ?>
                                             <option value="0">No time available</option>

                                             <?php

                                        }

                                    ?>
                               
                                <br>
                                <div class="btn success">Delivery Status</div>
                                <br>
                                <?php
                                         //This code retrives the data from database

                                        //This code displays prices from database
                                        $sql2= "SELECT * FROM deliveries";

                                        $result2 = mysqli_query($conn, $sql2);

                                        //This code checks whether an item id is available in the database
                                        $count = mysqli_num_rows($result2);

                                        $idn=1;

                                        if($count > 0)
                                        {
                                            while($rows=mysqli_fetch_assoc($result2)){
                                                //This code gets the data from table
                                                $delivery_status =$rows['delivery_status'];
                                                

                                                ?>

                                                <option value="<?php echo  $delivery_status; ?>"><?php echo $delivery_status; ?></option>

                                                <?php
                                            }
                                            
                                        }else{
                                            ?>
                                             <option value="0">No status available</option>

                                             <?php

                                        }

                                    ?>
                                
                                <br><br>
</fieldset>
<br><br>
        <a href="<?php echo SITEURL; ?>main.php" class="btn-secondary">DONE</a>

</form>   

    </div>
</div>