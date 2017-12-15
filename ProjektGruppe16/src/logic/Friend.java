package logic;


public class Friend implements java.io.Serializable{
    
    private String name;
    private int health;
    
    public Friend(String name){
       
       this.name = name;
       this.health = 20;
    }
    
}
