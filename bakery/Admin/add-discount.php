<?php include ('partials/menu.php'); ?>

   

<div class="content">
           <div class="wrapper">
                <h1>Add Discount</h1>
                <br/><br/>


                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                        <tr>
                                <td>Discount Code: </td>
                                <td>
                                    <input type="text" name="discount_code" placeholder="">
                                </td>
                        </tr>

                        <tr>
                                <td>Discount Percentage: </td>
                                <td>
                                    <input type="number" name="discount_percentage" placeholder="">
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
                                    <input type="date" name="end_date" >
                                </td>
                        </tr>

                        <tr>
                                <td colspan="2">
                                    <input type="submit" name="submit" value="Add Discount" class="btn-secondary">
                                </td>
                        </tr>
   
                    
                 </table>

                </form>

                
            <?php
                //This code submits the data into the database table
                if(isset($_POST['submit']))
                {
                    //This code gets data from form 
                    $discount_code = $_POST['discount_code'];
                    $discount_percentage = $_POST['discount_percentage'];
                    $start_date = $_POST['start_date'];
                    $end_date = $_POST['end_date'];

                    //This code performs a SQL Query to add to the database
                    $sql = " INSERT INTO  discounts SET
                    discount_code ='$discount_code',
                    discount_percentage = $discount_percentage,
                    start_date = '$start_date',
                    end_date ='$end_date'
                    ";

                    $result = mysqli_query($conn, $sql);

                    //This code checks if the action has been successful or not 
                    if($result == true){

                        $_SESSION['add-discount'] = "<div class='success'>Discount successfully added </div>";
                        header("location:".SITEURL.'Admin/discounts.php');

                    }else{

                        $_SESSION['add-discount'] = "<div class ='error'>Failed to add discount. Please try again</div>";
                        header("location:".SITEURL.'Admin/discounts.php');
                    }

                }


            ?>

               
           </div>
 </div>



<?php include ('partials/footer.php'); ?>