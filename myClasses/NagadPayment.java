package myclasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import myinterface.ConfirmPayment;

public class NagadPayment extends JFrame implements ActionListener, ConfirmPayment {

  final JLabel bkash_lbl;
  final JTextField num_fld;
  final JButton back_btn;
  final JButton next_btn;
  final JPasswordField pass_fld;

  NagadPayment() {
    System.out.println("Currently in NagadPayment class");
    setTitle("Nagad Payment");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 903, 554);
    setLocationRelativeTo(null);
    getContentPane().setBackground(Color.GRAY);
    setResizable(false);

    ImageIcon img = new ImageIcon("./images/NagadPayment.png");
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
    String MobileNumber = num_fld.getText(); // Get the mobile number from the input field
    String Pin = String.valueOf(pass_fld.getPassword()); // Get the PIN from the password field

    if (ae.getSource() == back_btn) {
      // Navigate back to Payment page
      new Payment();
      this.setVisible(false);
      System.out.println("Exited from NagadPayment class");
    } else if (ae.getSource() == next_btn) {
      boolean isMobileNumberEmpty = MobileNumber.isEmpty(); // Check if the mobile number is empty
      boolean isPinEmpty = Pin.isEmpty(); // Check if the PIN is empty
      confirmPayment(
          isMobileNumberEmpty,
          isPinEmpty,
          this,
          num_fld,
          pass_fld); // Call the confirmPayment method with the provided parameters
    }
  }
}
