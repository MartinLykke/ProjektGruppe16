package logic;


public class Enemy implements java.io.Serializable{
    
    private int health;
    private String name;
    private int damage;
  
    
    public Enemy(String name, int health){
       this.health = health;  
       this.damage = 10;
       this.name = name;
    }
    
    public int attack(){
        return this.damage;
    }
    
    public void takeDamage(int damage){
        this.health = this.health - damage;
        
        
    }
    // Checks if enemy is alive. Called before attacking an enemy.
    public boolean isAlive(){
        return this.health>0;
    }
    
    public int getHealth(){
        return this.health;
    }
    public String getName(){
        return this.name;
    }
}
