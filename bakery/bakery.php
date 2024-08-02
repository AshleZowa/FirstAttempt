<?php

//This code connects to the database
$host = 'localhost:3306';
$data = 'johns_bakery_db';
$user = 'root';
$pass = 'Password';
$chrs = 'utf8mb4';
$attr = "mysql:host=$host;dbname=$data;charset=$chrs";
$opts =
[
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    PDO::ATTR_EMULATE_PREPARES   => false,
];

try {
    $pdo = new PDO($attr, $user, $pass, $opts);
}
catch(\PDOException $e){
    throw new \PDOException($e->getMessage(), (int)$e->getCode());
}


function queryMysql($query){
    global $pdo;
    return $pdo->query($query);
}

function sanitizeString($var){
    global $pdo;
    $var = strip_tags($var);
    $var = htmlentities($var);

    if(get_magic_quotes_gpc())
        $var = striplashes($var);
    $result = $pdo->quote($var);
    return str_replace("'","", $result);
}

//This code performs the Logout or exit method
function destroySession(){
    $_SESSION=array();

    if(session_id() != "" || isset($_COOKIE[session_name()]))
     setcookie(session_name(), '', time()-2592000, '/');
    
    session_destroy();
   
}
?>





