<?php  include( 'header.php');?>

<?php
    if(isset($_SESSION['customer']))
    {
        echo $_SESSION['customer'];
        unset($_SESSION['customer']);
    }

?>


<div class="content">
    <h2 class= "text-center"> Enter customer details</h2>

    <?php 
    if(isset($_GET['id']))
    {
        //This gets the ID  data
        $id = $_GET['id'];
        $sql = "SELECT * FROM orders WHERE id=$id";

        $result = mysqli_query($conn, $sql);

        $row=mysqli_fetch_assoc($result);

        //This code gets individual
        $id = $row['id'];
        

    }else{
        
        //This code redirects to menu item page

    }


?>
<form action="" method="POST" class="order">

    <fieldset>
        <legend>Customer Details</legend>
        <br>
        <div>Order ID</div>
        <select name="order_id">
                                        <?php
                                             //This code retrives the data from database

                                            //This code displays prices from database
                                            $sql4 = "SELECT * FROM orders";

                                            $result4 = mysqli_query($conn, $sql4);

                                            //This code checks whether an item id is available in the database
                                            $count = mysqli_num_rows($result4);

                                            $idn=1;

                                            if($count > 0)
                                            {
                                                while($rows=mysqli_fetch_assoc($result4)){
                                                    //This code gets the data from table
                                                    $id=$rows['id'];
                                                    

                                                    ?>

                                                    <option value="<?php echo $idn++; ?>"><?php echo $idn++; ?></option>

                                                    <?php
                                                }
                                                
                                            }else{
                                                ?>
                                                 <option value="0">No id available</option>

                                                 <?php

                                            }

                                        ?>
                                           
                                    </select>
       
        <br><br>
        <div>Full name</div>
        <input type="text" name="name" placeholder="Enter your name" class= "input-responsive" required>
        <br><br>
        <div>Email</div>
        <input type="email" name="email" placeholder="Enter your email" class= "input-responsive" required>
        <br><br>
        <div>Address</div>
        <textarea name="address" cols="30" rows="3"></textarea>
        <br><br>
        <div>Contact</div>
        <input type="tel" name="phone_number" placeholder="Enter your phone number" class= "input-responsive" required>
        <br><br>
        <input type="submit" name="submit" value="Submit details" class="btn-secondary">

    </fieldset>
    <br><br>
            <a href="<?php echo SITEURL; ?>main.php" class="btn-secondary">DONE</a>

 </form>   
           
           <?php
        //This code checks whether the confirm order button is clicked
        if(isset($_POST['submit']))
        {
            //This code gets the data from the form
            $order_id = $_POST['order_id'];
            $name = $_POST['name'];
            $email = $_POST['email'];
            $address = $_POST['address'];
            $phone_number = $_POST['phone_number'];
           
             //This code stores data in database
             $sql2 ="INSERT INTO customers SET
                    order_id = '$order_id',
                    name = '$name',
                    email = '$email',
                    address = '$address',
                    phone_number = $phone_number
                ";

              //This code executes the SQL Query
            $result2 = mysqli_query($conn, $sql2);

            if($result2 ==true)
            {
                $_SESSION['customer'] = " <div class='success'>Order placed succesfully.</div>";
            

            }else{
                $_SESSION['customer'] = " <div class='error'>Failed to confirm order.</div>";
               
            }   


        }


    ?>

</div>


