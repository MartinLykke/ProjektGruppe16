
package logic;

// TODO: Implement interface

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public interface GameInterface {
    public void play();
    
    public void attack();
    public void drop();
    public void use();
    public void pickup();
    public void talk();
    public void goRoom(String direction);  
    public boolean quit();
    public void save();
    public void load();
    public String getText();
    public String getHealth();
    public String getLocation();
    public boolean getWinOrLose();
    public ArrayList<String> getItems();
    public boolean getEnemyStatus();
    public boolean getFriendStatus();
   
}
