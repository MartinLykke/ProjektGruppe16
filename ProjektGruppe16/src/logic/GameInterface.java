/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author rasmus
 */
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
