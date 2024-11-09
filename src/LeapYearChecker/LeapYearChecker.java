
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JTextField yearTextField;
    private JButton checkYearButton;

    public LeapYearChecker() {
        setTitle("Leap Year Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        yearTextField = new JTextField();
        yearTextField.setBounds(50, 30, 200, 30);
        yearTextField.setName("yearTextField"); 

        checkYearButton = new JButton("Check Year");
        checkYearButton.setBounds(100, 70, 100, 30);
        checkYearButton.setName("checkYearButton"); 

        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLeapYear();
            }
        });

        add(yearTextField);
        add(checkYearButton);
    }

    private void checkLeapYear() {
        try {
            int year = Integer.parseInt(yearTextField.getText());
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

            String message = isLeapYear ? "Leap year" : "Not a leap year";

            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LeapYearChecker app = new LeapYearChecker();
            app.setVisible(true);
        });
    }
}
