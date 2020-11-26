<?php

class Login {
    
    
    public $response = array() ;
    
    public function __construct($autoLogin = true) { 
        if($autoLogin) { 
            if( !isset($_REQUEST[ROUTER::$params['username']]) ||
                !isset($_REQUEST[ROUTER::$params['password']])  ||
                !isset($_REQUEST[ROUTER::$params['create']]) 
                    ) 
                { 
                
                        $this->response[message::$MESSAGE] = message::$WRONG_DATA ;
                        echo json_encode($this->response);
                        exit;
                      
                }
                 
                
            $username = $_REQUEST[ROUTER::$params['username']];
            $password = $_REQUEST[ROUTER::$params['password']];
            $create   = $_REQUEST[ROUTER::$params['create']];
            
            $this->Login($username, $password , $create);  
        }
            
    }
    
    
    
    
    private function Registration($username , $password) {
        
        $conn        = MyPDO::getInstance(); 
        $longer_pass = app::generateRandomString(70);
        $session     = app::generateRandomString(70);
         
      
        $query =  " INSERT INTO users "
                . " (username , password , session , longer_pass) "
                . " VALUES "
                . " (:username , MD5(CONCAT(:password , :longer_pass)) , :session , :longer_pass) ";
        
        $stmt = $conn->prepare($query);
        
        $stmt->bindParam(":username" , $username);
        $stmt->bindParam(":password" , $password);
        $stmt->bindParam(":session"  , $session);
        $stmt->bindParam(":longer_pass" , $longer_pass);
        
        try {
                $stmt->execute();
                $this->response[message::$MESSAGE] = message::$SUCCESS_REGISTRATION;
                $this->response[message::$SESSION] = $session ;
                echo json_encode($this->response);
                exit;
        } catch (PDOException $ex) { 
                $this->response[message::$MESSAGE] = message::$ERROR;
                $this->response[message::$ERROR]   = __LINE__ . "-" . __FILE__ . "-" .$ex->getMessage();
                echo json_encode($this->response);
        }
        
        
        
        
        
    }
    
    
    
    private function Login($username , $password , $create = 0) {
        
        $conn = MyPDO::getInstance();
        $query = "SELECT username FROM users WHERE username = :username";
        
        $stmt = $conn->prepare($query);
        $stmt->bindParam(":username" , $username);
        
        try {
            $stmt->execute() ; 
            $res = $stmt->rowCount();

            if ($res < 1) {
                if($create == 1)
                    $this->Registration($username, $password);
                else {
                    $this->response[message::$MESSAGE] = message::$ACCOUNT_NOT_EXISTS; 
                }
            } else {
                
                //random string  
                $session     = app::generateRandomString(70);
                $conn = MyPDO::getInstance();
                $query = " UPDATE users SET session = :session "
                        . " WHERE username = :username AND password = MD5(CONCAT(:password , longer_pass))";

                $stmt = $conn->prepare($query);
                $stmt->bindParam(":username" , $username);
                $stmt->bindParam(":session"  , $session);
                $stmt->bindParam(":password" , $password);

                try {
                    $stmt->execute(); 
                    $res = $stmt->rowCount();
                    
                    if($res == 1) {//ok login
                        $this->response[message::$MESSAGE] = message::$SUCCESS_LOGIN;
                        $this->response[message::$SESSION] = $session ;
                    }
                    else {//failed login
                        $this->response[message::$MESSAGE] = message::$FAILED_LOGIN ;
                    }
                    
                } catch (PDOException $exc) {
                    $this->response[message::$MESSAGE] = message::$ERROR ;
                    $this->response[message::$ERROR]   = __LINE__ . "-" . __FILE__ . "-" .$ex->getMessage();
                
                }
            }
        } catch (PDOException $exc) {
              $this->response[message::$MESSAGE] = message::$ERROR ;
              $this->response[message::$ERROR]   = __LINE__ . "-" . __FILE__ . "-" .$ex->getMessage();
        }
            
        
        
        echo json_encode($this->response); 
        
        
        
        
        
        
    }
    
    
    public function checkLogin($username , $session) {
        
 
        
        $conn = MyPDO::getInstance();
        $query = "SELECT id FROM users WHERE username = :username AND session = :session";
        
        $stmt = $conn->prepare($query);
        
        $stmt->bindParam(":username" , $username);
        $stmt->bindParam(":session"  , $session);
        
        try {
            
            $stmt->execute() ;
            
            while($res = $stmt->fetch(PDO::FETCH_ASSOC)) {
                 return $res['id'];

            }
            
           
 
            
        } catch (PDOException $exc) {
         //   echo $exc->getTraceAsString();
         return -2;
        }
            
        return -1; 
        
        
        
        
    }
    
    
    
    
    
}