package zuul.operator;

import zuul.Game;

/**
 * This class is based on the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word.
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is null.
 *
 * If the command had only one word, then the second word is null.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command
{
    private final String commandWord;
    private final String secondWord;
    private final String thirdWord;

    /**
     *
     */
    public static String NAME;

    /**
     * Create a command object. Need firstWord to process the command
     * @param firstWord The first word of the command.
     * @param secondWord The second word of the command.
     * @param thirdWord Third word of the command.
     */
    public Command(String firstWord, String secondWord, String thirdWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord() { return commandWord; }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord() { return secondWord; }
    
    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord() { return (secondWord != null); }

    /**
     *
     * @return true if the command has third word
     */
    public boolean hasThirdWord() { return (thirdWord != null); }
    
    /**
     *
     * @return The third word to this command. Returns null if there was no 
     * third word.
     */
    public String getThirdWord() { return thirdWord; }

    
    /**
     *
     * @return Returns all commands (up to three words entered by user)
     */
    public String[] getAllCommands() {
        String[] allWords = new String[3];
        allWords[0] = commandWord;
        allWords[1] = secondWord;
        allWords[2] = thirdWord;
        return allWords; 
    }
}

