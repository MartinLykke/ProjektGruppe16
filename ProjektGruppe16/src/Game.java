
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
   
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private SaveFile save;
        
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }
   
    
    private void createRooms()
    {
        Room beach1, beach2, beach3, jungle1, jungle2, jungle3, jungle4, jungle5, jungle6, cave;
      
        beach1 = new Room("You are on the Western part of the beach. The remains of the plane lie here, totally obliterated. The jungle stretches all the way to the water, but you cannnot enter.");
        beach2 = new Room("You are on the central part of the beach. The beach continues both directions from here. Ahead of you is a jungle, but you don't see an entrance.");
        beach3 = new Room("You are on the Eastern part of the beach. You can't go any further to the East, but you see an opening in the trees.");
        jungle1 = new Room("You are in the jungle. You can just spot the remains of the plane through the trees.  ");
        jungle2 = new Room("You are in the jungle. The light is fading, as the trees block out the sun.");
        jungle3 = new Room("You have ventured into the jungle. There are palmtrees all around you.");
        jungle4 = new Room("You are in the jungle.");
        jungle5 = new Room("You are in the jungle, once again surrounded by palmtrees.");
        jungle6 = new Room("You are in the jungle. You can just make out an entrance to a cave.");
        cave = new Room("You use your machete to enter a dimly lit cave. After a minute or two you stumble upon a crazy troll");
        
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
        boolean finished = false;
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
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Stranded!");
        System.out.println("Stranded is in development by project group 16");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help, and/or if you want the introduction");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Unknown command.");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.ATTACK) { // The following 6 commands are our new commands for the game
            attack(command);
        }
        else if (commandWord == CommandWord.DROP){
            drop(command);
        }
        else if (commandWord == CommandWord.INVENTORY){
           // inventory();
        }
        
        else if (commandWord == CommandWord.TALK){
            talk(command);
        }
        
        else if (commandWord == CommandWord.PICKUP){
            pickup(command);
        }
        else if (commandWord == CommandWord.USE){
            use(command);
        }
        else if (commandWord == CommandWord.SAVE){
            save();
        }
        else if (commandWord == CommandWord.LOAD){
            load(command.getSecondWord());
        }
        return wantToQuit;
    }
    
    private void attack(Command command){ // The following 6 methods are our new methods which the comamands activate
        int damageTaken;
        if(currentRoom.enemyPresent()){
            damageTaken = currentRoom.attack(10);
            System.out.println("You hit the enemy for " + 10 + " damage!");
            player.damagetaken(damageTaken);
            
        }
        else{
            System.out.println("No enemy to attack");
            return;
        }
        if(!currentRoom.enemyPresent()){
            System.out.println("You killed an enemy!");
            player.printhealth();
            player.removeTime(5);
        }
    }
    
    private void drop(Command command){
        String second;
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        else{
            second = command.getSecondWord();
           
        }
        if(player.inventory.getItem(second) != null){
            player.inventory.remove(second);
            player.addWoodToRaft();
        }
        else {
            System.out.println("You are not carrying any wood");
        }
    }
    
    private void talk (Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Talk to who?");
            return;
        }
        if(currentRoom.friendPresent()){
            System.out.println("What's up? My name is Walter!");  
        } 
    }
    
    private void pickup(Command command){
        String second;
        if(!command.hasSecondWord()) {
            System.out.println("Pickup what?");
            return;
        }
        else{
            second = command.getSecondWord();
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
    
    private void use (Command command){
        String SecondWord;
        if(!command.hasSecondWord()) {
            System.out.println("Use what?");
            return;
        
        }
        else {
            SecondWord=command.getSecondWord().toLowerCase();
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
    
    /*private void inventory (){
    System.out.println("");
    }*/
    
    private void printHelp() 
    {
        System.out.println("You wake up on a beach");
        System.out.println("You see the rests of a plane scattered around the beach");
        System.out.println("Use commands to perform actions");
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);
        player.addTime(10);
        try {        
            if(currentRoom.isBlocked(direction) && !player.inventory.hasItem("machete")){
                System.out.println("You need a machete to get through here");
            }
            else{
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    if(currentRoom.enemyPresent()){
                        System.out.println("A wild " + currentRoom.enemyName() + " has appeared!");
                        System.out.println("Enemy health: " + currentRoom.enemyHealth());
                    }
                    //System.out.println("This room contains:"); //List of items in the room.            
            }            
        } catch (NullPointerException e) {
            System.out.println("No exit");
        }
    }
    

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
    
    private void save(){
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
    
    private void load(String fileLocation){
        try {
            FileInputStream loadFile = new FileInputStream(fileLocation);
            ObjectInputStream in = new ObjectInputStream(loadFile);
            save = (SaveFile)in.readObject();
            in.close();
            loadFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        player.health = save.player.health;
        player.inventory = save.player.inventory;
        currentRoom = save.currentRoom;
        System.out.println(currentRoom.getLongDescription());
        if(currentRoom.enemyPresent()){
            System.out.println("A wild " + currentRoom.enemyName() + " has appeared!");
            System.out.println("Enemy health: " + currentRoom.enemyHealth());
        }
    }
}
