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

    /**
     * Constructeur naturel
     * @param Description du lieu
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
        this.aExits = new HashMap <String, Room>();

    }// Room

    /**
     * Setter Room Exits 
     * @param String name direction, Room in this direction
     */
    public void setExits(final String pName, final Room pNextRoom){
        switch (pName){
            case "North":
            this.aExits.put("North", pNextRoom);
            break;
            case "South":
            this.aExits.put("South", pNextRoom);
            break;
            case "West":
            this.aExits.put("East", pNextRoom);
            break;
            case "East":
            this.aExits.put("West", pNextRoom);
            break;
            case "Up":
            this.aExits.put("Up", pNextRoom);
            break;
            case "Down":
            this.aExits.put("Down", pNextRoom);
            break;
            default : 
        }

    }// setExits

    /**
     * Getter Room description
     * @return aDescription
     */
    public String getDescription(){
        return this.aDescription;
    }// getDescription

    /**
     * Getter Room Exits 
     * @param Direction
     */
    public Room getExits(final String pDirection){
        return this.aExits.get(pDirection);
    }// getExits

    /**
     * Get Exits String
     * @return available exits
     */
    public String getExitsString(){
        String vExits = "Exits :";
        Set<String> keys = this.aExits.keySet();
        for(String vExit : keys){
            vExits += " " + vExit;
        }
        return vExits;
    }// getExitsString

    /**
     * Print exits 
     */
    public void printExits(){
        System.out.println(this.getExitsString());

    }// printExits

    /**
     * Return the description and the exits
     * @return String description + exits
     */
    public String getLongDescription(){
        return "You are "+ this.getDescription() + " "+ this.getExitsString()+".\n";
    }// getLongDescription

} // Room
