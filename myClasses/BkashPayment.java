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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import myinterface.ConfirmPayment;

/**
 * The BkashPayment class represents a JFrame window for Bkash payment functionality. It implements
 * the ActionListener interface and uses the ConfirmPayment interface for confirming payments.
 */
public class BkashPayment extends JFrame implements ActionListener, ConfirmPayment {

  final JLabel bkash_lbl; // Label to display Bkash logo
  final JTextField num_fld; // Text field for entering the mobile number
  final JButton back_btn; // Button for navigating back
  final JButton next_btn; // Button for proceeding to the next step
  final JPasswordField pass_fld; // Password field for entering the PIN

  /**
   * The constructor of the BkashPayment class. It initializes the JFrame and adds components to it.
   */
  BkashPayment() {
    System.out.println("Currently in BkashPayment class");
    // Set JFrame properties
    setTitle("Bkash Payment");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 903, 554);
    setLocationRelativeTo(null);
    setResizable(false);
    getContentPane().setBackground(Color.GRAY);
    setResizable(false);

    // Load and display Bkash logo
    ImageIcon img = new ImageIcon("./images/BkashPayment.png");
    Image i = img.getImage();
    Image new_img = i.getScaledInstance(854, 580, Image.SCALE_SMOOTH);
    img = new ImageIcon(new_img);
    bkash_lbl = new JLabel("", img, JLabel.CENTER);
    bkash_lbl.setBounds(-190, -220, 854, 580);

    // Create and position text field for entering mobile number
    num_fld = new JTextField();
    num_fld.setBounds(260, 250, 300, 25);
    this.add(num_fld);

    // Create and position password field for entering PIN
    pass_fld = new JPasswordField();
    pass_fld.setBounds(260, 380, 300, 25);
    this.add(pass_fld);

    // Add Bkash logo label to the JFrame
    this.add(bkash_lbl);

    // Create and position back button
    back_btn = new JButton("Back");
    back_btn.setFont(new Font("Abadi", Font.BOLD, 15));
    back_btn.setBackground(Color.BLACK);
    back_btn.setForeground(Color.WHITE);
    back_btn.setBounds(720, 460, 80, 25);
    back_btn.addActionListener(this);
    this.add(back_btn);

    // Create and position next button
    next_btn = new JButton("Next");
    next_btn.setFont(new Font("Abadi", Font.BOLD, 15));
    next_btn.setBackground(Color.BLACK);
    next_btn.setForeground(Color.WHITE);
    next_btn.setBounds(620, 460, 80, 25);
    next_btn.addActionListener(this);
    this.add(next_btn);

    // Add Bkash logo label to the JFrame
    this.add(bkash_lbl);

    // Set the JFrame visible
    setVisible(true);
  }

  /**
   * This method is invoked when an action is performed on a component. It handles the button clicks
   * for the back and next buttons.
   *
   * @param ae The ActionEvent that occurred.
   */
  public void actionPerformed(ActionEvent ae) {
    // Get input values
    String MobileNumber = num_fld.getText();
    String Pin = String.valueOf(pass_fld.getPassword());

    if (ae.getSource() == back_btn) {
      // Navigate back to Payment page
      new Payment();
      this.setVisible(false);
      System.out.println("Exited from BkashPayment class");
    } else if (ae.getSource() == next_btn) {
      // Check if MobileNumber and Pin are empty
      boolean isMobileNumberEmpty = MobileNumber.isEmpty();
      boolean isPinEmpty = Pin.isEmpty();
      // Call confirmPayment method with input values and current instance
      confirmPayment(isMobileNumberEmpty, isPinEmpty, this, num_fld, pass_fld);
    }
  }

  /**
   * This method confirms the payment for a hotel stay. It is implemented from the ConfirmPayment
   * interface.
   *
   * @param isMobileNumberEmpty true if the mobile number is empty, false otherwise
   * @param isPinEmpty true if the PIN is empty, false otherwise
   * @param paymentFrame the JFrame object representing the payment frame
   * @param number the number field representing the mobile number
   * @param password the password field representing the PIN
   */
  @Override
  public void confirmPayment(
      boolean isMobileNumberEmpty,
      boolean isPinEmpty,
      JFrame paymentFrame,
      JTextField number,
      JPasswordField password) {
    System.out.println("confirmPayment function called");
    if (isMobileNumberEmpty) {
      JOptionPane.showMessageDialog(null, "Invalid Phone number ");
      System.out.println("Number field is empty");
    } else {
      if (isPinEmpty) {
        JOptionPane.showMessageDialog(null, "Invalid  Pin");
        System.out.println("Pin number is invalid");
      } else {
        if (inputValidation(number, password) && inputLength(number, password)) {
          JOptionPane.showMessageDialog(null, "Payment Confirmed\nThank You For Staying At Tipton");
          System.out.println("Payment Done Successfully");
          new UDashBoard();
          paymentFrame.setVisible(false);
          System.out.println("Exited from BkashPayment class");
        }
      }
    }
    System.out.println("confirmPayment funtion executed successfully");
  }

  /**
   * This method validates if the input values in the number and password fields consist only of
   * digits. It is implemented from the ConfirmPayment interface.
   *
   * @param number the number field representing the mobile number
   * @param password the password field representing the PIN
   * @return true if the input values consist only of digits, false otherwise
   */
  @Override
  public boolean inputValidation(JTextField number, JPasswordField password) {
    System.out.println("inputValidation funtion called");
    boolean n = true;
    boolean p = true;
    String numberText = number.getText();
    for (int i = 0; i < numberText.length(); i++) {
      char c = numberText.charAt(i);
      if (!Character.isDigit(c)) {
        n = false;
        break;
      }
    }

    String passText = String.valueOf(password.getPassword());
    for (int i = 0; i < passText.length(); i++) {
      char c = passText.charAt(i);
      if (!Character.isDigit(c)) {
        p = false;
        break;
      }
    }
    if (!n && !p) {
      JOptionPane.showMessageDialog(
          null,
          "Phone number and Pin number cannot contain characters",
          "Input error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (!n) {
      JOptionPane.showMessageDialog(
          null,
          "Phone Number cannot contain characters",
          "Phone number error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (!p) {
      JOptionPane.showMessageDialog(
          null,
          "Pin number cannot contain characters",
          "Pin number error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }
    System.out.println("inputValtidation funtion executed successfully");
    return true;
  }

  /**
   * This method checks the length of the input values in the number and password fields. It is
   * implemented from the ConfirmPayment interface.
   *
   * @param number the number field representing the mobile number
   * @param password the password field representing the PIN
   * @return true if the length of the input values is valid, false otherwise
   */
  @Override
  public boolean inputLength(JTextField number, JPasswordField password) {
    System.out.println("inputLength funtion called");
    String numberText = number.getText();
    String passText = String.valueOf(password.getPassword());

    if (numberText.length() != 11 && passText.length() != 4) {
      JOptionPane.showMessageDialog(
          null,
          "Phone number must contain exactly 11 digits and PIN number must contain exactly 4"
              + " digits",
          "Length error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (numberText.length() != 11) {
      JOptionPane.showMessageDialog(
          null,
          "Phone number must contain exactly 11 digits",
          "Length error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    } else if (passText.length() != 4) {
      JOptionPane.showMessageDialog(
          null,
          "PIN number must contain exactly 4 digits",
          "Length error",
          JOptionPane.WARNING_MESSAGE);
      return false;
    }

    System.out.println("inputLength funtion executed successfully");
    return true;
  }
}
