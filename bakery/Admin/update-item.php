<?php include('partials/menu.php');?>


<?php 
    if(isset($_GET['id']))
    {
        //This gets the ID  data
        $id = $_GET['id'];
        $sql = "SELECT * FROM menu_items WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        $row=mysqli_fetch_assoc($result);

        //This code gets individual
        $item_name = $row['item_name'];
        $description = $row['description'];
        $current_image = $row['image'];
        $available = $row['available'];

    }else{
        
        //This code redirects to menu item page
        header("location:".SITEURL.'Admin/menu-items.php');

    }


?>

<div class="content">
           <div class="wrapper">
                <h1>Update Item</h1>
                <br/><br/><br/>

               

                <form action="" method="POST" enctype="multipart/form-data">
                    <table class="tbl-small">
                        <tr>
                                <td>Item name: </td>
                                <td>
                                    <input type="text" name="item_name" value="<?php echo $item_name; ?>">
                                </td>
                        </tr>

                        <tr>
                                <td>Description: </td>
                                <td>
                                   <textarea name="description" cols="30" rows="5"><?php echo $description; ?></textarea>
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
                                <td>Current_Image: </td>
                                <td>
                                    <?php 
                                        if($current_image =="")
                                        {
                                            echo "<div class='error'>Image not available</div>";

                                        }else{

                                            ?>
                                                 <img src="<?php echo SITEURL; ?>img/food/<?php echo $current_image; ?>" width="100px">

                                            <?php
                                        }
                                    
                                    ?>
                                </td>
                        </tr>

                        <tr>
                                <td>New Image: </td>
                                <td>
                                    <input type="file" name="image" >
                                </td>
                        </tr>

                        <tr>
                                <td>Available: </td>
                                <td>
                                    <input <?php if($available == "Yes") {echo "checked";} ?> type="radio" name="available" value="Yes" >Yes
                                    <input <?php if($available == "No") {echo "checked";} ?> type="radio" name="available" value="No" >No
                                </td>
                        </tr>

                        <tr>
                                <td>
                                    <input type="hidden" name="id" value="<?php echo $id; ?>">
                                    <input type="hidden" name="current_image" value="<?php echo $current_image; ?>">

                                    <input type="submit" name="submit" value="Update item" class="btn-secondary">
                                </td>
                        </tr>
   
                    
                 </table>

                </form>

                <?php
                     if(isset($_POST['submit']))
                     {
                        
                        //This code gets the data from the form
                        $id = $_POST['id'];
                        $item_name = $_POST['item_name'];
                        $description = $_POST['description'];
                        $price = $_POST['price'];
                        $current_image = $_POST['current_image'];

                        $available  = $_POST['available'];

                          //This code checks whether a button is clicked
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
                                    header("location:".SITEURL.'Admin/menu-items.php');
                                    die();
                                }

                                if($current_image!="")
                                {
                                    //This code removes image
                                   $remove_path ="../img/food/".$current_image;

                                   $remove = unlink($remove_path);
                                    //This checks whether image is removed
                                   if($remove==FALSE){
                                    
                                    $_SESSION['remove-failed'] =  "<div class='error text-center '>Failed to upload image</div>";
                                    header("location:".SITEURL.'Admin/menu-items.php');
                                    die();
                                }
        
                                }
    
                            }else{
                                $image = $current_image;   

                            }
    
                        }else{

                            $image = $current_image;
                        }
                            //This code updates the item in the database
                            $sql2 = "UPDATE menu_items SET 
                                    item_name ='$item_name',
                                    description = '$description',
                                    price = $price ,
                                    image = '$image',
                                    available = '$available'
                                    WHERE id = $id  
                                  ";

                         //This code executes the SQL Query to the database
                            $result2 = mysqli_query($conn, $sql2);

                             //Check if data is updated
                            if($result2 ==TRUE){

                                //Create session variable to display message
                                $_SESSION['update'] = "<div class='success'>Item Updated Successfully</div>";
                                header("location:".SITEURL.'Admin/menu-items.php');
                            }
                            else{

                                //Create session variable to display message
                                $_SESSION['update'] = "<div class='error'>Failed to update Item</div>";
                                header("location:".SITEURL.'Admin/menu-items.php');
                            }


     
                     }

                ?>


           </div>
        </div>





<?php include('partials/footer.php');?>