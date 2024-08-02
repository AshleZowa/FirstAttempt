<?php include('partials/menu.php');?>

<?php
    if(isset($_SESSION['add-status']))
    {
        echo $_SESSION['add-status'];
        unset($_SESSION['add-status']);
    }

?>



<div class="content">
           <div class="wrapper">
                <h1>Add Delivery Status</h1>
                <br/><br/>

               
                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">

                            <tr>
                                <td>Order ID: </td>
                                    <td>
                                        <select name="order_id">
                                            <?php
                                                    //This code retrives the data from database

                                                    //This code displays prices from database
                                                    $sql = "SELECT * FROM orders";

                                                    $result = mysqli_query($conn, $sql);

                                                    //This code checks whether an item id is available in the database
                                                    $count = mysqli_num_rows($result);

                                                    $idn=1;

                                                    if($count > 0)
                                                    {
                                                        while($rows=mysqli_fetch_assoc($result)){
                                                            //This code gets the data from table
                                                            $id=$rows['id'];
                                                            

                                                            ?>

                                                            <option value="<?php echo $idn++; ?>"><?php echo $idn++; ?></option>

                                                            <?php
                                                        }
                                                        
                                                    }else{
                                                        ?>
                                                        <option value="0">No id available</option>

                                                        <?php

                                                    }

                                                ?>
                                                
                                            </select>
                                        </td>
                                </tr>

                        <tr>
                                <td>Delivery Date: </td>
                                <td>
                                        <select name="delivery_date">
                                            <?php
                                                    //This code retrives the data from database

                                                    //This code displays prices from database
                                                    $sql3 = "SELECT * FROM orders";

                                                    $result3 = mysqli_query($conn, $sql3);

                                                    //This code checks whether an item id is available in the database
                                                    $count = mysqli_num_rows($result3);

                                                    if($count > 0)
                                                    {
                                                        while($rows=mysqli_fetch_assoc($result3)){
                                                            //This code gets the data from table
                                                            $order_date = $rows['order_date'];
                                                            

                                                            ?>

                                                            <option value="<?php echo $order_date; ?>"><?php echo $order_date; ?></option>

                                                            <?php
                                                        }
                                                        
                                                    }else{
                                                        ?>
                                                        <option value="0">No id available</option>

                                                        <?php

                                                    }

                                                ?>
                                                
                                            </select>
                                        </td>
                                
                        </tr>

                        <tr>
                                <td>Delivery Time: </td>
                                <td>
                                     <input type="time" name="delivery_time"  value="<?php echo $delivery_time; ?>">
                                </td>
                        </tr>

                        <tr>
                                <td>Delivery_Status: </td>
                                <td>
                                    <input type="radio" name="delivery_status" value="In-Transit" >In-Transit
                                    <br/>
                                    <input type="radio" name="delivery_status" value="Delivered" >Delivered
                                </td>
                        </tr>

                        <tr>
                                <td colspan="2">
                                    <input type="submit" name="submit" value="Add" class="btn-secondary">
                                </td>
                        </tr>
   
                    
                 </table>

                </form>

                
                </form>

                <?php
                     if(isset($_POST['submit']))
                     {
                        
                        //This code gets the data from the form
                        $order_id = $_POST['order_id'];
                        $delivery_date = $_POST['delivery_date'];
                        $delivery_time = $_POST['delivery_time'];

                        
                         //This code checks whether radio buttons are selected
                            if(isset($_POST['delivery_status']))
                            {
                                $delivery_status = $_POST['delivery_status'];
                            }else{
                                $delivery_status = "In-Transit"; //This is a default value
                            }

                        
                            //This code inserts the item in the database
                            $sql2 = "INSERT INTO  deliveries SET 
                                    order_id = $order_id,
                                    delivery_date = '$delivery_date',
                                    delivery_time = '$delivery_time' ,
                                    delivery_status = '$delivery_status' 
                                  ";

                         //This code executes the SQL Query to the database
                            $result2 = mysqli_query($conn, $sql2);

                             //Check if data is updated
                            if($result2 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['add-status'] = "<div class='success text-center'>Status added Successfully</div>";
                                header("location:".SITEURL.'Admin/deliveries.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['add-status'] = "<div class='error text-center'>Failed to add Status</div>";
                                header("location:".SITEURL.'Admin/deliveries.php');
                            }


     
                     }

                ?>

            </div>

    </div>


<?php include('partials/footer.php');?>