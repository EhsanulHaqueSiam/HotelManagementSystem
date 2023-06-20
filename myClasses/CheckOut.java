package myClasses;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import myInterface.ClearCheckOut;

public class CheckOut extends JFrame
    implements ActionListener,
        myInterface.ClearCheckOut,
        myInterface.CustomerDataEntry,
        myInterface.CheckOutRoomSearch {

  private final JTable table;
  private final JTextField CustomerName_fld;
  private final JTextField CustomerNum_fld;
  private final JTextField checkInDate_fld;
  private final JTextField pricePerDay_fld;
  private final JTextField dayStay_fld;
  private final JTextField totalAmount_fld;
  private final JTextField email_fld;
  private final JComboBox<String>
      search_combo; // Creates a combo box that can only accept Strings as items for search options
  private final JButton logOut_btn;
  private final JButton back_btn;
  private final JButton checkOut_btn;
  private final JButton clear_btn;
  // private final JButton search_btn;
  String name;
  String mobileNumber;
  String nationality;
  String gmail;
  String address;
  String CheckinDate;
  String gender;
  String roomNo_B;
  String roomType;
  String bed;
  String roomPrice;
  String roomNumToDelete;

  public CheckOut() {
    System.out.println("Currently in CheckOut class");
    setResizable(false);
    setTitle("Admin checkout");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 927, 533);
    setLocationRelativeTo(null);
    JPanel contentPane = new JPanel();
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    logOut_btn = new JButton("Log Out");
    logOut_btn.setBounds(812, 11, 89, 23);
    logOut_btn.setFocusable(false);
    contentPane.add(logOut_btn);

    JLabel checkOut_lbl = new JLabel("CheckOut");
    checkOut_lbl.setForeground(Color.LIGHT_GRAY);
    checkOut_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    checkOut_lbl.setBounds(10, 3, 180, 34);
    contentPane.add(checkOut_lbl);

    back_btn = new JButton("Back");
    back_btn.setBounds(702, 11, 89, 23);
    back_btn.setFocusable(false);
    contentPane.add(back_btn);

    JLabel customerNameLbl = new JLabel("Customer Name");
    customerNameLbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    customerNameLbl.setForeground(Color.WHITE);
    customerNameLbl.setBounds(21, 80, 150, 23);
    contentPane.add(customerNameLbl);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 318, 891, 139);
    contentPane.add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);
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
    table.setEnabled(false);
    table.getTableHeader().setReorderingAllowed(false);
    table.getColumnModel().getColumn(0).setPreferredWidth(80);
    table.getColumnModel().getColumn(1).setPreferredWidth(82);

    // Set custom background colors for alternate rows
    table.setDefaultRenderer(
        Object.class,
        new DefaultTableCellRenderer() {
          @Override
          public Component getTableCellRendererComponent(
              JTable table,
              Object value,
              boolean isSelected,
              boolean hasFocus,
              int row,
              int column) {
            Component component =
                super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
            if (row % 2 == 0) {
              component.setBackground(new Color(230, 230, 230)); // Light gray for even rows
            } else {
              component.setBackground(Color.WHITE); // White for odd rows
            }
            return component;
          }
        });

    // Customize table header names
    JTableHeader header = table.getTableHeader();
    header.setBackground(new Color(150, 150, 150)); // Dark gray for header background
    header.setForeground(Color.WHITE); // White text color for header
    Font headerFont = header.getFont();
    header.setFont(headerFont.deriveFont(Font.BOLD)); // Make the font bold

    JLabel checkInDate_lbl = new JLabel("Check In Date");
    checkInDate_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    checkInDate_lbl.setForeground(Color.WHITE);
    checkInDate_lbl.setBounds(251, 80, 97, 23);
    contentPane.add(checkInDate_lbl);

    JLabel checkOutDate_lbl = new JLabel("Check Out (Today)");
    checkOutDate_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    checkOutDate_lbl.setForeground(Color.WHITE);
    checkOutDate_lbl.setBounds(479, 80, 150, 23);
    contentPane.add(checkOutDate_lbl);

    JLabel customerNumberLbl = new JLabel("Customer Mobile Number");
    customerNumberLbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    customerNumberLbl.setForeground(Color.WHITE);
    customerNumberLbl.setBounds(702, 78, 180, 26);
    contentPane.add(customerNumberLbl);

    CustomerName_fld = new JTextField();
    CustomerName_fld.setBounds(21, 113, 151, 20);
    CustomerName_fld.setEditable(false);
    contentPane.add(CustomerName_fld);
    CustomerName_fld.setColumns(10);

    CustomerNum_fld = new JTextField();
    CustomerNum_fld.setColumns(10);
    CustomerNum_fld.setEditable(false);
    CustomerNum_fld.setBounds(702, 113, 160, 20);
    contentPane.add(CustomerNum_fld);

    checkOut_btn = new JButton("Check Out");
    checkOut_btn.setBounds(25, 284, 97, 23);
    checkOut_btn.setFocusable(false);
    contentPane.add(checkOut_btn);

    checkInDate_fld = new JTextField();
    checkInDate_fld.setColumns(10);
    checkInDate_fld.setEditable(false);
    checkInDate_fld.setBounds(251, 114, 151, 20);
    contentPane.add(checkInDate_fld);

    JTextField checkOut_fld = new JTextField();
    checkOut_fld.setColumns(10);
    checkOut_fld.setEditable(false);
    checkOut_fld.setBounds(479, 113, 151, 20);

    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar cal = Calendar.getInstance();

    checkOut_fld.setText(myFormat.format(cal.getTime()));
    contentPane.add(checkOut_fld);

    JLabel priceDay_lbl = new JLabel("Price Per Day");
    priceDay_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    priceDay_lbl.setForeground(Color.WHITE);
    priceDay_lbl.setBounds(21, 168, 89, 23);
    contentPane.add(priceDay_lbl);

    JLabel numberOfDays_lbl = new JLabel("Number Of Days Stay");
    numberOfDays_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    numberOfDays_lbl.setForeground(Color.WHITE);
    numberOfDays_lbl.setBounds(251, 168, 180, 23);
    contentPane.add(numberOfDays_lbl);

    JLabel totalAmount_lbl = new JLabel("Total Amount");
    totalAmount_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    totalAmount_lbl.setForeground(Color.WHITE);
    totalAmount_lbl.setBounds(479, 168, 126, 23);
    contentPane.add(totalAmount_lbl);

    JLabel email_lbl = new JLabel("Email");
    email_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    email_lbl.setForeground(Color.WHITE);
    email_lbl.setBounds(702, 166, 44, 26);
    contentPane.add(email_lbl);

    pricePerDay_fld = new JTextField();
    pricePerDay_fld.setColumns(10);
    pricePerDay_fld.setEditable(false);
    pricePerDay_fld.setBounds(21, 201, 151, 20);
    contentPane.add(pricePerDay_fld);

    dayStay_fld = new JTextField();
    dayStay_fld.setColumns(10);
    dayStay_fld.setEditable(false);
    dayStay_fld.setBounds(251, 202, 151, 20);
    contentPane.add(dayStay_fld);

    totalAmount_fld = new JTextField();
    totalAmount_fld.setColumns(10);
    totalAmount_fld.setEditable(false);
    totalAmount_fld.setBounds(479, 201, 151, 20);
    contentPane.add(totalAmount_fld);

    email_fld = new JTextField();
    email_fld.setColumns(10);
    email_fld.setEditable(false);
    email_fld.setBounds(702, 201, 160, 20);
    contentPane.add(email_fld);

    JLabel roomNum_lbl = new JLabel("Room Number");
    roomNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    roomNum_lbl.setForeground(Color.WHITE);
    roomNum_lbl.setBounds(187, 32, 106, 23);
    contentPane.add(roomNum_lbl);

    search_combo = new JComboBox<>();
    search_combo.setBounds(303, 35, 151, 20);
    contentPane.add(search_combo);

    roomSearch();
    search_combo.setSelectedIndex(-1);

    clear_btn = new JButton("Clear");
    clear_btn.setBounds(160, 284, 97, 23);
    clear_btn.setFocusable(false);
    contentPane.add(clear_btn);

    logOut_btn.addActionListener(this);
    back_btn.addActionListener(this);
    checkOut_btn.addActionListener(this);
    clear_btn.addActionListener(this);
    search_combo.addActionListener(this);
    // search_btn.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Check if the room exists
    boolean DoesRoomExists = false;
    if (e.getSource() == logOut_btn) { // Logout button action
      // Display confirmation dialog
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);
      // If user confirms logout
      if (yesORno == JOptionPane.YES_OPTION) {
        // Hide current window and show login window
        this.setVisible(false);
        System.out.println("Exited from CheckOut class");
        new Login();
      }
    } else if (e.getSource() == back_btn) { // Back button action
      // Hide current window and show dashboard window
      setVisible(false);
      System.out.println("Exited from CheckOut class");
      new DashBoard();
    } else if (e.getSource() == clear_btn) { // Clear button action
      // Clear checkout fields and adjust table column widths
      ClearCheckOut.ClearCheckoutField(
          CustomerName_fld,
          CustomerNum_fld,
          checkInDate_fld,
          pricePerDay_fld,
          dayStay_fld,
          totalAmount_fld,
          email_fld,
          search_combo,
          table);

      table.getColumnModel().getColumn(0).setPreferredWidth(80);
      table.getColumnModel().getColumn(1).setPreferredWidth(82);
      System.out.println("All data cleared from Text Field and Combo Box set to Default");
    } else if (e.getSource() == checkOut_btn) {
      if (search_combo.getSelectedItem() == null) { // Show error if Search bar is Empty
        JOptionPane.showMessageDialog(
            null, "Error", "No room is selected", JOptionPane.WARNING_MESSAGE);
      } else {
        if (JOptionPane.showConfirmDialog(
                null, "Confirmation", "Are You Sure?", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION) {
          try {
            // Input room number to search for
            String roomNo = (String) search_combo.getSelectedItem();
            // Create a temporary file to write updated data to
            File tempFile = new File("./files/temp.txt");
            System.out.println("temp.txt file created");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"));
            String line2;
            while ((line2 = br.readLine()) != null) {
              if (line2.equals("Rooms Details")) {
                String[] rowData = new String[5]; // create an array with 5 elements
                for (int i = 0; i < 5; i++) {
                  // read the next 5 lines and add the data to the corresponding column
                  rowData[i] = br.readLine();
                }
                if (rowData[0].equals(roomNo)) { // if the room number is a match
                  System.out.println("Room number found");
                  rowData[4] = "Not Booked"; // update the status
                  System.out.println("Updated room details to Not Booked");
                }
                // write the updated row data to the temporary file
                pw.println("Rooms Details");
                System.out.println("Updated details to temp file");
                for (int i = 0; i < 5; i++) {
                  pw.println(rowData[i]);
                }
              } else {
                // write non-"Rooms Details" lines to the temporary file unchanged
                pw.println(line2);
              }
            }
            br.close();
            pw.close();
            // Replace the original file with the temporary file
            File originalFile = new File("./files/rooms.txt");
            if (originalFile.delete()) {
              boolean renamed = tempFile.renameTo(originalFile);
              if (renamed) {
                System.out.println("File renamed successfully.");
              } else {
                System.out.println("Failed to rename the file.");
              }
            } else {
              System.out.println("Failed to delete the original file.");
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          roomNumToDelete =
              (String)
                  search_combo
                      .getSelectedItem(); // change this to whatever room number you want to delete

          deleteRoomEntry();

          JOptionPane.showMessageDialog(
              null, "Check Out Successful", "Check Out", JOptionPane.INFORMATION_MESSAGE);
          System.out.println("CheckOut Done Successfully");
          ClearCheckOut.ClearCheckoutField(
              CustomerName_fld,
              CustomerNum_fld,
              checkInDate_fld,
              pricePerDay_fld,
              dayStay_fld,
              totalAmount_fld,
              email_fld,
              search_combo,
              table);

          // Clearing the input fields
          name = null;
          mobileNumber = null;
          nationality = null;
          gmail = null;
          address = null;
          CheckinDate = null;
          gender = null;
          roomNo_B = null;
          roomType = null;
          bed = null;
          roomPrice = null;
        }

        search_combo.removeAllItems();
        roomSearch();
        search_combo.setSelectedIndex(-1);
        ClearCheckOut.ClearCheckoutField(
            CustomerName_fld,
            CustomerNum_fld,
            checkInDate_fld,
            pricePerDay_fld,
            dayStay_fld,
            totalAmount_fld,
            email_fld,
            search_combo,
            table);
        System.out.println("All data cleared from Text Field and Combo Box set to Default");
      }
    }

    if (search_combo.getSelectedIndex() != -1) {
      if (e.getSource() == search_combo) {
        if (search_combo.getSelectedIndex() == -1) {
          JOptionPane.showMessageDialog(
              null, "There is no room to checkout", "Error", JOptionPane.WARNING_MESSAGE);
        } else {

          String search = (String) search_combo.getSelectedItem();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);

          // Read the rooms.txt file
          try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
              if (!line.equals("Rooms Details")) {
                String[] rowData = new String[5]; // create an array with 5 elements
                rowData[0] = line; // add the first element to the Room Number column
                assert search != null : "Cannot read rooms.txt";
                if (search.equals(rowData[0])) {
                  DoesRoomExists = true; // Set the flag to indicate that the room exists
                  roomNo_B = rowData[0]; // Store the room number in a variable
                  break; // Exit the loop since the room is found
                }
              }
            }
          } catch (Exception ex) {
            ex.printStackTrace(); // Print the stack trace if an exception occurs
          }
          // Check if the room exists
          if (DoesRoomExists) {
            System.out.println("Room Exist");
            // Retrieve customer data
            getCustomerData();
            System.out.println("Customer Data Retrived");
          } else {
            // Display an error message if the room is not found
            JOptionPane.showMessageDialog(
                null, "room not found", "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("Room Doesn't not exist");
            search_combo.setSelectedIndex(-1);
          }

          // Calculate the number of days stayed
          SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
          Calendar cal = Calendar.getInstance();
          String dateBeforeString = CheckinDate;
          Date dateBefore;
          try {
            dateBefore = myFormat.parse(dateBeforeString);
          } catch (ParseException ex) {

            throw new RuntimeException(ex);
          }
          String dateAfterString = myFormat.format(cal.getTime());
          Date dateAfter;
          try {
            dateAfter = myFormat.parse(dateAfterString);
          } catch (ParseException ex) {
            throw new RuntimeException(ex);
          }
          long difference = dateAfter.getTime() - dateBefore.getTime();
          int noOfDayStay = (int) (difference / (1000 * 60 * 60 * 24));
          // Ensure a minimum of 1 day stay
          if (noOfDayStay == 0) {
            noOfDayStay = 1;
          }
          // Set the number of days stayed
          dayStay_fld.setText(String.valueOf(noOfDayStay));
          // Calculate and display the total amount
          float price = Float.parseFloat(pricePerDay_fld.getText());
          totalAmount_fld.setText(String.valueOf(noOfDayStay * price));
        }
      }
    }
  }

  @Override
  public void deleteRoomEntry() {
    System.out.println("deleteRoomEntry funtion called");
    try {
      File inputFile = new File("./files/checkIn.txt");
      File tempFile = new File("./files/checkIn_temp.txt");
      System.out.println("temp file created");

      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String currentLine;
      int lineCounter = 0;
      while ((currentLine = reader.readLine()) != null) {
        lineCounter++;
        if (currentLine.contains(roomNumToDelete)) {
          break;
          // skip the lines that contain the room number to delete
        }
      }

      reader.close();
      reader = new BufferedReader(new FileReader(inputFile));
      int k = 0;
      while ((currentLine = reader.readLine()) != null) {
        k++;
        if (k > (lineCounter - 3) && k < (lineCounter + 10)) {
          // skip lines before the room number to delete

        } else {
          // write all other lines to the temp file

          writer.write(currentLine + System.getProperty("line.separator"));
          System.out.println("writting into temp file");
        }
      }

      writer.close();
      reader.close();

      // delete the original file
      inputFile.delete();
      System.out.println("Orginal file deleted");

      // rename the temp file to the original file name
      tempFile.renameTo(inputFile);
      System.out.println("temp file renamed to orginal file");

    } catch (IOException ex) {
      ex.printStackTrace();
    }
    System.out.println("deleteRoomEntry funtion executed successfully");
  }

  @Override
  public void getCustomerData() {
    System.out.println("getCustomerData funtion called");
    DefaultTableModel model;
    model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);

    try (BufferedReader br1 = new BufferedReader(new FileReader("./files/checkIn.txt"))) {
      String line1;

      while ((line1 = br1.readLine()) != null) {
        if (!line1.equals("Check In Details")) {
          String[] rowData1 = new String[11]; // create an array with 6 elements
          rowData1[0] = line1; // add the second element to the Room Number column
          for (int i = 1; i < 10; i++) {
            // read the next 4 lines and add the data to the corresponding column
            rowData1[i] = br1.readLine();
            // System.out.println(rowData1);
          } // set the last element to empty string

          try (BufferedReader br2 = new BufferedReader(new FileReader("./files/rooms.txt"))) {
            String line2;

            while ((line2 = br2.readLine()) != null) {
              if (!line2.equals("Rooms Details")) {
                String[] rowData2 = new String[6]; // create an array with 10 elements
                rowData2[0] = line2;
                for (int i = 1; i < 6; i++) {
                  rowData2[i] = br2.readLine();
                  // System.out.println(rowData2);
                }

                br2.readLine();
                if (rowData2[0].equals(roomNo_B)) {
                  roomType = rowData2[1];
                  bed = rowData2[2];
                  roomPrice = rowData2[3];
                }
              }
            }

          } catch (Exception ex) {
            ex.printStackTrace();
          }
          if (rowData1[1].equals(roomNo_B)) {
            name = rowData1[0];
            gender = rowData1[2];
            mobileNumber = rowData1[3];
            nationality = rowData1[4];
            gmail = rowData1[5];
            address = rowData1[6];
            CheckinDate = rowData1[7];
          }

          // add the row to the JTable
          br1.readLine();
          br1.readLine(); // skip the empty line
        }
      }
      if (name != null) {
        String[] data = {
          name,
          mobileNumber,
          nationality,
          gender,
          gmail,
          address,
          CheckinDate,
          roomNo_B,
          bed,
          roomType,
          roomPrice
        };
        model.addRow(data);
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    CustomerName_fld.setText(name);
    checkInDate_fld.setText(CheckinDate);
    CustomerNum_fld.setText(mobileNumber);
    pricePerDay_fld.setText(roomPrice);
    email_fld.setText(gmail);

    System.out.println("getCustomerData funtion executed successfully");
  }

  public void roomSearch() {
    System.out.println("roomSearch funtion called");
    try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.equals("Rooms Details")) {
          String[] rowData = new String[5]; // create an array with 5 elements
          for (int i = 0; i < 5; i++) {
            // read the next 4 lines and add the data to the corresponding column
            rowData[i] = br.readLine();
          }
          if (rowData[4].equals("Booked")) {
            search_combo.addItem(rowData[0]);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("roomSearch funtion executed successfully");
  }
}
