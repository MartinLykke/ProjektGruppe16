/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acq;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public interface IGame {
    public void play();
    public void injectData(IData dataFacade);
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
    public boolean getTime();
    public ArrayList<String> getItems();
    public boolean getEnemyStatus();
    public boolean getFriendStatus();
}
