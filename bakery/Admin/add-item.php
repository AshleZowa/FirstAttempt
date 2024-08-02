<?php include ('partials/menu.php'); ?>

<div class="content">
           <div class="wrapper">
                <h1>Add menu item</h1>
                <br/><br/>
               
                     <?php 
                        if(isset($_SESSION['upload'])){
                            echo $_SESSION['upload'];
                            unset($_SESSION['upload']);
                        }

                    ?>


                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                        <tr>
                                <td>Item name: </td>
                                <td>
                                <select name="item_name">
                                        <?php
                                             //This code retrives the data from database

                                            //This code displays prices from database
                                            $sql = "SELECT * FROM inventory";

                                            $result = mysqli_query($conn, $sql);

                                            //This code checks whether an item is available in the database
                                            $count = mysqli_num_rows($result);

                                            if($count > 0)
                                            {
                                                while($rows = mysqli_fetch_assoc($result)){
                                                    //This code gets the data from table
                                                    $id = $rows['id'];
                                                    $item_name = $rows['item_name'];

                                                    ?>

                                                    <option value="<?php echo $item_name; ?>"><?php echo $item_name; ?></option>

                                                    <?php
                                                }
                                                
                                            }else{
                                                ?>
                                                 <option value="0">No items in inventory</option>

                                                 <?php

                                            }

                                        ?>
                                           
                                    </select>
                                </td>
                        </tr>

                        <tr>
                                <td>Description: </td>
                                <td>
                                   <textarea name="description" cols="30" rows="5" placeholder="Food item description"></textarea>
                                </td>
                        </tr>

                        <tr>
                                <td>Price: </td>
                                <td>
                                <select name="price">
                                         <?php
                                             //This code retrives the data from database

                                            //This code displays prices from database
                                            $sql3 = "SELECT * FROM prices";

                                            $result3 = mysqli_query($conn, $sql3);

                                            //This code checks whether a price is available in the database
                                            $count = mysqli_num_rows($result3);

                                            if($count > 0)
                                            {
                                                while($rows=mysqli_fetch_assoc($result3)){
                                                    //This code gets the data from table
                                                    $price = $rows['price'];

                                                    ?>

                                                    <option value="<?php echo $price; ?>"><?php echo $price; ?></option>

                                                    <?php
                                                }
                                                
                                            }else{

                                                ?>
                                                 <option value="0">No Prices available</option>

                                                 <?php

                                            }

                                        ?>
                                        
                                    </select>
                                </td>
                                
                        </tr>

                        <tr>
                                <td>Image: </td>
                                <td>
                                    <input type="file" name="image" >
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

                                    <input type="submit" name="submit" value="Add item" class="btn-secondary">
                                </td>
                        </tr>
   
                    
                 </table>

                </form>

            <?php
                //This code submits the data into the database table
                if(isset($_POST['submit']))
                {
                    //This code gets data from form 
                    $item_name = $_POST['item_name'];
                    $description = $_POST['description'];
                    $price = $_POST['price'];


                     //This code checks whether radio buttons are selected
                    if(isset($_POST['available']))
                    {
                        $available = $_POST['available'];
                    }else{

                        $available = "No"; //This is a default value
                    }
                  
                  
                    if(isset($_FILES['image']['name']))
                    {
                        //This code retrieves image data
                        $image = $_FILES['image']['name'];

                        if($image!="")
                        {
                            //This piece of code represents the current location
                            $src = $_FILES['image']['tmp_name'];
                            //This piece of code represents the upload destination
                            $dst = "../img/food/".$image;

                            $upload = move_uploaded_file($src, $dst); //This code uploads the image selected

                            if($upload==FALSE){
                                $_SESSION['upload'] =  "<div class='error text-center '>Failed to upload image</div>";
                                header("location:".SITEURL.'Admin/add-item.php');
                                die();
                            }

                        }

                    }else{
                        $image = "";
                    }

                    //This code performs a SQL Query to add to the database
                    $sql2 = " INSERT INTO  menu_items SET
                            item_name ='$item_name',
                            description = '$description',
                            price = $price,
                            image ='$image',
                            available = '$available'
                            ";

                    $result2 = mysqli_query($conn, $sql2);

                    //This code checks if the action has been successful or not 
                    if($result2 == true){

                        $_SESSION['add'] = "<div class='success'>Item successfully added to menu</div>";
                        header("location:".SITEURL.'Admin/menu-items.php');

                    }else{

                        $_SESSION['add'] = "<div class ='error'>Item not added to menu. Please try again</div>";
                        header("location:".SITEURL.'Admin/menu-items.php');
                    }

                }


            ?>

               
           </div>
 </div>




<?php include ('partials/footer.php'); ?>