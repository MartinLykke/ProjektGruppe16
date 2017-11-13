
public class Player {
    private int health;
    private int maxhealth = 100;
    private boolean istheplayerdead;
    public Inventory inventory;
    public int time = 0;
    private int maxTime = 100;
    public int woodfortheraft = 0;
    public boolean enoughwoodfortheraft = false;
    int timeLeft = maxTime - time; // This line calculates how much time the user has left
   
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
    public void isThereEnoughWoodForTheRaft(){
        if(woodfortheraft >=6){
            enoughwoodfortheraft = true;
          
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
    public void addWoodToRaft(){
        
    }
}
