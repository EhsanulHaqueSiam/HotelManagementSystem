package myclasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Edit extends JFrame implements ActionListener {

  private final JTextField fullField;
  private final JTextField userField;
  private final JTextField phoneField;
  private final JLabel full;
  private final JLabel user;
  private final JLabel phone;
  private final JButton fullNameButton;
  private final JButton usernameButton;
  private final JButton phoneButton;
  private final JButton confirmButton1;
  private final JButton confirmButton2;
  private final JButton confirmButton3;
  private final JButton logoutButton;
  private final JButton exitButton;
  private final JButton backButton;
  private int check;

  public Edit() {
    System.out.println("Currently in Edit class");
    setResizable(false);
    setTitle("The Tipton Hotel Management System");
    setIconImage(
        Toolkit.getDefaultToolkit().getImage(Profile.class.getResource("../images/titleIcon.png")));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 903, 554);
    setLocationRelativeTo(null);
    JPanel contentPane = new JPanel();
    contentPane.setForeground(Color.LIGHT_GRAY);
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(null);

    setContentPane(contentPane);
    contentPane.setLayout(null);
    check = 0; // Set the initial value of 'check' variable

    BufferedImage ImgLabel = null;
    try {
      ImgLabel =
          ImageIO.read(Objects.requireNonNull(Profile.class.getResource("../images/profile.png")));

    } catch (IOException e) {
      e.printStackTrace();
    }
    assert ImgLabel != null : "The 'profile.png' image could not be loaded";
    Image imgLabelScaledInstance = ImgLabel.getScaledInstance(147, 147, Image.SCALE_SMOOTH);
    ImageIcon profile = new ImageIcon(imgLabelScaledInstance);
    JLabel imgLabel = new JLabel(profile);
    imgLabel.setBounds(67, 153, 147, 147);
    contentPane.add(imgLabel);

    JLabel displayName1 = new JLabel("Edit Information");
    displayName1.setHorizontalAlignment(SwingConstants.CENTER);
    displayName1.setBounds(294, 114, 256, 48);
    displayName1.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
    displayName1.setForeground(Color.decode("#6577b3"));
    contentPane.add(displayName1);

    fullNameButton = new JButton("Full Name");
    fullNameButton.setVisible(true);
    fullNameButton.setBounds(355, 210, 150, 30);
    fullNameButton.setBorder(BorderFactory.createEmptyBorder());
    fullNameButton.setBackground(new Color(49, 111, 112));
    fullNameButton.setForeground(Color.decode("#8ee0f0"));
    Font fullnameButtonFont = new Font("Times New Roman", Font.BOLD, 19);
    fullNameButton.setFont(fullnameButtonFont);
    fullNameButton.setFocusable(false);
    contentPane.add(fullNameButton);

    usernameButton = new JButton("User Name");
    usernameButton.setVisible(true);
    usernameButton.setBorder(BorderFactory.createEmptyBorder());
    usernameButton.setBounds(355, 270, 150, 30);
    usernameButton.setBackground(new Color(49, 111, 112));
    usernameButton.setForeground(Color.decode("#8ee0f0"));
    Font usernameButtonFont = new Font("Times New Roman", Font.BOLD, 19);
    usernameButton.setFont(usernameButtonFont);
    usernameButton.setFocusable(false);
    contentPane.add(usernameButton);

    phoneButton = new JButton("Phone Number");
    phoneButton.setVisible(true);
    phoneButton.setBounds(355, 330, 150, 30);
    phoneButton.setBorder(BorderFactory.createEmptyBorder());
    phoneButton.setBackground(new Color(49, 111, 112));
    phoneButton.setForeground(Color.decode("#8ee0f0"));
    Font phoneButtonFont = new Font("Times New Roman", Font.BOLD, 19);
    phoneButton.setFont(phoneButtonFont);
    phoneButton.setFocusable(false);
    contentPane.add(phoneButton);

    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    exitButton.setBounds(809, 486, 70, 21);
    exitButton.setFocusable(false);
    contentPane.add(exitButton);

    backButton = new JButton("Back");
    backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    backButton.setBounds(10, 486, 70, 21);
    backButton.setFocusable(false);
    contentPane.add(backButton);

    logoutButton = new JButton("logout");
    logoutButton.setBounds(809, 10, 70, 21);
    logoutButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    logoutButton.setFocusable(false);
    contentPane.add(logoutButton);

    confirmButton1 = new JButton("Confirm");
    confirmButton1.setVisible(false);
    confirmButton1.setBounds(390, 290, 80, 30);
    confirmButton1.setBorder(BorderFactory.createEmptyBorder());
    confirmButton1.setBackground(new Color(49, 111, 112));
    confirmButton1.setForeground(Color.decode("#8ee0f0"));
    Font confirmButtonFont1 = new Font("Times New Roman", Font.BOLD, 15);
    confirmButton1.setFont(confirmButtonFont1);
    confirmButton1.setFocusable(false);
    contentPane.add(confirmButton1);

    confirmButton2 = new JButton("Confirm");
    confirmButton2.setVisible(false);
    confirmButton2.setBounds(390, 290, 80, 30);
    confirmButton2.setBorder(BorderFactory.createEmptyBorder());
    confirmButton2.setBackground(new Color(49, 111, 112));
    confirmButton2.setForeground(Color.decode("#8ee0f0"));
    Font confirmButtonFont2 = new Font("Times New Roman", Font.BOLD, 15);
    confirmButton2.setFont(confirmButtonFont2);
    confirmButton2.setFocusable(false);
    contentPane.add(confirmButton2);

    confirmButton3 = new JButton("Confirm");
    confirmButton3.setVisible(false);
    confirmButton3.setBounds(390, 290, 80, 30);
    confirmButton3.setBorder(BorderFactory.createEmptyBorder());
    confirmButton3.setBackground(new Color(49, 111, 112));
    confirmButton3.setForeground(Color.decode("#8ee0f0"));
    Font confirmButtonFont3 = new Font("Times New Roman", Font.BOLD, 15);
    confirmButton3.setFont(confirmButtonFont3);
    confirmButton3.setFocusable(false);
    contentPane.add(confirmButton3);

    full = new JLabel("Enter your full name :");
    full.setVisible(false);
    full.setBounds(234, 210, 157, 30);
    Font fullFont = new Font("Times New Roman", Font.PLAIN, 17);
    full.setFont(fullFont);
    full.setForeground(Color.white);
    contentPane.add(full);

    fullField = new JTextField();
    fullField.setVisible(false);
    fullField.setBounds(401, 212, 203, 30);
    Font fullFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
    fullField.setFont(fullFieldFont);
    fullField.setOpaque(false);
    fullField.setForeground(new Color(219, 226, 233));
    fullField.setBorder(BorderFactory.createEmptyBorder());
    Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
    fullField.setBorder(redBorder);
    contentPane.add(fullField);

    user = new JLabel("Enter new user name :");
    user.setVisible(false);
    user.setBounds(234, 210, 157, 30);
    Font userFont = new Font("Times New Roman", Font.PLAIN, 17);
    user.setFont(userFont);
    user.setForeground(Color.white);
    contentPane.add(user);

    userField = new JTextField();
    userField.setVisible(false);
    userField.setBounds(401, 212, 203, 30);
    Font userFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
    userField.setFont(userFieldFont);
    userField.setOpaque(false);
    userField.setForeground(new Color(219, 226, 233));
    userField.setBorder(BorderFactory.createEmptyBorder());
    Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
    userField.setBorder(redBorder2);
    contentPane.add(userField);

    phone = new JLabel("Enter new phone number :");
    phone.setVisible(false);
    phone.setBounds(234, 210, 181, 30);
    Font phoneFont = new Font("Times New Roman", Font.PLAIN, 17);
    phone.setFont(phoneFont);
    phone.setForeground(Color.white);
    contentPane.add(phone);

    phoneField = new JTextField();
    phoneField.setVisible(false);
    phoneField.setBounds(431, 212, 173, 30);
    Font phoneFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
    phoneField.setFont(phoneFieldFont);
    phoneField.setOpaque(false);
    phoneField.setForeground(new Color(219, 226, 233));
    phoneField.setBorder(BorderFactory.createEmptyBorder());
    Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(49, 111, 112));
    phoneField.setBorder(redBorder3);
    contentPane.add(phoneField);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(160, 165, 197));
    panel.setBounds(0, 0, 147, 517);
    contentPane.add(panel);

    usernameButton.addActionListener(this);
    phoneButton.addActionListener(this);
    fullNameButton.addActionListener(this);
    confirmButton1.addActionListener(this);
    confirmButton2.addActionListener(this);
    confirmButton3.addActionListener(this);
    logoutButton.addActionListener(this);
    backButton.addActionListener(this);
    exitButton.addActionListener(this);

    this.setVisible(true);
  }

  public static boolean isValidFullname(String fullname) {
    System.out.println("isValidFullname funtion called");
    String pattern = "^(?!.*\\d)(?!.*[^a-zA-Z0-9 .'-])(?!.*[ .'-]{2,})[a-zA-Z0-9 .'-]+$";
    System.out.println("isValidFullname executed successfully");
    return fullname.matches(pattern);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String newPhoneNumber;
    boolean emptyName;

    if (e.getSource() == logoutButton) {
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        System.out.println("Exited from Edit class");
        new Login();
      }
    } else if (e.getSource() == exitButton) {
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Do you want to exit ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == 0) {
        System.out.println("Exited from Edit class");
        System.out.println("Exited from the Project");
        System.exit(1);
      }
    } else if (e.getSource() == fullNameButton) {
      check = 1;

      // Show relevant components for full name input
      fullField.setVisible(true);
      confirmButton1.setVisible(true);
      full.setVisible(true);

      // Hide irrelevant components
      confirmButton2.setVisible(false);
      confirmButton3.setVisible(false);
      user.setVisible(false);
      phone.setVisible(false);
      userField.setVisible(false);
      phoneField.setVisible(false);
      usernameButton.setVisible(false);
      fullNameButton.setVisible(false);
      phoneButton.setVisible(false);

    } else if (e.getSource() == usernameButton) {
      check = 1;

      // Show relevant components for username input
      userField.setVisible(true);
      confirmButton2.setVisible(true);
      user.setVisible(true);

      // Hide irrelevant components
      confirmButton1.setVisible(false);
      confirmButton3.setVisible(false);
      full.setVisible(false);
      phone.setVisible(false);
      fullField.setVisible(false);
      phoneField.setVisible(false);
      fullNameButton.setVisible(false);
      usernameButton.setVisible(false);
      phoneButton.setVisible(false);

      newPhoneNumber = userField.getText(); // Store the entered username
    } else if (e.getSource() == phoneButton) {
      check = 1;

      // Show relevant components for phone number input
      phoneField.setVisible(true);
      confirmButton3.setVisible(true);
      phone.setVisible(true);

      // Hide irrelevant components
      confirmButton1.setVisible(false);
      confirmButton2.setVisible(false);
      full.setVisible(false);
      user.setVisible(false);
      fullField.setVisible(false);
      userField.setVisible(false);
      fullNameButton.setVisible(false);
      phoneButton.setVisible(false);
      usernameButton.setVisible(false);

      newPhoneNumber = phoneField.getText(); // Store the entered phone number
    } else if (e.getSource() == backButton) {
      if (check
          == 0) { // If check is 0, Hide the current window and Create and display a new Profile
                  // window
        this.setVisible(false);
        System.out.println("Exited from Edit class");
        new Profile();
      } else {
        // Set visibility and bounds for various buttons
        fullNameButton.setVisible(true);
        fullNameButton.setBounds(355, 210, 150, 30);
        usernameButton.setVisible(true);
        usernameButton.setBounds(355, 270, 150, 30);
        phoneButton.setVisible(true);
        phoneButton.setBounds(355, 330, 150, 30);

        // Set visibility for confirm buttons
        confirmButton1.setVisible(false);
        confirmButton2.setVisible(false);
        confirmButton3.setVisible(false);
        // Hide various labels and text fields
        full.setVisible(false);
        user.setVisible(false);
        phone.setVisible(false);

        fullField.setVisible(false);
        userField.setVisible(false);
        phoneField.setVisible(false);

        check = 0; // Reset the value of check
      }
    } else if (e.getSource() == confirmButton1) {
      // Retrieve the entered name from the text field
      newPhoneNumber = fullField.getText();
      String newName;
      emptyName = newPhoneNumber.isEmpty();

      if (emptyName) {
        // Display a warning message if the name field is empty
        JOptionPane.showMessageDialog(
            null, "Enter your name", " Error!", JOptionPane.WARNING_MESSAGE);
      } else if (!isValidFullname(newPhoneNumber)) {
        // Display an error message for invalid Fullname
        JOptionPane.showMessageDialog(
            null,
            "Invalid fullname. Please enter a valid fullname.",
            "Error!",
            JOptionPane.WARNING_MESSAGE);
      } else {
        // Construct a new name string
        newName = "Full Name : " + newPhoneNumber;

        try {
          // Check if the username exists in the user_login.txt file
          FileReader fr1 = new FileReader("./files/user_login.txt");
          BufferedReader br1 = new BufferedReader(fr1);
          String currentLine1;
          int target = 0;
          while ((currentLine1 = br1.readLine()) != null) {
            if ((Login.fullUsername).equals(currentLine1)) {
              target = target - 1;
              break;
            } else {
              target++;
            }
          }
          fr1.close();
          br1.close();

          // Create a temporary file for writing updated data
          String tempfile = "./files/temp3.txt";

          File oldFile = new File("./files/user_login.txt");
          File newFile = new File("./files/temp3.txt");
          System.out.println("temp file created");
          String currentLine;

          FileWriter fileWriter2 = new FileWriter(tempfile, false);
          BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
          PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

          // Read the original file and update the required entry
          FileReader fr = new FileReader("./files/user_login.txt");
          BufferedReader br = new BufferedReader(fr);

          int l = 0;
          while ((currentLine = br.readLine()) != null) {
            if (target == l) {
              printWriter2.println(newName); // Write the updated name
            } else {
              printWriter2.println(currentLine); // Write the original line
            }
            l++;
          }
          printWriter2.flush();
          printWriter2.close();
          fr.close();
          br.close();
          bufferedWriter2.close();
          fileWriter2.close();

          // Delete the old file and rename the temporary file
          oldFile.delete();
          System.out.println("Old file deleted");
          File dumb = new File("./files/user_login.txt");
          newFile.renameTo(dumb);
          System.out.println("temp file name updated to orginal");

          // Perform further actions, such as opening the Profile view
          this.setVisible(false);
          new Profile();

        } catch (Exception ex) {
          ex.printStackTrace();
        }

        String oldName = Login.fullName.replace("Full Name : ", ""); // Store Old Name
        // Assign the new Full name
        Login.fullName = newName;

        try {
          // Read the checkIn.txt file
          FileReader fileRd = new FileReader("./files/checkIn.txt");
          BufferedReader BufRead = new BufferedReader(fileRd);

          // Loop through each line in the file
          while ((BufRead.readLine()) != null) {
            try {
              // Read the checkIn.txt file again for searching
              FileReader fileRd1 = new FileReader("./files/checkIn.txt");
              BufferedReader BufRead1 = new BufferedReader(fileRd1);
              String crntLine1;
              int tar1 = 0;
              // Find the line number of the target guest
              while ((crntLine1 = BufRead1.readLine()) != null) {
                if ((oldName).equals(crntLine1)) {
                  // Match found, break out of the loop
                  break;
                } else {
                  tar1++;
                }
              }
              // Close the file readers
              fileRd1.close();
              BufRead1.close();

              // Create a temporary file and copy contents with the new name
              String tempfl1 = "./files/temp4.txt";
              System.out.println("temp file created");
              File oldF1 = new File("./files/checkIn.txt");
              File newF1 = new File("./files/temp4.txt");
              String cLine2;

              // Write to the temporary file
              FileWriter fWrite2 = new FileWriter(tempfl1, false);
              BufferedWriter bufWrite2 = new BufferedWriter(fWrite2);
              PrintWriter pntWrite2 = new PrintWriter(bufWrite2);

              // Read from the checkIn.txt file again
              FileReader fr3 = new FileReader("./files/checkIn.txt");
              BufferedReader br3 = new BufferedReader(fr3);

              int line2 = 0;
              // Copy the contents of the original file to the temporary file
              while ((cLine2 = br3.readLine()) != null) {
                if (tar1 == line2) {
                  pntWrite2.println(newPhoneNumber); // Write the new name to the temporary file
                } else {
                  pntWrite2.println(cLine2); // Write the existing line to the temporary file
                }
                line2++;
              }
              System.out.println("Orginal file copied to temp file");
              // Close the file readers and writers
              pntWrite2.flush();
              pntWrite2.close();
              fr3.close();
              br3.close();
              bufWrite2.close();
              fWrite2.close();
              // Delete the original file
              oldF1.delete();
              File dum1 = new File("./files/checkIn.txt");
              // Rename the temporary file to the original file
              newF1.renameTo(dum1);
              System.out.println("temp file renamed to original file");

            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
          // Close the main file reader
          fileRd.close();
          BufRead.close();

          // Delete the destination file if it exists
          File sourceFile = new File("./files/temp4.txt");
          File destinationFile = new File("./files/checkIn.txt");

          if (destinationFile.exists()) {
            // Delete the destination file if it already exists
            destinationFile.delete();
          }
          System.out.println("old file deleted");

          // Rename the source file to the destination file
          sourceFile.renameTo(destinationFile);
          System.out.println("temp file renamed");

        } catch (Exception ex) {
          ex.printStackTrace();
        }

        // Assign the new Full name
        Login.fullName = newName;
      }

    } else if (e.getSource() == confirmButton2) {
      newPhoneNumber = userField.getText();
      String newName;
      emptyName = newPhoneNumber.isEmpty();

      if (emptyName) {
        JOptionPane.showMessageDialog(
            null, "Enter new user name", " Error!", JOptionPane.WARNING_MESSAGE);
      } else {
        newName = "User Name : " + newPhoneNumber; // Get the new Username

        try {
          // Count total lines in user_login.txt
          int totalLines = 0;
          BufferedReader readFile = new BufferedReader(new FileReader("./files/user_login.txt"));
          while (readFile.readLine() != null) {
            totalLines++;
          }
          readFile.close();

          // Admin login file checked
          BufferedReader adminFile = new BufferedReader(new FileReader("./files/admin_login.txt"));
          // Count total lines in admin_login.txt
          int totalLines2 = 0;
          while (adminFile.readLine() != null) {
            totalLines2++;
          }
          adminFile.close();

          boolean userflag = false;
          boolean adminflag = false;

          // for user
          // Check if username exists in user_login.txt
          for (int i = 0; i < totalLines; i++) {
            String line = Files.readAllLines(Paths.get("./files/user_login.txt")).get(i);
            if (line.equals("User Name : " + newPhoneNumber)) {
              userflag = true;
              break;
            }
          }

          // for admin
          // Check if username exists in admin_login.txt
          for (int i = 0; i < totalLines2; i++) {
            String line = Files.readAllLines(Paths.get("./files/admin_login.txt")).get(i);
            if (line.equals("User Name : " + newPhoneNumber)) {
              adminflag = true;
              break;
            }
          }

          if (!adminflag && !userflag) {
            // Find the line number of the current username in user_login.txt
            FileReader fr1 = new FileReader("./files/user_login.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            String currentline1;
            int target = 0;
            while ((currentline1 = br1.readLine()) != null) {
              if ((Login.fullUsername).equals(currentline1)) {
                break;
              } else {
                target++;
              }
            }
            fr1.close();
            br1.close();

            String tempfile = "./files/temp3.txt";
            File oldFile = new File("./files/user_login.txt");
            File newFile = new File("./files/temp3.txt");
            System.out.println("temp file created");
            String currentline;

            // Write updated username to a temporary file
            FileWriter fileWriter2 = new FileWriter(tempfile, false);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

            FileReader fr = new FileReader("./files/user_login.txt");
            BufferedReader br = new BufferedReader(fr);

            int l = 0;
            // Copy lines from user_login.txt to temp3.txt, replacing the target line with newName
            while ((currentline = br.readLine()) != null) {
              if (target == l) {
                printWriter2.println(newName);
              } else {
                printWriter2.println(currentline);
              }
              l++;
            }
            printWriter2.flush();
            printWriter2.close();
            fr.close();
            br.close();
            bufferedWriter2.close();
            fileWriter2.close();
            oldFile.delete();
            File dumb = new File("./files/user_login.txt");
            newFile.renameTo(dumb);
            System.out.println("temp file renamed");

            Login.fullUsername = newName;

            this.setVisible(false);
            new Profile();
          } else {
            // Display error message if username already exists
            JOptionPane.showMessageDialog(
                null, "User name already exist", " Error!", JOptionPane.WARNING_MESSAGE);
          }

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    } else if (e.getSource() == confirmButton3) {
      // Get the phone number from the input field
      newPhoneNumber = phoneField.getText();
      String newNumber;
      emptyName = newPhoneNumber.isEmpty(); // Check if the phone number is empty
      int number;
      int numcount = 0;
      try {
        number = Integer.parseInt(newPhoneNumber); // Try parsing the input as an integer
        if (newPhoneNumber.length() != 11) { // Check if the phone number has 11 digits
          numcount++; // Increment numcount if the length is not 11
        }
      } catch (Exception ex) {
        numcount = 1; // Set numcount to 1 if parsing fails
      }

      if (emptyName) {
        // Display a warning message if the input is empty
        JOptionPane.showMessageDialog(
            null, "Enter new phone number", " Error!", JOptionPane.WARNING_MESSAGE);
      } else if (numcount > 0) {
        // Display a warning message if the phone number is invalid
        JOptionPane.showMessageDialog(
            null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);
      } else {
        newNumber = "Phone : " + newPhoneNumber;

        try {
          // Open the user_login.txt file for reading
          FileReader fr1 = new FileReader("./files/user_login.txt");
          BufferedReader br1 = new BufferedReader(fr1);
          String currentline1;
          int target = 0;
          // Find the line number containing the current user's username
          while ((currentline1 = br1.readLine()) != null) {
            if ((Login.fullUsername).equals(currentline1)) {
              target = target + 2;
              break;
            } else {
              target++;
            }
          }
          fr1.close();
          br1.close();

          String tempfile = "./files/temp3.txt";
          File oldFile = new File("./files/user_login.txt");
          File newFile = new File("./files/temp3.txt");
          System.out.println("temp file created");
          String currentline;

          // Open the temp3.txt file for writing
          FileWriter fileWriter2 = new FileWriter(tempfile, false);
          BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
          PrintWriter printWriter2 = new PrintWriter(bufferedWriter2);

          // Open the user_login.txt file for reading again
          FileReader fr = new FileReader("./files/user_login.txt");
          BufferedReader br = new BufferedReader(fr);

          int l = 0;
          // Copy the lines from user_login.txt to temp3.txt, replacing the target line with the new
          // name
          while ((currentline = br.readLine()) != null) {
            if (target == l) {
              printWriter2.println(newNumber); // Write modified phone number to the temporary file
            } else {
              printWriter2.println(currentline);
            }
            l++;
          }
          printWriter2.flush();
          printWriter2.close();
          fr.close();
          br.close();
          bufferedWriter2.close();
          fileWriter2.close();
          oldFile.delete();
          File dumb = new File("./files/user_login.txt");
          newFile.renameTo(dumb);
          System.out.println("temp file renamed");
          Login.phoneNumber = newNumber; // Update the phoneNumber variable in the Login class

          this.setVisible(false);
          new Profile();

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }
  }
}
