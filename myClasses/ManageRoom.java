package myClasses;

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
import javax.swing.DefaultComboBoxModel;
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

public class ManageRoom extends JFrame implements ActionListener {
  // TODO Table data edit and table shift

  private final JTable table;
  private final JTextField roomNum_fld;
  private final JTextField price_fld;
  private final JButton logOut_btn;
  private final JButton back_btn;
  private final JButton add_btn;
  private final JButton del_btn;
  private final JComboBox<String> roomType_box;
  private final JComboBox<String> bed_box;

  public ManageRoom() {
    System.out.println("Currently in ManageRoom class");
    setResizable(false);
    setTitle("Admin manage room");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    back_btn = new JButton("Back");
    back_btn.setBounds(702, 11, 89, 23);
    back_btn.setFocusable(false);
    contentPane.add(back_btn);

    JLabel manageRoom_lbl = new JLabel("Manage Room");
    manageRoom_lbl.setForeground(Color.LIGHT_GRAY);
    manageRoom_lbl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    manageRoom_lbl.setBounds(10, 3, 180, 34);
    contentPane.add(manageRoom_lbl);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(22, 91, 536, 366);
    contentPane.add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);

    DefaultTableModel model =
        new DefaultTableModel(
            new Object[][] {},
            new String[] {"Room Number", "Room Type", "Bed", "Price", "Status"}) {
          @Override
          public boolean isCellEditable(int row, int column) {
            return false; // Make all cells non-editable
          }
        };

