package gui;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static gui.GraphicalUserInterface.startHistoryTimer;

/**
 * should be components listener, and will be sepearate window/panel which will be adjacent to the
 * main JFrame.
 *
 * @version 1.0
 * @author Chingiz
 */
public class History extends JWindow implements ActionListener
{

  JTextPane historyDisplay;
  Clipboard clipboard;
  Action[] textActions = {new DefaultEditorKit.CopyAction(), new DefaultEditorKit.PasteAction(),};
  // new DefaultEditorKit.CopyAction()
  // new DefaultEditorKit.PasteAction()

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

    historyDisplay = new JTextPane();
    historyPanel.setLayout(new GridLayout());
    historyDisplay.setEditable(false);

    // Action copy = historyDisplay.getActionMap().get("copy");

    JButton closeButton = new JButton("<");

    // JButton copyButton = new JButton(textActions[0]);
    // copyButton.addActionListener(this);
     closeButton.addActionListener(this);

    historyPanel.add(historyDisplay);
    // contentPane.add( copy);
    contentPane.add(historyPanel);
    contentPane.add(closeButton);
    // contentPane.add(copyButton);
    contentPane.add(Box.createVerticalGlue());

  }

  /**
   * Updates the text on the history window.
   *
   * @param text
   *          to be updated
   */
  public void updateText(String text)
  {
    historyDisplay.setText(historyDisplay.getText() + "\n" + text);

  }

  public void reset()
  {
    historyDisplay.setText("");
  }

  @Override
  public void setVisible(boolean b)
  {
    super.setVisible(b);
    startHistoryTimer();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    // String text = historyDisplay.getText();
    // historyDisplay.selectAll();
    // historyDisplay.setCaretPosition(historyDisplay.getDocument().getLength());
    String ac = e.getActionCommand();

    if (ac != null)
    {
      if (ac.equals("<"))
      {
        for (int i = 0; i < 42; i++)
        {
          historyDisplay.setSize(getWidth() - 7, 280);
          setSize(getWidth() - 7, 280);
          GraphicalUserInterface.setHistoryButtonVisible();
          try
          {
            TimeUnit.MILLISECONDS.sleep(10);
          }
          catch (InterruptedException ex)
          {
            ex.printStackTrace();
          }
        }
        setSize(getWidth() - 7, 280);
        return;
      }

    }


    historyDisplay.setSize(getWidth() + 1, 280);
    setSize(getWidth() + 7, 280);

    if (getWidth() > 260)
    {
      GraphicalUserInterface.stopHistoryTimer();
    }

  }
}
