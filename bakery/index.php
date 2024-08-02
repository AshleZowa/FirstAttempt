<?php
    
    require_once 'header.php';

    echo "<div class= 'center'>Welcome to John's Bakery,";

    if($loggedin) echo "$user, you are logged in";
    else          echo 'please sign up or log in';

    echo <<<_END
    </body>
    </html>
    _END;

?>