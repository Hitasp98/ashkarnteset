<?php

include './Config.php';
include './MyPDO.php';
 
$conn = MyPDO::getInstance();

$query = "SELECT fname , lname FROM users";

$stmt = $conn->prepare($query);
$response = array();
try {
    $stmt->execute();
     
    while($res = $stmt->fetch(PDO::FETCH_ASSOC)) { 
        $name = $res['fname'] . " " . $res['lname'];
        array_push($response , $name);
    }
    
    
    echo json_encode($response);
    
    
    
} catch (PDOException $exc) {
    echo $exc->getTraceAsString();
}




