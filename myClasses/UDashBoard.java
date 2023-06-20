package myClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UDashBoard extends JFrame implements ActionListener {

  private static JButton checkIn_btn;
  private static JButton profile_btn;
  private static JButton checkOut_btn;
  private final JButton logoutBtn;

  public UDashBoard() {
    System.out.println("Currently in UDashBoard class");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("The Tipton Hotel Management");
    setBounds(100, 100, 927, 533);
    setLocationRelativeTo(null);
    JPanel contentPane = new JPanel();
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel WelcomeLbl = new JLabel("Welcome To Tipton");
    WelcomeLbl.setFont(new Font("Lucida Handwriting", Font.PLAIN, 35));
    WelcomeLbl.setForeground(Color.GRAY);
    WelcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
    WelcomeLbl.setBounds(254, 11, 389, 78);
    contentPane.add(WelcomeLbl);

    JPanel design_LG_panel = new JPanel();
    design_LG_panel.setBackground(Color.LIGHT_GRAY);
    design_LG_panel.setBounds(34, 0, 15, 494);
    contentPane.add(design_LG_panel);

    JPanel design_W_Panel = new JPanel();
    design_W_Panel.setBackground(Color.WHITE);
    design_W_Panel.setBounds(59, 0, 15, 494);
    contentPane.add(design_W_Panel);

    JPanel design_G_Panel = new JPanel();
    design_G_Panel.setBackground(Color.GRAY);
    design_G_Panel.setBounds(84, 0, 15, 494);
    contentPane.add(design_G_Panel);

    JPanel titleBack_panel = new JPanel();
    titleBack_panel.setBorder(null);
    titleBack_panel.setBounds(0, 11, 911, 78);
    contentPane.add(titleBack_panel);

    BufferedImage checkIn = null;
    BufferedImage checkOut = null;
    BufferedImage profile = null;
    try {
      checkIn =
          ImageIO.read(
              Objects.requireNonNull(UDashBoard.class.getResource("../images/UserCheckIn.png")));
      checkOut =
          ImageIO.read(
              Objects.requireNonNull(UDashBoard.class.getResource("../images/UserCheckOut.png")));
      profile =
          ImageIO.read(
              Objects.requireNonNull(UDashBoard.class.getResource("../images/UserProfile3.png")));
    } catch (IOException e) {
      e.printStackTrace();
    }

    checkIn_btn = new JButton("CheckButton");
    checkIn_btn.setBounds(109, 162, 170, 170);
    assert checkIn != null : "The 'UserCheckIn.png' image could not be loaded";
    Image chkIn =
        checkIn.getScaledInstance(
            checkIn_btn.getWidth(), checkIn_btn.getHeight(), Image.SCALE_SMOOTH);
    checkIn_btn.setIcon(new ImageIcon(chkIn));
    contentPane.add(checkIn_btn);

    profile_btn = new JButton("Profile");
    profile_btn.setBounds(408, 162, 170, 170);
    assert profile != null : "The 'UserProfile3.png' image could not be loaded";
    Image profileScaledInstance =
        profile.getScaledInstance(
            checkIn_btn.getWidth(), checkIn_btn.getHeight(), Image.SCALE_SMOOTH);
    profile_btn.setIcon(new ImageIcon(profileScaledInstance));
    contentPane.add(profile_btn);

    checkOut_btn = new JButton("checkOut");
    checkOut_btn.setBounds(695, 162, 170, 170);
    assert checkOut != null : "The 'UserCheckOut.png' image could not be loaded";
    Image chkOut =
        checkOut.getScaledInstance(
            checkOut_btn.getWidth(), checkOut_btn.getHeight(), Image.SCALE_SMOOTH);
    checkOut_btn.setIcon(new ImageIcon(chkOut));
    contentPane.add(checkOut_btn);

    JLabel chkIn_lbl = new JLabel("Check In");
    chkIn_lbl.setForeground(Color.GRAY);
    chkIn_lbl.setFont(new Font("Jokerman", Font.PLAIN, 26));
    chkIn_lbl.setHorizontalAlignment(SwingConstants.CENTER);
    chkIn_lbl.setBounds(109, 343, 170, 39);
    contentPane.add(chkIn_lbl);

    JLabel profile_lbl = new JLabel("Profile");
    profile_lbl.setHorizontalAlignment(SwingConstants.CENTER);
    profile_lbl.setForeground(Color.GRAY);
    profile_lbl.setFont(new Font("Jokerman", Font.PLAIN, 26));
    profile_lbl.setBounds(408, 343, 170, 39);
    contentPane.add(profile_lbl);

    JLabel chkOut_lbl = new JLabel("Check Out");
    chkOut_lbl.setHorizontalAlignment(SwingConstants.CENTER);
    chkOut_lbl.setForeground(Color.GRAY);
    chkOut_lbl.setFont(new Font("Jokerman", Font.PLAIN, 26));
    chkOut_lbl.setBounds(695, 343, 170, 39);
    contentPane.add(chkOut_lbl);

    logoutBtn = new JButton("Logout");
    logoutBtn.setBounds(780, 440, 85, 31);
    logoutBtn.setFocusable(false);
    contentPane.add(logoutBtn);

    logoutBtn.addActionListener(this);
    checkIn_btn.addActionListener(this);
    profile_btn.addActionListener(this);
    checkOut_btn.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == checkIn_btn) {
      setVisible(false);
      System.out.println("Exited from UDashBoard class");
      new UCheckIn();
    } else if (e.getSource() == profile_btn) {
      setVisible(false);
      System.out.println("Exited from UDashBoard class");
      new Profile();
    } else if (e.getSource() == checkOut_btn) {
      setVisible(false);
      System.out.println("Exited from UDashBoard class");
      new UCheckOut();
    } else if (e.getSource() == logoutBtn) {
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == JOptionPane.YES_OPTION) {
        setVisible(false);
        System.out.println("Exited from UDashBoard class");
        new Login();
      }
    }
  }
}
