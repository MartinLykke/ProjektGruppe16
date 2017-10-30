



/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
   
    private Parser parser;
    private Room currentRoom;
    private Player player;
        
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
        jungle3 = new Room("You have ventured into the jungle. There are palmtrees all around you. As you look to your left you see an angry kanibal charging you through the jungle. You have no choice but to fight back.");
        jungle4 = new Room("You are in the jungle.");
        jungle5 = new Room("You are in the jungle, once again surrounded by palmtrees.");
        jungle6 = new Room("You are in the jungle. You can just make out an entrance to a cave.");
        cave = new Room("You are in a dimly lit cave.");
        
        //beach1.setExit("north", jungle1);
        beach1.setExit("east", beach2);
        beach1.putItem(new Coconut());
        beach1.spawnEnemy(new Enemy("Kanibal", 20));

        //beach2.setExit("north", jungle2);
        beach2.setExit("east", beach3);
        beach2.setExit("west", beach1);

        beach3.setExit("north", jungle3);
        beach3.setExit("west", beach2);

        jungle1.setExit("north", jungle4);
        //jungle1.setExit("east", jungle2);
        //jungle1.setExit("south", beach1);

        jungle2.setExit("north", jungle5);
        jungle2.setExit("east", jungle3);
        //jungle2.setExit("south", beach2);
        //jungle2.setExit("west", jungle1);
        
        //jungle3.setExit("north", jungle6);
        jungle3.setExit("south", beach3);
        jungle3.setExit("west", jungle2);

        jungle4.setExit("east", jungle5);
        jungle4.setExit("south", jungle1);

        jungle5.setExit("east", jungle6);
        jungle5.setExit("south", jungle2);
        jungle5.setExit("west", jungle4);
        
        jungle6.setExit("north", cave);
        //jungle6.setExit("south", jungle3);
        jungle6.setExit("west", jungle5);
        
        cave.setExit("south", jungle6);
        
        currentRoom = beach2; //
    }

    public void play() 
    {            
        player = new Player();
        printWelcome();
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
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
            Attack(command);
        }
        else if (commandWord == CommandWord.DROP){
            Drop(command);
        }
        else if (commandWord == CommandWord.INVENTORY){
            Inventory();
        }
        else if (commandWord == CommandWord.TALK){
            Talk(command);
        }
        else if (commandWord == CommandWord.PICKUP){
            Pickup(command);
        }
        else if (commandWord == CommandWord.USE){
            Use(command);
        }
        return wantToQuit;
    }
    private void Attack(Command command){ // The following 6 methods are our new methods which the comamands activate
        if(currentRoom.enemyPresent()){
            currentRoom.attack(10);
        }
        if(!currentRoom.enemyPresent()){
            System.out.println("you killed an enemy!");
            player.PrintHealth();
        }
    }
    private void Drop(Command command){ 
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
    } 
    private void Talk (Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Talk to who?");
            return;
        }
    }
    
    private void Pickup(Command command){
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
        }
        else {
            System.out.println("You look around but can't find any " + second);
        }
    }
    private void Use (Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Use what?");
            return;
        }
    }
    private void Inventory (){
        System.out.println("");
    }
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

        if (nextRoom == null) {
            System.out.println("Your path is blocked in this direction");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            //System.out.println("This room contains:"); //List of items in the room.
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
}
