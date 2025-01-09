package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView {
    public RegisterView(){
        JFrame mainFrame = new JFrame("Register");
        mainFrame.setSize(500, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6); 

        // Judul
        JLabel titleLabel = new JLabel("Register", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Label Name
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(nameLabel, gbc);

        // Field Name
        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nameField, gbc);

        // Label Telp
        JLabel telpLabel = new JLabel("Telp:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(telpLabel, gbc);

        // Field telp
        JTextField telpField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(telpField, gbc);
        
        // Label Alamat
        JLabel alamatLabel = new JLabel("Alamat:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(alamatLabel, gbc);

        // Field alamat
        JTextField alamatField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(alamatField, gbc);

        // Label Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        // Field Password
        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        // Tombol Register
        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(registerButton, gbc);

        JButton backMenu = new JButton("Back");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(backMenu, gbc);

        backMenu.addActionListener(e->{
            new MenuUtamaView();
            mainFrame.dispose();
        });

        registerButton.addActionListener(e->{
            String name = nameField.getText().trim();
            //int telp = telpField.get
            String alamat = alamatField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
    
            if (name.isEmpty() || telp.isEmpty() || alamat.isEmpty()|| password.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Semua field wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            RegisterController controller = new RegisterController();
            boolean isRegistered = controller.registerUser(name, telp,alamat, password);
    
            if (isRegistered) {
                JOptionPane.showMessageDialog(mainFrame, "Registrasi berhasil! Silakan login.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                mainFrame.dispose(); 
                new LoginView(); 
            }

        });
        
        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }
}
