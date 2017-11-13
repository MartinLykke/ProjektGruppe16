
public class Enemy {
    
    private int health;
    private String name;
    private int damage;
  
    
    public Enemy(String name, int health){
       this.health = health;  
       this.damage = 15;
       this.name = name;
    }
    
    public int attack(){
        return this.damage;
    }
    
    public void takeDamage(int damage){
        this.health = this.health - damage;
        
        
    }
    
    public boolean isAlive(){
        return this.health>0;
    }
    
    public int getHealth(){
        return this.health;
    }
}
