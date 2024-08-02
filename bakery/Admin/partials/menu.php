<?php 

    include('../config/constants.php');
    include('login-check.php'); 

?>



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bakery management website</title>
    <link rel="stylesheet"  href="../css/admin.css">
</head>
<body>
   <div class="main">
        <div class="navbar">
            <div class="icon">
                <h2 class="logo">John's Bakery</h2>
            </div>
            <div class="menu">
                <ul>
                    <li><a href="admin.php">Home</a></li>
                    <li><a href="manage-admin.php">Admin</a></li>
                     <li><a href="customers.php">Customers</a></li>
                     <li><a href="orders.php">Orders</a></li>
                     <li><a href="menu-items.php">Menu</a></li>
                     <li><a href="deliveries.php">Deliveries</a></li>
                     <li><a href="prices.php">Prices</a></li>
                     <li><a href="inventory.php">Inventory</a></li>
                     <li><a href="discounts.php">Discounts</a></li>
                     <li><a href="logout.php">Logout</a></li>
                </ul>           
            </div>
        </div>