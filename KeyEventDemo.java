import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
  <applet code="KeyEventDemo" width=400 height=200>
  </applet>
*/

public class KeyEventDemo extends Applet implements KeyListener {
    String message = "";
    int x = 20, y = 60;

    public void init() {
        addKeyListener(this);   // Register KeyListener
        requestFocus();         // Applet should get keyboard focus
    }

    public void keyPressed(KeyEvent ke) {
        message = "Key Pressed: " + ke.getKeyChar();
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
        message = "Key Released: " + ke.getKeyChar();
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
        message = "Key Typed: " + ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(message, x, y);
    }
}
