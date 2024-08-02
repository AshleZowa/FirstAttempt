<?php
//The php code

$forename = $surname = $username = $password = $email = "";

if(isset($_POST['forename']))
    $forename = fix_string($_POST['forename']);
if(isset($_POST['surname']))
    $surname = fix_string($_POST['surname']);
if(isset($_POST['username']))
    $username = fix_string($_POST['username']);
if(isset($_POST['password']))
    $password = fix_string($_POST['password']);
if(isset($_POST['email']))
    $email= fix_string($_POST['email']);

$fail  = validate_forename($forename);
$fail .= validate_surname($surname);
$fail .= validate_username($username);
$fail .= validate_password($password);
$fail .= validate_email($email);

echo "<!DOCTYPE html>\n<html><head><title>An Example Form</title>";

if ($fail == "")
{
    echo "</head><body>Form data successfully validated:
    $forename, $surname, $username, $password, $email.</body></html>";

    exit;
}

echo <<<_END

<!--The HTML/Javascript section-->

<style>
.signup{
    border:1px solid #999;
    font: normal 14px helvetica;
    color: #444;
}
</style>
<script>
function validate(form)
{
    fail = validateForename(form.forename.value)
    fail += validateSurname(form.surname.value)
    fail += validateUsername(form.username.value)
    fail += validatePassword(form.password.value)
    fail += validateEmail(form.email.value)

    if (fail == "")  return true
    else{ alert(fail); return false }
}


function validateForename(field)
{
    return (field == "") ? "No Forename was entered.\n" : ""
}


function validateSurname(field)
{
    return (field == "") ? "No Surname was entered.\n" : ""
}

function validateUsername(field)
{
    if(field == "") return  "No Username was entered.\n"
    else if(field.length < 5)
        return "Username must be at least 5 characters.\n"
    else if (/^a-zA-Z0-9_-]/.test(field))
        return "only a-z, A-Z, 0-9, - and _ allowed in username.\n"
    return ""
}

function validatePassword(field)
{
    if(field == "") return  "No Password was entered.\n"
    else if(field.length < 6)
        return "Username must be at least 6 characters.\n"
    else if (!/[a-z]/.test(field) ||!/[A-Z]/.test(field) ||
            !/[0-9]/.test(field))
        return "Passwords require one of each, a-z, A-Z and 0-9.\n"
    return ""
}

function validateEmail(field)
{
    if(field == "") return  "No Email was entered.\n"
    else if(!((field.indexOf(".") > 0) &&
            (field.indexOf("@")> 0)) ||
            /[^a-zA-Z0-9.@_-]/.test(field))
        return "Email address is invalid.\n"
    return ""
}

</script>
    <link rel="stylesheet"  href="style.css">
</head>
<body>
    <div class="main">
        <div class="navbar">
            <div class="icon">
                <h2 class="logo">World Of Photography</h2>
            </div>
            <div class="menu">
                <ul>
                     <li><a href="index.html">Home</a></li>
                     <li><a href="about.html">About </a></li>
                     <li><a href="service.html">Services</a></li>
                     <li><a href="contact.html">Contact </a></li>
                </ul>
            
            
            </div>
        </div>
        <div class="content">
            <h1>Welcome <br><span>to the world </span><br>of photography</h1>
            <p class="par">Capturing moments,  <br>creating stories, <br>inspiring minds <br><br><br>Fill in the form now and become a member. 
            <br>or <br>Click <a href="form.html">HERE</a> to send me a direct message.</p> 

        </div>
        </div>
    <table class="signup" border="0" cellpadding="2" 
        cellspacing="5" bgcolor="#eeeee">
        <th colspan="2" align="center"  >Signup Form</th>
        <form method="post" action="adduser.php" onsubmit="return validate(this)">
            <tr><td>Forename</td>
                <td><input type="text" maxlength="32" name="forename"></td></tr>
            <tr><td>Surname</td>
                <td><input type="text" maxlength="32" name="surname"></td></tr>
            <tr><td>Username</td>
                <td><input type="text" maxlength="16" name="username"></td></tr>
            <tr><td>Password</td>
                <td><input type="text" maxlength="12" name="password"></td></tr>
            <tr><td>Email</td>
                <td><input type="text" maxlength="64" name="email"></td></tr>
            <tr><td colspan="2" align="center"><input type="submit"
                    value="Signup"></td></tr>
        </form>
    </table>
   </div> 
   <footer>
        <a href="#">Ashley Zowa </a> 
        <a href="#">04HA2101882@myboston.co.za </a> 
        <a href="#">04HA2101882</a>
    </footer> 
    <script src="script.js"></script>   
</body>
</html>

_END;
//The php functions

function validate_forename($field)
{
    return ($field == "") ? "No Forename was entered<br>" : "";
}

function validate_surname($field)
{
    return ($field == "") ? "No Surname was entered<br>" : "";
}

function validate_username($field)
{
    if($field == "") return  "No Username was entered<br>";
    else if(strlen($field) < 5)
        return "Usernames must be at least 5 characters<br>";
    else if (preg_match("/[^a-zA-Z0-9_-]/", $field))
        return "Only letters, numbers, - and _ in usernames<br>";
    return "";
}

function validate_password($field)
{
    if($field == "") return  "No Password was entered<br>";
    else if(strlen($field) < 6)
        return "Passwords must be at least 6 characters<br>";
    else if (!preg_match("/[a-z]/", $field) ||
             !preg_match("/[A-Z]/", $field) ||
             !preg_match("/[0-9]/", $field))
        return "Passwords require one of each, a-z, A-Z and 0-9<br>";
    return "";
}

function validate_email($field)
{
    if($field == "") return  "No Email was entered<br>";
    else if(!((strpos($field, ".") > 0) &&
              (strpos($field, "@")> 0)) ||
              preg_match("/[^a-zA-Z0-9.@_-]/" , $field))
        return "Email address is invalid<br>";
    return "";
}

function fix_string($string)
{
    if (get_magic_quotes_gpc()) $string = stripslashes($string);
    return htmlentities($string);
}
?>



