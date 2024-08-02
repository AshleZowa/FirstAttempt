<?php

include('../config/constants.php');

    //This code destroys the session and redirects to log in page
    session_destroy();

    header("location:".SITEURL.'index.php');

?>