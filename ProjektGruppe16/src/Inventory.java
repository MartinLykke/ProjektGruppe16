/*
Class for creating and managing the inventory
*/
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory; //List of the items in inventory
    private int capacity; //Amount of items a player can carry
    
    public Inventory(int capacity){
        this.inventory = new ArrayList<>();
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
        this.inventory.add(item);
    }
    
    //Removes an item from the inventory list
    public void remove(Item item){
        this.inventory.remove(item);
    }
    
    //Returns a copy of the inventory list
    public ArrayList inventoryList(){
        ArrayList<Item> list = new ArrayList<>(this.inventory);
        return list;
    }
}
