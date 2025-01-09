package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUtamaView {
    public MenuUtamaView(){
        JFrame mainFrame = new JFrame("Menu Utama");
        mainFrame.setSize(700, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton login = new JButton("Login");
        login.addActionListener(e->{
            new LoginView();
            mainFrame.dispose();
        });

        JButton Registrasi = new JButton("Registrasi");
        Registrasi.addActionListener(e->{
            new RegisterView();
            mainFrame.dispose();

        });

        JButton Transaksi = new JButton("Tambah Transaksi");
        Transaksi.addActionListener(e->{

        });

        JButton History = new JButton("History");
        History.addActionListener(e->{

        });

        panel.add(login);
        panel.add(Registrasi);
        panel.add(Transaksi);
        panel.add(History);

        mainFrame.add(panel);
        mainFrame.setVisible(true);

    }

}
