package logic;


import data.Save;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import data.Highscore;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game implements GameInterface
{

    private Room currentRoom;
    private Player player;
    private Save save;
    private String actionText;
    private String text;
    private int numberOfPresses;
    private Highscore highscore;
        
    public Game() 
    {
        createRooms();
        save = new Save();
        numberOfPresses = 1;
        actionText = "";
        highscore = new Highscore();
    }
    
    private void createRooms()
    { //TODO: fix item placement
        Room beach1, beach2, beach3, jungle1, jungle2, jungle3, jungle4, jungle5, jungle6, cave;
      
        beach1 = new Room("You are on the Western part of the beach.\n"
                + " The remains of a plane lie here, totally obliterated.\n"
                + " The jungle stretches all the way to the water, but you cannnot enter.\n"
                + "You notice a guy in the distance, he looks like he has been in an accident. Ripped clothing, bleeding..\n "
                + "You Approach him.", "beach");
        beach2 = new Room("You are on the central part of the beach.\n"
                + "Ahead of you is a jungle, but you don't see an entrance.", "beach");
        beach3 = new Room("You are on the Eastern part of the beach.\n"
                + " You can't go any further to the East, but you see an opening in the trees.", "beach");
        jungle1 = new Room("You are in the jungle.\n"
                + " You can just barely spot the remains of the plane through the trees.", "jungle");
        jungle2 = new Room("You are in the jungle.\n"
                + " The light is fading, as the trees block out the sun.", "jungle2");
        jungle3 = new Room("You have ventured into the jungle.\n"
                + " There are palmtrees all around you.", "jungle2");
        jungle4 = new Room("You are in the jungle.", "jungle");
        jungle5 = new Room("You are in the jungle, once again surrounded by palmtrees.", "jungle");
        jungle6 = new Room("You are in the jungle. You can just make out an entrance to a cave.", "jungle2");
        cave = new Room("You use your machete to enter a dimly lit cave.\n"
                + " After a minute or two you stumble upon a crazy troll", "cave");
        
        beach1.setExit("east", beach2, false);
        beach1.putItem(new Item("wood"));
        beach1.spawnFriend("Walter");

        beach2.setExit("east", beach3, false);
        beach2.setExit("west", beach1, false);
        beach2.putItem(new Item("coconut"));
        

        beach3.setExit("north", jungle3, false);
        beach3.setExit("west", beach2, false);
        beach3.putItem(new Item("coconut"));

        jungle1.setExit("north", jungle4, false);
        jungle1.putItem(new Item("machete"));
        jungle1.spawnEnemy("Cannibal", 20);

        jungle2.setExit("north", jungle5, false);
        jungle2.setExit("east", jungle3, false);
        jungle2.putItem(new Item("wood"));
        jungle2.spawnEnemy("Cannibal", 20);
        
        jungle3.setExit("south", beach3, false);
        jungle3.setExit("west", jungle2, false);
        jungle3.putItem(new Item("coconut"));
        jungle3.spawnEnemy("Cannibal", 20);

        jungle4.setExit("east", jungle5, false);
        jungle4.setExit("south", jungle1, false);
        jungle4.putItem(new Item("wood"));
        

        jungle5.setExit("east", jungle6, false);
        jungle5.setExit("south", jungle2, false);
        jungle5.setExit("west", jungle4, false);
        jungle5.putItem(new Item("coconut"));
        jungle5.spawnEnemy("Cannibal", 20);
        
        jungle6.setExit("north", cave, true);
        jungle6.setExit("west", jungle5, false);
        jungle6.putItem(new Item("coconut"));
        jungle6.spawnEnemy("Cannibal", 20);
        
        cave.setExit("south", jungle6, false);
        cave.spawnEnemy("Troll", 40);
        cave.putItem(new Item("wood"));
        
        currentRoom = beach2; // Sets the spawnpoint for the player
    }

    public void play() 
    {            //TODO: fix win conditions
        player = new Player();
        printWelcome();
        /*boolean finished = false;
        while (! finished) {
           if(player.enoughwoodfortheraft == true){ // Ends the game if the player wins by collecting enough wood
                finished = true;
                System.out.println("You build a raft and escaped the island. You won!");
            }
           if(player.isDead()){ // Ends the game if the player runs out of health
               finished = true;
               System.out.println("You lost all your health and died!");
           }public boolean getFriendStatus()
        }
        
        System.out.println("Thank you for playing.  Good bye.");*/
    }

    private void printWelcome()
    {
        text = "Welcome to Stranded! "
                + "Stranded is an adventure / survival game by group 16.\n"
                + "Your objective is to survive.\n "
                + "You wake up on a beach with scratches, torn clothes and water in your lungs. "
                + currentRoom.getLongDescription();
    }
    
    public void attack(){ // The following 6 methods are our new methods which the comamands activate
        int damageTaken;
        if(currentRoom.enemyPresent()){
            damageTaken = currentRoom.attack(10);
            actionText = "You hit the enemy for " + 10 + " damage!";
            player.damagetaken(damageTaken);
            
        }
        else{
            actionText = "No enemy to attack";
            return;
        }
        if(!currentRoom.enemyPresent()){
            
            player.removeTime(5);
            highscore.addPointsToScore();
          actionText = "You killed an enemy! You have " + highscore.getScore() + " points.";
        }
    }
    
    public void drop(){
        if(player.inventory.getItem("coconut") == null) {
            System.out.println("Drop what?");
            return;
        }
        else{
            player.inventory.remove("coconut");
        }
    }
    
    public void talk (){
        if(currentRoom.friendPresent()) { 
            if (numberOfPresses == 1){
                text = "Survivor: Oh thank god, i thought i was the only survivor.. My name is Dave\n"
                        + "Looks like we are stranded..\n"
                        + "I think my foot is broken, so i wont be much help to you.\n"
                        + "You should probably collect some wood so we can build a raft\n"
                        + "Come back to me when you have enough wood for the raft! 4 Logs will do.";
              
                numberOfPresses++;
            } else if (numberOfPresses == 2){
                text = "Dave: Hey what's up? Any progress?";
                numberOfPresses++;
            } else if (numberOfPresses == 3){
                text = "Dave : Any news?";
                numberOfPresses++;
            }
              else if (numberOfPresses == 4){
                text = "Dave : Quit messing around, we need to get off this island!";
                numberOfPresses--;
                numberOfPresses--;
                
            }
         
        
        } 
    }
    
    public void pickup(){
        if(!currentRoom.itemExist()) { //TODO: fix wood, fix max inventory
            actionText = "Pickup what?";
            return;
        }
        
        if(player.inventory.inventoryFull()){
            actionText = "You are carrying too much. Use the drop command.";
        }
        else{
            player.inventory.add(currentRoom.getItem());
            player.removeTime(5);
        }
    }
    
    public void use (){
        String SecondWord;
        if(false) { //TODO: new check
            System.out.println("Use what?");
            return;
        
        }
        else {
            SecondWord="coconut"; //TODO: Figure it out
            if(player.inventory.hasItem("coconut")){
            //    player.eat(player.inventory.getItem(SecondWord)); Fix this
                System.out.println("You ate a coconut and restored 10 health.");
               player.Heal();
               player.inventory.remove("coconut");
            }
            else{
                System.out.println("No coconuts");
            }
        }
    }
    
    public void goRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction);
        player.addTime(10);
        try {        
            if(currentRoom.isBlocked(direction) && !player.inventory.hasItem("machete")){
                actionText = "You need a machete to get through here";
            }
            else{
                    currentRoom = nextRoom;
                    text = currentRoom.getLongDescription();
                    if(currentRoom.enemyPresent()){
                        actionText = "A wild " + currentRoom.enemyName() + " has appeared!\n"
                                + "Enemy health: " + currentRoom.enemyHealth();
                    }
                    else{
                        actionText = "";
                    }         
            }            
        } catch (NullPointerException e) {
            actionText = "No exit";
        }
    }
    

    public boolean quit() 
    {
        if(false) { //TODO: new check
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
    
    public void save(){
        save.save(player, currentRoom);
    }
    
    public void load(){
        save.load("test.save");
        
        player = save.getLoadedPlayer();
        currentRoom = save.getloadedRoom();
        
        text = currentRoom.getLongDescription();
        if(currentRoom.enemyPresent()){
            actionText = "A wild " + currentRoom.enemyName() + " has appeared!\n"
                + "Enemy health: " + currentRoom.enemyHealth();
        }
    }
    
    public String getText(){
        return text + "\n" + actionText;
    }
    
    public String getHealth(){
        return "Health: " + player.health;
    }
    
    public boolean getLoseCondition(){ //TODO: fix death, possibly rename to lose condition
        if(player.time >= 100){  // Ends the game if the player runs out of time
            text = "You ran out of time!";
            actionText = "";
            return true;
        } else if(player.isDead()) {
            text = "You lost all your health and died";
            return true;
        }
        return false;
    }
    public boolean getWinCondition(){
        if(player.isThereEnoughWoodForTheRaft() == true && getFriendStatus()){ // Ends the game if the player wins by collecting enough wood
                 
                System.out.println("You build a raft and escaped the island. You won!");
                Highscore.highscore();
                return true;
            }
             return false;
       
    }
    public String getLocation(){
        return currentRoom.getLocation();
    }
    
    public ArrayList<String> getItems(){
        ArrayList<String> temp = player.inventory.getItems();
        for (String string : temp) {
            System.out.println(string);
        }
        return temp;
    }
    
    // Checks if enemy is in the current room
    public boolean getEnemyStatus(){
        if(currentRoom.enemyPresent()){
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean getFriendStatus(){
        if(currentRoom.friendPresent()){
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
     * Adds health to a player object and removes a "coconut" from it's inventory
     */
    public void eat(){
        if(player.inventory.hasItem("coconut") && player.health < player.maxhealth){
            player.Heal();
            player.inventory.remove("coconut");
            actionText = "You eat the delicious coconut and it heals you a bit";
        } else{
            actionText = "You're starving and out of food.. Go find some!";
        }
        
    }
}
