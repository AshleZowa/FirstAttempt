<?php

require_once 'header.php';

echo <<<_END
    <style>
        body{
            font-family:  sans-serif;
        }
       
        form{
            width:500px;
            margin:0 auto;
            margin-top: 50px;
        }

        input, textarea{
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
        }

        h3{
            padding: 10px;
            text-align: center;
        }

       
    </style>
   
_END;
$error = $user = $pass = "";


if (isset($_POST['user'])){
       
    $user = sanitizeString($_POST['user']);
    $pass = md5(sanitizeString($_POST['pass']));

  
    if($user == "" || $pass == "")
    $error = 'Please make sure to fill all fields<br><br>';
else{
    $result = queryMysql("SELECT  user, pass FROM members
    WHERE user='$user' AND pass='$pass'");

    if ($result->rowCount() == 0){
        $error = "Invalid login attempt";
    }
    else{
        $_SESSION['user'] = $user;
        $_SESSION['pass'] = $pass;

        die("<div class='center'> You are now logged in. Please
        <a data-transition= 'slide' href= 'main.php?view=$user&r=$randstr'>Click here</a>
        to continue.</div></div></body></html>");
    }
}
}
 

echo <<<_END
    <form method='post' action='login.php?r=$randstr' onsubmit='return validate(this)'>
        <div data-role= 'fieldcontain'>
            <label></label>  
            <span class='error'>$error</span>      
        </div>
         <div data-role= 'fieldcontain'>
            <h3>Please enter your details to log in</h3>
        </div>
         <div data-role= 'fieldcontain'>  
            <label>Username</label>
            <input type= 'text' maxlength= '16' name='user' value='$user'
         </div>
        <div data-role= 'fieldcontain'>
            <label>Password</label>
            <input type= 'password' maxlength= '16' name='pass' value='$pass'>
        </div>
        <div data-role= 'fieldcontain'>
            <label></label>
            <input data-transition= 'slide' type= 'submit' value= 'Login'>
        </div>
    </form>
   </div>
  </body>
 </htmml>
_END;



?>

