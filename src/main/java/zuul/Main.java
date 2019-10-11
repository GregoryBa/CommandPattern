package zuul;


import zuul.io.InConsole;
import zuul.io.OutConsole;

/**
 *
 * @author moose
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game("singleplayer",  new OutConsole(), new InConsole()).play();
    }
}