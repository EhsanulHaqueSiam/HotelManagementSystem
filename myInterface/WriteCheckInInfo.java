package myInterface;

import java.io.File;
import java.io.IOException;

public interface WriteCheckInInfo {
  // Interface for writing check-in information to a file

  /**
   * Writes check-in data to a file.
   *
   * @param nationality the nationality of the guest
   * @param gmail the email address of the guest
   * @param address the address of the guest
   * @param CheckInDate the check-in date of the guest
   * @param cost the cost of the room
   * @param gender the gender of the guest
   * @param roomNo_B the room number or identifier
   * @param file the file to write the data into
   * @param fullName the full name of the guest
   * @param mobileNumber the mobile number of the guest
   * @throws IOException if an I/O error occurs while writing the data
   */
  void WriteCheckinData(
      String nationality,
      String gmail,
      String address,
      String CheckInDate,
      String cost,
      String gender,
      String roomNo_B,
      File file,
      String fullName,
      String mobileNumber)
      throws IOException;
}
