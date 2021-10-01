
package v1;

public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
     
    /**
     * Constructeur 
     */
    public Game(){
        this.createRooms();
        this.aParser = new Parser();
    }// Game
    
    /**
     * Getter Current position
     * @return current room
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }// getCurrentRoom
    
    /**
     * Setter current room
     * @param current room
     */
    public void setCurrentRoom(final Room pCurrentRoom){
        this.aCurrentRoom = pCurrentRoom;
    }// setCurrentRoom
    
    /**
     * Create Rooms
     */
    private void createRooms(){
        // Creation des lieux
        Room vRoom1 = new Room("In the campus pub");
        Room vRoom2 = new Room("Outside the main entrance of the university");
        Room vRoom3 = new Room("In a lecture theatre");
        Room vRoom4 = new Room("In the campus lab");
        Room vRoom5 = new Room("In the computing admin office");
        
        // Positionnement des sorties
        vRoom1.setExits(null, null, vRoom2, null);
        vRoom2.setExits(null, vRoom4, vRoom3, vRoom1);
        vRoom3.setExits(null, null, vRoom2, null);
        vRoom4.setExits(vRoom2, null, vRoom5, null);
        vRoom5.setExits(null, null, null, vRoom4);
        
        // Position courante
        this.setCurrentRoom(vRoom2);
        
    }// createRooms
    
    /**
     * goRoom change place
     * @param Command
     */
    private void goRoom(final Command pCommand){
        if (!pCommand.hasSecondWord()) {
            System.out.println ("Go where?");
            return;
        }
        
        Room vNextRoom = new Room(null);
        String vDirection = pCommand.getSecondWord();
        if (this.aCurrentRoom.getExits(vDirection) == null){
            System.out.println("There is no door !");
            
        }else {
            vNextRoom = this.aCurrentRoom.getExits(vDirection);
            this.setCurrentRoom(vNextRoom);
            System.out.println(this.aCurrentRoom.getDescription());
            this.aCurrentRoom.printExits();
        }
        
    }// goRoom
    
    /**
     * Print Welcome message
     */
    private void printWelcome(){
        Game vG = new Game();
        System.out.println("Welcome to the World of Zuul! World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        this.aCurrentRoom.printExits();
        
    }// printWelcome
    
    /**
     * Print help
     */
    private void printHelp(){
        System.out.println ("You are lost. You are alone. You wander around at the university.");
        System.out.println("Your command words are :");
        System.out.println(" go quit help ");
    }// printHelp
    
    
    /**
     * Process command
     * @param String complete command
     * @return boolean
     */
    private boolean processCommand(final Command pCompleteCommand){
        switch (pCompleteCommand.getCommandWord()) {
            case "help":
                this.printHelp();
                return false;
            case "go":
                return false;
            case "quit":
                return quit(pCompleteCommand);
            default : 
                System.out.println("I don't know what you mean...");
                return false;
        }
        
    }// processCommand
    
    /**
     * Quit
     */
    private boolean quit(final Command pCommand){
        
        if (pCommand.hasSecondWord()){
            System.out.println("Quit what??");
            return false;
        }
        else return true;
        
    }// quit
    
    /**
     * Play Game
     */
    public void play(){
        this.printWelcome();
        boolean vFinished = false;
        while (!vFinished){
            vFinished = this.processCommand(this.aParser.getCommand());
        }
        System.out.println("Thank you for playing.  Good bye!");
    }// play
} // Game
