package Swing;

/**
 * @author nsush
 * @created 6/10/2025
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;

    public SwingApp() {
        // Set up the frame
        setTitle("Swing Greeting App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add label
        JLabel promptLabel = new JLabel("Enter your name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(promptLabel, gbc);

        // Add text field
        textField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(textField, gbc);

        // Add button
        JButton greetButton = new JButton("Greet Me");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(greetButton, gbc);

        // Add result label
        resultLabel = new JLabel(" ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(resultLabel, gbc);

        // Button action listener
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText().trim();
                if (name.isEmpty()) {
                    resultLabel.setText("Please enter a name!");
                } else {
                    resultLabel.setText("Hello, " + name + "!");
                }
            }
        });

        // Add panel to frame
        add(panel);
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingApp().setVisible(true);
            }
        });
    }
}

