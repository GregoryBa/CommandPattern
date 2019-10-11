package zuul.operator.basic;

import java.util.ArrayList;
import zuul.operator.Commandexe;
import zuul.operator.Command;
import zuul.Game;
import zuul.Room;

/**
 *
 * @author gb430
 */
public class DROPoperator implements Commandexe {
    Game zuul;
    Room room;
    
    /**
     *
     * @param zuul
     */
    public DROPoperator(Game zuul) {
        this.zuul = zuul;
    }

    /**
     *  * Command "drop" was entered. 
     * 
     * @param cmd : consists of max 3 words entered by user.
     */
    @Override
    public void execute(String[] cmd) {
        if (cmd[1] == null) {
            zuul.write("Drop what?");
            return;
        }

        String item = cmd[1];
        ArrayList items = zuul.getItemsList();
        ArrayList weights = zuul.getWeightsList();
        Room currentRoom = zuul.getCurrentRoom();
        int totalWeight = zuul.getTotalWeight();
        
        int i = items.indexOf(item);
        if (i == -1) {
            zuul.write("You don't have the " + item);
            return;
        }
        items.remove(i);
        zuul.updateItemsList(items);
        int w = (Integer) weights.remove(i);
        totalWeight -= w;
        zuul.updateWeights(weights, totalWeight);
        
        currentRoom.addItem(item, w);
        zuul.write("You dropped: " + item);
    }
}