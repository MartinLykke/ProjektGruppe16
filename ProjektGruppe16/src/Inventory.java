/*
Class for creating and managing the inventory
*/
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Item> inventory; //List of the items in inventory
    private int capacity; //Amount of items a player can carry
    
    public Inventory(int capacity){
        this.inventory = new HashMap<>();
        this.capacity = capacity;
    }
    
    //Checks if inventory is full
    public boolean inventoryFull(){
        System.out.println("Log: Size = " + this.inventory.size());
        System.out.println("Log: Capacity = " + this.capacity);
        return !(this.inventory.size() < this.capacity);
    }
    
    //Adds an item to the inventory list
    public void add(Item item){
        this.inventory.put(item.name, item);
    }
    
    //Removes an item from the inventory list
    public void remove(Item item){
        this.inventory.remove(item.name);
    }
    
    public Item getItem(String item){
        return this.inventory.get(item);
    }
}
