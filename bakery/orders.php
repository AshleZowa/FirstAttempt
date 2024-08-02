<?php  include( 'header.php');?>

<?php
    if(isset($_SESSION['order']))
    {
        echo $_SESSION['order'];
        unset($_SESSION['order']);
    }

?>

   

<div class="content">

    <h2 class= "text-center"> Confirm Item ordered</h2>

    <?php 
        //This code checks whether item id is set or not
        if(isset($_GET['food_id']))
        {
            //This code retrieves Item id of selected food
            $food_id = $_GET['food_id'];
            //This code executes the SQL Query
            $sql = "SELECT * FROM menu_items WHERE id=$food_id";
            $result = mysqli_query($conn, $sql);

            $count = mysqli_num_rows($result);

            if($count ==1)
            {
                $row = mysqli_fetch_assoc($result);

                $item_name =$row['item_name'];
                $price =$row['price'];
                $image =$row['image'];

            }else{


            }


        }
        else{
            //Redirects to home page
            
        }


    ?> 
   


    <form action="" method="POST" class="order">
        <fieldset>
            <legend>Selected food</legend>
            <br><br>
                <div class="food-menu-img">

                        <?php 
                            if($image =="")
                            {
                                echo "<div class='error text-center '>Image not available</div>";
                            }
                            else{
                                ?>
                                     <img src="<?php echo SITEURL;?>img/food/<?php echo $image;?>" width="100px" alt="">
                                <?php

                            }
                        ?>
                   
                </div>

                <div class="food-menu-desc">
                    <h2><?php echo $item_name;?></h2>
                    <input type="hidden" name="order_items" value="<?php echo $item_name;?>">
                    <p class="food-price">R<?php echo $price;?></p>
                    <input type="hidden" name="price" value="<?php echo $price;?>">
                    <br>

                    <div class="order-label">Quantity</div>
                    <input type="number" name="qty" class="input-responsive" value="1" required>
                    <br><br>

                    <input type="submit" name="submit" value="Confirm order" class="btn-secondary">
                    <br><br>
                </div>
        </fieldset>
        <br><br>
            <a href="<?php echo SITEURL; ?>customer-details.php" class="btn-secondary">NEXT</a>

    </form>

    <?php
        //This code checks whether the confirm order button is clicked
        if(isset($_POST['submit']))
        {
            //This code gets the data from the form
            $order_date = date("Y-m-d");

            $order_items = $_POST['order_items'];
            $price = $_POST['price'];
            $qty = $_POST['qty'];

            $total = $price * $qty;
            $order_status = "ordered";

            //This code stores data in database
            $sql2 ="INSERT INTO orders SET
                order_date = '$order_date',
                order_items = '$order_items',
                price = $price,
                qty = $qty,
                total = $total,
                order_status = '$order_status'
                ";
            //echo $sql2; die();

            //This code executes the SQL Query
            $result2 = mysqli_query($conn, $sql2);

            if($result2 == true)
            {
                $_SESSION['order'] = "<div class='success'>Order placed.</div>";

            }else{
                $_SESSION['order'] = "<div class='error'>Failed to make order.</div>";
                
            }

        }


    ?>

</div>
