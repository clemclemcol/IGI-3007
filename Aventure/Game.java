import java.util.HashMap;
import java.util.Set;

/**
 * @author COLNOT Clemence
 * @version 2021.11.15
 */

public class Game
{  
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Constructeur 
     */
    public Game(){
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface(this.aEngine);
        this.aEngine.setGUI(this.aGui);
    }// Game

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

} // Game
