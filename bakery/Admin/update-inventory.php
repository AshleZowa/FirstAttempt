<?php include ('partials/menu.php'); ?>

<?php 
    if(isset($_GET['item_id']))
    {
        //This gets the ID  data
        $item_id = $_GET['item_id'];
        $sql = "SELECT * FROM inventory WHERE item_id=$item_id";

        $result = mysqli_query($conn, $sql);

        $row=mysqli_fetch_assoc($result);

        //This code gets individual
        $quantity = $row['quantity'];
        $available = $row['available'];
       

    }else{
        
        //This code redirects to menu item page
        header("location:".SITEURL.'Admin/inventory.php');

    }


?>

<div class="content">
     <div class="wrapper">
                <h1>Update Inventory Item</h1>
                <br/><br/><br/>

               

                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                    <tr>
                                <td>Quantity: </td>
                                <td>
                                    <input type="number" name="quantity" placeholder="Enter quantity here">
                        
                                </td>
                        </tr>

                        <tr>
                                <td>Available: </td>
                                <td>
                                    <input <?php if($available == "Yes") {echo "checked";} ?> type="radio" name="available" value="Yes" >Yes
                                    <br/>
                                    <input <?php if($available == "No") {echo "checked";} ?> type="radio" name="available" value="No" >No
                                </td>
                        </tr>

                        <tr>
                                <td colspan="2">
                                    <input type="submit" name="submit" value="Update" class="btn-secondary">
                                </td>
                        </tr>

                 </table>

                </form>

                
                <?php
                     if(isset($_POST['submit']))
                     {
                        
                        //This code gets the data from the form

                        $quantity = $_POST['quantity'];
                        $available = $_POST['available'];

                       
                       //This code updates the item in the database
                            $sql2 = "UPDATE inventory SET 
                                    quantity = $quantity,
                                    available = '$available'
                                    WHERE item_id = $item_id
                                  ";

                         //This code executes the SQL Query to the database
                            $result2 = mysqli_query($conn, $sql2);

                             //Check if data is updated
                            if($result2 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['update-inventory'] = "<div class='success text-center'>Item Updated Successfully</div>";
                                header("location:".SITEURL.'Admin/inventory.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['update-inventory'] = "<div class='error text-center'>Failed to update Item</div>";
                                header("location:".SITEURL.'Admin/inventory.php');
                            }


     
                     }

                ?>
    </div>

</div>




<?php include ('partials/footer.php'); ?>