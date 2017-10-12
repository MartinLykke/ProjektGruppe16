
/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        Room beach1, beach2, beach3, jungle1, jungle2, jungle3, jungle4, jungle5, jungle6, cave;
      
        beach1 = new Room("on the Western part of the beach!!!"); //Kasper test
        beach2 = new Room("on the central part of the beach");
        beach3 = new Room("on the Eastern part of the beach");
        jungle1 = new Room("in the jungle, the mighty jungle, where lions sleep tonight");
        jungle2 = new Room("in the jungle, the mighty jungle, where lions sleep tonight");
        jungle3 = new Room("in the jungle, the mighty jungle, where lions sleep tonight");
        jungle4 = new Room("in the jungle, the mighty jungle, where lions sleep tonight");
        jungle5 = new Room("in the jungle, the mighty jungle, where lions sleep tonight");
        jungle6 = new Room("in the jungle, the mighty jungle, where lions sleep tonight");
        cave = new Room("in a dimly lit cave");
        
        beach1.setExit("north", jungle1);
        beach1.setExit("east", beach2);

        beach2.setExit("north", jungle2);
        beach2.setExit("east", beach3);
        beach2.setExit("west", beach1);

        beach3.setExit("north", jungle3);
        beach3.setExit("west", beach2);

        jungle1.setExit("north", jungle4);
        jungle1.setExit("east", jungle2);
        jungle1.setExit("south", beach1);

        jungle2.setExit("north", jungle5);
        jungle2.setExit("east", jungle3);
        jungle2.setExit("south", beach2);
        jungle2.setExit("west", jungle1);
        
        jungle3.setExit("north", jungle6);
        jungle3.setExit("south", beach3);
        jungle3.setExit("west", jungle2);

        jungle4.setExit("east", jungle5);
        jungle4.setExit("south", jungle1);

        jungle5.setExit("east", jungle6);
        jungle5.setExit("south", jungle2);
        jungle5.setExit("west", jungle4);
        
        jungle6.setExit("north", cave);
        jungle6.setExit("south", jungle3);
        jungle6.setExit("west", jungle5);
        
        cave.setExit("south", jungle6);
        
        currentRoom = beach1;
    }

    public void play() 
    {            
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
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
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
            Attack();
        }
        else if (commandWord == CommandWord.DROP){
            Drop();
        }
        else if (commandWord == CommandWord.INVENTORY){
            Inventory();
        }
        else if (commandWord == CommandWord.TALK){
            Talk();
        }
        else if (commandWord == CommandWord.PICKUP){
            Pickup();
        }
        else if (commandWord == CommandWord.USE){
            Use();
        }
        return wantToQuit;
    }
    private void Attack(){
        
    }
    private void Drop(){
        
    } 
    private void Talk (){
        
    }
    
    private void Pickup(){
        
    }
    private void Use (){
        
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
