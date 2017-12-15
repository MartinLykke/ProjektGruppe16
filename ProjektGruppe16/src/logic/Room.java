package logic;


import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room implements java.io.Serializable
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item;
    private Enemy enemy;
    private Friend friend;
    private HashMap<String, Boolean> blocked;
    private String name;
/**
 * Creates a room object
 * @param description parameter is a descrpition of the room 
 * @param name paramter is a name for the room
 */
    public Room(String description, String name) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.item = null;
        this.enemy = null;
        this.blocked = new HashMap<>();
        this.name = name;
    }
    /**
     * 
     * @param direction
     * @param neighbor
     * @param blocked 
     */
    public void setExit(String direction, Room neighbor, boolean blocked) 
    {
        this.blocked.put(direction, blocked);
        exits.put(direction, neighbor);
    }

    /**
     * 
     * @return 
     */
    public String getLongDescription()
    {
        String itemList = "";
        if(this.item != null){
            itemList = "Items: " + this.item.name;
        }
        return description + "\n" + getExitString() + "\n" + itemList;
    }
     // TODO: Write comment
	private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
/**
 * 
 * @param direction
 * @return 
 */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    // "Spawns" an item in the specific room
    /**
     * 
     * @param item 
     */
    public void putItem(Item item){
        this.item = item;
    }
    /**
     * 
     * @return 
     */
    public Item getItem(){
        Item temp = this.item;
        this.item = null;
        return temp;
    }
    /**
     * 
     * @return 
     */
    public boolean itemExist(){
        return !(this.item == null);
    }
    /**
     * 
     * @param name
     * @param health 
     */
    public void spawnEnemy(String name, int health){
            System.out.println("Debug: Spawning");
            this.enemy = new Enemy(name, health);
            System.out.println(enemyPresent());      
    }
    
    //Checks if an enemy is present when attacking
    /**
     * 
     * @return 
     */
    public boolean enemyPresent(){
        return !(this.enemy == null);
    }
    
    /**
     * 
     * @param name 
     */
    public void spawnFriend(String name){
            System.out.println("Debug: Spawning");
            this.friend = new Friend(name);
            System.out.println(friendPresent());      
    }
    
    //Checks if a friendly person is present when talk command is used
    /**
     * 
     * @return 
     */
    public boolean friendPresent(){
        return !(this.friend == null);
    }
    /**
     * 
     * @param damage
     * @return 
     */
    public int attack(int damage){
        this.enemy.takeDamage(damage);
        if(!this.enemy.isAlive()){
            this.enemy = null;
            return 0;
        }
        return this.enemy.attack();
    }
    /**
     * 
     * @return 
     */
    public int enemyHealth(){
        return this.enemy.getHealth();
    }
    /**
     * 
     * @return 
     */
    public String enemyName(){
        return this.enemy.getName();
    }
    /**
     * 
     * @param exit
     * @return 
     */
    public boolean isBlocked(String exit){
        return this.blocked.get(exit);
    }
    /**
     * 
     * @return 
     */
    public String getLocation(){
        return this.name;
    }
    
}

