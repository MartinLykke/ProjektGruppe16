
public class Enemy {
    
    private int health;
    private String name;
    private int damage;
  
    
    public Enemy(String name, int health){
       this.health = health;  
       this.damage = 10;
       this.name = name;
    }
    
    public void attack(){
        
    }
    
    public void takeDamage(int damage){
        this.health = this.health - damage;
    }
    
    public boolean isAlive(){
        return this.health<=0;
    }
}
