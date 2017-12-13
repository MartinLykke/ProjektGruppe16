package logic;


public class Friend implements java.io.Serializable{
    
    private String name;
    private int health;
    
    public Friend(String name){
       
       this.name = name;
       this.health = 20;
    }
    
    public void greetPlayer(){
        System.out.println("Aah, I'm hurt. Can you get us off this island? I will rest here while you think of a plan.");
    }
    public boolean isAlive(){
        return this.health>0;
    }
}
