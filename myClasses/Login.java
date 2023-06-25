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
import java.nio.file.Path;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class Login extends JFrame implements ActionListener {

  public static String USERNAME;
  protected static boolean loginFlag;
  protected static boolean isAdmin;
  protected static String fullName;
  protected static String oldPassword;
  protected static String phoneNumber;
  protected static String fullUsername;
  private final JTextField usernameField;
  private final JPasswordField passwordField;
  private final ImageIcon on;
  private final ImageIcon off;
  private final JToggleButton EyeBtn;
  private final JButton signup;
  private final JButton exitButton;
  private final JButton loginButton;
  private final JButton forgot;

  public Login() {
    System.out.println("Currently in Login class");
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

    JLabel LoginTxt = new JLabel("LOGIN");
    LoginTxt.setForeground(new Color(215, 210, 203));
    LoginTxt.setFont(new Font("Verdana", Font.BOLD, 22));
    LoginTxt.setBounds(677, 79, 83, 30);
    contentPane.add(LoginTxt);

    JLabel UsernameTxt = new JLabel("Username");
    UsernameTxt.setForeground(new Color(215, 210, 203));
    UsernameTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
    UsernameTxt.setBounds(603, 141, 94, 30);
    contentPane.add(UsernameTxt);

    usernameField = new JTextField();
    usernameField.setOpaque(false);
    usernameField.setForeground(new Color(219, 226, 233));
    usernameField.setFont(new Font("Times New Roman", Font.BOLD, 17));
    usernameField.setBounds(603, 181, 205, 30);
    usernameField.setBorder(BorderFactory.createEmptyBorder());
    Border userBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    usernameField.setBorder(userBorder);
    contentPane.add(usernameField);

    JLabel PasswordTxt = new JLabel("Password");
    PasswordTxt.setForeground(new Color(215, 210, 203));
    PasswordTxt.setFont(new Font("Verdana", Font.PLAIN, 18));
    PasswordTxt.setBounds(603, 223, 94, 30);
    contentPane.add(PasswordTxt);

    passwordField = new JPasswordField();
    passwordField.setOpaque(false);
    passwordField.setForeground(new Color(219, 226, 233));
    passwordField.setFont(new Font("Verdana", Font.BOLD, 17));
    passwordField.setEchoChar('*');
    passwordField.setBorder(BorderFactory.createEmptyBorder());
    Border passBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    passwordField.setBorder(passBorder);
    passwordField.setBounds(603, 276, 205, 30);
    contentPane.add(passwordField);

    // Define variables for two BufferedImages
    BufferedImage imgOn = null;
    BufferedImage imgOff = null;
    try {
      // Read in the image files from resources
      imgOn = ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/show.png")));
      imgOff = ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/hide.png")));

    } catch (IOException e) {
      // Print the stack trace if an IOException occurs
      e.printStackTrace();
    }
    // Check that the images have been loaded successfully
    assert imgOn != null : "The 'show' image could not be loaded";
    assert imgOff != null : "The 'hide' image could not be loaded";
    // Scale the images and store them as Icons
    Image imgON = imgOn.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image imgOFF = imgOff.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    on = new ImageIcon(imgON);
    off = new ImageIcon(imgOFF);
    // Create a JToggleButton using the "off" icon
    EyeBtn = new JToggleButton(off);
    EyeBtn.setOpaque(false);
    EyeBtn.setForeground(Color.DARK_GRAY);
    EyeBtn.setBackground(Color.DARK_GRAY);
    EyeBtn.setBounds(818, 276, 44, 30);
    EyeBtn.setFocusable(false);
    contentPane.add(EyeBtn);

    forgot = new JButton("Forgotten Password ?");
    forgot.setOpaque(false);
    forgot.setForeground(Color.LIGHT_GRAY);
    forgot.setFont(new Font("Dialog", Font.BOLD, 10));
    forgot.setBorder(BorderFactory.createEmptyBorder());
    forgot.setBackground(Color.DARK_GRAY);
    forgot.setBounds(687, 311, 120, 19);
    forgot.setFocusable(false);
    contentPane.add(forgot);

    signup = new JButton("Don't have an account?");
    signup.setForeground(new Color(220, 20, 60));
    signup.setBorder(BorderFactory.createEmptyBorder());
    signup.setFont(new Font("Calibri", Font.BOLD, 14));
    signup.setBackground(Color.DARK_GRAY);
    signup.setBounds(637, 410, 189, 30);
    signup.setFocusable(false);
    contentPane.add(signup);

    // Load the login background image
    BufferedImage imgLogin = null;
    try {
      imgLogin =
          ImageIO.read(
              Objects.requireNonNull(Login.class.getResource("../images/LoginBackground.png")));

    } catch (IOException e) {
      // If the image fails to load, print the error
      e.printStackTrace();
    }
    // Make sure the image has loaded successfully
    assert imgLogin != null : "The 'LoginBackground.png' image could not be loaded";
    // Scale the image to the desired size
    Image imgLOGIN = imgLogin.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
    // Create a new label to display the image
    JLabel LoginPageImage = new JLabel("New label");
    LoginPageImage.setForeground(Color.DARK_GRAY);
    LoginPageImage.setBackground(Color.DARK_GRAY);
    LoginPageImage.setIcon(new ImageIcon(imgLOGIN));
    LoginPageImage.setBounds(37, 170, 500, 300);
    contentPane.add(LoginPageImage);

    JLabel LoginLblTxt = new JLabel("The Tipton Hotel");
    LoginLblTxt.setForeground(Color.LIGHT_GRAY);
    LoginLblTxt.setFont(new Font("Modern No. 20", Font.PLAIN, 54));
    LoginLblTxt.setBounds(72, 42, 404, 82);
    contentPane.add(LoginLblTxt);

    loginButton = new JButton("Login");
    loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
    loginButton.setBounds(653, 345, 153, 40);
    loginButton.setFocusable(false);
    contentPane.add(loginButton);

    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    exitButton.setBounds(809, 486, 70, 21);
    exitButton.setFocusable(false);
    contentPane.add(exitButton);

    EyeBtn.addActionListener(this);
    signup.addActionListener(this);
    exitButton.addActionListener(this);
    loginButton.addActionListener(this);
    forgot.addActionListener(this);

    this.setVisible(true);
  }

  // Return the value of login flag
  public static boolean getloginFlag() {
    return loginFlag;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Get the user input from the username and password fields
    String user = usernameField.getText();
    String pass = String.valueOf(passwordField.getPassword());

    // Check if the username and password fields are empty
    boolean userEmpty = user.isEmpty();
    boolean passEmpty = pass.isEmpty();

    // Check which button was clicked
    if (e.getSource() == EyeBtn) {
      // If the "show password" button was clicked, toggle the password visibility
      if (EyeBtn.isSelected()) {
        EyeBtn.setIcon(on);
        passwordField.setEchoChar((char) 0); // Show password
      } else {
        EyeBtn.setIcon(off);
        passwordField.setEchoChar('*'); // Hide password
      }
    } else if (e.getSource() == signup) {
      // If the "signup" button was clicked, go to the signup page
      System.out.println("Exited from Login class");
      this.setVisible(false);
      new Signup();
    } else if (e.getSource() == exitButton) {
      // If the "exit" button was clicked, prompt the user to confirm if they want to exit
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == 0) {
        System.out.println("Exited from Login class");
        System.out.println("Exited from The program");
        System.exit(1); // If the user chooses "yes", exit the program
      }
    } else if (e.getSource() == loginButton) {
      // If the "login" button was clicked, check if the username and password fields are filled
      if (userEmpty || passEmpty) {
        JOptionPane.showMessageDialog(
            null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
      } else {
        boolean userbool = false; // Flag to check if the user is an admin or not
        isAdmin = false; // Flag to check if the user is an admin or not
        try {
          // Check if the admin login file exists, if not create it and add default admin
          // credentials
          File file = new File("./files/admin_login.txt");
          if (!file.exists()) {
            boolean created = file.createNewFile();
            if (created) {
              System.out.println("File created successfully.");
            } else {
              System.out.println("File creation failed.");
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println("===============================================");
            printWriter.println("User Name : admin");
            printWriter.println("Password : admin");
            printWriter.println("===============================================");
            printWriter.close();
          }

          // Create strings for the username and password
          String uname = "User Name : " + user;
          String pin = "Password : " + pass;

          // Check if the user is an admin by reading the admin login file
          BufferedReader readFile1 = new BufferedReader(new FileReader("./files/admin_login.txt"));

          int totalLines1 = 0;
          while (readFile1.readLine() != null) {
            totalLines1++;
          }
          readFile1.close();

          // Iterate over each line in the admin login file and check if the user credentials match
          for (int i = 0; i < totalLines1; i++) {
            Path adminLoginPath = Paths.get("./files/admin_login.txt");
            String line = Files.readAllLines(adminLoginPath).get(i);
            if (line.equals(uname)) {
              String line2 = Files.readAllLines(adminLoginPath).get((i + 1));
              System.out.println("user name matched to admin");
              // Set flags and username, and open the dashboard window
              if (line2.equals(pin)) {
                loginFlag = true;
                isAdmin = true;
                USERNAME = user;
                System.out.println("pin matched to admin user");
                this.setVisible(false);
                System.out.println("Exited from Login class");
                // Show the admin Dashboard
                new DashBoard();
                break;
              } else {
                isAdmin = false;
              }
            } else {
              isAdmin = false;
            }
          }

          // Check if the user is a regular user
          if (!isAdmin) { // Check if the user is not an admin
            // Read the user_login.txt file
            File userfile = new File("./files/user_login.txt");
            if (userfile.exists()) { // Check if the file exists
              // Create a buffered reader to read the file
              BufferedReader readFile =
                  new BufferedReader(new FileReader("./files/user_login.txt"));
              int totalLines = 0;
              // Count the total number of lines in the file
              while (readFile.readLine() != null) {
                totalLines++;
              }
              readFile.close();

              // Loop through each line of the file
              for (int i = 0; i < totalLines; i++) {
                // Get the i-th line of the file
                Path userLoginPath = Paths.get("./files/user_login.txt");
                String line = Files.readAllLines(userLoginPath).get(i);
                // Check if the username matches the i-th line of the file
                if (line.equals(uname)) {
                  // Check if the password matches the (i+1)-th line of the file
                  System.out.println("User found");
                  String line2 = Files.readAllLines(userLoginPath).get((i + 1));
                  if (line2.equals(pin)) {
                    System.out.println("Password matched with user name");
                    // Set login flag, username, full name, phone number, and old password
                    loginFlag = true;
                    userbool = true;
                    USERNAME = user;
                    fullName = Files.readAllLines(userLoginPath).get(i - 1);
                    phoneNumber = Files.readAllLines(userLoginPath).get(i + 2);
                    oldPassword = Files.readAllLines(userLoginPath).get(i + 1);
                    fullUsername = uname;
                    // Hide the login frame and show the User dashboard
                    System.out.println("Exited from Login class");
                    this.setVisible(false);
                    new UDashBoard();
                    // Exit the loop
                    break;
                  }
                }
              }
            }
          }
          // If the login is unsuccessful, show an error message
          if (!userbool && !isAdmin) {
            JOptionPane.showMessageDialog(
                null, "Invalid Name or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
          }
          // Catch any exceptions and show an error message
        } catch (Exception ex) {
          if (!userbool && !isAdmin) {
            JOptionPane.showMessageDialog(
                null, "Invalid Name or Password!", "Warning!", JOptionPane.WARNING_MESSAGE);
          }
        }
      }
    } else if (e.getSource()
        == forgot) { // If the "forgot" button was clicked, go to the ForgotPass page
      this.setVisible(false);
      System.out.println("Exited from Login class");
      new ForgetPass();
    }
  }
}
