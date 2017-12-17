package logic;

/**
 *Class for friendly npc's in the game
 * @author Martin
 */
public class Friend implements java.io.Serializable{
    
    private String name;
    private int health;
    
    /**
     *Constructs a Friend object with a given name and a preconfigured health
     * @param name the name of the npc
     */
    public Friend(String name){
       
       this.name = name;
       this.health = 20;
    }
    
}
