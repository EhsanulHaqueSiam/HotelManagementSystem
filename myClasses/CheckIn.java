package myClasses;

import java.awt.Color;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckIn extends ShowRoom implements ActionListener, myInterface.WriteCheckInInfo {

  private final JFrame frame;
  private final JTextField name_field;
  private final JTextField mbl_fld;
  private final JTextField nationality_fld;
  private final JTextField gmail_fld;
  private final JTextField address_fld;
  private final JTextField date_fld;
  private final JTextField cost_fld;

  // Create JComboBoxes that can only accept Strings as items
  private final JComboBox<String> bed_Box;
  private final JComboBox<String> roomType_Box;
  private final JComboBox<String> roomNo_Box;
  private final JComboBox<String> gender_Box;

  private final JButton back_btn;
  private final JButton confirm_btn;
  private final JButton clear_btn;
  private final JButton logOut_Btn;

  public String roomNo;

  public CheckIn() {
    System.out.println("Currently in CheckIn class");
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 927, 533);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setTitle("Admin checkin");
    JPanel contentPane = new JPanel();
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    frame.setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel checkIn_lbl = new JLabel("Check In");
    checkIn_lbl.setForeground(Color.LIGHT_GRAY);
    checkIn_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    checkIn_lbl.setBounds(10, 3, 180, 34);
    contentPane.add(checkIn_lbl);

    JLabel fullName_lbl = new JLabel("Full Name");
    fullName_lbl.setForeground(Color.WHITE);
    fullName_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    fullName_lbl.setBounds(10, 74, 141, 34);
    contentPane.add(fullName_lbl);

    name_field = new JTextField();
    name_field.setBounds(10, 109, 218, 20);
    contentPane.add(name_field);
    name_field.setColumns(10);

    JLabel mblNum_lbl = new JLabel("Mobile Number");
    mblNum_lbl.setForeground(Color.WHITE);
    mblNum_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    mblNum_lbl.setBounds(10, 151, 141, 34);
    contentPane.add(mblNum_lbl);

    JLabel nationality_lbl = new JLabel("Nationality");
    nationality_lbl.setForeground(Color.WHITE);
    nationality_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    nationality_lbl.setBounds(10, 231, 141, 34);
    contentPane.add(nationality_lbl);

    JLabel gender_lbl = new JLabel("Gender");
    gender_lbl.setForeground(Color.WHITE);
    gender_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    gender_lbl.setBounds(10, 298, 141, 34);
    contentPane.add(gender_lbl);

    JLabel gmail_lbl = new JLabel("Gmail");
    gmail_lbl.setForeground(Color.WHITE);
    gmail_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    gmail_lbl.setBounds(10, 379, 141, 34);
    contentPane.add(gmail_lbl);

    mbl_fld = new JTextField();
    mbl_fld.setColumns(10);
    mbl_fld.setBounds(10, 187, 218, 20);
    contentPane.add(mbl_fld);

    nationality_fld = new JTextField();
    nationality_fld.setColumns(10);
    nationality_fld.setBounds(10, 267, 218, 20);
    contentPane.add(nationality_fld);

    gmail_fld = new JTextField();
    gmail_fld.setColumns(10);
    gmail_fld.setBounds(10, 415, 218, 20);
    contentPane.add(gmail_fld);

    gender_Box = new JComboBox<>();
    gender_Box.setModel(new DefaultComboBoxModel<>(new String[] {"Male", "Female", "Others"}));
    gender_Box.setBounds(10, 342, 76, 22);
    contentPane.add(gender_Box);

    JLabel address = new JLabel("Address");
    address.setForeground(Color.WHITE);
    address.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    address.setBounds(324, 74, 141, 34);
    contentPane.add(address);

    address_fld = new JTextField();
    address_fld.setColumns(10);
    address_fld.setBounds(324, 109, 218, 20);
    contentPane.add(address_fld);

    date_fld = new JTextField();
    date_fld.setColumns(10);
    date_fld.setBounds(324, 187, 218, 20);
    date_fld.setEditable(false);
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar cal = Calendar.getInstance();
    date_fld.setText(myFormat.format(cal.getTime()));
    contentPane.add(date_fld);

    JLabel date = new JLabel("Date(Today)");
    date.setForeground(Color.WHITE);
    date.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    date.setBounds(324, 151, 141, 34);
    contentPane.add(date);

    JLabel bed_lbl = new JLabel("Bed");
    bed_lbl.setForeground(Color.WHITE);
    bed_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    bed_lbl.setBounds(650, 74, 141, 34);
    contentPane.add(bed_lbl);

    JLabel roomType_lbl = new JLabel("Room Type");
    roomType_lbl.setForeground(Color.WHITE);
    roomType_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    roomType_lbl.setBounds(650, 152, 141, 34);
    contentPane.add(roomType_lbl);

    JLabel roomNo_lbl = new JLabel("Room No");
    roomNo_lbl.setForeground(Color.WHITE);
    roomNo_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    roomNo_lbl.setBounds(650, 231, 141, 34);
    contentPane.add(roomNo_lbl);

    JLabel cost_lbl = new JLabel("Total Cost");
    cost_lbl.setForeground(Color.WHITE);
    cost_lbl.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
    cost_lbl.setBounds(650, 309, 141, 34);
    contentPane.add(cost_lbl);

    bed_Box = new JComboBox<>();
    bed_Box.setModel(new DefaultComboBoxModel<>(new String[] {"Single", "Double", "Triple"}));
    bed_Box.setBounds(650, 108, 133, 22);
    bed_Box.addActionListener(this);
    contentPane.add(bed_Box);

    cost_fld = new JTextField();
    cost_fld.setEditable(false);
    cost_fld.setBounds(650, 344, 218, 20);
    contentPane.add(cost_fld);

    roomType_Box = new JComboBox<>();
    roomType_Box.setModel(new DefaultComboBoxModel<>(new String[] {"AC", "Non-Ac"}));
    roomType_Box.setBounds(650, 186, 133, 22);
    roomType_Box.addActionListener(this);
    contentPane.add(roomType_Box);

    roomNo_Box = new JComboBox<>();
    roomNo_Box.setBounds(650, 266, 133, 22);
    roomNo_Box.addActionListener(this);
    contentPane.add(roomNo_Box);

    back_btn = new JButton("Back");
    back_btn.setBounds(779, 435, 89, 23);
    back_btn.setFocusable(false);
    contentPane.add(back_btn);

    confirm_btn = new JButton("Confirm Book");
    confirm_btn.setBackground(Color.DARK_GRAY);
    confirm_btn.setForeground(Color.WHITE);
    confirm_btn.setBounds(261, 399, 176, 52);
    confirm_btn.setFocusable(false);
    contentPane.add(confirm_btn);

    clear_btn = new JButton("Clear All");
    clear_btn.setBackground(Color.DARK_GRAY);
    clear_btn.setForeground(Color.WHITE);
    clear_btn.setBounds(473, 399, 176, 52);
    clear_btn.setFocusable(false);
    contentPane.add(clear_btn);

    logOut_Btn = new JButton("Log Out");
    logOut_Btn.setBounds(812, 11, 89, 23);
    logOut_Btn.setFocusable(false);
    contentPane.add(logOut_Btn);

    back_btn.addActionListener(this);
    confirm_btn.addActionListener(this);
    clear_btn.addActionListener(this);
    logOut_Btn.addActionListener(this);

    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    String name = name_field.getText();
    String mobileNumber = mbl_fld.getText();
    String nationality = nationality_fld.getText();
    String gmail = gmail_fld.getText();
    String address = address_fld.getText();
    String checkindate = date_fld.getText();
    String cost = cost_fld.getText();
    String gender = (String) gender_Box.getSelectedItem();
    String roomNo_B = (String) roomNo_Box.getSelectedItem();

    boolean isNameFieldEmpty = name_field.getText().isEmpty();
    boolean isMobileNumberFieldEmpty = mbl_fld.getText().isEmpty();
    boolean isNationalityFieldEmpty = nationality_fld.getText().isEmpty();
    boolean isGmailEmpty = gmail_fld.getText().isEmpty();
    boolean isAddressEmpty = address_fld.getText().isEmpty();
    boolean isCheckinDateEmptyField = date_fld.getText().isEmpty();
    boolean isCostFieldEmpty = cost_fld.getText().isEmpty();

    if (e.getSource() == back_btn) {
      // Navigate back to the dashboard
      frame.setVisible(false);
      System.out.println("Exited from CheckIn class");
      new DashBoard();
    } else if (e.getSource() == logOut_Btn) {
      // Prompt for confirmation and logout if confirmed
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == JOptionPane.YES_OPTION) {
        // Logout and show the login screen
        frame.setVisible(false);
        System.out.println("Exited from CheckIn class");
        new Login();
      }
    } else if (e.getSource() == clear_btn) {
      // Clear all input fields
      name_field.setText(null);
      mbl_fld.setText(null);
      nationality_fld.setText(null);
      gmail_fld.setText(null);
      address_fld.setText(null);
      cost_fld.setText(null);
      gender_Box.setSelectedIndex(0);
      bed_Box.setSelectedIndex(0);
      roomType_Box.setSelectedIndex(0);
      System.out.println("All data cleared from Text Field and Combo Box set to Default");
    } else if (e.getSource() == confirm_btn) {
      if (!isNameFieldEmpty
          && !isMobileNumberFieldEmpty
          && !isNationalityFieldEmpty
          && !isGmailEmpty
          && !isAddressEmpty
          && !isCheckinDateEmptyField
          && !isCostFieldEmpty) {

        // Checks if Nationality contains numbers or special character
        if (!nationality.matches("[a-zA-Z]+")) {
          JOptionPane.showMessageDialog(
              null,
              "Nationality cannot contain numbers or special character",
              "Error",
              JOptionPane.WARNING_MESSAGE);
          nationality_fld.setText(null);
          // checks if gmail contains @ and .com
        } else if (!(gmail.contains("@") && gmail.contains(".com"))) {
          JOptionPane.showMessageDialog(
              null, "Gmail must contain @ and .com", "Error", JOptionPane.WARNING_MESSAGE);
          gmail_fld.setText(null);
          // checks if address contain
        } else if (address.matches("^\\d+$")) {
          JOptionPane.showMessageDialog(
              null, "Address can not contain only number", "Error", JOptionPane.WARNING_MESSAGE);
          address_fld.setText(null);
          // checks if the mobile number is valid
        } else if (!(mobileNumber.length() == 11 && mobileNumber.matches("\\d+"))) {
          JOptionPane.showMessageDialog(
              null, "mobile number must be only 11 digit", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
          try {
            String CheckinFilePath = "./files/checkIn.txt";
            try {
              // Create a new file or use an existing file for check-in data
              File file = new File(CheckinFilePath);
              if (!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                  System.out.println("File created successfully.");
                } else {
                  System.out.println("File creation failed.");
                }
                // Open the file for writing
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.close();
              } else {
                System.out.println("File already exists.");
              }
              // Write check-in data to the file
              WriteCheckinData(
                  nationality,
                  gmail,
                  address,
                  checkindate,
                  cost,
                  gender,
                  roomNo_B,
                  file,
                  name,
                  mobileNumber);

              try {
                // Input room number to search for
                String roomNo = Objects.requireNonNull(roomNo_Box.getSelectedItem()).toString();
                // Create a temporary file to write updated data to
                File tempFile = new File("./files/temp.txt");
                System.out.println("temp file created");
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
                System.out.println("Writting into temp file");
                BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"));
                System.out.println("Reading from room.txt");
                String line2;
                while ((line2 = br.readLine()) != null) {
                  if (line2.equals("Rooms Details")) {
                    String[] rowData = new String[5]; // create an array with 5 elements
                    for (int i = 0; i < 5; i++) {
                      // read the next 5 lines and add the data to the corresponding column
                      rowData[i] = br.readLine();
                      System.out.println("reading room.txt");
                    }
                    if (rowData[0].equals(roomNo)) { // if the room number is a match
                      System.out.println("Room found");
                      rowData[4] = "Booked"; // update the status
                      System.out.println("Updated room status to Booked");
                    }
                    // write the updated row data to the temporary file
                    pw.println("Rooms Details");
                    System.out.println("Updating data to temp file");
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

              JOptionPane.showMessageDialog(
                  null,
                  "Congratulation Check In successfully",
                  "Congratulation",
                  JOptionPane.INFORMATION_MESSAGE);
              System.out.println("Check in done successfully");
              // Clearing the input fields
              name_field.setText(null);
              mbl_fld.setText(null);
              nationality_fld.setText(null);
              gmail_fld.setText(null);
              address_fld.setText(null);
              cost_fld.setText(null);
              gender_Box.setSelectedIndex(0);
              bed_Box.setSelectedIndex(0);
              roomType_Box.setSelectedIndex(0);
              System.out.println("All data cleared from Text Field and Combo Box set to Default");

            } catch (Exception ex) {
              ex.printStackTrace();
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      } else {
        JOptionPane.showMessageDialog(
            null, "Please Fill all the box", "Error", JOptionPane.WARNING_MESSAGE);
      }
    } else if (e.getSource() == roomType_Box) {
      // Update room details based on selected room type
      super.roomDetails(cost_fld, bed_Box, roomType_Box, roomNo_Box);

    } else if (e.getSource() == bed_Box) {
      // Update room details based on selected bed type
      super.roomDetails(cost_fld, bed_Box, roomType_Box, roomNo_Box);

    } else if (e.getSource() == roomNo_Box) {
      roomNo = (String) roomNo_Box.getSelectedItem(); // Get the selected room number
      try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
          if (line.equals("Rooms Details")) {
            String[] rowData = new String[5]; // create an array with 5 elements
            for (int i = 0; i < 5; i++) {
              // read the next 4 lines and add the data to the corresponding column
              rowData[i] = br.readLine();
            }
            if (rowData[0].equals(roomNo)) {
              // Set the cost in the cost_fld
              cost_fld.setText(rowData[3]);
            }
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * Writes check-in data to a file in the hotel management system.
   *
   * @param nationality The nationality of the guest.
   * @param gmail The guest's Gmail address.
   * @param address The guest's address.
   * @param CheckInDate The date of check-in.
   * @param cost The cost of the booking.
   * @param gender The gender of the guest.
   * @param roomNo_B The room number or identifier.
   * @param file The file to write the check-in data to.
   * @param fullName The full name of the guest.
   * @param mobileNumber The guest's mobile number.
   * @throws IOException If an I/O error occurs while writing the data to the file.
   */
  @Override
  public void WriteCheckinData(
      String nationality,
      String gmail,
      String address,
      String CheckInDate,
      String cost,
      String gender,
      String roomNo_B,
      File file,
      String fullName,
      String mobileNumber)
      throws IOException {
    System.out.println("WriteCheckinData funtion called");
    FileWriter fileWriter = new FileWriter(file, true);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    PrintWriter printWriter = new PrintWriter(bufferedWriter);
    // Write check-in details to the file
    printWriter.println("Check In Details");
    printWriter.println(fullName);
    printWriter.println(roomNo_B);
    printWriter.println(gender);
    printWriter.println(mobileNumber);
    printWriter.println(nationality);
    printWriter.println(gmail);
    printWriter.println(address);
    printWriter.println(CheckInDate);
    printWriter.println(cost);
    printWriter.println("Booked");
    printWriter.println();

    printWriter.close();
    System.out.println("WriteCheckinData funtion executed successfully");
    System.out.println("New checkIn data stored successfully");
  }
}
