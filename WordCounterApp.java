import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a label for the text area
        JLabel userLabel = new JLabel("Enter paragraph:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        // Create a text area for paragraph input
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setBounds(10, 50, 360, 150);
        panel.add(textArea);

        // Create a button to count words
        JButton countButton = new JButton("Count Words");
        countButton.setBounds(10, 210, 150, 25);
        panel.add(countButton);

        // Create a label to display the result
        JLabel resultLabel = new JLabel("Number of words:");
        resultLabel.setBounds(180, 210, 200, 25);
        panel.add(resultLabel);

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Number of words: " + wordCount);
            }
        });
    }

    private static int countWords(String text) {
        // Split the text by whitespace and count the number of tokens
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
}