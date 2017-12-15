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
 * @param description parameter is a description of the room 
 * @param name parameter is a name for the room
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
     * @param direction decides which exists exist
     * @param neighbor used to decide which room the player comes into when going in a direction
     * @param blocked used to decide which exists are blocked
     */
    public void setExit(String direction, Room neighbor, boolean blocked) 
    {
        this.blocked.put(direction, blocked);
        exits.put(direction, neighbor);
    }

   
    /**
     * 
     * @return returns a string of items,exits and description of the room
     */
    public String getLongDescription()
    {
        String itemList = "";
        if(this.item != null){
            itemList = "Items: " + this.item.name;
        }
        return description + "\n" + getExitString() + "\n" + itemList;
    }
     /**
      * 
      * @return returns string of aviable exits
      */
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
 * @return returns the room object
 */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    // "Spawns" an item in the specific room
    /**
     * used to put items inside rooms
     * @param item the name of the item
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
     * checks if there is an item
     * @return returns false if items is null, which means that the item does not exist
     */
    public boolean itemExist(){
        return !(this.item == null);
    }
    /**
     * Creates a new enemy from the enemy class
     * @param name this is the name of the enemy
     * @param health this is the health of the enemy
     */
    public void spawnEnemy(String name, int health){
            System.out.println("Debug: Spawning");
            this.enemy = new Enemy(name, health);
            System.out.println(enemyPresent());      
    }
    
    
    /**
     * Checks if an enemy is present when attacking
     * @return returns false if there is no enemy
     */
    public boolean enemyPresent(){
        return !(this.enemy == null);
    }
    
    /**
     * Creates a new friend object from the friend class
     * @param name this is the name of the friendly character
     */
    public void spawnFriend(String name){
            System.out.println("Debug: Spawning");
            this.friend = new Friend(name);
            System.out.println(friendPresent());      
    }
    
    /**
     * Checks if a friendly person is present when talk command is used
     * @return returns false if friend is null
     */
    public boolean friendPresent(){
        return !(this.friend == null);
    }
    /**
     * 
     * @param damage this is the damage which the player does to the enemy
     * @return returns nothing if the enemy health is 0 or below, returns attack method if enemy health is above 0
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

