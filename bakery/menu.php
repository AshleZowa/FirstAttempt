<?php  include( 'header.php');?>

<div class="content">
    <div class="wrapper">
        <h2 class="text-center">Food Menu</h2>  

        <?php 
        
            //This code retrieves all available items in the database
            $sql = "SELECT * FROM menu_items WHERE available= 'Yes' LIMIT 2";

            $result = mysqli_query($conn, $sql);
            $count = mysqli_num_rows($result);

            //This code checks whether items are available in table
            if($count > 0)
            {
                while($row= mysqli_fetch_assoc($result))
                {
                    $id = $row['id'];
                    $item_name = $row['item_name'];
                    $description = $row['description'];
                    $price = $row['price'];
                    $image = $row['image'];

                    ?>
                        <div class="food-menu-box">
                            <div class="food-menu-img">
                                <?php 
                                    //This code whether image is available
                                    if($image== "")
                                    {
                                        echo " <div class='error'>Image not available.</div>";

                                    }else{
                                        ?>
                                        <img src="<?php echo SITEURL;?>img/food/<?php echo $image;?>" width="100px" alt="">
                                        <?php
                                    }
                                ?>
                               
                            </div>

                            <div class="food-menu-desc">
                                <h2><?php echo $item_name;?></h2>
                                <p class="food-price">R<?php echo $price;?></p>
                                <p class="food-info">
                                    <?php echo $description;?>
                                </p>
                                <br>

                                <a href="<?php echo SITEURL;?>orders.php?food_id=<?php echo $id ;?>" class="btn success">Order now</a>
                            </div>
                        </div>
              


                    <?php
                }
            }
            else
            {

                echo " <div class='error'>Food not available.</div>";
            }

        ?>
                   

    </div>
</div>






