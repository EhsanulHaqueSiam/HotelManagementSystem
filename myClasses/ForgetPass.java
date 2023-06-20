package myClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import javax.swing.border.Border;

public class ForgetPass extends JFrame implements ActionListener {

  protected static int deleteLine;
  private final JTextField userField;
  private final JButton exitButton;
  private final JButton nextButton;
  private final JButton backButton;

  public ForgetPass() {
    System.out.println("Currently in ForgetPass class");
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

    JLabel forget = new JLabel("Reset Password");
    forget.setForeground(Color.WHITE);
    forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    forget.setBounds(363, 10, 147, 50);
    contentPane.add(forget);

    JLabel username = new JLabel("Username:");
    username.setForeground(Color.WHITE);
    username.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    username.setBounds(504, 236, 94, 25);
    contentPane.add(username);

    userField = new JTextField();
    userField.setBounds(608, 237, 180, 25);
    Font userfieldFont = new Font("Times New Roman", Font.BOLD, 18);
    userField.setFont(userfieldFont);
    userField.setVisible(true);
    userField.setOpaque(false);
    userField.setForeground(new Color(219, 226, 233));
    userField.setBorder(BorderFactory.createEmptyBorder());
    Border userFieldBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    userField.setBorder(userFieldBorder);
    contentPane.add(userField);

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

    JLabel imgLabel = new JLabel("New label");
    imgLabel.setBounds(10, 70, 456, 369);
    // Load an image from the project's resources
    BufferedImage imgForget = null;
    try {
      imgForget =
          ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/Forget1.png")));
    } catch (IOException e) {
      // If an error occurs while loading the image, print the stack trace
      e.printStackTrace();
    }
    // If the image fails to load, print the error
    assert imgForget != null : "The 'Forget1' image could not be loaded";
    // Scale the image to fit the label and set it as the label's icon
    Image imgFORGET =
        imgForget.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
    imgLabel.setIcon(new ImageIcon(imgFORGET));
    contentPane.add(imgLabel);

    nextButton = new JButton("Next");
    nextButton.setBounds(715, 272, 70, 21);
    nextButton.setFocusable(false);
    contentPane.add(nextButton);

    nextButton.addActionListener(this);
    backButton.addActionListener(this);
    exitButton.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Get the user input from a text field and check if it is empty
    String user = "User Name : " + userField.getText();
    String user1 = userField.getText();
    boolean userEmpty = user1.isEmpty();
    // Initialize some variables
    boolean isFound = false;
    int totalLines = 0;

    // Check which button was clicked
    if (e.getSource() == nextButton) {
      try {
        // Open the file containing user login information
        File userfile = new File("./files/user_login.txt");
        if (userfile.exists()) {
          // Count the total number of lines in the file
          BufferedReader readFile = new BufferedReader(new FileReader("./files/user_login.txt"));
          while (readFile.readLine() != null) {
            totalLines++;
          }
          readFile.close();
        }
        // If the user input is empty, show an error message
        if (userEmpty) {
          JOptionPane.showMessageDialog(
              null, "Enter User Name", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
          // Loop through each line in the file and compare it to the user input
          for (int i = 0; i < totalLines; i++) {
            String line = Files.readAllLines(Paths.get("./files/user_login.txt")).get(i);
            if (line.equals(user)) {
              // If a match is found, set a flag variable and exit the loop
              System.out.println("User name found");
              deleteLine = i;
              isFound = true;
              break;
            }
          }
          // If a match was found, hide the current window and show the next one
          // Otherwise, show an error message
          if (isFound) {
            this.setVisible(false);
            System.out.println("Exited from ForgetPass class");
            new ForgetPass2();
          } else {
            System.out.println("User Name not found");
            JOptionPane.showMessageDialog(
                null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);
          }
        }
      } catch (Exception ex) {
        // Show an error message if there was a problem accessing the file
        System.out.println("User name not found error in file");
        JOptionPane.showMessageDialog(
            null, "Username not found", "Error", JOptionPane.WARNING_MESSAGE);
      }

    } else if (e.getSource() == exitButton) {
      // If the exit button was clicked, ask the user if they really want to exit
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);
      if (yesORno == 0) {
        // If the user chooses to exit, close the application
        System.out.println("Exited from ForgetPass class");
        System.out.println("Exited from the Project");
        System.exit(1);
      }
    } else if (e.getSource() == backButton) {
      // If the back button was clicked, hide the current window and show the login window
      this.setVisible(false);
      System.out.println("Exited from ForgetPass class");
      new Login();
    }
  }
}
