/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room upExit;
    private Room downExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }
    
    /**
     * Return exit to the direction.
     * @param direction Direction to be verified.
     * @return Room at the direction.
     */
    public Room getExit( String direction){
        if(direction.equals("north")){
            return northExit;
        }
        if( direction.equals("south")){
            return southExit;
        }
        if( direction.equals("east") ){
            return eastExit;
        }
        if( direction.equals("west") ){
            return westExit;
        }
        if( direction.equals("up") ){
            return upExit;
        }
        if( direction.equals("down") ){
            return downExit;
        }

        return null;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        upExit = up;
        downExit = down;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return exit description.
     * @return String that represents the direction that leads to the next room.
     */
    public String getExitString(){
        String exit = "Exists: ";
        if(northExit != null) {
            exit += "north ";
        }
        if(eastExit != null) {
            exit += "east ";
        }
        if(southExit != null) {
            exit += "south ";
        }
        if(westExit != null) {
            exit += "west ";
        }
        if(upExit != null) {
            exit += "up ";
        }
        if(downExit != null) {
            exit += "down ";
        }

        return exit;
    }

}