
public class Player {
    private int health;
    private int maxhealth = 100;
    private boolean istheplayerdead;
    public Inventory inventory;
    private int point = 0;
    int time = 0;
    
    public Player(){
        this.health = 100;
        this.istheplayerdead = false;
        this.inventory = new Inventory(4);
    }
    // Method for restoring health, uses food class
    public void eat(Food food){ 
        
        if(this.health + food.restorevalue < this.maxhealth){ // Checks if the restoration will exceed the maximum allowed health.
            this.health = this.health + food.restorevalue;
        }
        else {
            this.health = this.maxhealth; 
        }
    }
    
    public void addpoints(){ 
    this.point = this.point + 5;
    }
    public void printPoints(){
        
    }
    
    // Method for taking damage from enemy
    public void damagetaken(int damage){
        this.health = this.health - damage;
        if(this.health <= 0){
            this.istheplayerdead = true;
        }
    }
    // Method for printing how much health the player has left.
    public void printhealth(){
        System.out.println("You have " + health + " health left."); 
    }
    public void Heal(int healamount){
        this.health=this.health+10;
    }
    public boolean isDead(){
        return istheplayerdead;
    }
        // this method is for the time system
    public void timer(){
      int maxTime = 100;
      
    }
    public void addTime(int addedTime){
   time = time + addedTime;    
    }
    public void removeTime(int removedTime){
   time = time - removedTime;     
    }
    // this method is not for the final game
    public void testFunction(){
        System.out.println(time);
    
    }
}
