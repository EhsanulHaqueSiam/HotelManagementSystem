package myclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ShowRoom {

  /**
   * Retrieves room details based on selected criteria.
   *
   * @param cost_fld JTextField to display the room cost.
   * @param bed_Box JComboBox for selecting bed type.
   * @param roomType_Box JComboBox for selecting room type.
   * @param roomNo_Box JComboBox to populate available room numbers.
   */
  public void roomDetails(
      JTextField cost_fld,
      JComboBox<String> bed_Box,
      JComboBox<String> roomType_Box,
      JComboBox<String> roomNo_Box) {

    System.out.println("roomDetails Funtion called from Show room class");
    String bed = (String) bed_Box.getSelectedItem();
    String roomtype = (String) roomType_Box.getSelectedItem();

    roomNo_Box.removeAllItems();
    cost_fld.setText(null);

    try (BufferedReader br = new BufferedReader(new FileReader("./files/rooms.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.equals("Rooms Details")) {
          String[] rowData = new String[5]; // create an array with 5 elements
          for (int i = 0; i < 5; i++) {
            // read the next 5 lines and add the data to the corresponding column
            rowData[i] = br.readLine();
          }
          if (rowData[1].equals(roomtype)
              && rowData[2].equals(bed)
              && rowData[4].equals("Not Booked")) {
            roomNo_Box.addItem(rowData[0]); // add the room number to the combo
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("roomDetails funtion ran successfully");
  }
}
