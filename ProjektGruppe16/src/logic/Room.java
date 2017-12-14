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
    private String picture;

    public Room(String description, String picture) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.item = null;
        this.enemy = null;
        this.blocked = new HashMap<>();
        this.picture = picture;
    }

    // Used for deciding which exits exist in the game
    public void setExit(String direction, Room neighbor, boolean blocked) 
    {
        this.blocked.put(direction, blocked);
        exits.put(direction, neighbor);
    }

    // Originally used to print out a description of the game
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

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    // "Spawns" an item in the specific room
    public void putItem(Item item){
        this.item = item;
    }
    public Item getItem(){
        Item temp = this.item;
        this.item = null;
        return temp;
    }
    
    public boolean itemExist(){
        return !(this.item == null);
    }
    
    public void spawnEnemy(String name, int health){
            System.out.println("Debug: Spawning");
            this.enemy = new Enemy(name, health);
            System.out.println(enemyPresent());      
    }
    
    //Checks if an enemy is present when attacking
    public boolean enemyPresent(){
        return !(this.enemy == null);
    }
    
    
    public void spawnFriend(String name){
            System.out.println("Debug: Spawning");
            this.friend = new Friend(name);
            System.out.println(friendPresent());      
    }
    
    //Checks if a friendly person is present when talk command is used
    public boolean friendPresent(){
        return !(this.friend == null);
    }
    
    public int attack(int damage){
        this.enemy.takeDamage(damage);
        if(!this.enemy.isAlive()){
            this.enemy = null;
            return 0;
        }
        return this.enemy.attack();
    }
    
    public int enemyHealth(){
        return this.enemy.getHealth();
    }
    public String enemyName(){
        return this.enemy.getName();
    }
    
    public boolean isBlocked(String exit){
        return this.blocked.get(exit);
    }
    
    public String getLocation(){
        return this.picture;
    }
    
}

