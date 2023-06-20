package myClasses;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DashBoard extends JFrame implements ActionListener {
  // TODO table editable table changeable logout image

  private final JButton Manage_btn;
  private final JButton logoutButton;
  private final JButton checkinButton;
  private final JButton checkoutButton;

  public DashBoard() {
    System.out.println("Currently in DashBoard class");
    setResizable(false);
    setTitle("Admin dashboard");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 819, 580);
    setLocationRelativeTo(null);
    JPanel contentPane = new JPanel();
    contentPane.setForeground(Color.LIGHT_GRAY);
    contentPane.setBackground(Color.DARK_GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    logoutButton = new JButton("Log Out");
    logoutButton.setFocusable(false);
    logoutButton.setBounds(704, 15, 89, 23);
    contentPane.add(logoutButton);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(161, 49, 632, 481);
    contentPane.add(scrollPane);

    JTable table = new JTable();
    scrollPane.setViewportView(table);

    DefaultTableModel model =
        new DefaultTableModel(
            new Object[][] {},
            new String[] {"Customer Name", "Room Number", "Room Type", "Bed", "Price", "Status"});
    table.setModel(model);
    table.getTableHeader().setReorderingAllowed(false);
    table.setEnabled(false);

    model.setRowCount(0);

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

    try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (!line.equals("Rooms Details")) {
          String[] rowData = new String[6]; // create an array with 6 elements
          rowData[0] = ""; // set the first element to empty string
          rowData[1] = line; // add the second element to the Room Number column
          for (int i = 2; i < 6; i++) {
            // read the next 4 lines and add the data to the corresponding column
            rowData[i] = br.readLine();
          } // set the last element to empty string

          try (BufferedReader br2 = new BufferedReader(new FileReader("./files/checkIn.txt"))) {
            String line2;
            while ((line2 = br2.readLine()) != null) {
              if (!line2.equals("Check In Details")) {
                String[] rowData2 = new String[10]; // create an array with 10 elements
                rowData2[0] = line2; // Store the first line in the array
                for (int i = 1; i < 10; i++) { // Read the next 9 lines and store them in the array
                  rowData2[i] = br2.readLine();
                }

                if (rowData[1].equals(
                    rowData2[1])) { // Swap the first line with the matching row's first line
                  String temp = rowData2[0];
                  rowData[0] = temp;
                }

                br2.readLine(); // Skip a line
              }
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }

          model.addRow(rowData); // add the row to the JTable
          br.readLine(); // skip the empty lines
          br.readLine();
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    checkinButton = new JButton("Start Booking");
    checkinButton.setBounds(34, 150, 90, 70);
    checkoutButton = new JButton("Cancel Booking");
    checkoutButton.setBounds(34, 271, 90, 70);

    // Load check-in, check-out, and room management images
    BufferedImage checkIn = null;
    BufferedImage checkOut = null;
    BufferedImage mngRoomPhoto = null;
    try { // Load the images
      checkIn =
          ImageIO.read(
              Objects.requireNonNull(DashBoard.class.getResource("../images/check_in.png")));
      checkOut =
          ImageIO.read(
              Objects.requireNonNull(DashBoard.class.getResource("../images/check_out.png")));
      mngRoomPhoto =
          ImageIO.read(Objects.requireNonNull(DashBoard.class.getResource("../images/room.png")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Assert that images are successfully loaded
    assert checkIn != null : "'check_in.png' not found";
    assert checkOut != null : "'check_out.png' not found";
    // Scale check-in image to fit the button size
    Image chkIn =
        checkIn.getScaledInstance(
            checkinButton.getWidth(), checkinButton.getHeight(), Image.SCALE_SMOOTH);
    // Scale check-out image to fit the button size
    Image chkOut =
        checkOut.getScaledInstance(
            checkoutButton.getWidth(), checkoutButton.getHeight(), Image.SCALE_SMOOTH);

    checkinButton.setIcon(new ImageIcon(chkIn));
    checkinButton.setForeground(Color.WHITE);
    checkinButton.setBackground(Color.DARK_GRAY);

    checkoutButton.setIcon(new ImageIcon(chkOut));
    checkoutButton.setForeground(Color.WHITE);
    checkoutButton.setBackground(Color.DARK_GRAY);

    contentPane.add(checkinButton);
    contentPane.add(checkoutButton);

    JTextField chkField_2 = new JTextField();
    chkField_2.setHorizontalAlignment(SwingConstants.CENTER);
    chkField_2.setBorder(null);
    chkField_2.setText("Check Out");
    chkField_2.setForeground(Color.WHITE);
    chkField_2.setBackground(Color.DARK_GRAY);
    chkField_2.setBounds(34, 349, 89, 20);
    contentPane.add(chkField_2);
    chkField_2.setColumns(10);

    JTextField textField = new JTextField();
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setText("Check In");
    textField.setForeground(Color.WHITE);
    textField.setColumns(10);
    textField.setBorder(null);
    textField.setBackground(Color.DARK_GRAY);
    textField.setBounds(34, 216, 89, 23);
    contentPane.add(textField);

    Manage_btn = new JButton("Manage Room");
    Manage_btn.setBounds(34, 379, 90, 70);
    assert mngRoomPhoto != null : "'room.png' not found";
    Image mngRoom =
        mngRoomPhoto.getScaledInstance(
            Manage_btn.getWidth(), Manage_btn.getHeight(), Image.SCALE_SMOOTH);
    Manage_btn.setIcon(new ImageIcon(mngRoom));
    Manage_btn.setForeground(Color.WHITE);
    Manage_btn.setBackground(Color.DARK_GRAY);
    contentPane.add(Manage_btn);

    JTextField manage_lbl = new JTextField();
    manage_lbl.setText("Manage Room");
    manage_lbl.setHorizontalAlignment(SwingConstants.CENTER);
    manage_lbl.setForeground(Color.WHITE);
    manage_lbl.setColumns(10);
    manage_lbl.setBorder(null);
    manage_lbl.setBackground(Color.DARK_GRAY);
    manage_lbl.setBounds(34, 459, 89, 20);
    contentPane.add(manage_lbl);

    logoutButton.addActionListener(this);
    checkinButton.addActionListener(this);
    checkoutButton.addActionListener(this);
    Manage_btn.addActionListener(this);

    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == logoutButton) { // Prompt user for confirmation before logging out
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno
          == JOptionPane
              .YES_OPTION) { // If user confirms, hide current window and open Login window
        this.setVisible(false);
        System.out.println("Exited from DashBoard class");
        new Login();
      }
    } else if (e.getSource() == checkinButton) {
      setVisible(false);
      System.out.println("Exited from DashBoard class");
      new CheckIn();
    } else if (e.getSource() == checkoutButton) {
      setVisible(false);
      System.out.println("Exited from DashBoard class");
      new CheckOut();
    } else if (e.getSource() == Manage_btn) {
      setVisible(false);
      System.out.println("Exited from DashBoard class");
      new ManageRoom();
    }
  }
}
