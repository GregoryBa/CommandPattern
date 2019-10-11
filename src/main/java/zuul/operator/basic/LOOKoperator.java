package zuul.operator.basic;

import zuul.operator.Commandexe;
import zuul.operator.Command;
import zuul.Game;
import zuul.Room;

/**
 *
 * @author gb430
 */
public class LOOKoperator implements Commandexe {
    Game zuul;
    Room room;
    
    /**
     *
     * @param zuul
     */
    public LOOKoperator(Game zuul) {
        this.zuul = zuul;
    }

    /**
     * Command "look" was entered. 
     * 
     * @param cmd : consists of max 3 words entered by user.
     */
    @Override
    public void execute(String[] cmd) {
        Room currentRoom = zuul.getCurrentRoom();
        
        zuul.write("You are " + currentRoom.getDescription() + ".");
        zuul.write("Exits: " + zuul.getExits());
        
        zuul.write("\nItems: ");
        if (currentRoom.itemDescription != null) {
            zuul.write(currentRoom.itemDescription
                    + '(' + currentRoom.itemWeight + ')' + "\n");
        }
    }
}