    table.getTableHeader().setReorderingAllowed(false);
    table.setModel(model);
    table.getColumnModel().getColumn(0).setPreferredWidth(80);
    table.getColumnModel().getColumn(1).setPreferredWidth(82);

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
            // Customize selection colors
            if (isSelected) {
              component.setBackground(Color.RED); // Set red background for selected row
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
          String[] rowData = new String[5]; // create an array with 5 elements
          rowData[0] = line; // add the first element to the Room Number column
          for (int i = 1; i < 5; i++) {
            // read the next 4 lines and add the data to the corresponding column
            rowData[i] = br.readLine();
          }
          model.addRow(rowData); // add the row to the JTable
          br.readLine();
          br.readLine();
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    JLabel roomNumber_lbl = new JLabel("Room Number");
    roomNumber_lbl.setForeground(Color.BLACK);
    roomNumber_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
    roomNumber_lbl.setBounds(631, 86, 89, 23);
    contentPane.add(roomNumber_lbl);

    roomNum_fld = new JTextField();
    roomNum_fld.setBounds(631, 121, 151, 20);
    contentPane.add(roomNum_fld);
    roomNum_fld.setColumns(10);

    JLabel roomType_lbl = new JLabel("Room Type");
    roomType_lbl.setForeground(Color.BLACK);
    roomType_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
    roomType_lbl.setBounds(631, 152, 72, 23);
    contentPane.add(roomType_lbl);

    roomType_box = new JComboBox<>();
    roomType_box.setModel(new DefaultComboBoxModel<>(new String[] {"AC", "Non-Ac"}));
    roomType_box.setBounds(631, 186, 156, 22);
    contentPane.add(roomType_box);

    JLabel bed_lbl = new JLabel("Bed");
    bed_lbl.setForeground(Color.BLACK);
    bed_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
    bed_lbl.setBounds(631, 220, 72, 23);
    contentPane.add(bed_lbl);

    bed_box = new JComboBox<>();
    bed_box.setModel(new DefaultComboBoxModel<>(new String[] {"Single", "Double", "Triple"}));
    bed_box.setBounds(631, 248, 156, 22);
    contentPane.add(bed_box);

    JLabel price_lbl = new JLabel("Price");
    price_lbl.setForeground(Color.BLACK);
    price_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
    price_lbl.setBounds(631, 281, 97, 26);
    contentPane.add(price_lbl);

    price_fld = new JTextField();
    price_fld.setColumns(10);
    price_fld.setBounds(631, 318, 160, 20);
    contentPane.add(price_fld);

    add_btn = new JButton("Add Room");
    add_btn.setBounds(631, 382, 111, 34);
    add_btn.setFocusable(false);
    contentPane.add(add_btn);

    del_btn = new JButton("Remove Room");
    del_btn.setBounds(760, 382, 120, 34);
    del_btn.setFocusable(false);
    contentPane.add(del_btn);

    logOut_btn.addActionListener(this);
    back_btn.addActionListener(this);
    add_btn.addActionListener(this);
    del_btn.addActionListener(this);

    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Get the input values from the text fields and combo boxes
    String romNum = roomNum_fld.getText(); // Room number
    String romType = (String) roomType_box.getSelectedItem(); // Room type
    String bed = (String) bed_box.getSelectedItem(); // Bed type
    String price = price_fld.getText().trim(); // Room price

    // Check if room number and price fields are empty
    boolean romNumEmpty = roomNum_fld.getText().isEmpty();
    boolean priceEmpty = price_fld.getText().isEmpty();

    if (e.getSource() == logOut_btn) {
      // Prompt for confirmation before logging out
      int yesORno =
          JOptionPane.showConfirmDialog(
              null, "Are you sure ?", "Alert!", JOptionPane.YES_NO_OPTION);

      if (yesORno == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        System.out.println("Exited from ManageRoom class");
        new Login();
      }
    } else if (e.getSource() == back_btn) {
      setVisible(false);
      System.out.println("Exited from ManageRoom class");
      new DashBoard();
    } else if (e.getSource() == add_btn) {
      // Check if room number and price are not empty
      if (!romNumEmpty && !priceEmpty) {
        boolean flag = false;
        try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
          String line;
          // Check if the room number already exists in the file
          System.out.println("Checking if room number already exists");
          while ((line = br.readLine()) != null) {
            if (line.equals(roomNum_fld.getText())) {
              flag = true;
              break;
            }
          }

          if (flag) {
            System.out.println("Room number already exists");
          } else {
            System.out.println("Room number available to add");
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        if (flag) {
          // Display a warning message if the room number already exists
          JOptionPane.showMessageDialog(
              null, "Room number already exist", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (!price.matches("\\d+")) {
          JOptionPane.showMessageDialog(
              null, "Invalid Price", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
          try {
            String line = "./files/rooms.txt";
            try {
              File file = new File(line);
              if (!file.exists()) {
                file.createNewFile();
                // Append data to the file
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.close();
              }

              BufferedReader rdfile3 = new BufferedReader(new FileReader("./files/rooms.txt"));
              int ttlLines3 = 0;
              while (rdfile3.readLine() != null) {
                ttlLines3++;
              }
              rdfile3.close();

              // Append room details to the file
              FileWriter fileWriter = new FileWriter(file, true);
              BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
              PrintWriter printWriter = new PrintWriter(bufferedWriter);
              printWriter.println("Rooms Details");
              printWriter.println(romNum);
              printWriter.println(romType);
              printWriter.println(bed);
              printWriter.println(price);
              printWriter.println("Not Booked");
              printWriter.println();
              printWriter.close();

              // Clear text fields
              roomNum_fld.setText(null);
              price_fld.setText(null);

              System.out.println("New Room added");

            } catch (Exception ex) {
              ex.printStackTrace();
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      } else {
        // Display a warning message if any box is not filled
        JOptionPane.showMessageDialog(
            null, "Please Fill all the box", "Error", JOptionPane.WARNING_MESSAGE);
      }
      DefaultTableModel model = (DefaultTableModel) table.getModel();
      model.setRowCount(0);

      try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
          if (!line.equals("Rooms Details")) {
            String[] rowData = new String[5]; // create an array with 5 elements
            rowData[0] = line; // add the first element to the Room Number column
            for (int i = 1; i < 5; i++) {
              // read the next 4 lines and add the data to the corresponding column
              rowData[i] = br.readLine();
            }
            model.addRow(rowData); // add the row to the JTable
            br.readLine(); // skip two empty lines
            br.readLine();
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (e.getSource() == del_btn) {
      if (JOptionPane.showConfirmDialog(
              null, "Confirmation", "Remove This Room?", JOptionPane.YES_NO_OPTION)
          == JOptionPane.YES_OPTION) {
        DefaultTableModel tempTbl = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();

        // Check if a row is selected
        if (table.getSelectedRow() != -1) {

          // Get data from the selected row
          String[] data = new String[5];
          for (int i = 0; i < 5; i++) {
            data[i] = tempTbl.getValueAt(selectedRow, i).toString();
          }

          // Check if the room is not booked
          if (data[4].equals("Not Booked")) {
            try {
              File inputFile = new File("./files/rooms.txt");
              File tempFile = new File("./files/rooms_temp.txt");
              System.out.println("temp file created");

              // Read the original file and write to the temp file, excluding the room to delete
              BufferedReader reader = new BufferedReader(new FileReader(inputFile));
              BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
              System.out.println("temp file updated");

              String currentLine;
              int lineCounter = 0;
              while ((currentLine = reader.readLine()) != null) {
                lineCounter++;
                if (currentLine.contains(data[0])) {
                  break;
                  // skip the lines that contain the room number to delete
                }
              }

              reader.close();
              reader = new BufferedReader(new FileReader(inputFile));
              int k = 0;
              while ((currentLine = reader.readLine()) != null) {
                k++;
                if (k > (lineCounter - 2) && k < (lineCounter + 6)) {
                } else {
                  // write all other lines to the temp file
                  writer.write(currentLine + System.getProperty("line.separator"));
                }
              }

              System.out.println("Room deleted");

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
            // Remove the selected row from the table
            tempTbl.removeRow(table.getSelectedRow());
          } else {
            JOptionPane.showMessageDialog(this, "Room is Booked Please check out it first");
          }

        } else {
          if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Table is Empty!");

          } else {
            JOptionPane.showMessageDialog(this, "Please select A row to delete ");
          }
        }
      }
    }
  }
}
