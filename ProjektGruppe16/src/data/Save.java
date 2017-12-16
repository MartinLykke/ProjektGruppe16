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
    
    /**
     * Takes a Player and Room object as input and then adds them to a 
     * SaveFile object which is then written to a file using serialization
     * @param player The Player object 
     * @param currentRoom 
     */
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
    
    /**
     * Method for loading a SaveFile object from a file created by the 
     * save() method and then loads it's Player and Room object into temporary
     * variables for loading into the game.
     * @param fileLocation The location of the file to load the objects from,
     * including the filename of the file to load. E.g. "savefiles/save.save"
     */
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
    
    /**
     * Method for getting a loaded Player object
     * @return The Player object loaded from a file by the load() method
     */
    public Player getLoadedPlayer(){
        return loadedPlayer;
    }
    
    /**
     * Method for getting a loaded Room object
     * @return The Room object loaded from a file by the load() method
     */
    public Room getloadedRoom(){
        return loadedRoom;
    }
}
