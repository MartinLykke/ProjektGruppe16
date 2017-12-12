
package logic;

// TODO: Implement interface
public interface GameInterface {
    public void play();
    
    public void attack       ();
    public void drop         ();
    public void use          ();
    public void pickup       ();
    public void talk         ();
    public void goRoom       (String direction);  
    public void quit         ();
    public void save         ();
    public void load         ();
    public void getText      ();
    public void getHealth    ();
    
}
