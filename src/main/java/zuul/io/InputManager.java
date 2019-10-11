package zuul.io;

import java.io.InputStream;

/**
 * Class to handle input
 * @author gb430
 */
public interface InputManager {
    
    /**
     * Return the input stream for this input
     *
     * @return the stream
     */
    public InputStream getInputStream();
}
