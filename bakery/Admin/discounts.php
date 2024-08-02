<?php include('partials/menu.php');?>




 <div class="content">
    <div class="wrapper">
                <h1>Manage Discounts</h1>

                <br/><br/><br/>


                 <!--Button to Add admin-->
                <a href="<?php echo SITEURL; ?>Admin/add-discount.php" class="btn-primary">Add Discount</a>

                <?php

                    if(isset($_SESSION['add-discount'])){
                        echo  $_SESSION['add-discount'];
                        unset( $_SESSION['add-discount']);
                    }

                    if(isset($_SESSION['update-discount'])){
                        echo  $_SESSION['update-discount'];
                        unset( $_SESSION['update-discount']);
                    }

                    if(isset($_SESSION['delete-discount'])){
                        echo  $_SESSION['delete-discount'];
                        unset( $_SESSION['delete-discount']);
                    }


                ?>

                <br/><br/><br/>

                <table class="tbl-full">
                        <tr>
                                <th>ID</th>
                                <th>Discount Code</th>
                                <th>Discount Percentage</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Actions</th>
                        </tr>

                        <?php
                    //This code executes the query to get all admin data from database
                        $sql = "SELECT * FROM discounts";

                        $result = mysqli_query($conn, $sql);

                        if($result==TRUE){
                            //This code retrieves all rows from database table
                            $count = mysqli_num_rows($result);

                            $idn=1; //This value allows the displayed ID number to increase by 1

                            if($count > 0)
                            {
                                while($rows=mysqli_fetch_assoc($result)){
                                    //Using while loop to get data from database table
                                    $id=$rows['id'];
                                    $discount_code=$rows['discount_code'];
                                    $discount_percentage=$rows['discount_percentage'];
                                    $start_date=$rows['start_date'];
                                    $end_date=$rows['end_date'];

                                    //This code displays values in table on manage admin page
                                    ?>

                                        <tr>
                                            <td><?php echo $idn++; ?></td>
                                            <td><?php echo $discount_code; ?></td>
                                            <td><?php echo $discount_percentage; ?>%</td>
                                            <td><?php echo $start_date; ?></td>
                                            <td><?php echo $end_date; ?></td>
                                            <td >
                                                  <a href="<?php echo SITEURL; ?>Admin/update-discount.php?id=<?php echo $id; ?>" class="btn-secondary">Update discount</a>
                                                  <a href="<?php echo SITEURL; ?>Admin/delete-discount.php?id=<?php echo $id; ?>&start_date=<?php echo $start_date; ?>&end_date=<?php echo $end_date; ?>" class="btn-tertiary">Delete discount</a>
                                            </td>
                                        </tr>

                                         <?php
                                }
                            }
                            else{
                                echo "<tr><td colspan='6' class ='error'>Nothing Added yet.</td></tr>"; 

                            }
                        }
                     ?>

                </table>

                

           </div>
        </div>

        <?php include('partials/footer.php');?>