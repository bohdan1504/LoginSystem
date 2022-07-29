import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {

    JLabel message = new JLabel("");
    JButton goBackButton = new JButton("Go back");

    WelcomePage(String userID){

        // message label
        message.setText("Welcome " + userID + "!");
        message.setFont(LoginPage.font);

        // Go Back button - returns to LoginPage
        goBackButton.addActionListener(this);
        goBackButton.setFocusable(false);

        this.add(message);
        this.add(goBackButton);
        this.getRootPane().setDefaultButton(goBackButton);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==goBackButton){
            this.dispose();
            IDandPasswords idandPasswords = new IDandPasswords();
            new LoginPage(idandPasswords.getLoginInfo());
        }
    }
}
