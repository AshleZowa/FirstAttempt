<?php include('partials/menu.php');?>

<?php 
    if(isset($_GET['id']))
    {
        //This gets the ID  data
        $id = $_GET['id'];
        $sql = "SELECT * FROM deliveries WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        $row=mysqli_fetch_assoc($result);

        //This code gets individual
        $delivery_status = $row['delivery_status'];
       

    }else{
        
        //This code redirects to menu item page
        header("location:".SITEURL.'Admin/deliveries.php');

    }


?>

<div class="content">
     <div class="wrapper">
                <h1>Update Status</h1>
                <br/><br/><br/>

               

                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                        <tr>
                                <td>Delivery_Status: </td>
                                <td>
                                    <input <?php if($delivery_status == "IN-Transit") {echo "checked";} ?> type="radio" name="delivery_status" value="In-Transit" >In-Transit
                                    <br/>
                                    <input <?php if($delivery_status == "Delivered") {echo "checked";} ?> type="radio" name="delivery_status" value="Delivered" >Delivered
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

                        $delivery_status = $_POST['delivery_status'];

                       
                       //This code updates the item in the database
                            $sql2 = "UPDATE deliveries SET 
                                    delivery_status = '$delivery_status'
                                    WHERE id = $id  
                                  ";

                         //This code executes the SQL Query to the database
                            $result2 = mysqli_query($conn, $sql2);

                             //Check if data is updated
                            if($result2 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['update-status'] = "<div class='success text-center'>Status Updated Successfully</div>";
                                header("location:".SITEURL.'Admin/deliveries.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['update-status'] = "<div class='error text-center'>Failed to update status</div>";
                                header("location:".SITEURL.'Admin/deliveries.php');
                            }


     
                     }

                ?>
    </div>

</div>




<?php include('partials/footer.php');?>