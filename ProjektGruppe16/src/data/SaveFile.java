package data;


import logic.Player;
import logic.Room;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rasmus
 */
public class SaveFile implements java.io.Serializable {
    
    /**
     *Player object to be saved.
     */
    public Player player;

    /**
     *Room object to be saved.
     */
    public Room currentRoom;
    
    /**
     *Constructs a SaveFile object containing a Player and Room object to be saved
     * @param player the Player object to be saved.
     * @param currentRoom the Room object to be saved.
     */
    public SaveFile(Player player, Room currentRoom){
        this.player = player;
        this.currentRoom = currentRoom;
    }
    
}
