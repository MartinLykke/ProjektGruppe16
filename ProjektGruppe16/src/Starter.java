
public class Starter {
    public static void main (String[] args){
        Game game = new Game();
        GUI gui = new GUI();
        gui.guiStart(args);    
        
        game.play();
    }
}
