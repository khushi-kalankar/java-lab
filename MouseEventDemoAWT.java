import java.awt.*;
import java.awt.event.*;

public class MouseEventDemoAWT extends Frame implements MouseListener {

    String message = "";

    public MouseEventDemoAWT() {
        // Set title and size
        setTitle("Mouse Event Demo");
        setSize(400, 300);

        // Add mouse listener to the frame
        addMouseListener(this);

        // Set layout and background color
        setLayout(new FlowLayout());
        setBackground(Color.LIGHT_GRAY);

        // Make frame invisible initially
        setVisible(false);
    }

    // Called when mouse is clicked
    public void mouseClicked(MouseEvent me) {
        message = "Mouse Clicked at (" + me.getX() + ", " + me.getY() + ")";
        repaint();
    }

    // Called when mouse enters the frame
    public void mouseEntered(MouseEvent me) {
        message = "Mouse Entered Frame";
        setVisible(true);  // Make frame visible
        repaint();
    }

    // Called when mouse exits the frame
    public void mouseExited(MouseEvent me) {
        message = "Mouse Exited Frame";
        repaint();
    }
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    // Paint method to display messages
    public void paint(Graphics g) {
        g.drawString(message, 100, 150);
    }
    // Main method to run the program
    public static void main(String[] args) {
        MouseEventDemoAWT frame = new MouseEventDemoAWT();
        frame.setVisible(true);
        // Initially not visible; will be shown when mouse enters it
    }
}
