package myclasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class Signup extends JFrame implements ActionListener {

  private final JTextField usernameField;
  private final JPasswordField passwordField;
  private final JPasswordField confirmPassField;
  private final JToggleButton EyeBtn;
  private final JToggleButton EyeBtn2;
  private final JTextField fullField;
  private final ImageIcon on;
  private final ImageIcon off;
  private final JButton signin;
  private final JButton signup;
  private final JButton exitButton;
  private final JTextField phoneNumberField;

  public Signup() {
    System.out.println("Currently in Signup class");
    setResizable(false);
    setTitle("The Tipton Hotel Management System");
    setIconImage(
        Toolkit.getDefaultToolkit().getImage(Login.class.getResource("../images/titleIcon.png")));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 903, 554);
    setLocationRelativeTo(null);
    JPanel contentPane = new JPanel();
    contentPane.setForeground(Color.LIGHT_GRAY);
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(null);

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel SignUpText = new JLabel("SIGN UP");
    SignUpText.setForeground(new Color(215, 210, 203));
    SignUpText.setFont(new Font("Verdana", Font.BOLD, 22));
    SignUpText.setBounds(203, 10, 114, 30);
    contentPane.add(SignUpText);

    JLabel fullName = new JLabel("Full Name :");
    fullName.setForeground(Color.WHITE);
    fullName.setFont(new Font("Verdana", Font.PLAIN, 17));
    fullName.setBounds(11, 68, 106, 30);
    contentPane.add(fullName);

    fullField = new JTextField();
    fullField.setBounds(193, 68, 248, 30);
    Font fullFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
    fullField.setFont(fullFieldFont);
    fullField.setOpaque(false);
    fullField.setForeground(new Color(219, 226, 233));
    fullField.setBorder(BorderFactory.createEmptyBorder());
    Border Border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    fullField.setBorder(Border);
    contentPane.add(fullField);

    JLabel username = new JLabel("User Name :");
    username.setBounds(11, 105, 114, 30);
    Font usernameFont = new Font("Verdana", Font.PLAIN, 17);
    username.setFont(usernameFont);
    username.setForeground(Color.white);
    contentPane.add(username);

    usernameField = new JTextField();
    usernameField.setBounds(193, 105, 248, 30);
    Font userfieldFont = new Font("Times New Roman", Font.PLAIN, 17);
    usernameField.setFont(userfieldFont);
    usernameField.setOpaque(false);
    usernameField.setForeground(new Color(219, 226, 233));
    usernameField.setBorder(BorderFactory.createEmptyBorder());
    usernameField.setBorder(Border);
    contentPane.add(usernameField);

    JLabel phoneNumber = new JLabel("Phone Number :");
    phoneNumber.setForeground(Color.WHITE);
    phoneNumber.setFont(new Font("Verdana", Font.PLAIN, 17));
    phoneNumber.setBounds(11, 148, 150, 27);
    contentPane.add(phoneNumber);

    phoneNumberField = new JTextField();
    phoneNumberField.setBounds(193, 148, 248, 30);
    Font emailFieldFont = new Font("Times New Roman", Font.PLAIN, 17);
    phoneNumberField.setFont(emailFieldFont);
    phoneNumberField.setOpaque(false);
    phoneNumberField.setForeground(new Color(219, 226, 233));
    phoneNumberField.setBorder(BorderFactory.createEmptyBorder());
    phoneNumberField.setBorder(Border);
    contentPane.add(phoneNumberField);

    JLabel password = new JLabel("Password :");
    password.setForeground(Color.WHITE);
    password.setFont(new Font("Verdana", Font.PLAIN, 17));
    password.setBounds(11, 189, 106, 30);
    contentPane.add(password);

    passwordField = new JPasswordField();
    passwordField.setBounds(193, 189, 248, 30);
    Font passfieldFont = new Font("Verdana", Font.PLAIN, 18);
    passwordField.setFont(passfieldFont);
    passwordField.setEchoChar('*');
    passwordField.setOpaque(false);
    passwordField.setForeground(new Color(219, 226, 233));
    passwordField.setBorder(BorderFactory.createEmptyBorder());
    passwordField.setBorder(Border);
    contentPane.add(passwordField);

    JLabel confirmPassTxt = new JLabel("Confirm Password :");
    confirmPassTxt.setForeground(Color.WHITE);
    confirmPassTxt.setFont(new Font("Verdana", Font.PLAIN, 17));
    confirmPassTxt.setBounds(10, 229, 173, 30);
    contentPane.add(confirmPassTxt);

    confirmPassField = new JPasswordField();
    confirmPassField.setBounds(193, 229, 248, 30);
    Font confirmPassFieldFont = new Font("Verdana", Font.PLAIN, 18);
    confirmPassField.setFont(confirmPassFieldFont);
    confirmPassField.setEchoChar('*');
    confirmPassField.setOpaque(false);
    confirmPassField.setForeground(new Color(219, 226, 233));
    confirmPassField.setBorder(BorderFactory.createEmptyBorder());
    confirmPassField.setBorder(Border);
    contentPane.add(confirmPassField);

    BufferedImage imgOn = null;
    BufferedImage imgOff = null;
    try {
      imgOn = ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/show.png")));

      imgOff = ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/hide.png")));

    } catch (IOException e) {
      e.printStackTrace();
    }
    assert imgOn != null : "The 'show.png' image could not be loaded";
    Image imgON = imgOn.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    assert imgOff != null : "The 'hide.png' image could not be loaded";
    Image imgOFF = imgOff.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    on = new ImageIcon(imgON);
    off = new ImageIcon(imgOFF);
    EyeBtn = new JToggleButton(off);
    EyeBtn.setOpaque(false);
    EyeBtn.setForeground(Color.DARK_GRAY);
    EyeBtn.setBackground(Color.DARK_GRAY);
    EyeBtn.setBounds(444, 189, 29, 30);
    contentPane.add(EyeBtn);

    EyeBtn2 = new JToggleButton(off);
    EyeBtn2.setOpaque(false);
    EyeBtn2.setOpaque(false);
    EyeBtn2.setForeground(Color.DARK_GRAY);
    EyeBtn2.setBackground(Color.DARK_GRAY);
    EyeBtn2.setBounds(444, 229, 29, 30);
    contentPane.add(EyeBtn2);

    signin = new JButton("Already have an account?");
    signin.setFont(new Font("Papyrus", Font.BOLD, 17));
    signin.setForeground(new Color(155, 157, 196));
    signin.setBackground(Color.DARK_GRAY);
    signin.setBounds(331, 405, 264, 47);
    signin.setFocusable(false);
    contentPane.add(signin);

    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    exitButton.setBounds(809, 486, 70, 21);
    exitButton.setFocusable(false);
    contentPane.add(exitButton);

    signup = new JButton("Sign up");
    signup.setFocusable(false);
    signup.setBounds(213, 298, 110, 34);
    contentPane.add(signup);
    signup.setFont(new Font("Tahoma", Font.BOLD, 15));

    // Load the login background image
    BufferedImage imgSignup = null;
    try {
      imgSignup =
          ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/signup.jpg")));

    } catch (IOException e) {
      // If the image fails to load, print the error
      e.printStackTrace();
    }
    // Make sure the image has loaded successfully
    assert imgSignup != null : "The 'signup' image could not be loaded";
    // Scale the image to the desired size
    Image imgSIGNUP = imgSignup.getScaledInstance(396, 385, Image.SCALE_SMOOTH);

    JLabel SideImageLbl = new JLabel(new ImageIcon(imgSIGNUP));
    SideImageLbl.setBounds(483, 10, 396, 385);
    signup.addActionListener(this);

    Panel SidePanel = new Panel();
    SidePanel.setBackground(Color.WHITE);
    SidePanel.setBounds(479, 0, 410, 517);
    contentPane.add(SidePanel);
    SidePanel.add(SideImageLbl);

    exitButton.addActionListener(this);
    signin.addActionListener(this);
    EyeBtn.addActionListener(this);
    EyeBtn2.addActionListener(this);

    this.setVisible(true);
  }

  public static boolean isValidFullname(String fullname) {
    System.out.println("isValidFullname function called");
    String pattern = "^(?!.*\\d)(?!.*[^a-zA-Z0-9 .'-])(?!.*[ .'-]{2,})[a-zA-Z0-9 .'-]+$";
    System.out.println("isValidFullname function executed successfully");
    return fullname.matches(pattern);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Get user input
    String user = usernameField.getText(); // Get username
    String pass = String.valueOf(passwordField.getPassword()); // Get password
    String confpass = String.valueOf(confirmPassField.getPassword()); // Get confirmed password
    String name = fullField.getText(); // Get full name
    String PhoneNumber = phoneNumberField.getText(); // Get phone number

    // Check if fields are empty
    boolean userEmpty = user.isEmpty(); // Check if username is empty
    boolean passEmpty = pass.isEmpty(); // Check if password is empty
    boolean confEmpty = confpass.isEmpty(); // Check if confirmed password is empty
    boolean nameEmpty = name.isEmpty(); // Check if full name is empty
    boolean emailEmpty = PhoneNumber.isEmpty(); // Check if phone number is empty

    // Check if password matches confirmed password
    boolean check = pass.equals(confpass);
    int numcount = 0;

    try {
      // Check phone number length
      if (PhoneNumber.length() != 11) {
        numcount++; // Increment numcount if phone number length is not equal to 11
      }
    } catch (Exception ex) {
      numcount = 1; // Set numcount to 1 if an exception occurs
    }

    if (e.getSource() == signup) {
      if (userEmpty || passEmpty || confEmpty || nameEmpty || emailEmpty) {
        // Display an error message if any field is empty
        JOptionPane.showMessageDialog(
            null, "Please fill all of the fields.", "Error!", JOptionPane.WARNING_MESSAGE);
      } else if (!isValidFullname(name)) {
        // Display an error message for invalid Fullname
        JOptionPane.showMessageDialog(
            null,
            "Invalid fullname. Please enter a valid fullname.",
            "Error!",
            JOptionPane.WARNING_MESSAGE);
      } else if (!validateUsername(user)) {
        // Display an error message for invalid username
        JOptionPane.showMessageDialog(
            null,
            "Invalid username. Please enter a valid username.",
            "Error!",
            JOptionPane.WARNING_MESSAGE);
      } else if (numcount > 0) {
        // Display an error message for invalid phone number
        JOptionPane.showMessageDialog(
            null, "Invalid Phone Number", " Error!", JOptionPane.WARNING_MESSAGE);
      } else if (!check) {
        // Display an error message if password doesn't match
        JOptionPane.showMessageDialog(
            null, "Password is not matching", " Error!", JOptionPane.WARNING_MESSAGE);
      } else {
        try {
          File file = new File("./files/user_login.txt");
          if (!file.exists()) {
            // Create a new file if it doesn't exist
            boolean created = file.createNewFile();
            if (created) {
              System.out.println("User Login File created successfully.");
            } else {
              System.out.println("User Login File creation failed.");
            }
          }
          FileWriter fileWriter = new FileWriter(file, true);
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
          PrintWriter printWriter = new PrintWriter(bufferedWriter);

          LocalDateTime myDateObj = LocalDateTime.now();
          DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

          String timeAndDate = myDateObj.format(myFormatObj);

          // User Login file checked
          int totalLines = 0; // Check the total lines in User Login file
          BufferedReader readFile = new BufferedReader(new FileReader("./files/user_login.txt"));
          while (readFile.readLine() != null) {
            totalLines++;
          }
          readFile.close();

          // Admin login file checked
          BufferedReader adminFile = new BufferedReader(new FileReader("./files/admin_login.txt"));
          int totalLines2 = 0; // Check the total lines in Admin Login file
          while (adminFile.readLine() != null) {
            totalLines2++;
          }
          adminFile.close();

          boolean userflag = false;
          boolean adminflag = false;

          // for user
          for (int i = 0;
              i < totalLines;
              i++) { // Check if the username already exists in User Login file
            String line = Files.readAllLines(Paths.get("./files/user_login.txt")).get(i);
            if (line.equals("User Name : " + user)) {
              userflag = true;
              System.out.println("User name exists");
              break;
            }
          }

          // for admin
          for (int i = 0;
              i < totalLines2;
              i++) { // Check if the username already exists in Admin Login file
            String line = Files.readAllLines(Paths.get("./files/admin_login.txt")).get(i);
            if (line.equals("User Name : " + user)) {
              System.out.println("User name exists as Admin");
              adminflag = true;
              break;
            }
          }
          if (!userflag && !adminflag) {
            // If username is not taken, add user information to the file
            printWriter.println("===============================================");
            printWriter.println("Full Name : " + name);
            printWriter.println("User Name : " + user);
            printWriter.println("Password : " + pass);
            printWriter.println("Phone : " + PhoneNumber);
            printWriter.println("Time & Date : " + timeAndDate);
            printWriter.println("===============================================");

            System.out.println("New User details added");

            this.setVisible(false);
            System.out.println("Exited from Signup class");
            new Login(); // Open the login window

          } else {
            // Display a warning message if username is already taken
            JOptionPane.showMessageDialog(
                null, "User name already taken", "Warning", JOptionPane.WARNING_MESSAGE);
          }

          printWriter.close();

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }

    } else if (e.getSource() == EyeBtn) {
      if (EyeBtn.isSelected()) {
        EyeBtn.setIcon(on); // Set eye icon to "on"
        passwordField.setEchoChar((char) 0); // Show password characters
      } else {
        EyeBtn.setIcon(off); // Set eye icon to "off"
        passwordField.setEchoChar('*'); // Hide password characters
      }
    } else if (e.getSource() == EyeBtn2) {
      if (EyeBtn2.isSelected()) {
        EyeBtn2.setIcon(on);
        confirmPassField.setEchoChar((char) 0); // Show password characters
      } else {
        EyeBtn2.setIcon(off);
        confirmPassField.setEchoChar('*'); // Hide password characters
      }
    } else if (e.getSource() == signin) {
      this.setVisible(false);
      System.out.println("Exited from Signup class");
      new Login();
    } else if (e.getSource() == exitButton) {
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == 0) {
        System.exit(1);
      }
    }
  }

  public boolean validateUsername(String username) {
    System.out.println("validateUsername function called");
    // Check for spaces
    if (username.contains(" ")) {
      return false;
    }

    // Check for symbols and allowed formats using regular expression
    if (!username.matches("^[a-zA-Z0-9]+$")
        && !username.matches("^[a-zA-Z]+$")
        && !username.matches("^[a-zA-Z]+[0-9]+$")) {
      return false;
    }

    // Check length
    int length = username.length();
    System.out.println("validateUsername function executed successfully");
    return length >= 3 && length <= 20;

    // Additional validation rules can be added here
  }
}
