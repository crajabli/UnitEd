package gui;

import javax.swing.*;
import java.awt.*;

/**
 * should be components listener, and will be sepearate window/panel which will be adjacent to the main JFrame.
 *
 */
public class History extends JWindow {

  public History() {
    super();
    setSize(150, 280);
    setVisible(true);
  }





  /*public static void main(String[] args)
  {
    Container contentPane;
    JButton        cancelButton, okButton;
    JFrame         frame;
    JLabel         titleLabel;
    JTextArea      messageArea;
    JToolBar     toolBar;

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());

    titleLabel = new JLabel();
    titleLabel.setText("A Button Example");
    contentPane.add(titleLabel, BorderLayout.NORTH);

    messageArea = new JTextArea(40,20);
    contentPane.add(messageArea, BorderLayout.CENTER);

    // This is new
    toolBar = new JToolBar();

    okButton = new JButton("OK");
    // This is new
    toolBar.add(okButton);

    cancelButton = new JButton("Cancel");
    // This is new
    toolBar.add(cancelButton);

    // This is new
    contentPane.add(toolBar, BorderLayout.SOUTH);

    frame.setSize(400,400);
    frame.setVisible(true);
  }*/
}



