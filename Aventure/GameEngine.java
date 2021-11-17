import java.util.HashMap;
import java.util.Set;

/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author COLNOT Clémence
 * @version 2021.11.15
 */
public class GameEngine
{
    private Parser        aParser;
    private Room          aCurrentRoom;
    private HashMap       aRooms;
    private UserInterface aGui;
    
    /**
     * Constructeur d'objets de classe GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.createRooms();
    }
    
    /**
     * Set the value of the User Interface
     */
    public void setGUI(final UserInterface pUserInterface){
        this.aGui = pUserInterface;
        this.printWelcome();
    }// setGUI

    /**
     * Print Welcome message
     */
    private void printWelcome(){
        this.aGui.println("");
        this.aGui.println("Welcome to Surviving History! Surviving History is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help.\n");
        this.aGui.println("");
        this.printLocationInfos();
        if (this.aCurrentRoom.getImageName() != null)
            aGui.showImage(this.aCurrentRoom.getImageName());

    }// printWelcome

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
        this.aRooms = new HashMap <String, Room>();
        //ajouter le nom des images
        Room vBastille = new Room("in the court yard of the Bastille.","Images/bastille.jpg");
        Room vCelluleBastille = new Room("locked a cell of the Bastille.","Images/cachot.jpg");
        Room vSaintLazare = new Room("","");
        Room vChatelet = new Room("" ,"");
        Room vLouvre = new Room("in front of the castle of the Louvre.","Images/louvre.jpg");
        Room vJardinTuileries = new Room("on the walking path of the Tuileries.","Images/tuileries.jpg");
        Room vIleCite = new Room("near the Seine on the City Isle.","Images/ileCite.JPG");
        Room vIleSaintLouis = new Room("near the Seine on Saint Louis'Isle.","");
        Room vJardinPlantes = new Room("by the exotic flowers.","");
        Room vSorbonne = new Room("in front of the Sorbonne's building.","Images/sorbonne.webp");
        Room vLuxembourg = new Room("by the Luxembourg gardens.","");
        Room vHotelInvalides = new Room("in the Hotel's lobby.","");
        Room vSalpetriere = new Room("by the Salpetriere's front desk.","");
        Room vGobelins = new Room("in front of the Gobelins'building.","");
        Room vObservatoire = new Room("at the top of the Observatory.","Images/observatoire.jpg");
        Room vCatacombes = new Room("in the Catacombes' gallery.","Images/catacombes.jpg");
        Room vPortRoyal = new Room("","");
        Room vPalaisVersailles = new Room("in front of the royal castle.","Images/palaisVersailles.jpg");
        Room vGallerieGlasses = new Room("in the glass coridor.","Images/galerieGlaces.jpg");
        Room vCouloirChambre = new Room("in the bedrooms' coridor.","");
        Room vChambreReine = new Room("in the Queen's bedroom.","Images/chambreReine.jpg");
        Room vChambreRoi = new Room("in the King's bedroom.","Images/chambreRoi.jpg");
        Room vSouterrainVersailles = new Room("in the Palace's undergrounds.","Images/souterrainVersailles.jpg");
        Room vJardinVersailles = new Room("by the Appollo fountain of Versailles.","Images/jardinVersailles.jpg");

        // Positionnement des sorties
        vCelluleBastille.setExits("up", vBastille);

        vBastille.setExits("east", vChatelet);
        vBastille.setExits("down", vCelluleBastille);
        
        vSaintLazare.setExits("south", vChatelet);

        vChatelet.setExits("north",vSaintLazare);
        vChatelet.setExits("south",vIleCite);
        vChatelet.setExits("east",vBastille);
        vChatelet.setExits("west",vLouvre);

        vLouvre.setExits("south", vLuxembourg);
        vLouvre.setExits("east", vChatelet);
        vLouvre.setExits("west", vJardinTuileries);

        vJardinTuileries.setExits("south", vHotelInvalides);
        vJardinTuileries.setExits("east", vLouvre);

        vIleCite.setExits("north",vChatelet);
        vIleCite.setExits("south",vSorbonne);
        vIleCite.setExits("east",vIleSaintLouis);

        vIleSaintLouis.setExits("south", vJardinPlantes);
        vIleSaintLouis.setExits("west", vIleCite);

        vJardinPlantes.setExits("north",vIleSaintLouis);
        vJardinPlantes.setExits("south", vGobelins); 
        vJardinPlantes.setExits("west", vSorbonne);

        vSorbonne.setExits("north",vIleCite);
        vSorbonne.setExits("south",vPortRoyal);
        vSorbonne.setExits("east",vJardinPlantes);
        vSorbonne.setExits("west",vLuxembourg);

        vLuxembourg.setExits("north",vLouvre);
        vLuxembourg.setExits("south",vObservatoire);
        vLuxembourg.setExits("east",vSorbonne);
        vLuxembourg.setExits("west",vHotelInvalides);

        vHotelInvalides.setExits("north",vJardinTuileries);
        vHotelInvalides.setExits("east",vLuxembourg);

