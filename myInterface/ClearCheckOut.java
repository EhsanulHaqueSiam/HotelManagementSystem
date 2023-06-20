package myInterface;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface ClearCheckOut {

  /**
   * Clears the check-out fields and resets the table model.
   *
   * @param custName_fld JTextField for customer name
   * @param custNum_fld JTextField for customer number
   * @param checkInDate_fld JTextField for check-in date
   * @param pricePerDay_fld JTextField for price per day
   * @param dayStay_fld JTextField for number of days stayed
   * @param totalAmount_fld JTextField for total amount
   * @param email_fld JTextField for customer email
   * @param roomNum_fld JComboBox for room number
   * @param table JTable for displaying data
   */
  static void ClearCheckoutField(
      JTextField custName_fld,
      JTextField custNum_fld,
      JTextField checkInDate_fld,
      JTextField pricePerDay_fld,
      JTextField dayStay_fld,
      JTextField totalAmount_fld,
      JTextField email_fld,
      JComboBox<String> roomNum_fld,
      JTable table) {
    System.out.println("ClearCheckoutField funtion called");
    custName_fld.setText(null);
    custNum_fld.setText(null);
    checkInDate_fld.setText(null);
    pricePerDay_fld.setText(null);
    dayStay_fld.setText(null);
    totalAmount_fld.setText(null);
    email_fld.setText(null);
    roomNum_fld.setSelectedIndex(-1);

    table.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {
              "Name",
              "Mobile Number",
              "Nationality",
              "Gender",
              "Email",
              "Address",
              "Check In Data",
              "Room Number",
              "Bed",
              "Room Type",
              "Price Per Day"
            }));
    System.out.println("ClearCheckoutField funtion executed successfully");
  }
}
