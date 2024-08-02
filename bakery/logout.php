<?php
    require_once 'header.php';

    if(isset($_SESSION['user']))
    {
        Session_destroy();
        echo "<br><div class='center'> You have been logged out. Please
              <a data-transition= 'slide' href= 'index.php?view=$user&r=$randstr'>Click here</a>
                 to refresh the screen.</div>";
    }
    else echo "<div class='center'> You cannot log out because you are not logged in</div>";

    echo <<<_END
    </div>
    </body>
    </html>
    _END;

?>