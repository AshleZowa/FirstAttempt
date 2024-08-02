<?php include ('partials/menu.php'); ?>



<div class="content">
    <div class="wrapper">
                <h1>Add to Inventory</h1>
                <br/><br/>


                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">


                        <tr>
                                <td>Item: </td>
                                <td>
                                    <input type="text" name="item_name" placeholder="Food item name">

                                </td>
                        </tr>  
                    
                        <tr>
                        <tr>
                                <td>Quantity: </td>
                                <td>
                                    <input type="number" name="quantity" placeholder="Enter quantity here">
                                </td>
                        </tr>

                                </td>
                                
                        </tr>

                       

                        <tr>
                                <td>Available: </td>
                                <td>
                                    <input type="radio" name="available" value="Yes" >Yes 
                                    <br>
                                    <input type="radio" name="available" value="No" >No
                                </td>
                        </tr>

                        <tr>
                                <td colspan="2">
                                    <input type="submit" name="submit" value="Add to Inventory" class="btn-secondary">
                                </td>
                        </tr>
   
                    
                 </table>

                </form>

                <?php
                     if(isset($_POST['submit']))
                     {
                        
                        //This code gets the data from the form
                        $item_name = $_POST['item_name'];
                        $quantity = $_POST['quantity'];
                       

                        
                         //This code checks whether radio buttons are selected
                            if(isset($_POST['available']))
                            {
                                $available = $_POST['available'];
                            }else{

                                $available = "No"; //This is a default value
                            }

                        
                            //This code updates the item in the database
                            $sql2 = "INSERT INTO  inventory SET 
                                    item_name = '$item_name',
                                    quantity = $quantity,
                                    available = '$available' 
                                  ";

                         //This code executes the SQL Query to the database
                            $result2 = mysqli_query($conn, $sql2);

                             //Check if data is updated
                            if($result2 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['inventory'] = "<div class='success text-center'> Added to inventory Successfully</div>";
                                header("location:".SITEURL.'Admin/inventory.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['inventory'] = "<div class='error text-center'>Failed to add to inventory</div>";
                                header("location:".SITEURL.'Admin/inventory.php');
                            }


     
                     }

                ?>


     </div>

</div>





<?php include ('partials/footer.php'); ?>