import java.util.HashMap;
import java.util.Set;

/**
 * @author COLNOT Clemence
 * @version 2021.10.26
 */

public class Room
{
    private String aDescription;
    private HashMap <String, Room> aExits;
    private String aImageName;

    /**
     * Constructeur naturel
     * @param Description du lieu et Image associée
     */
    public Room(final String pDescription, final String pImage){
        this.aDescription = pDescription;
        this.aExits = new HashMap <String, Room>();
        this.aImageName = pImage;

    }// Room

    /**
     * @return le nom de l'image
     */
    public String getImageName(){
        return aImageName;
    }// getNameImage
    
    
    /**
     * Setter Room Exits 
     * @param String name direction, Room in this direction
     */
    public void setExits(final String pName, final Room pNextRoom){
        this.aExits.put(pName, pNextRoom);
    }// setExits

    /**
     * Getter Room description
     * @return aDescription
     */
    public String getShortDescription(){
        return this.aDescription;
    }// getDescription
    
    /**
     * Return the description and the exits
     * @return String description + exits
     */
    public String getLongDescription(){
        return "You are "+ this.aDescription + " "+ this.getExitsString()+".\n";
    }// getLongDescription

    /**
     * Getter Room Exit 
     * @param Direction
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }// getExits

    /**
     * Get Exits String
     * @return available exits
     */
    public String getExitsString(){
        StringBuilder vExits = new StringBuilder( "Exits:" );
        Set<String> keys = this.aExits.keySet();
        for(String vExit : keys){
            vExits.append(" " + vExit);
        }
        return vExits.toString();
    }// getExitsString

    /**
     * Print exits 
     */
    public void printExits(){
        System.out.println(this.getExitsString());

    }// printExits

    
} // Room
