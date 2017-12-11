package logic;


import data.Save;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{

    private Room currentRoom;
    private Player player;
    private Save save;
    private String text;
        
    public Game() 
    {
        createRooms();
        save = new Save();
    }
   
    
    private void createRooms()
    {
        Room beach1, beach2, beach3, jungle1, jungle2, jungle3, jungle4, jungle5, jungle6, cave;
      
        beach1 = new Room("You are on the Western part of the beach.\n"
                + " The remains of the plane lie here, totally obliterated.\n"
                + " The jungle stretches all the way to the water, but you cannnot enter.", "beach");
        beach2 = new Room("You are on the central part of the beach. The beach continues both directions from here.\n"
                + "Ahead of you is a jungle, but you don't see an entrance.", "beach");
        beach3 = new Room("You are on the Eastern part of the beach.\n"
                + " You can't go any further to the East, but you see an opening in the trees.", "beach");
        jungle1 = new Room("You are in the jungle.\n"
                + " You can just spot the remains of the plane through the trees.", "jungle");
        jungle2 = new Room("You are in the jungle.\n"
                + " The light is fading, as the trees block out the sun.", "jungle2");
        jungle3 = new Room("You have ventured into the jungle.\n"
                + " There are palmtrees all around you.", "jungle2");
        jungle4 = new Room("You are in the jungle.", "jungle");
        jungle5 = new Room("You are in the jungle, once again surrounded by palmtrees.", "jungle");
        jungle6 = new Room("You are in the jungle. You can just make out an entrance to a cave.", "jungle2");
        cave = new Room("You use your machete to enter a dimly lit cave.\n"
                + " After a minute or two you stumble upon a crazy troll", "cave");
        
        //beach1.setExit("north", jungle1);
        beach1.setExit("east", beach2, false);
        beach1.putItem(new Item("coconut"));
        beach1.spawnEnemy("Cannibal", 20);
        beach1.putItem(new Item("wood"));

        //beach2.setExit("north", jungle2);
        beach2.setExit("east", beach3, false);
        beach2.setExit("west", beach1, false);
        beach2.spawnEnemy("Cannibal", 20);
        beach2.putItem(new Item("coconut"));
        beach2.putItem(new Item("wood"));
        beach2.spawnFriend("Walter");

        beach3.setExit("north", jungle3, false);
        beach3.setExit("west", beach2, false);
        beach3.spawnEnemy("Cannibal", 20);
        beach3.putItem(new Item("coconut"));
        beach3.putItem(new Item("wood"));

        jungle1.setExit("north", jungle4, false);
        beach2.putItem(new Item("machete")); //TODO: Define Machete
        //jungle1.setExit("east", jungle2);
        //jungle1.setExit("south", beach1);        
        jungle1.putItem(new Item("wood"));

        jungle2.setExit("north", jungle5, false);
        jungle2.setExit("east", jungle3, false);
        //jungle2.setExit("south", beach2);
        //jungle2.setExit("west", jungle1);
        jungle2.putItem(new Item("wood"));
        
        //jungle3.setExit("north", jungle6);
        jungle3.setExit("south", beach3, false);
        jungle3.setExit("west", jungle2, false);
        jungle3.putItem(new Item("wood"));

        jungle4.setExit("east", jungle5, false);
        jungle4.setExit("south", jungle1, false);
        jungle4.putItem(new Item("wood"));

        jungle5.setExit("east", jungle6, false);
        jungle5.setExit("south", jungle2, false);
        jungle5.setExit("west", jungle4, false);
        jungle5.putItem(new Item("wood"));
        
        jungle6.setExit("north", cave, true);
        //jungle6.setExit("south", jungle3);
        jungle6.setExit("west", jungle5, false);
        jungle6.putItem(new Item("wood"));
        
        cave.setExit("south", jungle6, false);
        cave.spawnEnemy("Troll", 40);
        cave.putItem(new Item("wood"));
        
        currentRoom = beach2; // Sets the spawnpoint for the player
    }

    public void play() 
    {            
        player = new Player();
        printWelcome();
        /*boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if(player.time >= 100){  // Ends the game if the player runs out of time
                finished = true;
                System.out.println("You ran out of time!");
            } 
           if(player.enoughwoodfortheraft == true){ // Ends the game if the player wins by collecting enough wood
                finished = true;
                System.out.println("You build a raft and escaped the island. You won!");
               
            }
           if(player.isDead()){ // Ends the game if the player runs out of health
               finished = true;
               System.out.println("You lost all your health and died!");
           }
        }
        
        System.out.println("Thank you for playing.  Good bye.");*/
    }

    public void printWelcome()
    {
        text = "Welcome to Stranded!\n"
                + "Stranded is in development by project group 16\n"
                + currentRoom.getLongDescription();
//        System.out.println(currentRoom.getLongDescription());
    }
    
    public void attack(){ // The following 6 methods are our new methods which the comamands activate
        int damageTaken;
        if(currentRoom.enemyPresent()){
            damageTaken = currentRoom.attack(10);
            text = "You hit the enemy for " + 10 + " damage!";
            player.damagetaken(damageTaken);
            
        }
        else{
            text = "No enemy to attack";
            return;
        }
        if(!currentRoom.enemyPresent()){
            text = "You killed an enemy!";
            player.removeTime(5);
            player.addPointsToScore(100);
        }
    }
    
    private void drop(){
        String second;
        if(false) { //TODO: new check
            System.out.println("Drop what?");
            return;
        }
        else{
            second = "My grades"; //TODO: Figure it out
           
        }
        if(player.inventory.getItem(second) != null){
            player.inventory.remove(second);
            player.addWoodToRaft();
            player.addPointsToScore(200);
        }
        else {
            System.out.println("You are not carrying any wood");
        }
    }
    
    private void talk (){
        if(false) { //TODO: new check
            System.out.println("Talk to who?");
            return;
        }
        if(currentRoom.friendPresent()){
            System.out.println("What's up? My name is Walter!");  
        } 
    }
    
    private void pickup(){
        String second;
        if(false) { //TODO: new check
            System.out.println("Pickup what?");
            return;
        }
        else{
            second = "noget"; //TODO: Figure it out
        }
        if(player.inventory.inventoryFull()){
            System.out.println("You are carrying too much. Use the drop command.");
        }
        else if(currentRoom.itemExist(second)){
            
            player.inventory.add(currentRoom.getItem(second));
            player.removeTime(5);
            player.isThereEnoughWoodForTheRaft(); 
        }
        else {
            System.out.println("You look around but can't find any " + second);
        }
    }
    
    private void use (){
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
               player.Heal(10);
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
                text = "You need a machete to get through here";
            }
            else{
                    currentRoom = nextRoom;
                    text = currentRoom.getLongDescription();
                    if(currentRoom.enemyPresent()){
                        text = text + "\nA wild " + currentRoom.enemyName() + " has appeared!\n"
                                + "Enemy health: " + currentRoom.enemyHealth();
                    }
                    //System.out.println("This room contains:"); //List of items in the room.            
            }            
        } catch (NullPointerException e) {
            text = "No exit";
        }
    }
    

    private boolean quit() 
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
            text = text + "\nA wild " + currentRoom.enemyName() + " has appeared!\n"
                + "Enemy health: " + currentRoom.enemyHealth();
        }
    }
    
    public String getText(){
        return text;
    }
    
    public String getHealth(){
        return "Health: " + player.health;
    }
    
    public void getTime(){
        if(player.time >= 100){  // Ends the game if the player runs out of time
            text = "You ran out of time!";
        }
    }
    
    public String getLocation(){
        return currentRoom.getLocation();
    }
}
