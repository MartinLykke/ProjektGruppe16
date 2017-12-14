package logic;

/*
Class for creating and managing the inventory
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory implements java.io.Serializable{
    private HashMap<String, ArrayList<Item>> inventory; //List of the items in inventory
    private int capacity; //Amount of items a player can carry
    
    public Inventory(int capacity){
        this.inventory = new HashMap<>();
        this.capacity = capacity;
    }
    
    //Checks if inventory is full
    public boolean inventoryFull(){
        System.out.println("Log: Size = " + this.inventory.size());
        System.out.println("Log: Capacity = " + this.capacity);
        for (Map.Entry<String, ArrayList<Item>> entry : inventory.entrySet()) {
            String key = entry.getKey();
            ArrayList<Item> value = entry.getValue();
            
            System.out.println(key + ": " + value.size());
        }
        return !(this.inventory.size() < this.capacity);
    }
    
    //Adds an item to the inventory list
    public void add(Item item){
        if(!this.inventory.containsKey(item.name)){
            this.inventory.put(item.name, new ArrayList<>());
        }
        
        this.inventory.get(item.name).add(item);
    }
    
    //Removes an item from the inventory list
    public void remove(String name){
        if(this.inventory.get(name).size() == 1){
            this.inventory.remove(name);    
        }
        else{ this.inventory.get(name).remove(0);}

    }
    
    public Item getItem(String item){
        return this.inventory.get(item).get(0);
    }
    
    public boolean hasItem(String item){
        if (this.inventory.containsKey(item)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /*
    public ArrayList<String> getItems(){
        ArrayList<String> items;
        
        return items;
    }*/
}
