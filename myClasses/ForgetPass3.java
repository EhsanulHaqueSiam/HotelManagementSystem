package myClasses;

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
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class ForgetPass3 extends JFrame implements ActionListener {

  private final JToggleButton EyeBtn2;
  private final JToggleButton EyeBtn1;
  private final JButton next3Button;
  private final ImageIcon on;
  private final ImageIcon off;
  private final JPasswordField newPass;
  private final JPasswordField confirmPass;
  private final JButton exitButton;
  private final JButton backButton;

  public ForgetPass3() {
    System.out.println("Currently in ForgetPass3 class");
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

    JLabel forget = new JLabel("Reset Password");
    forget.setForeground(Color.WHITE);
    forget.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    forget.setBounds(363, 10, 147, 50);
    contentPane.add(forget);

    JLabel newPasslabel = new JLabel("New Password :");
    newPasslabel.setForeground(Color.WHITE);
    newPasslabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    newPasslabel.setBounds(469, 224, 147, 37);
    contentPane.add(newPasslabel);

    newPass = new JPasswordField();
    newPass.setBounds(648, 224, 180, 37);
    Font newPasslFont = new Font("Monospace", Font.BOLD, 18);
    newPass.setFont(newPasslFont);
    newPass.setVisible(true);
    newPass.setOpaque(false);
    newPass.setForeground(new Color(219, 226, 233));
    newPass.setBorder(BorderFactory.createEmptyBorder());
    Border newPassBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    newPass.setBorder(newPassBorder);
    newPass.setEchoChar('*');
    contentPane.add(newPass);

    JLabel confirmPassLbl = new JLabel("Confirm Password :");
    confirmPassLbl.setForeground(Color.WHITE);
    confirmPassLbl.setFont(new Font("Times New Roman", Font.PLAIN, 22));
    confirmPassLbl.setBounds(469, 276, 184, 37);
    contentPane.add(confirmPassLbl);

    confirmPass = new JPasswordField();
    confirmPass.setBounds(648, 277, 180, 36);
    Font confpassFont = new Font("Monospace", Font.BOLD, 18);
    confirmPass.setFont(confpassFont);
    confirmPass.setOpaque(false);
    confirmPass.setForeground(new Color(219, 226, 233));
    confirmPass.setBorder(BorderFactory.createEmptyBorder());
    Border confirmPassBorder =
        BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    confirmPass.setBorder(confirmPassBorder);
    confirmPass.setVisible(true);
    confirmPass.setEchoChar('*');
    contentPane.add(confirmPass);

    next3Button = new JButton("Next");
    next3Button.setBounds(758, 356, 70, 21);
    next3Button.setFocusable(false);
    contentPane.add(next3Button);

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
    EyeBtn2 = new JToggleButton(off);
    EyeBtn2.setBounds(827, 276, 35, 37);
    EyeBtn2.setBackground(new Color(0, 0, 0, 0));
    EyeBtn2.setForeground(new Color(0, 0, 0, 0));
    EyeBtn2.setOpaque(false);
    EyeBtn2.setBorder(BorderFactory.createEmptyBorder());
    Border EyeBtn2Border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    EyeBtn2.setBorder(EyeBtn2Border);
    contentPane.add(EyeBtn2);

    EyeBtn1 = new JToggleButton(off);
    EyeBtn1.setBounds(827, 224, 35, 37);
    EyeBtn1.setBackground(new Color(0, 0, 0, 0));
    EyeBtn1.setForeground(new Color(0, 0, 0, 0));
    EyeBtn1.setOpaque(false);
    EyeBtn1.setBorder(BorderFactory.createEmptyBorder());
    Border EyeBtnBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
    EyeBtn1.setBorder(EyeBtnBorder);
    contentPane.add(EyeBtn1);

    BufferedImage img = null;
    try {
      img = ImageIO.read(Objects.requireNonNull(Login.class.getResource("../images/Forget3.png")));

    } catch (IOException e) {
      e.printStackTrace();
    }
    assert img != null : "The 'Forget3' image could not be loaded";
    Image IMG = img.getScaledInstance(412, 354, Image.SCALE_SMOOTH);
    JLabel imgLbl = new JLabel(new ImageIcon(IMG));
    imgLbl.setBounds(30, 94, 412, 354);
    contentPane.add(imgLbl);

    EyeBtn1.addActionListener(this);
    EyeBtn2.addActionListener(this);
    next3Button.addActionListener(this);
    backButton.addActionListener(this);
    exitButton.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == next3Button) {
      int yesORno =
          JOptionPane.showConfirmDialog(
              null,
              "Are you sure You Want to Change Password?",
              "Alert!",
              JOptionPane.YES_NO_OPTION);

      if (yesORno == JOptionPane.YES_OPTION) {

        try {
          // Read the user_login.txt file
          File userfile = new File("./files/user_login.txt");
          if (userfile.exists()) {
            System.out.println("Reading Text From user_login.txt");
          }
          // Get the new password
          String newpass1 = String.valueOf(newPass.getPassword());
          boolean newpass3 = newpass1.isEmpty();

          // Get the confirmed password
          String confpass1 = String.valueOf(confirmPass.getPassword());
          String confpass2 = "Password : " + String.valueOf(confirmPass.getPassword());
          boolean confpass3 = confpass1.isEmpty();
          boolean check = newpass1.equals(confpass1);

          // Check for empty passwords
          if (newpass3 || confpass3) {
            JOptionPane.showMessageDialog(
                null, "Enter password", "Error", JOptionPane.WARNING_MESSAGE);
          } else if (!check) {
            // Check if passwords match
            JOptionPane.showMessageDialog(
                null, "Password not matching", "Error", JOptionPane.WARNING_MESSAGE);
          } else {
            String tempfile = "./files/temp.txt";
            File oldFile = new File("./files/user_login.txt");
            File newFile = new File("./files/temp.txt");
            System.out.println("temp file created");
            int l = 0;

            String currentline;

            // Write to the temp file
            FileWriter fileWriter = new FileWriter(tempfile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            FileReader fr = new FileReader("./files/user_login.txt");
            BufferedReader br = new BufferedReader(fr);

            int n = (ForgetPass.deleteLine) + 2;
            while ((currentline = br.readLine()) != null) {
              l++;
              if (n != l) {
                printWriter.println(currentline);
              } else {
                printWriter.println(confpass2); // Replace the line with the new password
                System.out.println("New password replace with old password");
              }
            }
            printWriter.flush();
            printWriter.close();
            fr.close();
            br.close();
            bufferedWriter.close();
            fileWriter.close();

            // Delete the old file and rename the temp file
            oldFile.delete();
            System.out.println("Original file deleted");
            File dumb = new File("./files/user_login.txt");
            newFile.renameTo(dumb);
            System.out.println("temp file rename to original file");
            // Close the current window and open the Login window
            this.setVisible(false);
            System.out.println("Exited from ForgetPass3 class");
            new Login();
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }

    } else if (e.getSource() == exitButton) {
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == 0) {
        System.out.println("Exited from ForgetPass3 class");
        System.out.println("Exited from the Project");
        System.exit(1);
      }
    } else if (e.getSource() == backButton) {
      this.setVisible(false);
      System.out.println("Exited from ForgetPass3 class");
      new ForgetPass();
    } else if (e.getSource() == EyeBtn2) {
      if (EyeBtn2.isSelected()) {
        EyeBtn2.setIcon(on);
        confirmPass.setEchoChar((char) 0); // Show the text entered in confirmPass
      } else {
        EyeBtn2.setIcon(off);
        confirmPass.setEchoChar('*'); // Hide the text entered in confirmPass with asterisks
      }
    } else if (e.getSource() == EyeBtn1) {
      if (EyeBtn1.isSelected()) {
        EyeBtn1.setIcon(on);
        newPass.setEchoChar((char) 0); // Show the text entered in newPass
      } else {
        EyeBtn1.setIcon(off);
        newPass.setEchoChar('*'); // Hide the text entered in newPass with asterisks
      }
    }
  }
}
