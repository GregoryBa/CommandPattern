package zuul.operator.basic;

import zuul.operator.Commandexe;
import zuul.operator.Command;
import zuul.Game;

/**
 *
 * @author gb430
 */
public class HELPoperator implements Commandexe {

    Game zuul;
    
    /**
     *
     * @param zuul
     */
    public HELPoperator(Game zuul) {
        this.zuul = zuul;
    }

     // HERE I ALSO NEED TO INCLUDE NEW COMMANDS TO BE UPDATED
    // CREATE A METHOD GET COMMANDS IN COMMAND_FACTORY_STATIC_MAP METHOD!!!!!

    /**
     * Command "go" was entered. 
     * 
     * @param cmd : consists of max 3 words entered by user.
     */
    @Override
    public void execute(String[] cmd) {
       String[] msgs = {
            "You are lost. You are alone. You wander",
            "around at the university.",
            "",
            "Your command words are:",
            "   go quit help look take drop " };
        zuul.write(msgs);
        //outputMgr.write(String.join(" ", getCommandWords()));
    }
}


