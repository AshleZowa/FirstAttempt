<?php include('partials/menu.php');?>

<?php 

    if(isset($_GET['id']))
    {
        //This gets the ID  data
        $id = $_GET['id'];
        $sql = "SELECT * FROM orders WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        $row=mysqli_fetch_assoc($result);

        //This code gets individual
        $current_order_status = $row['order_status'];
      

    }else{
        
        //This code redirects to menu item page
        header("location:".SITEURL.'Admin/orders.php');

    }


?>


<div class="content">
     <div class="wrapper">
                <h1>Update Order Status</h1>
                <br/><br/><br/>

               

                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                        <tr>
                                <td>Current Order Status: </td>
                                <td>
                                    <input type="text" name="current_order_status" value="<?php echo $current_order_status; ?>" >
                                </td>
                        </tr>

                        <tr>
                                <td>Order Status: </td>
                                <td>
                                <?php
                                                    //This code retrives the data from database

                                                    //This code displays prices from database
                                                    $sql2 = "SELECT * FROM deliveries";

                                                    $result2 = mysqli_query($conn, $sql2);

                                                    //This code checks whether an item id is available in the database
                                                    $count = mysqli_num_rows($result2);

                                                    if($count > 0)
                                                    {
                                                        while($rows=mysqli_fetch_assoc($result2)){
                                                            //This code gets the data from table
                                                            $delivery_status = $rows['delivery_status'];
                                                            

                                                            ?>

                                                            <option value="<?php echo $delivery_status; ?>"><?php echo $delivery_status; ?></option>

                                                            <?php
                                                        }
                                                        
                                                    }else{
                                                        ?>
                                                        <option value="0">No status available</option>

                                                        <?php

                                                    }

                                                ?>
                                </td>
                        </tr>

                        <tr>
                                <td colspan="2">
                                    <input type="hidden" name="order_status" value="<?php echo $delivery_status; ?>">

                                    <input type="submit" name="submit" value="Update" class="btn-secondary">
                                </td>
                        </tr>

                 </table>

                </form>

                <?php
                     if(isset($_POST['submit']))
                     {
                        
                        //This code gets the data from the form
                        $current_order_status = $_POST['current_order_status'];
                        $delivery_status = $_POST['order_status'];

                       
                       //This code updates the item in the database
                            $sql3 = "UPDATE orders SET 
                                    order_status = '$delivery_status'
                                    WHERE id = $id  
                                  ";

                         //This code executes the SQL Query to the database
                            $result3 = mysqli_query($conn, $sql3);

                             //Check if data is updated
                            if($result3 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['update-status'] = "<div class='success text-center'>Status Updated Successfully</div>";
                                header("location:".SITEURL.'Admin/orders.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['update-status'] = "<div class='error text-center'>Failed to update status</div>";
                                header("location:".SITEURL.'Admin/orders.php');
                            }


     
                     }

                ?>
    </div>

</div>






<?php include('partials/footer.php');?>