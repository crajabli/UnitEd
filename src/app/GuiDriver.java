package app;

import javax.swing.JFrame;

import gui.GraphicalUserInterface;

/**
 * An calculator application which supports units of measure but not fractions.
 * 
 * @author Makenzie Williams
 *
 */
public class GuiDriver
{

  private JFrame frame; 

  /**
   * Runs GraphicalUserInterface class.
   * @param args
   * @throws NumberFormatException
   */
  public static void main(final String[] args) throws NumberFormatException
  {
    new GraphicalUserInterface();
  }

}
