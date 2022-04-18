package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * should be components listener, and will be sepearate window/panel which will be adjacent to the main JFrame.
 *
 */
public class History extends JWindow implements ActionListener {

  JTextArea historyDisplay;

  public History()
  {
    super();

    setLayout();
  }

  private void setLayout()
  {
    Container contentPane = getContentPane();

    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

    JPanel historyPanel = new JPanel();

    historyDisplay = new JTextArea();
    historyPanel.setLayout(new GridLayout());


    historyDisplay.setEditable(false);

    historyDisplay.setSize(160, 100);


    JButton closeButton = new JButton("<");
    closeButton.addActionListener(this);


    historyPanel.add(historyDisplay);
    contentPane.add(historyPanel);
    contentPane.add(closeButton);
    setSize(200, 280);
    contentPane.add(Box.createVerticalGlue());

  }

  public void updateText(String text)
  {
    historyDisplay.setText(historyDisplay.getText() + "\n" + text);
    System.out.println(historyDisplay.getText());
  }


  public void reset()
  {
    historyDisplay.setText("");
  }

  @Override
  public void setVisible(boolean b)
  {
    super.setVisible(b);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    String ac = e.getActionCommand();

    if (ac.equals("<"))
    {
      setVisible(false);
    }
  }
}



