import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.io.*;


public class GuiPacman extends Application
{
  private String outputBoard; // The filename for where to save the Board
  private Board board; // The Game Board

  // Fill colors to choose
  private static final Color COLOR_GAME_OVER = Color.rgb(238, 228, 218, 0.73);
  private static final Color COLOR_VALUE_LIGHT = Color.rgb(249, 246, 242);
  private static final Color COLOR_VALUE_DARK = Color.rgb(119, 110, 101);

  /** Add your own Instance Variables here */
  


  /* 
   * Name:      start
   * Purpose:   Start and keep the game running.
   * Parameter: 
   * Return:    
   */
  @Override
  public void start(Stage primaryStage)
  {
    // Process Arguments and Initialize the Game Board
    processArgs(getParameters().getRaw().toArray(new String[0]));

    /** Add your Code for the GUI Here */
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
    pane.setHgap(5.5);
    pane.setVgap(5.5);
    
    Scene scene = new Scene(pane);
    primaryStage.setTitle("PacMan");
    primaryStage.setScene(scene);
    primaryStage.show();


  }



  /** Add your own Instance Methods Here */

  /*
   * Name:       myKeyHandler
   *
   * Purpose:     
   *
   *
   */
  private class myKeyHandler implements EventHandler<KeyEvent> {

   /* 
    * Name:      handle
    * Purpose:   handle the KeyEvent of user's input.
    * Parameter: 
    * Return:    
    */
    @Override
    public void handle (KeyEvent e) {
      // TODO
    }


    /* 
     * Name:      gameIsOver
     * Purpose:   Check if the game is over and show the gameover board.
     * Parameter: 
     * Return:    
     */
    private void gameIsOver() {
      //TODO
    }
  } // End of Inner Class myKeyHandler.



  /*
   * Name:        Tile
   *
   * Purpose:     This class tile helps to make the tiles in the board 
   *              presented using JavaFX. Whenever a tile is needed,
   *              the constructor taking one char parameter is called
   *              and create certain ImageView fit to the char representation
   *              of the tile.
   * 
   *
   */
  private class Tile {

    private ImageView repr;   // This field is for the Rectangle of tile.
 
    /* 
     * Constructor
     *
     * Purpose:   
     * Parameter: 
     *
     */
    public Tile(char tileAppearance) {
      //TODO
    }


    public ImageView getNode() {
      //TODO
    	return null;
    }

  }  // End of Inner class Tile




  /** DO NOT EDIT BELOW */

  // The method used to process the command line arguments
  private void processArgs(String[] args)
  {
    String inputBoard = null;   // The filename for where to load the Board
    int boardSize = 0;          // The Size of the Board

    // Arguments must come in pairs
    if((args.length % 2) != 0)
    {
      printUsage();
      System.exit(-1);
    }

    // Process all the arguments 
    for(int i = 0; i < args.length; i += 2)
    {
      if(args[i].equals("-i"))
      {   // We are processing the argument that specifies
        // the input file to be used to set the board
        inputBoard = args[i + 1];
      }
      else if(args[i].equals("-o"))
      {   // We are processing the argument that specifies
        // the output file to be used to save the board
        outputBoard = args[i + 1];
      }
      else if(args[i].equals("-s"))
      {   // We are processing the argument that specifies
        // the size of the Board
        boardSize = Integer.parseInt(args[i + 1]);
      }
      else
      {   // Incorrect Argument 
        printUsage();
        System.exit(-1);
      }
    }

    // Set the default output file if none specified
    if(outputBoard == null)
      outputBoard = "Pac-Man.board";
    // Set the default Board size if none specified or less than 2
    if(boardSize < 3)
      boardSize = 10;

    // Initialize the Game Board
    try{
      if(inputBoard != null)
        board = new Board(inputBoard);
      else
        board = new Board(boardSize);
    }
    catch (Exception e)
    {
      System.out.println(e.getClass().getName() + " was thrown while creating a " +
          "Board from file " + inputBoard);
      System.out.println("Either your Board(String, Random) " +
          "Constructor is broken or the file isn't " +
          "formated correctly");
      System.exit(-1);
    }
  }

  // Print the Usage Message 
  private static void printUsage()
  {
    System.out.println("GuiPacman");
    System.out.println("Usage:  GuiPacman [-i|o file ...]");
    System.out.println();
    System.out.println("  Command line arguments come in pairs of the form: <command> <argument>");
    System.out.println();
    System.out.println("  -i [file]  -> Specifies a Pacman board that should be loaded");
    System.out.println();
    System.out.println("  -o [file]  -> Specifies a file that should be used to save the Pac-Man board");
    System.out.println("                If none specified then the default \"Pac-Man.board\" file will be used");
    System.out.println("  -s [size]  -> Specifies the size of the Pac-Man board if an input file hasn't been");
    System.out.println("                specified.  If both -s and -i are used, then the size of the board");
    System.out.println("                will be determined by the input file. The default size is 10.");
  }
}


