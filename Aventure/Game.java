/**
 * @author COLNOT Clemence
 * @version 2021.10.26
 */

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
     * Setter current room
     * @param current room
     */
    public void setCurrentRoom(final Room pCurrentRoom){
        this.aCurrentRoom = pCurrentRoom;
    }// setCurrentRoom

    /**
     * Getter Current position
     * @return current room
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }// getCurrentRoom

    /**
     * Create Rooms
     */
    private void createRooms(){
        // Creation des lieux
        Room vBastille = new Room("In the court yard of the Bastille.");
        Room vCelluleBastille = new Room("Locked a cell of the Bastille.");
        Room vSaintLazare = new Room("");
        Room vChatelet = new Room("");
        Room vLouvre = new Room("In front of the castle of the Louvre.");
        Room vJardinTuileries = new Room("On the walking path of the Tuileries.");
        Room vIleCite = new Room("Near the Seine on the City Isle.");
        Room vIleSaintLouis = new Room("Near the Seine on Saint Louis'Isle.");
        Room vJardinPlantes = new Room("By the exotic flowers.");
        Room vSorbonne = new Room("In front of the Sorbonne's building.");
        Room vLuxembourg = new Room("By the Luxembourg gardens.");
        Room vHotelInvalides = new Room("In the Hotel's lobby.");
        Room vSalpetriere = new Room("By the Salpetriere's front desk.");
        Room vGobelins = new Room("In front of the Gobelins'building.");
        Room vObservatoire = new Room("At the top of the Observatory.");
        Room vCatacombes = new Room("In the Catacombes' gallery.");
        Room vPortRoyal = new Room("");
        Room vPalaisVersailles = new Room("In front of the royal castle.");
        Room vGallerieGlasses = new Room("In the glass coridor.");
        Room vCouloirChambre = new Room("In the bedrooms coridor.");
        Room vChambreReine = new Room("In the Queen's bedroom.");
        Room vChambreRoi = new Room("In the King's bedroom.");
        Room vSouterrainVersailles = new Room("In the Palace's undergrounds.");
        Room vJardinVersailles = new Room("By the Appollo fountain of Versailles.");

        // Positionnement des sorties
        vBastille.setExits("East", vChatelet);
        vBastille.setExits("Down", vCelluleBastille);

        vCelluleBastille.setExits("Up", vBastille);

        vSaintLazare.setExits("South", vChatelet);

        vChatelet.setExits("North",vSaintLazare);
        vChatelet.setExits("South",vIleCite);
        vChatelet.setExits("East",vBastille);
        vChatelet.setExits("West",vLouvre);

        vLouvre.setExits("South", vLuxembourg);
        vLouvre.setExits("East", vChatelet);
        vLouvre.setExits("West", vJardinTuileries);

        vJardinTuileries.setExits("South", vHotelInvalides);
        vJardinTuileries.setExits("East", vLouvre);

        vIleCite.setExits("North",vChatelet);
        vIleCite.setExits("South",vSorbonne);
        vIleCite.setExits("East",vIleSaintLouis);

        vIleSaintLouis.setExits("South", vJardinPlantes);
        vIleSaintLouis.setExits("West", vIleCite);

        vJardinPlantes.setExits("North",vIleSaintLouis);
        vJardinPlantes.setExits("South", vGobelins); 
        vJardinPlantes.setExits("West", vSorbonne);

        vSorbonne.setExits("North",vIleCite);
        vSorbonne.setExits("South",vPortRoyal);
        vSorbonne.setExits("East",vJardinPlantes);
        vSorbonne.setExits("West",vLuxembourg);

        vLuxembourg.setExits("North",vLouvre);
        vLuxembourg.setExits("South",vObservatoire);
        vLuxembourg.setExits("East",vSorbonne);
        vLuxembourg.setExits("West",vHotelInvalides);

        vHotelInvalides.setExits("North",vJardinTuileries);
        vHotelInvalides.setExits("East",vLuxembourg);

        vSalpetriere.setExits("East",vGobelins);

        vGobelins.setExits("North",vJardinPlantes);
        vGobelins.setExits("East",vSalpetriere);
        vGobelins.setExits("West",vObservatoire);

        vObservatoire.setExits("North",vLuxembourg);
        vObservatoire.setExits("South",vCatacombes);
        vObservatoire.setExits("East",vGobelins);

        vCatacombes.setExits("North",vObservatoire);
        vCatacombes.setExits("East",vPortRoyal); // Passage secret

        vPortRoyal.setExits("North",vSorbonne);
        vPortRoyal.setExits("West",vCatacombes);

        vPalaisVersailles.setExits("East",vCatacombes);
        vPalaisVersailles.setExits("West",vJardinVersailles);
        vPalaisVersailles.setExits("Up",vGallerieGlasses);
        vPalaisVersailles.setExits("Down",vSouterrainVersailles);

        vGallerieGlasses.setExits("Up",vCouloirChambre);
        vGallerieGlasses.setExits("Down",vPalaisVersailles);

        vCouloirChambre.setExits("East",vChambreRoi);
        vCouloirChambre.setExits("West",vChambreReine);
        vCouloirChambre.setExits("Down",vGallerieGlasses);

        // Position courante
        this.setCurrentRoom(vCelluleBastille); //cachot

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
            this.printLocationInfos();
        }

    }// goRoom

    /**
     * Print Welcome message
     */
    private void printWelcome(){
        System.out.println("Welcome to the World of Zuul! World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        this.printLocationInfos();

    }// printWelcome

    /**
     * Print help
     */
    private void printHelp(){
        System.out.println ("You are lost. You are alone. You're locked in the Bastille, in the XVII century.");
        System.out.println();
        System.out.println("Your command words are :");
        this.aParser.showCommands();
    }// printHelp

    /**
     * Print Location infos
     */
    private void printLocationInfos(){
        System.out.println(this.aCurrentRoom.getLongDescription());
    }

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
            case "look":
            this.look();
            return false;
            case "eat":
            this.eat();
            return false;
            default : 
            System.out.println("I don't know what you mean...");
            return false;
        }

    }// processCommand

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
     * Look
     */
    public void look(){
        this.printLocationInfos();
    }// look

    /**
     * Eat
     */
    public void eat(){
        System.out.println("You've eaten. You're full of energy now.");
    }// eat

} // Game
