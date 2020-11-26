<?php


include './ROUTER.php';     
include './Config.php';
include './MyPDO.php';
include './class/app.php';
include './class/message.php';
require_once 'class/Login.php';

$ROUTE = "";

if(!isset($_REQUEST["ROUTE"])  ) {
    die("no Direct Access") ;
}

$ROUTE = $_REQUEST['ROUTE'];
    

switch ($ROUTE) {
    case ROUTER::$params["Login"] :
    
   
        $login = new Login();  
        break;
    
    
    case ROUTER::$params['UploadPhoto'] : {
        require_once './class/UploadPhoto.php';
        $upload = new UploadPhoto();
        $upload->upload();
        break;
    }
    case ROUTER::$params['getPhotos'] : {
        require_once './class/UploadPhoto.php';
        $upload = new UploadPhoto(); 
        $upload->getPhotos();
        break;
    }

    default:
            echo "Wrong route ...";
        break;
}

















?>