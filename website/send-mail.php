<?php

$to = "04HA2101882@myboston.co.za";
$subject = "Contact Form Submission";

$name = $_POST["name"];
$email = $_POST["email"];
$message = $_POST["message"];

$body = "Name: $name\nEmail: $email\nMessage: $message";

mail($to, $subject, $body);

header( "Location: /thank-you.html");

?>