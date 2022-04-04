package gui;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Makenzie Williams
 * @version 1
 *
 */
public class GraphicalUserInterface implements ActionListener
{

  public GraphicalUserInterface()
  {
    setLayout();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // TODO Auto-generated method stub

  }

  private void setLayout()
  {

    // creation of frame and content pane
    JFrame frame = new JFrame("UnitED");
    JPanel contentPane = (JPanel)frame.getContentPane();
    contentPane.setLayout(new GridLayout(3,1));
    
    // creation of panels
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BorderLayout());
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    
    // adding panels to content frame
    contentPane.add(displayPanel);
    contentPane.add(inputPanel);
    contentPane.add(buttonPanel);
    
    // creation of display text field
    JTextField display = new JTextField();
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.CENTER);

    // creation of input text field
    JTextField input = new JTextField();
    display.setSize(500, 50);
    
    // creation of all buttons
    JButton reset = new JButton("R");
    JButton clear = new JButton("C");
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton multiply = new JButton("x");
    JButton divide = new JButton("\u00F7");
    JButton equals = new JButton("=");
    
    // adding display and input to respective panels
    displayPanel.add(display, BorderLayout.CENTER);
    inputPanel.add(input, BorderLayout.CENTER);
    
    // adding buttons to button panel
    buttonPanel.add(reset);
    buttonPanel.add(clear);
    buttonPanel.add(plus);
    buttonPanel.add(minus);
    buttonPanel.add(multiply);
    buttonPanel.add(divide);
    buttonPanel.add(equals);
    
    // setting frame
    frame.setSize(550, 250);
    frame.setVisible(true);
  }
  
  /**
   * Clears both input and display field.
   */
  private void reset() {
    
  }
  
  /**
   * Clears input field.
   */
  private void clear() {
   
  }

}