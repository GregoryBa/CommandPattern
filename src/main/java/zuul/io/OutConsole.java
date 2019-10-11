package zuul.io;

import java.util.Collection;

/**
 *
 * @author gb430
 */
public class OutConsole implements OutputManager {

    /**
     * Generate output mechanism for console
     */
    public OutConsole() { }
    
    /**
     * 
     */
    @Override
    public void prompt() { System.out.print("> "); }
    
    /**
     *
     */
    @Override
    public void newLine() {System.out.println();}

    /**
     *
     * @param str
     */
    @Override
    public void write(String str) { System.out.println(str); }

    /**
     *
     * @param messages
     */
    @Override
    public void write(Collection<String> messages) {
        for (String msg : messages) 
            System.out.println(msg);
    }

    /**
     *
     * @param messages
     */
    @Override
    public void write(String[] messages) {
        for (String msg : messages) 
            System.out.println(msg);
    }

    /**
     *
     * @param str
     */
    @Override
    public void error(String str) { System.err.println(str); }

    /**
     *
     * @param messages
     */
    @Override
    public void error(String[] messages) {
        for (String msg : messages) 
            System.err.println(msg);
    }
    
    /**
     *
     * @param str
     */
    @Override
    public void fatal(String str) { System.err.println(str); } 
    

}
