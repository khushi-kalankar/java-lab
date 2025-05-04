import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentMarksGUI extends JFrame implements ActionListener {

    JTextField[] marksFields = new JTextField[5];
    JButton resultButton;

    public StudentMarksGUI() {
        setTitle("Student Marks Entry");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i = 0; i < 5; i++) {
            add(new JLabel("Subject " + (i + 1) + " Marks:"));
            marksFields[i] = new JTextField();
            add(marksFields[i]);
        }

        resultButton = new JButton("Show Result");
        resultButton.addActionListener(this);
        add(resultButton);

        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int total = 0;
            for (JTextField tf : marksFields) {
                int mark = Integer.parseInt(tf.getText());
                if (mark < 0 || mark > 100) {
                    throw new NumberFormatException("Invalid mark range");
                }
                total += mark;
            }

            int average = total / 5;
            String grade;

            if (average >= 90) grade = "A+";
            else if (average >= 80) grade = "A";
            else if (average >= 70) grade = "B";
            else if (average >= 60) grade = "C";
            else if (average >= 50) grade = "D";
            else grade = "Fail";

            showResultWindow(total, average, grade);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integer marks between 0 and 100.");
        }
    }
    private void showResultWindow(int total, int average, String grade) {
        JFrame resultFrame = new JFrame("Student Result");
        resultFrame.setSize(300, 200);
        resultFrame.setLayout(new GridLayout(4, 1));

        resultFrame.add(new JLabel("Total Marks: " + total));
        resultFrame.add(new JLabel("Average Marks: " + average));
        resultFrame.add(new JLabel("Grade: " + grade));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> resultFrame.dispose());
        resultFrame.add(closeButton);

        resultFrame.setLocationRelativeTo(this);
        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentMarksGUI();
    }
}
