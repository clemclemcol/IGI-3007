
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private final String[] sValidCommands = { "go", "quit", "help", "eat", "look", "move" }; 
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {

    } // CommandWords()*/

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int i = 0; i < this.sValidCommands.length; i++ ) {
            if ( this.sValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    } // isCommand()

    /**
     * Print all the valid commands
     */
    public String getCommandList(){
        String vList = "";
        for(String command : sValidCommands){
            vList += command + " ";
        }
        return vList;
    }
} // CommandWords