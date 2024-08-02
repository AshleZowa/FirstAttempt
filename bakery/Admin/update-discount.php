<?php include('partials/menu.php');?>

<?php 
    if(isset($_GET['id']))
    {
        //This gets the ID  data
        $id = $_GET['id'];
        $sql = "SELECT * FROM discounts WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        $row=mysqli_fetch_assoc($result);

        //This code gets individual
        $discount_percentage = $row['discount_percentage'];
        $start_date = $row['start_date'];
        $end_date = $row['end_date'];
       

    }else{
        
        //This code redirects to menu item page
        header("location:".SITEURL.'Admin/discounts.php');

    }


?>

<div class="content">
     <div class="wrapper">
                <h1>Update Status</h1>
                <br/><br/><br/>

               

                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                        <tr>
                                <td>Discount Percentage: </td>
                                <td>
                                    <input type="number" name="discount_percentage">
                                </td>
                        </tr>

                        <tr>
                                <td>Start Date: </td>
                                <td>
                                    <input type="date" name="start_date">
                                </td>
                        </tr>

                        <tr>
                                <td>End Date: </td>
                                <td>
                                  <input type="date" name="end_date">
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

                        $discount_percentage = $_POST['discount_percentage'];
                        $start_date = $_POST['start_date'];
                        $end_date = $_POST['end_date'];


                       
                       //This code updates the item in the database
                            $sql2 = "UPDATE discounts SET 
                                    discount_percentage = $discount_percentage,
                                    start_date = '$start_date',
                                    end_date = '$end_date'
                                    WHERE id = $id  
                                  ";

                         //This code executes the SQL Query to the database
                            $result2 = mysqli_query($conn, $sql2);

                             //Check if data is updated
                            if($result2 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['update-discount'] = "<div class='success text-center'>Discount Updated Successfully</div>";
                                header("location:".SITEURL.'Admin/discounts.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['update-discount'] = "<div class='error text-center'>Failed to update discount</div>";
                                header("location:".SITEURL.'Admin/discounts.php');
                            }


     
                     }

                ?>
    </div>

</div>




<?php include('partials/footer.php');?>