package myClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
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

public class ForgetPass2 extends JFrame implements ActionListener {

  private final JButton next2Button;
  private final JTextField phoneField;
  private final JButton backButton;
  private final JButton exitButton;

  public ForgetPass2() {
    System.out.println("Currently in ForgetPass2 class");
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

    phoneField = new JTextField();
    phoneField.setBounds(592, 247, 180, 30);
    Font phoneFieldFont = new Font("Times New Roman", Font.BOLD, 18);
    phoneField.setFont(phoneFieldFont);
    phoneField.setOpaque(false);
    phoneField.setForeground(new Color(219, 226, 233));
    phoneField.setBorder(BorderFactory.createEmptyBorder());
    Border phoneFieldBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    phoneField.setBorder(phoneFieldBorder);
    phoneField.setVisible(true);
    contentPane.add(phoneField);

    next2Button = new JButton("Next");
    next2Button.setBounds(702, 287, 70, 21);
    next2Button.setFocusable(false);
    contentPane.add(next2Button);

    JLabel phone = new JLabel("Phone No :");
    phone.setForeground(Color.WHITE);
    phone.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    phone.setBounds(473, 248, 109, 25);
    contentPane.add(phone);

    try {
      int k = ((ForgetPass.deleteLine) + 2);
      String line1 = Files.readAllLines(Paths.get("./files/user_login.txt")).get(k);
      String line2 = "";
      line2 = line2 + line1.charAt(16);
      line2 = line2 + line1.charAt(17);
      line2 = line2 + line1.charAt(18);

      JLabel hintPhnNum = new JLabel("Hint :xxxxxxxx" + line2);
      hintPhnNum.setBounds(592, 207, 180, 30);
      hintPhnNum.setForeground(new Color(245, 242, 208, 150));
      Font hintphnFont = new Font("Verdana", Font.BOLD, 14);
      hintPhnNum.setFont(hintphnFont);
      hintPhnNum.setVisible(true);
      contentPane.add(hintPhnNum);
    } catch (Exception e) {
      e.printStackTrace();
    }

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
    imgLabel.setBounds(10, 105, 453, 343);
    BufferedImage imgForget = null;
    try {
      imgForget =
          ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/Forget2.png")));

    } catch (IOException e) {
      e.printStackTrace();
    }
    assert imgForget != null : "The 'Forget2' image could not be loaded";
    Image imgFORGET =
        imgForget.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
    imgLabel.setIcon(new ImageIcon(imgFORGET));
    contentPane.add(imgLabel);

    JLabel forget = new JLabel("Reset Password");
    forget.setForeground(Color.WHITE);
    forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    forget.setBounds(363, 10, 147, 50);
    contentPane.add(forget);

    next2Button.addActionListener(this);
    backButton.addActionListener(this);
    exitButton.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String user =
        "Phone : "
            + phoneField
                .getText(); // Get the value of the phoneField and format it as "Phone : {phone
                            // number}"
    String user1 = phoneField.getText(); // Get the value of the phoneField
    boolean userEmpty = user1.isEmpty(); // Check if the phoneField is empty
    boolean isFound =
        false; // Initialize a boolean variable to keep track of whether the user's phone number is
               // found

    // Check which button was clicked
    if (e.getSource() == next2Button) {
      try {
        if (userEmpty) {
          // Show a warning message if the phoneField is empty
          JOptionPane.showMessageDialog(
              null, "Enter phone number", "Error", JOptionPane.WARNING_MESSAGE);

        } else {
          // Calculate the line number to read from the file
          int n = ((ForgetPass.deleteLine) + 2);
          // Read the specified line from the user_login.txt file
          BufferedReader readFile = new BufferedReader(new FileReader("./files/user_login.txt"));
          String line = Files.readAllLines(Paths.get("./files/user_login.txt")).get(n);
          // Check if the line matches the formatted phone number
          if (line.equals(user)) {
            System.out.println("User phonenumber found");
            isFound = true;
          }

          if (!isFound) {
            // Show a warning message if the phone number is not found in the file
            System.out.println("User phonenumber not found");
            JOptionPane.showMessageDialog(
                null, "Phone number not found!", "Error", JOptionPane.WARNING_MESSAGE);
          } else {
            this.setVisible(false); // Hide the current frame and show the ForgetPass3 frame
            System.out.println("Exited from ForgetPass2 class");
            new ForgetPass3();
          }
          readFile.close();
        }

      } catch (
          Exception
              ex) { // Show a warning message if an exception occurs while reading from the file
        System.out.println("User phone number not found error in file");
        JOptionPane.showMessageDialog(
            null, "Phone number not found!", "Error", JOptionPane.WARNING_MESSAGE);
      }
    } else if (e.getSource()
        == exitButton) { // Show a confirmation dialog before exiting the program
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == 0) {
        // If Yes then exit from the project
        System.out.println("Exited from ForgetPass2 class");
        System.out.println("Exited from the Project");
        System.exit(1);
      }
    } else if (e.getSource()
        == backButton) { // Hide the current frame and show the ForgetPass frame
      this.setVisible(false);
      System.out.println("Exited from ForgetPass2 class");
      new ForgetPass();
    }
  }
}
