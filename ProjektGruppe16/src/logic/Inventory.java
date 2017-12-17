package logic;

/*
Class for creating and managing the inventory
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *Class for a players inventory.
 * Implements java.io.Serializable to be able to write it to a file for saving.
 * @author rasmus
 */
public class Inventory implements java.io.Serializable{
    private HashMap<String, ArrayList<Item>> inventory; //List of the items in inventory
    private int capacity; //Amount of items a player can carry
    
    /**
     *Constructs a new inventory with a given capacity.
     * @param capacity the amount of items to be hold in the inventory.
     */
    public Inventory(int capacity){
        this.inventory = new HashMap<>();
        this.capacity = capacity;
    }
    
    /**
     * Method for checking if an inventory is at it's maximum capacity
     * @return true if the inventory is at it's maximum capacity and false if it isn't
     */
    public boolean inventoryFull(){
        int items = 0;
        for (Map.Entry<String, ArrayList<Item>> entry : inventory.entrySet()) {
            ArrayList<Item> value = entry.getValue();
            items = items + value.size();
        }
        return !(items <= this.capacity);
    }
    

    /**
     *Adds an item to the inventory list.
     * @param item Item object to be added to the inventory
     */
    public void add(Item item){
        if(!this.inventory.containsKey(item.name)){
            this.inventory.put(item.name, new ArrayList<>());
        }
        
        this.inventory.get(item.name).add(item);
    }


    /**
     *Removes an item from the inventory list.
     * @param name name of the item to be removed
     */
    public void remove(String name){
        if(this.inventory.get(name).size() == 1){
            this.inventory.remove(name);    
        }
        else{ this.inventory.get(name).remove(0);}

    }
    
    /**
     *Method for returning a list of Item objects with a given name
     * @param item name of the item
     * @return ArrayList of Items containing all the Item objects with the given name
     */
    public ArrayList<Item> getItem(String item){
        try {
            return this.inventory.get(item);
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    /**
     * Checks if user has an item.
     * @param item name of the item to check for
     * @return true if the item exists in inventory and false otherwise
     */
    public boolean hasItem(String item){
        if (this.inventory.containsKey(item)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     *Method for getting a list of the items in inventory and the amount of each.
     * @return ArrayList of Strings containing each item type in inventory and the amount of each
     */
    public ArrayList<String> getItems(){
        ArrayList<String> items = new ArrayList<>();
        
        for (Map.Entry<String, ArrayList<Item>> entry : inventory.entrySet()) {
            String key = entry.getKey();
            ArrayList<Item> value = entry.getValue();
            items.add(key + ": " + value.size());
        }
        
        return items;
    }
}
