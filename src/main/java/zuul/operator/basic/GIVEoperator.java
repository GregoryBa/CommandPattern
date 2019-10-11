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
public class GIVEoperator implements Commandexe {
    Game zuul;
    Room room;
    
    /**
     *
     * @param zuul
     */
    public GIVEoperator(Game zuul) {
        this.zuul = zuul;
    }

    /**
     * Command "give" was entered. 
     * 
     * @param cmd : consists of max 3 words entered by user.
     */
    @Override
    public void execute(String[] cmd) {
        if ((cmd[1] == null)) {
            // if there is no second word, we don't know what to give...
            zuul.write("Give what?");
            return;
        }
        if ((cmd[2] == null)) {
            // if there is no third word, we don't to whom to give it...
            zuul.write("Give it to who?");
            return;
        }

        Room currentRoom = zuul.getCurrentRoom();
        String whom = cmd[2];

        if (currentRoom.getCharacter() != whom) {
            // cannot give it if the chacter is not here
            zuul.write(whom + " is not in the room");
            return;
        } else {
             String item = cmd[1];

       
        ArrayList items = zuul.getItemsList();
        int totalWeight = zuul.getTotalWeight();
        ArrayList weights = zuul.getWeightsList();
        
        int i = zuul.getItemsList().indexOf(item);
        if (i == -1) {
            zuul.write("You don't have the " + item);
            return;
        }
        items.remove(i);
        zuul.updateItemsList(items);
        int w = (Integer) weights.remove(i);
        totalWeight -= w;
        zuul.updateWeights(weights, totalWeight);
        }
    }
}