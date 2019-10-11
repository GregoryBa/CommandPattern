package zuul.operator;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import zuul.io.InputManager;
import zuul.io.OutputManager;

/**
 *
 * @author gb430
 */
public class Parser 
{
    private Scanner reader;         // source of command input
    private InputManager inputMgr;
    private OutputManager outputMgr;

    /**
     * Create a parser to read from the terminal window.
     * @param version
     * @param in
     * @param out
     */
    public Parser(String version, InputManager in, OutputManager out) 
    {
        this.inputMgr = in;
        this. outputMgr = out;
        //commands = new CommandFactory(version);
        //commands = new CommandWords();
        reader = new Scanner(in.getInputStream());
        
    }
    
    /**
     *
     * @param str
     */
    public void setInputStream(FileInputStream str) { 
        reader = new Scanner(str);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        outputMgr.prompt();
        String inputLine = reader.nextLine();
        
        String word1 = null;
        String word2 = null;
        String word3 = null;

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
            if(tokenizer.hasNext()) {
                word3 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }
            return new Command(word1, word2, word3);
    }
}