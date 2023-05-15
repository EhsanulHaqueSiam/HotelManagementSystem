package myInterface;

import myClasses.UDashBoard;

import javax.swing.*;

public interface ConfirmPayment {
    /**
     * Confirms the payment for a hotel stay.
     *
     * @param isMobileNumberEmpty  true if the mobile number is empty, false otherwise
     * @param isPinEmpty           true if the PIN is empty, false otherwise
     * @param paymentFrame         the JFrame object representing the payment frame
     */
    default void confirmPayment(boolean isMobileNumberEmpty, boolean isPinEmpty, JFrame paymentFrame) {
        if (isMobileNumberEmpty) {
            JOptionPane.showMessageDialog(null, "Invalid Phone number ");
        } else {
            if (isPinEmpty) {
                JOptionPane.showMessageDialog(null, "Invalid  Pin");
            } else {
                JOptionPane.showMessageDialog(null, "Payment Confirmed\nThank you For Staying At Tipton");
                new UDashBoard();
                paymentFrame.setVisible(false);
            }
        }
    }
}
