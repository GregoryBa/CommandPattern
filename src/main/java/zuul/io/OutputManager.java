/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul.io;

import java.util.Collection;
/**
 *
 * @author gb430
 */
public interface OutputManager {
    /**
     * Print a prompt message
     */
    public void prompt();
    
    /**
     *
     */
    public void newLine();

    /**
     * Print a message
     * @param str the message
     */
    public void write(String str);

    /**
     * Print a list of messages
     * @param messages the messages
     */
    public void write(Collection<String> messages);

    /**
     * Print a list of messages
     * @param messages the messages
     */
    public void write(String[] messages);

    /**
     * Print an error message
     * @param str the message
     */
    public void error(String str);

    /**
     * Print a list of error messages
     * @param messages the messages
     */
    public void error(String[] messages);

    /**
     * A fatal error
     * @param message the error
     */
    public void fatal(String message);
}
