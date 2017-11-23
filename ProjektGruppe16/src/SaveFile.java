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
    
    Player player;
    Room currentRoom;
    
    public SaveFile(Player player, Room currentRoom){
        this.player = player;
        this.currentRoom = currentRoom;
    }
    
}
