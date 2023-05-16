package myInterface;

import myClasses.UDashBoard;

import javax.swing.*;
import javax.swing.text.*;

public interface ConfirmPayment {
    /**
     * Confirms the payment for a hotel stay.
     *
     * @param isMobileNumberEmpty  true if the mobile number is empty, false otherwise
     * @param isPinEmpty           true if the PIN is empty, false otherwise
     * @param paymentFrame         the JFrame object representing the payment frame
     * @param number               number represent the Number Field
     * @param password             password represent the Password Field
     */
    default void confirmPayment(boolean isMobileNumberEmpty, boolean isPinEmpty, JFrame paymentFrame, JTextField number, JPasswordField password) {
        if (isMobileNumberEmpty) {
            JOptionPane.showMessageDialog(null, "Invalid Phone number ");
        } else {
            if (isPinEmpty) {
                JOptionPane.showMessageDialog(null, "Invalid  Pin");
            } else {
                if (inputValidation(number, password) && inputLength(number, password)) {
                    JOptionPane.showMessageDialog(null, "Payment Confirmed\nThank You For Staying At Tipton");
                    new UDashBoard();
                    paymentFrame.setVisible(false);
                }
            }
        }
    }
    //Check if the input consist any character in number and password field
    default boolean inputValidation(JTextField number, JPasswordField password) {

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
        if(n == false && p == false){
            JOptionPane.showMessageDialog(null, "Phone number and Pin number cannot contain character", "Input error", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(n == false){
            JOptionPane.showMessageDialog(null, "Phone Number cannot contain character", "Phone number error", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(p == false){
            JOptionPane.showMessageDialog(null, "Pin number cannot contain character", "Pin number error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    //Check if the phonenumber length is 11 and password length is 4
    default boolean inputLength(JTextField number, JPasswordField password) {
        String numberText = number.getText();
        String passText = String.valueOf(password.getPassword());

        if (numberText.length() != 11 && passText.length() != 4) {
            JOptionPane.showMessageDialog(null, "Phone number must contain exactly 11 digits and PIN number must contain exactly 4 digits", "Length error", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (numberText.length() != 11) {
            JOptionPane.showMessageDialog(null, "Phone number must contain exactly 11 digits", "Length error", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (passText.length() != 4) {
            JOptionPane.showMessageDialog(null, "PIN number must contain exactly 4 digits", "Length error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }


}
