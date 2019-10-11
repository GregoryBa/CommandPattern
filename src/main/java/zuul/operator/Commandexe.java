package zuul.operator;

import zuul.Game;

/**
 * Interface that handles execution of given command.
 * @author gb430
 */
public interface Commandexe {

    /**
     *
     * @param cmd : consists of max 3 words entered by user.
     */
    public void execute(String[] cmd);
}