import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class LoginPage extends JFrame implements ActionListener{

    JLabel headline = new JLabel("Login page");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("User ID");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    static Font font = new Font("Ink Free", Font.ITALIC, 18); // using this font in WelcomePage

    HashMap<String, String> loginInfo;

    LoginPage(HashMap<String, String> loginInfoOriginal){

        loginInfo = loginInfoOriginal; // making passed attribute available for the whole LoginPage class

        // setting headline
        headline.setBounds(125,25,300,50);
        headline.setFont(new Font("Ink Free", Font.BOLD, 30));

        // setting userID and password Labels
        userIDLabel.setBounds(50,125,75,25);
        userPasswordLabel.setBounds(50,175,75,25);

        // setting message Label
        messageLabel.setBounds(125,275,250,35);
        messageLabel.setFont(font);

        // setting UserID and password fields
        userIDField.setBounds(125,125,200,25);
        userPasswordField.setBounds(125,175,200,25);

        // setting login button
        loginButton.setBounds(125,225,100,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        // setting reset button
        resetButton.setBounds(225,225,100,25);
        resetButton.addActionListener(this);
        loginButton.setFocusable(false);

        this.add(headline);
        this.add(userIDLabel);
        this.add(userPasswordLabel);
        this.add(messageLabel);
        this.add(userIDField);
        this.add(userPasswordField);
        this.add(loginButton);
        this.add(resetButton);
        this.getRootPane().setDefaultButton(loginButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Reset button - reset ID, password and message fields
        if (e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        // login button functionality
        if (e.getSource()==loginButton) {
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            // checking if entered userID exists in the hashmap and if the password matches the key
            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(userPassword)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    new WelcomePage(userID); // creating an instance of Welcome page and passing userID as an attribute
                    this.dispose(); // closing current LoginPage
                } else {
                    messageLabel.setText("Incorrect password");
                    messageLabel.setForeground(Color.red);
                }
            } else {
                messageLabel.setText("Username not found");
                messageLabel.setForeground(Color.red);
            }
        }
    }
}
