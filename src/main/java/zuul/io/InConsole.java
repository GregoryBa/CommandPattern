package zuul.io;

import java.io.InputStream;

/**
 * Class to handle input from the console
 * @author gb430
 */
public class InConsole implements InputManager {
    private final InputStream in;
    
    /** Create an input mechanism */
    public InConsole () { in = System.in; }

    /**
     *
     * @return InputStream
     */
    @Override
     public InputStream getInputStream() { return in; }
}
