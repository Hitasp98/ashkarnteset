<?php

class UploadPhoto {
    
    
    public $response = array();
    public function __construct() {
         
    }
    
    public function upload() {
        
        if(
                !isset($_REQUEST[message::$SESSION]) ||
                !isset($_REQUEST[message::$TEXT])    ||
                !isset($_REQUEST[ROUTER::$params["username"]]) || 
                !isset($_FILES[message::$IMAGE]) 
                
                ) {
            
            $this->response[message::$MESSAGE] = message::$NOT_ENOUGH_DATA;
            echo json_encode($this->response);
            exit;            
        }
          
        
        $login = new Login(false);
        
        $username = $_REQUEST[ROUTER::$params["username"]];
        $session  = $_REQUEST[message::$SESSION] ;
        $text     = $_REQUEST[message::$TEXT];
        $userID = $login->checkLogin($username, $session);
         
        if($userID == -1 || $userID == -2) {
            $this->response[message::$MESSAGE] = message::$FAILED_LOGIN ;
            echo json_encode($this->response);
            exit;
        }
        
        
        
        //key IMAGE
        $fileName =    basename($_FILES[message::$IMAGE]["name"]);
        
        $imageFileType = strtolower(pathinfo($fileName , PATHINFO_EXTENSION));
        
        
        if($imageFileType != "jpg" && $imageFileType != "jpeg" && $imageFileType != "png") {
            
            $this->response[message::$MESSAGE] = message::$FILE_NOT_ALLOWED;
            echo json_encode($this->response);
            exit;
        }
        
        $hash = Config::$UPLOAD_DIRECTORY . app::generateRandomString(20) . "." . $imageFileType;
        
        if(move_uploaded_file($_FILES[message::$IMAGE]["tmp_name"] , $hash)) {   
            $this->response[message::$MESSAGE] = message::$SUCCESS_UPLOAD; 
             $this->registerImage($userID, $hash, $text);
        
        }
        else {
            $this->response[message::$MESSAGE] = message::$FAILED_UPLOAD ;
         }
         
         
         echo json_encode($this->response);
        
        
      
    }
    
    
    
    
    private function registerImage ($userID , $hash , $text) {
        
        $conn = MyPDO::getInstance();
        $query = "INSERT INTO images (user , image , text) VALUES (:user , :image , :text)";
        
        $stmt = $conn->prepare($query);
        
        $stmt->bindParam(":user" , $userID);
        $stmt->bindParam(":image" , $hash);
        $stmt->bindParam(":text"  , $text);
        
        try {
            $stmt->execute(); 
        } catch (PDOException $exc) {

            $this->response[message::$MESSAGE] = message::$ERROR;
            
            
        }
            
        
        
    }
    
    
    
    
    public function getPhotos() {
        
        
        if(
                !isset($_REQUEST[message::$SESSION]) || 
                !isset($_REQUEST[ROUTER::$params["username"]])   
                ) {
            
            $this->response[message::$MESSAGE] = message::$NOT_ENOUGH_DATA;
            echo json_encode($this->response);
            exit;            
        }
          
        
        $login = new Login(false);
        
        $username = $_REQUEST[ROUTER::$params["username"]];
        $session  = $_REQUEST[message::$SESSION] ; 
        $userID = $login->checkLogin($username, $session);
         
        $conn = MyPDO::getInstance();
        $query = "SELECT image , date , text FROM images WHERE user = :user ORDER BY id DESC";
        $stmt = $conn->prepare($query) ;
        $stmt->bindParam(":user" , $userID);
        $images = array() ;
        try {
            $stmt->execute();
            while($res = $stmt->fetch(PDO::FETCH_ASSOC)) {
                array_push($images , $res);
            }
        } catch (PDOException $exc) {
            $this->response[message::$MESSAGE] = message::$ERROR;
        }
            
//        $this->response[message::$MESSAGE] = message::$IMAGE;
//        $this->response[message::$IMAGE] = $images; 
        echo json_encode($images);
            
            
        
    }
    
    
}