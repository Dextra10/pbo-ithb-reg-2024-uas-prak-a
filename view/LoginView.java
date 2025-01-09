package view;

import controller.LoginController;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LoginView {
    public LoginView(){
        // Membuat JFrame
        JFrame mainFrame = new JFrame("Login");
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Judul
        JLabel titleLabel = new JLabel("Pratama Express", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Label telp
        JLabel telpLabel = new JLabel("Telp:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(telpLabel, gbc);

        // Field Email
        JTextField telpField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(telpField, gbc);

        // Label Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        // Field Password
        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        // Button Login
        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(loginButton, gbc);

        loginButton.addActionListener(e->{
            int telp = 0;
            String password = new String(passwordField.getPassword());
            LoginController loginController = new LoginController();
            boolean isValid = loginController.validateLogin(telp, password);
            if(isValid){
                new MenuUtamaView();
            }
            
        });
        

        JButton backMenu = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(backMenu, gbc);

        backMenu.addActionListener(e->{
            new MenuUtamaView();
            mainFrame.dispose();
        });

        mainFrame.add(panel);
        mainFrame.setVisible(true);

    }
}
