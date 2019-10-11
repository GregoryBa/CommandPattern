package zuul;

import zuul.operator.basic.LOOKoperator;
import zuul.operator.basic.DROPoperator;
import zuul.operator.basic.GOoperator;
import zuul.operator.basic.TAKEoperator;
import zuul.operator.basic.QUIToperator;
import zuul.operator.basic.GIVEoperator;
import zuul.operator.basic.HELPoperator;
import zuul.operator.Command;
import zuul.operator.Parser;
import java.util.ArrayList;
import zuul.io.InputManager;
import zuul.io.OutputManager;
import java.util.HashMap;
import zuul.operator.Commandexe;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * To play this game, create an instance of this class and call the "play"
 * method.
 *
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Game {
    /** direct all output messages though outputMgr */
    private final OutputManager outputMgr;
    /** direct all input messages though inputMgr */
    private final InputManager inputMgr;
    // Decides the version we want to use:
    private final String version;    // DEBATABLE IF FINAL OR NOT???????
    private final HashMap<String, Commandexe> validCommands;
    
    private final Parser parser;
    private Room currentRoom;
    private ArrayList items;
    private ArrayList weights;
    private int totalWeight;

    /**
     * Create the game and initialise its internal map.
     * @param version
     * @param out
     * @param in
     */
    public Game(String version, OutputManager out, InputManager in) {
        this.version = version;
        outputMgr = out;
        inputMgr = in;
        parser = new Parser(version, in, out);
        items = new ArrayList();
        weights = new ArrayList();
        totalWeight = 0;
        validCommands = new HashMap<>();
        createRooms();
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExits(null, theatre, lab, pub);
        outside.addItem("notebook", 2);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside;  // start game outside
    }

    /**
     * Main play routine. Loops until end of play.
     *  // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
     */
    public void play() {
        outputMgr.write(welcome());
        initValidCommands();

        while (true) {
            Command command = parser.getCommand();
            processCommand(command);
        }
    }
    
     /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     */
    private void processCommand(Command command) {
        if(isCommand(command.getCommandWord())) { validCommands.get(command.getCommandWord()).execute(command.getAllCommands()); }
        if (!isCommand(command.getCommandWord())) { outputMgr.write("I don't know what you mean..."); }
    }
    
    private void initValidCommands() {
        // Commands for basic version
        validCommands.put("help", new HELPoperator(this));
        validCommands.put("go", new GOoperator(this));
        validCommands.put("give", new GIVEoperator(this));
        validCommands.put("drop", new DROPoperator(this));
        validCommands.put("look", new LOOKoperator(this));
        validCommands.put("take", new TAKEoperator(this));
        validCommands.put("quit", new QUIToperator(this));
        
        if("multiplayer".equals(version)) {
            // ADD COMMANDS FOR MULTIPLAYER VERSION OF THE GAME
        }
    }
    

    /**
     * I've chosen to put this method here to avoid code duplication.
     * @return : all the possible exits
     */
    public String getExits() {
        String exits = "";
        if (currentRoom.northExit != null) { exits += "north "; }
        if (currentRoom.eastExit != null) { exits += "east "; }
        if (currentRoom.southExit != null) { exits += "south "; }
        if (currentRoom.westExit != null) { exits += "west "; }
        return exits;
    }
    
    /**
     * Print out the opening message for the player.
     */
    private String welcome() {
        return String.join("\n",
                "World of Zuul is a new, incredibly boring adventure game.", 
                "Type 'help' if you need help.", "\n",
                "You are " + currentRoom.getDescription()
                + ". \nExits: " + getExits()
                + "\nItems: " + getItems() + "\n");
    }
    
    private String getItems() {
        String items = "";
        if (currentRoom.itemDescription != null) {
            items = (currentRoom.itemDescription + '(' + currentRoom.itemWeight + ')');
        }
        return items;
    }

    /**
     *
     * @param msgs
     */
    public void write(String[] msgs) { outputMgr.write(msgs); }
    
    /**
     *
     * @param msgs
     */
    public void write(String msgs) { outputMgr.write(msgs); }
    
    /**
     *
     * @param newRoom
     */
    public void setCurrentRoom(Room newRoom) { currentRoom = newRoom; }
    
    /**
     *
     * @param aString
     * @return
     */
    public boolean isCommand(String aString) { return validCommands.containsKey(aString); }
    
    /**
     *
     * @return
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     *
     * @return
     */
    public int getTotalWeight() {return totalWeight; }
    
    /**
     *
     * @param newItem
     * @param w
     */
    public void addItem(String newItem, int w) {
        items.add(newItem);
        weights.add(w);
        totalWeight += w;
    }
    
    /**
     *
     * @return
     */
    public ArrayList getItemsList() { return items; }
    
    /**
     *
     * @return
     */
    public ArrayList getWeightsList() {return weights; }
    
    /**
     *
     * @param newItems
     */
    public void updateItemsList(ArrayList newItems) { items = newItems; }
    
    /**
     *
     * @param newWeights
     * @param newTotalWeight
     */
    public void updateWeights(ArrayList newWeights, int newTotalWeight) {
        weights = newWeights;
        totalWeight = newTotalWeight;
    } 
}
