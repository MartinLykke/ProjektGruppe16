
public class Player {
    private int health;
    private int maxhealth = 100;
    private boolean istheplayerdead;
    public Inventory inventory;
    int time = 0;
    int maxTime = 100;
    int timeLeft = maxTime - time;
   
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
    // Method for gaining health after eating a coconut
    public void Heal(int healamount){
        this.health=this.health+10;
    }
    public boolean isDead(){
        return istheplayerdead;
    }
    // Method for making the time go
    public void addTime(int addedTime){
   time = time + addedTime;    
    }
    // This method grants the player more time when a progressive action is performed
    public void removeTime(int removedTime){
   time = time - removedTime;     
    }
    // this method is not for the final game. Used for printing out variables.
    public void testFunction(){
        
        System.out.println("You spend " + time + " seconds. You have " + timeLeft + " seconds left" );
    
    }
}
