
public class Enemy {
    
    private int health;
    private String name;
    private int damage;
  
    
    public Enemy(String name){
       this.health = 20;  
       this.damage = 10;
       this.name = name;
    }
    
    public void attack(){
        
    }
    
    public void damage(int damage){
        this.health = this.health - damage;
    }
}
