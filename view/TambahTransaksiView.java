package view;

import controller.TambahTransaksiController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TambahTransaksiView {
    public TambahTransaksiView() {
        // Membuat JFrame
        JFrame mainFrame = new JFrame("Tambah Transaksi");
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        
        TambahTransaksiController controller = new TambahTransaksiController();

        // Label dan Field untuk Nama Penerima
        JLabel nameLabel = new JLabel("Nama Penerima:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Label dan Field untuk Alamat Penerima
        JLabel addressLabel = new JLabel("Alamat Penerima:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(addressLabel, gbc);

        JTextField addressField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(addressField, gbc);

        // Label dan Field untuk Nomor Telepon Penerima
        JLabel phoneLabel = new JLabel("Nomor Telepon:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(phoneLabel, gbc);

        JTextField phoneField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        // Label dan Field untuk Berat Paket
        JLabel weightLabel = new JLabel("Berat Paket (Kg):");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(weightLabel, gbc);

        JTextField weightField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(weightField, gbc);

        // Label dan ComboBox untuk Tipe Paket
        JLabel typeLabel = new JLabel("Tipe Paket:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(typeLabel, gbc);

        JComboBox<String> packageTypeComboBox = new JComboBox<>();
        List<String> packageTypes = controller.getPackageTypes();
        for (String type : packageTypes) {
            packageTypeComboBox.addItem(type);
        }
        gbc.gridx = 1;
        panel.add(packageTypeComboBox, gbc);

        // Button Simpan
        JButton saveButton = new JButton("Simpan");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(saveButton, gbc);

        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String address = addressField.getText().trim();
            String phone = phoneField.getText().trim();
            String weightText = weightField.getText().trim();
            String packageType = (String) packageTypeComboBox.getSelectedItem();

            // Validasi input
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || weightText.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double weight;
            try {
                weight = Double.parseDouble(weightText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainFrame, "Berat paket harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (weight <= 0) {
                JOptionPane.showMessageDialog(mainFrame, "Berat paket tidak boleh nol atau negatif!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            weight = Math.ceil(weight * 2) / 2.0; 
            double cost = controller.calculateCost(weight, packageType);

            // Insert ke database
            if (controller.saveTransaction(name, address, phone, weight, packageType, cost)) {
                JOptionPane.showMessageDialog(mainFrame, "Transaksi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                mainFrame.dispose();
                new MenuUtamaView();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Gagal menyimpan transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Button Back
        JButton backButton = new JButton("Back");
        gbc.gridy = 6;
        panel.add(backButton, gbc);

        backButton.addActionListener(e -> {
            new MenuUtamaView();
            mainFrame.dispose();
        });

        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }
}
