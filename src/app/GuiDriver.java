package app;

import java.awt.EventQueue;

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

  public static void main(final String[] args) throws NumberFormatException
  {
    new GraphicalUserInterface();
  }

}
