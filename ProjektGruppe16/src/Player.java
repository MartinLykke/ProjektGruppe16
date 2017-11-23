
public class Player {
    public int health;
    public int maxhealth = 100;
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

    public void isThereEnoughWoodForTheRaft(){
        if(woodfortheraft >=1){ //                           FIX THIS VALUE LATER 
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
        this.health += 10;
    }
    
    // Method for checking if the player is dead
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
    
    public void addWoodToRaft(){
        woodfortheraft++;
    }
  
}
