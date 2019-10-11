package zuul.operator.basic;

import zuul.operator.Commandexe;
import zuul.operator.Command;
import zuul.Game;
import zuul.Room;

/**
 *
 * @author gb430
 */
public class GOoperator implements Commandexe {

    Game zuul;
    Room room;
    
    /**
     *
     * @param zuul
     */
    public GOoperator(Game zuul) {
        this.zuul = zuul;
    }

    /**
     *
     * @param cmd
     */
    @Override
    public void execute(String[] cmd) {
        if (cmd[1] == null) {
            zuul.write("Go where?");
            return;
        }
        String direction = cmd[1];
       
        Room currentRoom = zuul.getCurrentRoom();
        Room nextRoom = null;
        
        if (direction.equals("north")) { nextRoom = currentRoom.northExit; }
        if (direction.equals("east")) { nextRoom = currentRoom.eastExit; }
        if (direction.equals("south")) { nextRoom = currentRoom.southExit; }
        if (cmd[1].equals("west")) { nextRoom = currentRoom.westExit; }
        if (nextRoom == null) { zuul.write("There is no door!"); } 
        else {
            
            currentRoom = nextRoom;
            zuul.setCurrentRoom(currentRoom);
            
        
            zuul.write("Exits: " + zuul.getExits());
            
            zuul.write("\nItems: ");
            if (currentRoom.itemDescription != null) {
                zuul.write(currentRoom.itemDescription
                        + '(' + currentRoom.itemWeight + ')' + "\n");
            }
        }
    }
}