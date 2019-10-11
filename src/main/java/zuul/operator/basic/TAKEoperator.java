package zuul.operator.basic;

import zuul.operator.Commandexe;
import zuul.operator.Command;
import zuul.Game;
import zuul.Room;

/**
 *
 * @author gb430
 */
public class TAKEoperator implements Commandexe {
    Game zuul;
    Room room;
    private final int MAX_WEIGHT = 10;
    
    /**
     *
     * @param zuul
     */
    public TAKEoperator(Game zuul) {
        this.zuul = zuul;
    }

    /**
     * Command "take" was entered. 
     * 
     * @param cmd : consists of max 3 words entered by user.
     */
    @Override
    public void execute(String[] cmd) {
        Room currentRoom = zuul.getCurrentRoom();
        
        if (cmd[1] == null) {
            // if there is no second word, we don't know what to take...
            zuul.write("Take what?");
            return;
        }

        String item = cmd[1];
        
        int w = currentRoom.containsItem(item);
        if (w == 0) {
            // The item is not in the room
            zuul.write("No " + item + " in the room");
            return;
        }
        
        if (zuul.getTotalWeight() + w > MAX_WEIGHT) {
            // The player is carrying too much
            zuul.write(item + " is too heavy");
            return;
        }
        // OK we can pick it up
        currentRoom.removeItem(item);
        zuul.addItem(item, w);
        zuul.write("You picked up: " + item + "\nYour current weight is: " + zuul.getTotalWeight());
    }
}