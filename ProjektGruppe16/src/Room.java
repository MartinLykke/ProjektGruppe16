
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.items = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) 
    {
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
}

