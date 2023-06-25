package myclasses;

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

public class UCheckOut extends JFrame
    implements ActionListener, myinterface.CheckOutRoomSearch, myinterface.CustomerDataEntry {

  final String nameLogin = Login.fullName.replace("Full Name : ", "");
  private final JTable table;
  private final JTextField customerName_fld;
  private final JTextField customerNum_fld;
  private final JTextField checkInDate_fld;
  private final JTextField checkOut_fld;
  private final JTextField pricePerDay_fld;
  private final JTextField dayStay_fld;
  private final JTextField totalAmount_fld;
  private final JTextField email_fld;
  private final JComboBox<String>
      roomNum_combo; // Create a JComboBox for selecting Room Number (using String as the data type
                     // for options)
  private final JButton logOut_btn;
  private final JButton back_btn;
  private final JButton checkOut_btn;
  private final JButton clear_btn;
  // private final JButton search_btn;
  String name;
  String MobileNumber;
  String nationality;
  String gmail;
  String address;
  String CheckInDate;
  String gender;
  String roomNo_B;
  String roomType;
  String bed;
  String roomPrice;
  private DefaultTableModel model;

  public UCheckOut() {
    System.out.println("Currently in UcheckOut class");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Checkout");
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

    JLabel custName_lbl = new JLabel("Customer Name");
    custName_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    custName_lbl.setForeground(Color.WHITE);
    custName_lbl.setBounds(21, 80, 150, 23);
    contentPane.add(custName_lbl);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 318, 891, 139);
    contentPane.add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);

    model =
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
            }) {
          @Override
          public boolean isCellEditable(int row, int column) {
            // Make all cells not editable
            return false;
          }
        };

    table.setEnabled(false);
    table.getTableHeader().setReorderingAllowed(false);

    table.setModel(model);

    table.getColumnModel().getColumn(0).setPreferredWidth(80);
    table.getColumnModel().getColumn(1).setPreferredWidth(82);

    table.setEnabled(false);

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

    JLabel custNum_lbl = new JLabel("Customer Mobile Number");
    custNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    custNum_lbl.setForeground(Color.WHITE);
    custNum_lbl.setBounds(702, 78, 180, 26);
    contentPane.add(custNum_lbl);

    customerName_fld = new JTextField();
    customerName_fld.setBounds(21, 113, 151, 20);
    customerName_fld.setEditable(false);
    contentPane.add(customerName_fld);
    customerName_fld.setColumns(10);

    customerNum_fld = new JTextField();
    customerNum_fld.setColumns(10);
    customerNum_fld.setEditable(false);
    customerNum_fld.setBounds(702, 113, 160, 20);
    contentPane.add(customerNum_fld);

    checkOut_btn = new JButton("Check Out");
    checkOut_btn.setBounds(25, 284, 97, 23);
    checkOut_btn.setFocusable(false);
    contentPane.add(checkOut_btn);

    checkInDate_fld = new JTextField();
    checkInDate_fld.setColumns(10);
    checkInDate_fld.setEditable(false);
    checkInDate_fld.setBounds(251, 114, 151, 20);

    contentPane.add(checkInDate_fld);

    checkOut_fld = new JTextField();
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

    roomNum_combo = new JComboBox<>();
    roomNum_combo.setBounds(303, 35, 151, 20);
    contentPane.add(roomNum_combo);

    deleteRoomEntry(/*nameLogin, roomNum_combo*/ );
    roomNum_combo.setSelectedIndex(-1);

    clear_btn = new JButton("Clear");
    clear_btn.setBounds(160, 284, 97, 23);
    clear_btn.setFocusable(false);
    contentPane.add(clear_btn);

    logOut_btn.addActionListener(this);
    back_btn.addActionListener(this);
    checkOut_btn.addActionListener(this);
    clear_btn.addActionListener(this);
    roomNum_combo.addActionListener(this);
    // search_btn.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    boolean roomexists = false; // Variable to track if a room exists
    if (e.getSource() == logOut_btn) {
      // Display confirmation dialog
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == JOptionPane.YES_OPTION) {
        setVisible(false);
        System.out.println("Exited from UcheckOut class");
        new Login();
      }
    } else if (e.getSource() == back_btn) {
      setVisible(false);
      System.out.println("Exited from UcheckOut class");
      new UDashBoard();
    } else if (e.getSource() == clear_btn) {
      // Clear input fields
      customerName_fld.setText(null);
      customerNum_fld.setText(null);
      checkInDate_fld.setText(null);
      pricePerDay_fld.setText(null);
      dayStay_fld.setText(null);
      totalAmount_fld.setText(null);
      email_fld.setText(null);

      // Create a new empty table model
      model =
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
              }) {
            @Override
            public boolean isCellEditable(int row, int column) {
              // Make all cells not editable
              return false;
            }
          };

      table.setModel(model); // Set the table model
      table.getColumnModel().getColumn(0).setPreferredWidth(80); // Set preferred width for column 0
      table.getColumnModel().getColumn(1).setPreferredWidth(82); // Set preferred width for column 1

    } else if (e.getSource() == checkOut_btn) {
      // Check if a room is selected for checkout
      if (roomNum_combo.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(
            null, "No room selected to checkout", "Error", JOptionPane.WARNING_MESSAGE);
      } else {
        // Ask for confirmation before proceeding with checkout
        if (JOptionPane.showConfirmDialog(
                null, "Confirmation", "Are You Sure?", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION) {

          try {
            // Input room number to search for
            String roomNo = (String) roomNum_combo.getSelectedItem();
            // Create a temporary file to write updated data to
            File tempFile = new File("./files/temp.txt");
            System.out.println("temp file created");
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
                  System.out.println("Room Number found");
                  rowData[4] = "Not Booked"; // update the status
                  System.out.println("Room details ulpdated to Not Booked");
                }
                // write the updated row data to the temporary file
                pw.println("Rooms Details");
                for (int i = 0; i < 5; i++) {
                  pw.println(rowData[i]);
                }
                System.out.println("temp file updated");
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
          String roomNumToDelete =
              (String)
                  roomNum_combo
                      .getSelectedItem(); // change this to whatever room number you want to delete

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
              assert roomNumToDelete != null
                  : "The 'RoomNumberToDelete' variable Doesn't contain any value";
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
                System.out.println("temp file updated");
                writer.write(currentLine + System.getProperty("line.separator"));
              }
            }

            writer.close();
            reader.close();

            // delete the original file
            inputFile.delete();
            System.out.println("Original file deleted");

            // rename the temp file to the original file name
            tempFile.renameTo(inputFile);
            System.out.println("temp file renamed as original file");

          } catch (IOException ex) {
            ex.printStackTrace();
          }

          // Clear customer input fields
          customerName_fld.setText(null);
          customerNum_fld.setText(null);
          checkInDate_fld.setText(null);
          checkOut_fld.setText(null);
          pricePerDay_fld.setText(null);
          dayStay_fld.setText(null);
          totalAmount_fld.setText(null);
          email_fld.setText(null);
          roomNum_combo.setSelectedIndex(0);

          // Create a new table model for displaying customer information
          model =
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
                  }) {
                @Override
                public boolean isCellEditable(int row, int column) {
                  // Make all cells not editable
                  return false;
                }
              };
          // Set the table model for the table component
          table.setModel(model);

          // Clear variables related to customer information
          name = null;
          MobileNumber = null;
          nationality = null;
          gmail = null;
          address = null;
          CheckInDate = null;
          gender = null;
          roomNo_B = null;
          roomType = null;
          bed = null;
          roomPrice = null;

          deleteRoomEntry();

          this.setVisible(false);
          System.out.println("Exited from UcheckOut class");
          new Payment();
        }
      }
    }
    if (roomNum_combo.getSelectedIndex() != -1) {
      if (e.getSource() == roomNum_combo) {
        if (roomNum_combo.getSelectedIndex() == -1) {
          // Display a warning message if there are no rooms to check out
          JOptionPane.showMessageDialog(
              null, "There is no room to checkout", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
          // Retrieve the selected room number
          String srch = (String) roomNum_combo.getSelectedItem();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0); // Clear the table before populating it with new data

          try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
              if (!line.equals("Rooms Details")) {
                String[] rowData = new String[5]; // create an array with 5 elements
                rowData[0] = line; // add the first element to the Room Number column

                assert srch != null : "The 'rooms.txt' could not be loaded";
                // Check if the selected room number matches the current row
                if (srch.equals(rowData[0])) {
                  roomexists = true;
                  roomNo_B = rowData[0];
                  break;
                }
              }
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }

          if (roomexists) {
            // Retrieve customer data if the room exists
            getCustomerData();
          } else {
            // Display a warning message if the room is not found
            JOptionPane.showMessageDialog(
                null, "room not found", "Error", JOptionPane.WARNING_MESSAGE);
            roomNum_combo.setSelectedIndex(0);
          }

          // Calculate the number of days stayed
          SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
          Calendar cal = Calendar.getInstance();
          String dateBeforeString = CheckInDate;
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

          // If the stay is less than a day, set it as 1 day
          if (noOfDayStay == 0) {
            noOfDayStay = 1;
          }
          // Display the number of days stayed
          dayStay_fld.setText(String.valueOf(noOfDayStay));
          // Calculate and display the total amount
          float price = Float.parseFloat(pricePerDay_fld.getText());
          totalAmount_fld.setText(String.valueOf(noOfDayStay * price));
        }
      }
    }
  }

  @Override
  public void getCustomerData() {
    System.out.println(" getCustomerData funtion called");
    DefaultTableModel model;
    model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);

    try (BufferedReader br1 = new BufferedReader(new FileReader("./files/checkIn.txt"))) {
      String line1;

      while ((line1 = br1.readLine()) != null) {
        if (!line1.equals("Check In Details")) {
          String[] rowData1 =
              new String[11]; // create an array with 11 elements to store customer data
          rowData1[0] = line1; // add the second element to the Room Number column
          for (int i = 1; i < 10; i++) {
            // read the next 9 lines and add the data to the corresponding column
            rowData1[i] = br1.readLine();
          } // set the last element to empty string

          try (BufferedReader br2 = new BufferedReader(new FileReader("./files/rooms.txt"))) {
            String line2;

            while ((line2 = br2.readLine()) != null) {
              if (!line2.equals("Rooms Details")) {
                String[] rowData2 =
                    new String[6]; // create an array with 6 elements to store room data
                rowData2[0] = line2;
                for (int i = 1;
                    i < 6;
                    i++) { // read the next 5 lines and add the data to the corresponding column
                  rowData2[i] = br2.readLine();
                }

                br2.readLine(); // skip the empty line
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
            MobileNumber = rowData1[3];
            nationality = rowData1[4];
            gmail = rowData1[5];
            address = rowData1[6];
            CheckInDate = rowData1[7];
          }

          br1.readLine();
          br1.readLine(); // skip the empty line
        }
      }
      if (name != null) {
        String[] data = {
          name,
          MobileNumber,
          nationality,
          gender,
          gmail,
          address,
          CheckInDate,
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

    // Update UI fields with retrieved data
    customerName_fld.setText(name);
    checkInDate_fld.setText(CheckInDate);
    customerNum_fld.setText(MobileNumber);
    pricePerDay_fld.setText(roomPrice);
    email_fld.setText(gmail);

    System.out.println("getCustomerData funtion executed successfully");
  }

  @Override
  public void deleteRoomEntry() {
    System.out.println("deleteRoomEntry funtion called");
    try (BufferedReader br = new BufferedReader(new FileReader("./files/checkIn.txt"))) {
      String line;
      String[] roomNums = new String[10]; // create an array to store the room numbers
      int i = 0; // initialize the index of the array to 0
      while ((line = br.readLine()) != null) {
        if (line.equals(nameLogin)) {
          String roomNum = br.readLine(); // read the next line after

          roomNums[i] = roomNum; // store it in the array
          i++; // increment the index of the array
        }
      }
      for (int j = 0;
          j < i;
          j++) { // loop through the array and add the room numbers to the JComboBox
        roomNum_combo.addItem(roomNums[j]);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("deleteRoomEntry funtion executed successfully");
  }
}
