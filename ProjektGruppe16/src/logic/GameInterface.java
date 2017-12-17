
package logic;

// TODO: Implement interface

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 *Interface for the Game class.
 * Contains all methods to be used in the representation package.
 * @author rasmus
 */
public interface GameInterface {

    /**
     *Method for initializing the game.
     */
    public void play();
    
    /**
     *Method for attacking an enemy.
     */
    public void attack();

    /**
     *Method for dropping a "coconut" item.
     */
    public void drop();

    /**
     *Method for picking up an item from a room.
     */
    public void pickup();

    /**
     *Method for talking to a friendly npc.
     */
    public void talk();

    /**
     *Method for moving around between rooms.
     * @param direction the direction to move in.
     */
    public void goRoom(String direction);  

    /**
     *Method for quitting the game.
     * Not implemented.
     * @return
     */
    public boolean quit();

    /**
     *Method for saving a game to a file.
     */
    public void save();

    /**
     *Method for loading a game from a file.
     */
    public void load();

    /**
     *Method for getting the current text from the game.
     * @return the current text.
     */
    public String getText();

    /**
     *Method for getting a string that shows the current health of a player.
     * @return string that shows the current health of a player.
     */
    public String getHealth();

    /**
     *Method for getting the name of the current location.
     * @return name of the current location
     */
    public String getLocation();

    /**
     *Method for checking if a player is dead or out of time.
     * @return true if the player meets a lose condition and false otherwise
     */
    public boolean getLoseCondition();

    /**
     *Method for checking if a player meets the win condition.
     * @return true if the player meets the win condition and false otherwise
     */
    public boolean getWinCondition();

    /**
     *Method for getting a list of items in a players inventory.
     * @return ArrayList of Strings containing the items in a players inventory.
     */
    public ArrayList<String> getItems();

    /**
     *Checks if an enemy is present in the current room.
     * @return true if an enemy is present and false otherwise
     */
    public boolean getEnemyStatus();

    /**
     *Checks if a friendly npc is present in the current room.
     * @return true if a friendly npc is present and false otherwise
     */
    public boolean getFriendStatus();

    /**
     *Method for eating a coconut and healing the player.
     */
    public void eat();

    /**
     *Method for getting the highscore list.
     * @return ArrayList of Strings containing the highscore
     */
    public ArrayList<String> getList();
   
}
