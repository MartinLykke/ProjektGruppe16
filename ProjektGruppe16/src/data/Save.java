/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import logic.Player;
import logic.Room;

/**
 *
 * @author hej1
 */
public class Save {
    private SaveFile save;
    private Room loadedRoom;
    private Player loadedPlayer;
    
    public void save(Player player, Room currentRoom){
        save = new SaveFile(player, currentRoom);
        
        try {
            FileOutputStream saveFile = new FileOutputStream("test.save");
            ObjectOutputStream out = new ObjectOutputStream(saveFile);
            out.writeObject(save);
            out.close();
            saveFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void load(String fileLocation){
        try {
            FileInputStream loadFile = new FileInputStream(fileLocation);
            ObjectInputStream in = new ObjectInputStream(loadFile);
            save = (SaveFile)in.readObject();
            in.close();
            loadFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        loadedPlayer = save.player;
        loadedRoom = save.currentRoom;
    }
    
    public Player getLoadedPlayer(){
        return loadedPlayer;
    }
    
    public Room getloadedRoom(){
        return loadedRoom;
    }
}
