package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static gui.GraphicalUserInterface.startIntermediateTimer;

public class Intermediate extends JWindow implements ActionListener {
  JTextArea intermediateDisplay;

  /**
   * default Constructor.
   *
   */
  public Intermediate() {
    super();
    setupLayout();
  }



  /**
   * sets up the layout of the History window.
   *
   */
  private void setupLayout() {
    Container contentPane = getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

    JPanel intermediatePanel = new JPanel();

    intermediateDisplay = new JTextArea();
    intermediatePanel.setLayout(new GridLayout());
    intermediateDisplay.setEditable(false);



    JButton closeButton = new JButton(">");
    closeButton.addActionListener(this);


    intermediatePanel.add(intermediateDisplay);
    contentPane.add(closeButton);
    contentPane.add(intermediatePanel);
    contentPane.add(Box.createVerticalGlue());
  }

  public void updateIntermediate() {
    intermediateDisplay.setText("s");
  }


  @Override
  public void setVisible(boolean b)
  {
    super.setVisible(b);
    startIntermediateTimer();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    String ac = e.getActionCommand();

    if (ac != null)
    {
      if (ac.equals(">"))
      {
        for (int i = 0; i < 42; i++)
        {
          intermediateDisplay.setSize(getWidth() - 7, 280);
          setSize(getWidth() - 7, 280);
          setLocation(getX() + 7, getY());
          GraphicalUserInterface.setIntermediateButtonVisible();
          try {
            TimeUnit.MILLISECONDS.sleep(10);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
        setLocation(getX() - 28, getY());
        return;
      }
    }


    setSize(getWidth() + 7, 280);
    setLocation(getX() - 7, getY());

    if (getWidth() > 260)
    {
      GraphicalUserInterface.stopIntermediateTimer();
    }
  }
}
