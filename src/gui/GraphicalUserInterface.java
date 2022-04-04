package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

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

    JFrame frame = new JFrame("UnitED");
    JPanel contentPane = (JPanel)frame.getContentPane();
    contentPane.setLayout(new GridLayout(3,1));
    
    
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BorderLayout());
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    
    contentPane.add(displayPanel);
    contentPane.add(inputPanel);
    contentPane.add(buttonPanel);
    
    JTextField display = new JTextField();
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.CENTER);

    JTextField input = new JTextField();
    display.setSize(500, 50);

    JButton reset = new JButton("R");
    
    JButton clear = new JButton("C");
    
    JButton plus = new JButton("+");
    
    JButton minus = new JButton("-");
    
    JButton multiply = new JButton("x");
    
    JButton divide = new JButton("\u00F7");
    
    JButton equals = new JButton("=");
    
    displayPanel.add(display, BorderLayout.CENTER);
    inputPanel.add(input, BorderLayout.CENTER);
    
    buttonPanel.add(reset);
    buttonPanel.add(clear);
    buttonPanel.add(plus);
    buttonPanel.add(minus);
    buttonPanel.add(multiply);
    buttonPanel.add(divide);
    buttonPanel.add(equals);


    frame.setSize(550, 250);
    frame.setVisible(true);
  }

}
