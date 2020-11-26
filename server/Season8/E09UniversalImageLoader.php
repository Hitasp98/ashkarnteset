<?php

include './Config.php';
include './MyPDO.php';


$query = "SELECT * FROM customers";

$conn = MyPDO::getInstance();

$stmt = $conn->prepare($query);

$response = array();

try {
    $stmt->execute() ;
    
    while($res = $stmt->fetch(PDO::FETCH_ASSOC))
            array_push($response , $res);
    
    
    
    echo json_encode($response);
} catch (PDOException $exc) {
    echo $exc->getTraceAsString();
}
