
<?php include('partials/menu.php');?>

        <div class="content">
           <div class="wrapper">
                <h1>Dashboard</h1>

                <br><br>
                <?php
                     if(isset($_SESSION['login'])){
                        echo $_SESSION['login'];
                        unset($_SESSION['login']);
                    }
                ?>
                <br><br>
                    <h1 class='text-center'>Welcome back Admin.</h1>

           </div>
        </div>
  
<?php include('partials/footer.php');?>
