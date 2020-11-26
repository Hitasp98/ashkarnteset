<?php

require_once './Config.php';
require_once './MyPDO.php' ;
require_once './ROUTER.php';

$conn = MyPDO::getInstance();

$query = "SELECT * FROM customers";


$stmt = $conn->prepare($query);

$response = array();
try { 
    
    $stmt->execute(); 
    while($res = $stmt->fetch(PDO::FETCH_ASSOC)) {
    
        $row = array();
        
//        $row[ROUTER::$CustomerID]   = $res["CustomerID"];
//        $row[ROUTER::$CustomerName] = $res["CustomerName"];
//        $row[ROUTER::$ContactName]  = $res["ContactName"];
//        $row[ROUTER::$Address]      = $res["Address"];
//        $row[ROUTER::$City]         = $res["City"];
//        $row[ROUTER::$PostalCode]   = $res["PostalCode"];
//        $row[ROUTER::$Country]      = $res["Country"];
//        
        
        
       
         $row[ROUTER::$params['CustomerID']]   = $res['CustomerID']  ;
         $row[ROUTER::$params['CustomerName']] = $res["CustomerName"];
         $row[ROUTER::$params['ContactName']]  = $res['ContactName'] ;
         $row[ROUTER::$params["Address"]]      = $res["Address"]     ;
         $row[ROUTER::$params["City"]]         = $res["City"]        ;
         $row[ROUTER::$params["PostalCode"]]   = $res["PostalCode"]  ;
         $row[ROUTER::$params["Country"]]      = $res["Country"]     ;
         
         
         
            array_push($response , $res);
            
        
    }
    
   
     echo json_encode($response);
    
    
    
} catch (PDOException $exc) {
    echo $exc->getTraceAsString();
}
