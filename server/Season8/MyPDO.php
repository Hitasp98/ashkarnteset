<?php



class MyPDO extends PDO {
    
    private static $instance ;
    
    
    public function __construct() {
        
        try {
            
           parent::__construct("mysql:host=".Config::$serverName.";dbname=".Config::$dbName, Config::$username, Config::$password);
           self::$instance = $this;
           self::$instance->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
           self::$instance->exec("set names utf8");
        }
        catch(PDOException $e) {
            echo $e->getMessage();
        }
    }
    
    
    
    public static function getInstance() {
        if(self::$instance == NULL) {
            
            self::$instance = new PDO("mysql:host=" . Config::$serverName . ";dbname=".Config::$dbName , Config::$username , Config::$password);
            self::$instance->setAttribute(PDO::ATTR_ERRMODE , PDO::ERRMODE_EXCEPTION);
            self::$instance->exec("set names utf8"); 
            
        }
        
        
        return self::$instance;
    }
    
    
    
    private function __clone() {
        
    }
    
    public static  function getRowCount($stmt) {
        return $stmt->rowCount();
    }
    
    
    
    
    
    
    
    
    
    
}
