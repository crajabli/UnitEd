package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * should be components listener, and will be sepearate window/panel which will be adjacent to the main JFrame.
 *
 */
public class History extends JWindow  {



  public History() {
    super();
    setSize(150, 280);

  }

  @Override
  public void setVisible(boolean b) {
    super.setVisible(b);
  }


}



