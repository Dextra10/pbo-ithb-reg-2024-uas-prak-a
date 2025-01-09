package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    public LoginView() {
        // Membuat JFrame
        JFrame mainFrame = new JFrame("Login");
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
        // Logo
        ImageIcon originalIcon = new ImageIcon("./image/logo.png");
        Image originalImage = originalIcon.getImage(); 
        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(resizedImage); 

        JLabel logoLabel = new JLabel(resizedIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(logoLabel);


        // Judul 
        JLabel titleLabel = new JLabel("Pratama Express");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label Telp
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel telpLabel = new JLabel("Telp:");
        formPanel.add(telpLabel, gbc);

        // Field Telp
        gbc.gridx = 1;
        JTextField telpField = new JTextField(15);
        formPanel.add(telpField, gbc);

        // Label Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        formPanel.add(passwordLabel, gbc);

        // Field Password
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        formPanel.add(passwordField, gbc);

        // Tambahkan formPanel ke mainPanel
        mainPanel.add(formPanel);

        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));

        // Button Login
        JButton loginButton = new JButton("Login");
        buttonPanel.add(loginButton);

        // Button Back
        JButton backButton = new JButton("Back");
        buttonPanel.add(backButton);

        // Tambahkan buttonPanel ke mainPanel
        mainPanel.add(buttonPanel);

        // Action listener untuk tombol Login
        loginButton.addActionListener(e -> {
            String telp = telpField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (telp.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Nomor telepon dan password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LoginController loginController = new LoginController();
            boolean isValid = loginController.validateLogin(telp, password);

            if (isValid) {
                JOptionPane.showMessageDialog(mainFrame, "Login berhasil! Selamat datang!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                mainFrame.dispose();
                new HomeUserView(); 
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Nomor telepon atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener untuk tombol Back
        backButton.addActionListener(e -> {
            new MenuUtamaView(); // Navigasi ke menu utama
            mainFrame.dispose();
        });

        // Tambahkan mainPanel ke mainFrame
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
