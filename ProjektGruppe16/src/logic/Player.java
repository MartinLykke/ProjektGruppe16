package logic;


public class Player implements java.io.Serializable{
    public int health;
    public int maxhealth = 100;
    private boolean istheplayerdead;
    public Inventory inventory;
    public int time = 0;
    private int maxTime = 100;
    public int woodfortheraft = 0;
    public boolean enoughwoodfortheraft = false;
    int timeLeft = maxTime - time; // This line calculates how much time the user has left
    private int points = 0;
    private int score = 0;
    public Player(){
        this.health = 100;
        this.istheplayerdead = false;
        this.inventory = new Inventory(4);
    }
    
// If this is true, the player should win the game
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
    
    
    // Method for gaining health after eating a coconut
    public void Heal(){
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
    
    // This method grants the player more time when progressive action is performed
    public void removeTime(int removedTime){
   time = time - removedTime;     
    }
    
    public void addWoodToRaft(){
        woodfortheraft++;
    }
    public void addPointsToScore(int points){
       
        score = score + points;
    }
    public int getScore(){
        return score;
    }
  
}
