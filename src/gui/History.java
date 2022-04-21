package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;


/**
 * should be components listener, and will be sepearate window/panel which will be adjacent to the main JFrame.
 *
 * @version 1.0
 * @author Chingiz
 */
public class History extends JWindow implements ActionListener {

  JTextArea historyDisplay;

  /**
   * default Constructor.
   *
   */
  public History()
  {
    super();

    setLayout();
  }

  /**
   * sets up the layout of the History window.
   *
   */
  private void setLayout()
  {
    Container contentPane = getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

    JPanel historyPanel = new JPanel();

    historyDisplay = new JTextArea();
    historyPanel.setLayout(new GridLayout());
    historyDisplay.setEditable(false);



    JButton closeButton = new JButton("<");
    closeButton.addActionListener(this);


    historyPanel.add(historyDisplay);
    contentPane.add(historyPanel);
    contentPane.add(closeButton);
    contentPane.add(Box.createVerticalGlue());

  }

  /**
   * Updates the text on the history window.
   *
   * @param text to be updated
   */
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
  public void actionPerformed(ActionEvent e)
  {
    String ac = e.getActionCommand();

    if (ac != null)
    {
      if (ac.equals("<"))
      {
        for (int i = 0; i < 42; i++)
        {
          GraphicalUserInterface.startTimer();
          historyDisplay.setSize(getWidth() - 7, 280);
          setSize(getWidth() - 7, 280);
          if (getWidth() == 0) {
            GraphicalUserInterface.stopTimer();
          }
          GraphicalUserInterface.setHistoryButtonVisible();
          try {
            TimeUnit.MILLISECONDS.sleep(10);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }

      }
    }

    System.out.println(getWidth());
    historyDisplay.setSize(getWidth()+1, 280);
    setSize(getWidth() + 7, 280);

    if (getWidth() > 260)
    {
      GraphicalUserInterface.stopTimer();
    }


  }
}



