package zuul.operator.basic;

import zuul.operator.Commandexe;
import zuul.Game;

/**
 *
 * @author gb430
 */
public class QUIToperator implements Commandexe {
    Game zuul;
    
    /**
     *
     * @param zuul
     */
    public QUIToperator(Game zuul) {
        this.zuul = zuul;
    }

    /**
     * Command "quit" was entered. Safe quits the program.
     * 
     * @param cmd : consists of max 3 words entered by user.
     */
    @Override
    public void execute(String[] cmd) {
        if (!(cmd[1] == null)) { zuul.write("Quit what?"); } 
        else {
            zuul.write("Thank you for playing.  Good bye.");
            System.exit(0);
        }
    }
}