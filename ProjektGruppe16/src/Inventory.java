/*
Class for creating and managing the inventory
*/
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory; //List of the items in inventory
    private int capacity; //Amount of items a player can carry
    
    public Inventory(){
        inventory = new ArrayList<>();
        capacity = 4;
    }
    
    //Checks if inventory is full
    public boolean inventoryFull(){
        return this.inventory.size() < this.capacity;
    }
    
    //Adds an item to the inventory list
    public void add(Item item){
        this.inventory.add(item);
    }
}
