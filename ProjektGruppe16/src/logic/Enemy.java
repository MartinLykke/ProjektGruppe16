package logic;


public class Enemy implements java.io.Serializable{
    
    private int health;
    private String name;
    private int damage;
  
    /**
     * 
     * @param name each enemy object gets a name
     * @param health each enemy object gets health attribute
     */
    public Enemy(String name, int health){
       this.health = health;  
       this.damage = 20;
       this.name = name;
    }
    /**
     * this method is called attack even though it should be called getAttack
     * It gets the damage of the enemy
     * @return returns the enemy's damage
     */
    public int attack(){
        return this.damage;
    }
    /**
     * calculates the remaining health when enemy is attacked by player
     * @param damage the damage which the enemy takes
     */
    public void takeDamage(int damage){
        this.health = this.health - damage;
        
        
    }
    // 
    /**
     * Checks if enemy is alive. Called before attacking an enemy.
     * @return 
     */
    public boolean isAlive(){
        return this.health>0;
    }
    /**
     * 
     * @return getter method that returns the enemy's health
     */
    public int getHealth(){
        return this.health;
    }
    /**
     * 
     * @return getter method that returns the enemy's name
     */
    public String getName(){
        return this.name;
    }
}
