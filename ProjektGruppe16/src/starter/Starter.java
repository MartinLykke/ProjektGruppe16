package starter;

import presentation.GUI;

/**
 *Starts the game.
 * @author rasmus
 */
public class Starter {

    /**
     *Starts the game by creating a GUI object and initializing it.
     * @param args
     */
    public static void main (String[] args){
       
        GUI gui = new GUI();
        gui.guiStart(args);    
       
    }
}
