
public class Player {
    private int health;
    private int maxhealth = 100;
    public boolean istheplayerdead;
    
    public Player(){
        health = 100;
        istheplayerdead = false;
    }
    // Method for restoring health, uses food class
    public void eat(Food food){ 
        
        if(health+food.restorevalue<maxhealth){ // Checks if the restoration will exceed the maximum allowed health.
            health = health+food.restorevalue;
        }
        else {
            health = maxhealth; 
        }
    }
    // Method for taking damage from enemy
    public void damagetaken(int damage){
        health = health-damage;
        if(health<=0){
            istheplayerdead = true;
        }
       
    }
}
