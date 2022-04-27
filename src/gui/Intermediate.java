package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Intermediate extends JWindow implements ActionListener {
  JTextArea intermediateDisplay;

  /**
   * default Constructor.
   *
   */
  public Intermediate() {
    super();
  }



  /**
   * sets up the layout of the History window.
   *
   */
  private void setupLayout() {
    Container contentPane = getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

    JPanel historyPanel = new JPanel();

    intermediateDisplay = new JTextArea();
    historyPanel.setLayout(new GridLayout());
    intermediateDisplay.setEditable(false);



    JButton closeButton = new JButton("<");
    closeButton.addActionListener(this);


    historyPanel.add(intermediateDisplay);
    contentPane.add(historyPanel);
    contentPane.add(closeButton);
    contentPane.add(Box.createVerticalGlue());
  }


  @Override
  public void setVisible(boolean b)
  {
    super.setVisible(b);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    String ac = e.getActionCommand();

    if (ac != null)
    {
      if (ac.equals("<"))
      {
        for (int i = 0; i < 42; i++)
        {
          GraphicalUserInterface.startTimer();
          intermediateDisplay.setSize(getWidth() - 7, 280);
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
    intermediateDisplay.setSize(getWidth()+1, 280);
    setSize(getWidth() + 7, 280);

    if (getWidth() > 260)
    {
      GraphicalUserInterface.stopTimer();
    }
  }
}
