
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory;
    private int capacity;
    
    public Inventory(){
        inventory = new ArrayList<>();
        capacity = 4;
    }
    
    public boolean inventoryFull(){
        return this.inventory.size() < this.capacity;
    }
    
    public void add(Item item){
        this.inventory.add(item);
    }
}
