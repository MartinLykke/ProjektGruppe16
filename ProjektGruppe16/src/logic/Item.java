package logic;

/**
 *Class for creating items in the game.
 * @author rasmus
 */
public class Item implements java.io.Serializable{
    
    /**
     *Name of an item.
     */
    public String name;

    /**
     *Constructs an Item object with a given name
     * @param name Name of the item to be created.
     */
    public Item(String name){
        this.name = name;
    }
}
