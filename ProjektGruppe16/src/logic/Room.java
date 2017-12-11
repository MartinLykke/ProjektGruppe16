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
    private HashMap<String, Item> items;
    private Enemy enemy;
    private Friend friend;
    private HashMap<String, Boolean> blocked;
    private String picture;

    public Room(String description, String picture) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.items = new HashMap<>();
        this.enemy = null;
        this.blocked = new HashMap<>();
        this.picture = picture;
    }

    public void setExit(String direction, Room neighbor, boolean blocked) 
    {
        this.blocked.put(direction, blocked);
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return description + "\n" + getExitString();
    }

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
    
    public void putItem(Item item){
        this.items.put(item.name, item);
    }
    public Item getItem(String item){
        Item temp = this.items.get(item);
        this.items.remove(item);
        return temp;
    }
    
    public boolean itemExist(String item){
        return this.items.containsKey(item);
    }
    
    public void spawnEnemy(String name, int health){
            System.out.println("Debug: Spawning");
            this.enemy = new Enemy(name, health);
            System.out.println(enemyPresent());      
    }
    
    public boolean enemyPresent(){
        return !(this.enemy == null);
    }
    
    public void spawnFriend(String name){
            System.out.println("Debug: Spawning");
            this.friend = new Friend(name);
            System.out.println(friendPresent());      
    }
    
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

