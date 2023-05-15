package myClasses;

import myInterface.ConfirmPayment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BkashPayment extends JFrame implements ActionListener, ConfirmPayment {
    final JLabel bkash_lbl;
    final JTextField num_fld;
    final JButton back_btn;
    final JButton next_btn;
    final JPasswordField pass_fld;

    BkashPayment() {

        setTitle("Bkash Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 554);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);
        setResizable(false);


        ImageIcon img = new ImageIcon("./images/BkashPayment.png");
        Image i = img.getImage();
        Image new_img = i.getScaledInstance(854, 580, Image.SCALE_SMOOTH);
        img = new ImageIcon(new_img);
        bkash_lbl = new JLabel("", img, JLabel.CENTER);
        bkash_lbl.setBounds(-190, -220, 854, 580);

        num_fld = new JTextField();
        num_fld.setBounds(260, 250, 300, 25);
        this.add(num_fld);
        pass_fld = new JPasswordField();
        pass_fld.setBounds(260, 380, 300, 25);
        this.add(pass_fld);


        this.add(bkash_lbl);

        back_btn = new JButton("Back");
        back_btn.setFont(new Font("Abadi", Font.BOLD, 15));
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.white);
        back_btn.setBounds(720, 460, 80, 25);
        back_btn.addActionListener(this);
        this.add(back_btn);

        next_btn = new JButton("Next");
        next_btn.setFont(new Font("Abadi", Font.BOLD, 15));
        next_btn.setBackground(Color.BLACK);
        next_btn.setForeground(Color.white);
        next_btn.setBounds(620, 460, 80, 25);
        next_btn.addActionListener(this);
        this.add(next_btn);


        this.add(bkash_lbl);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Get input values
        String MobileNumber = num_fld.getText();
        String Pin = String.valueOf(pass_fld.getPassword());

        if (ae.getSource() == back_btn) {
            // Navigate back to Payment page
            new Payment();
            this.setVisible(false);
        } else if (ae.getSource() == next_btn) {
            // Check if MobileNumber and Pin are empty
            boolean isMobileNumberEmpty = MobileNumber.isEmpty();
            boolean isPinEmpty = Pin.isEmpty();
            // Call confirmPayment method with input values and current instance
            confirmPayment(isMobileNumberEmpty, isPinEmpty, this);
        }
    }

}
