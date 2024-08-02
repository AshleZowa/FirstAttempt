<?php include ('partials/menu.php'); ?>

    <div class="content">
           <div class="wrapper">
                <h1>Add item price</h1>
                <br/><br/>


                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                    
                        <tr>
                                <td>Price: </td>
                                <td>
                                    <input type="number" name="price" >
                                </td>
                                
                        </tr>

                        <tr>
                                <td>Start_date: </td>
                                <td>
                                    <input type="date" name="start_date" >
                                </td>
                        </tr>

                        <tr>
                                <td>End_date: </td>
                                <td>
                                <input type="date" name="end_date" >
                                </td>
                        </tr>

                        <tr>
                                <td colspan="2">
                                    <input type="submit" name="submit" value="Add Price" class="btn-secondary">
                                </td>
                        </tr>
   
                    
                 </table>

                </form>

                <?php
                    //This code submits the data into the database table
                    if(isset($_POST['submit']))
                    {
                        //This code gets data from form 
                        $price= $_POST['price'];
                        $start_date = $_POST['start_date'];
                        $end_date = $_POST['end_date'];

                        //This code performs a SQL Query to add to the database
                        $sql = " INSERT INTO prices SET
                                    price = $price,
                                    start_date = '$start_date',
                                    end_date = '$end_date'
                                ";

                        $result = mysqli_query($conn, $sql);

                        //This code checks if the action has been successful or not 
                        if($result == true){

                            $_SESSION['add'] = "<div class='success'>Price successfully updated in menu</div>";
                            header("location:".SITEURL.'Admin/prices.php');

                        }else{

                            $_SESSION['add'] = "<div class ='error'>Price not updated in menu. Please try again</div>";
                            header("location:".SITEURL.'Admin/prices.php');
                        }

                    }


                ?>

           </div>
 </div>



<?php include ('partials/footer.php'); ?>