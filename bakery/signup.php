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

        h4{
            text-align: center;
            font-size: 50px;
        }

       
    </style>
 <script>
    function checkUser(user){
        if(user.value == ''){
            $('#used').html('&nbsp;')
            return
        }

        $.post('checkUser.php', {
            user : user.value
        }, function(data){
            $('#used').html(data)
        })
    }
</script>
_END;

    $error = $user = $pass = "";
    if (isset($_SESSION['user'])) destroySession();

    if (isset($_POST['user'])){
        $user = sanitizeString($_POST['user']);
        $pass = md5(sanitizeString($_POST['pass']));

        if($user == "" || $pass == "")
        $error = 'Please make sure to fill all fields<br><br>';
    else{
        $result = queryMysql("SELECT * FROM members WHERE user='$user'");

        if ($result->rowCount())
        $error = 'That username already exists<br><br>';

        else{
            queryMysql("INSERT INTO members VALUES('$user' , '$pass')");
            die('<h4> Account created<br><br>Please log in. </h4> </div></body></html>');
        }
    }
    }

echo <<<_END
    <form method= 'post' action='signup.php?r=$randstr'>$error
    <div data-role= 'fieldcontain'>
        <h3>Please enter your details to sign up<br></h3>        
        </div>
     <div data-role= 'fieldcontain'>
        <label>Username</label>
       <input type= 'text' maxlength= '16' name='user' value='$user'
            onBlur= 'checkUser(this)'>
         <label></label><div id='used'>&nbsp;</div>
        </div>
    <div data-role= 'fieldcontain'>
        <label>Password</label>
        <input type= 'text' maxlength= '16' name='pass' value='$pass'>
        </div>
    <div data-role= 'fieldcontain'>
        <label></label>
       <input data-transition= 'slide' type= 'submit' value= 'Sign Up'>
        </div>
    </div>
    </body>
    </html>
_END;

?>