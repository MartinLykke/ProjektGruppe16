/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marti
 */
public class Food extends Item{
    
    private int restorevalue;
    public Food(String name, int restorevalue){
        this.name = name;
        this.restorevalue = restorevalue;
    }
}
