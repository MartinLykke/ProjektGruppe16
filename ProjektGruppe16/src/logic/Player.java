package logic;

/**
 *Class for the player of the game. 
 * Contains all information about the player and methods for altering it.
 * @author Martin and Rasmus
 */
public class Player implements java.io.Serializable{

    /**
     *The current health of a player.
     */
    public int health;

    /**
     *The max health of a player
     */
    public int maxhealth = 100;
    private boolean istheplayerdead;

    /**
     *Holds the Inventory object for the players inventory.
     */
    public Inventory inventory;

    /**
     *The current time a player has used.
     */
    public int time = 0;
    private int maxTime = 100;
    private int woodfortheraft = 0;

    /**
     *Boolean for telling if a player has enough wood for the raft
     */
    public boolean enoughwoodfortheraft = false;
    
    /**
     *Constructs a Player object with 100 life and an inventory with a capacity.
     */
    public Player(){
        this.health = 100;
        this.istheplayerdead = false;
        this.inventory = new Inventory(6);
    }
    

    /**
     *If this is true, the player should win the game.
     * @return true or false based on the amount of wood in a players inventory and the needed amount.
     */
    public boolean isThereEnoughWoodForTheRaft(){
        try {
            if(inventory.getItem("wood").size() >= 4){
                return true;
            }
        } catch (NullPointerException e) {
        }
        return false;
    }
    
    /**
     * Method for taking damage from enemy.
     * @param damage the amount of damage to be taken.
     */
    public void damagetaken(int damage){
        this.health = this.health - damage;
        if(this.health <= 0){
            this.istheplayerdead = true;
        }
    }
    
    
    /**
     * Method for gaining health after eating a coconut.
     */
    public void Heal(){
        if(health <= 90){
            this.health += 10;
        } else{
            this.health = 100;
        }
    }
    
    /**
     * Method for checking if the player is dead.
     * @return the istheplayerdead variable that represents if the player is dead or not.
     */
    public boolean isDead(){
        return istheplayerdead;
    }
    
    /**
     * Method for adding time.
     * @param addedTime the amount of time to add
     */
    public void addTime(int addedTime){
        time = time + addedTime;    
    }
    
    /**
     * This method grants the player more time when progressive action is performed
     * @param removedTime the amount of time to remove
     */
    public void removeTime(int removedTime){
        time = time - removedTime;     
    }
    // 
   
}