        vSalpetriere.setExits("east",vGobelins);

        vGobelins.setExits("north",vJardinPlantes);
        vGobelins.setExits("east",vSalpetriere);
        vGobelins.setExits("west",vObservatoire);

        vObservatoire.setExits("north",vLuxembourg);
        vObservatoire.setExits("south",vCatacombes);
        vObservatoire.setExits("east",vGobelins);

        vCatacombes.setExits("north",vObservatoire);
        vCatacombes.setExits("east",vPortRoyal); // Passage secret

        vPortRoyal.setExits("north",vSorbonne);
        vPortRoyal.setExits("west",vCatacombes);

        vPalaisVersailles.setExits("east",vCatacombes);
        vPalaisVersailles.setExits("west",vJardinVersailles);
        vPalaisVersailles.setExits("up",vGallerieGlasses);
        vPalaisVersailles.setExits("down",vSouterrainVersailles);

        vGallerieGlasses.setExits("up",vCouloirChambre);
        vGallerieGlasses.setExits("down",vPalaisVersailles);

        vCouloirChambre.setExits("east",vChambreRoi);
        vCouloirChambre.setExits("west",vChambreReine);
        vCouloirChambre.setExits("down",vGallerieGlasses);

        // Position courante
        //this.setCurrentRoom(vCelluleBastille);
        this.setCurrentRoom(vPalaisVersailles);
        
        
        //Stockage dans la HashMap
        this.aRooms.put("vBastille", vBastille);
        this.aRooms.put("vCelluleBastille", vCelluleBastille);
        this.aRooms.put("vSaintLazare",vSaintLazare);
        this.aRooms.put("vChatelet", vChatelet);
        this.aRooms.put("vLouvre", vLouvre);
        this.aRooms.put("vJardinTuileries",vJardinTuileries);
        this.aRooms.put("vIleCite", vIleCite);
        this.aRooms.put("vIleSaintLouis", vIleSaintLouis); 
        this.aRooms.put("vJardinPlantes", vJardinPlantes);
        this.aRooms.put("vSorbonne", vSorbonne); 
        this.aRooms.put("vLuxembourg", vLuxembourg); 
        this.aRooms.put("vHotelInvalides", vHotelInvalides);
        this.aRooms.put("vSalpetriere", vSalpetriere); 
        this.aRooms.put("vGobelins", vGobelins);
        this.aRooms.put("vObservatoire", vObservatoire); 
        this.aRooms.put("vCatacombes", vCatacombes);
        this.aRooms.put("vPortRoyal", vPortRoyal); 
        this.aRooms.put("vPalaisVersailles", vPalaisVersailles);
        this.aRooms.put("vGallerieGlasses", vGallerieGlasses); 
        this.aRooms.put("vCouloirChambre", vCouloirChambre); 
        this.aRooms.put("vChambreReine", vChambreReine);
        this.aRooms.put("vChambreRoi", vChambreRoi);
        this.aRooms.put("vSouterrainVersailles", vSouterrainVersailles); 
        this.aRooms.put("vJardinVersailles", vJardinVersailles);

    }// createRooms

    /**
     * goRoom change place
     * @param Command
     */
    private void goRoom(final Command pCommand){
        if (!pCommand.hasSecondWord()) {
            this.aGui.println("Go where?");
            return;
        }
        
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        if (this.aCurrentRoom.getExit(vDirection) == null){
            this.aGui.println("There is no door !");

        }else {
            vNextRoom = this.aCurrentRoom.getExit(vDirection);
            this.setCurrentRoom(vNextRoom);
            this.printLocationInfos();
        }

    }// goRoom

    /**
     * Print help
     */
    private void printHelp(){
        this.aGui.println ("You are lost. You are alone. You're locked in the Bastille, in the XVII century.");
        this.aGui.println("");
        this.aGui.println("Your command words are :");
        this.aGui.println(this.aParser.showCommands());
    }// printHelp

    /**
     * Print Location infos
     */
    private void printLocationInfos(){
        this.aGui.println(this.aCurrentRoom.getLongDescription());
        this.aGui.println(this.aCurrentRoom.getImageName());
    }

    /**
     * Interpret Command
     * @param String complete command
     * @return boolean
     */
    public void interpretCommand(final String pCommandLine){
        this.aGui.println("> " + pCommandLine);
        Command vCommand = this.aParser.getCommand(pCommandLine);
        
        switch (vCommand.getCommandWord()) {
            case "help":
                this.printHelp();
                return ;
 
            case "go":
                this.goRoom(vCommand);
                return;
                
            case "quit":
                if ( vCommand.hasSecondWord() )
                    this.aGui.println( "Quit what?" );
                else
                    this.endGame();
                return ;
                
            case "look":
                this.look();
                return ;
                
            case "eat":
                this.eat();
                return ;
            default : 
                System.out.println("I don't know what you mean...");
                return ;
        }

    }// processCommand

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
        this.aGui.println("You've eaten. You're full of energy now.");
        this.aGui.enable( false );
    }// eat
    
    /**
     * End game message
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }// endGame

}
