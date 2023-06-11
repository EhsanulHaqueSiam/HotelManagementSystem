# HotelManagementSystem 🏨💻

This repository contains the collaborative project called HotelManagementSystem, which is our first project. It is a comprehensive hotel management system designed to streamline operations and enhance the guest experience.

## Collaboration 👥

- [Md Ehsanul Haque](https://github.com/EhsanulHaqueSiam) - Student ID: 22-49370-3 🎓
- [Aonyendo Paul Neteish](https://github.com/NitPaul) - Student ID: 22-49421-3 🎓

Special thanks to our Java faculty, **Rashidul Hasan Nabil**, for guiding and inspiring us throughout this project.

## Project Description 📜

The HotelManagementSystem project utilizes various classes and interfaces to handle different functionalities within a hotel. The classes and their relationships are depicted in the Mermaid graph below:

```mermaid
classDiagram
direction BT
class BkashPayment {
  ~ JLabel bkash_lbl
  ~ JButton back_btn
  ~ JButton next_btn
  ~ JPasswordField pass_fld
  ~ JTextField num_fld
  + inputValidation(JTextField, JPasswordField) boolean
  + actionPerformed(ActionEvent) void
  + inputLength(JTextField, JPasswordField) boolean
  + confirmPayment(boolean, boolean, JFrame, JTextField, JPasswordField) void
}
class CheckIn {
  + String roomNo
  - JTextField gmail_fld
  - JButton clear_btn
  - JTextField cost_fld
  - JTextField date_fld
  - JTextField name_field
  - JTextField address_fld
  - JButton confirm_btn
  - JComboBox~String~ bed_Box
  - JFrame frame
  - JComboBox~String~ gender_Box
  - JTextField nationality_fld
  - JComboBox~String~ roomNo_Box
  - JTextField mbl_fld
  - JButton back_btn
  - JComboBox~String~ roomType_Box
  - JButton logOut_Btn
  + actionPerformed(ActionEvent) void
  + WriteCheckinData(String, String, String, String, String, String, String, File, String, String) void
}
class CheckOut {
  ~ String roomNo_B
  - JTextField CustomerNum_fld
  - JTextField pricePerDay_fld
  ~ String name
  ~ String CheckinDate
  - JButton logOut_btn
  - JButton back_btn
  ~ String roomPrice
  ~ String bed
  ~ String gender
  ~ String address
  - JTextField totalAmount_fld
  - JComboBox~String~ search_combo
  - JTable table
  ~ String gmail
  - JTextField checkInDate_fld
  - JTextField dayStay_fld
  ~ String nationality
  - JTextField CustomerName_fld
  - JTextField email_fld
  - JButton clear_btn
  - JButton checkOut_btn
  ~ String mobileNumber
  ~ String roomType
  ~ String roomNumToDelete
  + roomSearch() void
  + deleteRoomEntry() void
  + getCustomerData() void
  + actionPerformed(ActionEvent) void
}
class CheckOutRoomSearch {
<<Interface>>
  + deleteRoomEntry() void
}
class ClearCheckOut {
<<Interface>>
  + ClearCheckoutField(JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, JTextField, JComboBox~String~, JTable) void
}
class ConfirmPayment {
<<Interface>>
  + inputLength(JTextField, JPasswordField) boolean
  + confirmPayment(boolean, boolean, JFrame, JTextField, JPasswordField) void
  + inputValidation(JTextField, JPasswordField) boolean
}
class CustomerDataEntry {
<<Interface>>
  + getCustomerData() void
}
class DashBoard {
  - JButton Manage_btn
  - JButton logoutButton
  - JButton checkoutButton
  - JButton checkinButton
  + actionPerformed(ActionEvent) void
}
class Edit {
  - JButton exitButton
  - JTextField userField
  - JButton backButton
  - JButton logoutButton
  - JButton usernameButton
  - JLabel user
  - JTextField fullField
  - JButton confirmButton1
  - JButton fullNameButton
  - JButton confirmButton3
  - JButton phoneButton
  - int check
  - JTextField phoneField
  - JLabel full
  - JLabel phone
  - JButton confirmButton2
  + isValidFullname(String) boolean
  + actionPerformed(ActionEvent) void
}
class ForgetPass {
  - JButton backButton
  - JButton next
  # int deleteLine
  - JTextField userField
  - JButton exitButton
  + actionPerformed(ActionEvent) void
}
class ForgetPass2 {
  - JTextField phoneField
  - JButton backButton
  - JButton next2
  - JButton exitButton
  + actionPerformed(ActionEvent) void
}
class ForgetPass3 {
  - JButton NextButton
  - JPasswordField newPass
  - JToggleButton EyeBtn2
  - ImageIcon off
  - JPasswordField confirmPass
  - JButton exitButton
  - JButton backButton
  - JToggleButton EyeBtn1
  - ImageIcon on
  + actionPerformed(ActionEvent) void
}
class Login {
  + String USERNAME
  # String fullName
  - JButton loginButton
  - ImageIcon on
  # boolean loginFlag
  # String oldPassword
  - JToggleButton EyeBtn
  # String phoneNumber
  - JButton exitButton
  - ImageIcon off
  - JButton signup
  - JPasswordField passwordField
  - JButton forgot
  # boolean isAdmin
  # String fullUsername
  - JTextField usernameField
  + getloginFlag() boolean
  + actionPerformed(ActionEvent) void
}
class Main {
  + main(String[]) void
}
class ManageRoom {
  - JTextField roomNum_fld
  - JComboBox~String~ bed_box
  - JButton logOut_btn
  - JButton del_btn
  - JButton add_btn
  - JTable table
  - JComboBox~String~ roomType_box
  - JButton back_btn
  - JTextField price_fld
  + actionPerformed(ActionEvent) void
}
class NagadPayment {
  ~ JButton next_btn
  ~ JTextField num_fld
  ~ JLabel bkash_lbl
  ~ JButton back_btn
  ~ JPasswordField pass_fld
  + actionPerformed(ActionEvent) void
}
class Payment {
  ~ JButton next_btn
  ~ JRadioButton bkash_btn
  ~ ButtonGroup bkashNagad_grp
  ~ JRadioButton nagad_btn
  ~ JLabel payment_lbl
  + actionPerformed(ActionEvent) void
}
class Profile {
  - JButton editButton
  - JButton backButton
  - JButton exitButton
  - JButton logoutButton
  + actionPerformed(ActionEvent) void
}
class ShowRoom {
  + roomDetails(JTextField, JComboBox~String~, JComboBox~String~, JComboBox~String~) void
}
class Signup {
  - JTextField usernameField
  - ImageIcon on
  - JPasswordField confirmPassField
  - JButton signup
  - JTextField fullField
  - ImageIcon off
  - JButton signin
  - JPasswordField passwordField
  - JButton exitButton
  - JToggleButton EyeBtn
  - JTextField phoneNumberField
  - JToggleButton EyeBtn2
  + actionPerformed(ActionEvent) void
  + isValidFullname(String) boolean
}
class UCheckIn {
  - String fullName
  - JTextField mbl_fld
  - JTextField nationality_fld
  - JTextField gmail_fld
  - JTextField address_fld
  - String MobileNumber
  - JComboBox~String~ roomType_Box
  - JComboBox~String~ roomNo_Box
  - JTextField name_field
  - JButton logOut_Btn
  - JButton clear_btn
  - JButton confirm_btn
  - JComboBox~String~ bed_Box
  + String roomNo
  - JTextField cost_fld
  - JButton back_btn
  - JFrame frame
  - JComboBox~String~ gender_Box
  - JTextField date_fld
  + WriteCheckinData(String, String, String, String, String, String, String, File, String, String) void
  + actionPerformed(ActionEvent) void
}
class UCheckOut {
  - JTextField customerName_fld
  - JTextField checkOut_fld
  - JButton logOut_btn
  - JButton back_btn
  ~ String MobileNumber
  - JTextField checkInDate_fld
  - JTextField pricePerDay_fld
  - JComboBox~String~ roomNum_combo
  ~ String bed
  ~ String roomPrice
  - JTextField totalAmount_fld
  ~ String gender
  - JTextField customerNum_fld
  - JButton clear_btn
  ~ String address
  - DefaultTableModel model
  ~ String gmail
  ~ String roomNo_B
  ~ String CheckInDate
  - JTextField dayStay_fld
  - JTextField email_fld
  ~ String nationality
  ~ String roomType
  ~ String name
  - JButton checkOut_btn
  - JTable table
  ~ String nameLogin
  + actionPerformed(ActionEvent) void
  + getCustomerData() void
  + deleteRoomEntry() void
}
class UDashBoard {
  - JButton checkOut_btn
  - JButton profile_btn
  - JButton logoutBtn
  - JButton checkIn_btn
  + actionPerformed(ActionEvent) void
}
class WriteCheckInInfo {
<<Interface>>
  + WriteCheckinData(String, String, String, String, String, String, String, File, String, String) void
}

BkashPayment  ..>  ConfirmPayment 
CheckIn  -->  ShowRoom 
CheckIn  ..>  WriteCheckInInfo 
CheckOut  ..>  CheckOutRoomSearch 
CheckOut  ..>  ClearCheckOut 
CheckOut  ..>  CustomerDataEntry 
NagadPayment  ..>  ConfirmPayment 
UCheckIn  -->  ShowRoom 
UCheckIn  ..>  WriteCheckInInfo 
UCheckOut  ..>  CheckOutRoomSearch 
UCheckOut  ..>  CustomerDataEntry 


```

The classes and interfaces in this project serve various purposes, including managing payments (💸 BkashPayment, 💸 NagadPayment, 💸 ConfirmPayment), handling check-in and check-out processes (🛎️ CheckIn, 🛎️ CheckOut, 🛎️ CheckOutRoomSearch, 🛎️ ClearCheckOut, 🛎️ CustomerDataEntry, 🛎️ WriteCheckInInfo), providing user interfaces (🖥️ DashBoard, ✏️ Edit, 🔑 ForgetPass, 🔑 ForgetPass2, 🔑 ForgetPass3, 🔑 Login, 🏠 Main, 🛏️ ManageRoom, 💰 Payment, 👤 Profile, 📄 ShowRoom, ✏️ Signup, 🛎️ UCheckIn, 🛎️ UCheckOut, 🖥️ UDashBoard), and more.

This project aims to demonstrate the practical implementation of object-oriented programming principles, guided by the expertise of our Java faculty, **Rashidul Hasan Nabil**. It provides a solid foundation for further development and enhancement.

Feel free to explore the source code and contribute to the project to make it even more robust and feature-rich. Happy coding! 🚀👩‍💻👨‍💻

Certainly! Here's the same content rewritten in Markdown format for your README file:

## Disclaimer 📜

Please note that this project has the following limitations:

- No dedicated database: Instead of using a dedicated database like SQL or NoSQL, this project utilizes a simple text file as the database. All data will be stored and accessed from the text file.

- JavaFX not implemented: This project exclusively uses Java Swing for the user interface. JavaFX is not utilized in any part of the application.

## Installation 🛠️

Follow these steps to install and run the Hotel Management System:

1. Clone the repository to your local machine:
   ```
   git clone https://github.com/EhsanulHaqueSiam/HotelManagementSystem.git
   ```

2. Navigate to the project directory:
   ```
   cd HotelManagementSystem
   ```

3. Compile the `Main.java` file using `javac`:
   ```
   javac Main.java
   ```

4. Run the application by executing the compiled `Main` class:
   ```
   java Main
   ```

5. The Hotel Management System should now be up and running. Follow the on-screen instructions to interact with the application.

# Contributors 👥

Thanks to all the people who contribute. [[Contributors](https://github.com/EhsanulHaqueSiam/HotelManagementSystem/graphs/contributors)].

<a href="https://github.com/EhsanulHaqueSiam/HotelManagementSystem/graphs/contributors"><img src="https://contributors-img.web.app/image?repo=EhsanulHaqueSiam/HotelManagementSystem" /></a>
## Usage 📝

Once the application is running, you can perform various tasks such as managing hotel bookings, checking room availability, and more. Please refer to the application's user documentation for detailed instructions on how to use the system.

## Screenshots 📷

Discover the ultimate Hotel Management system in our captivating title screenshot. With a user-friendly Login Page, Sign Up, and Forget Password options, guests and staff can effortlessly access their accounts. The User Dashboard and Admin Dashboard provide intuitive interfaces for managing reservations, check-ins, check-outs, and payments. Experience streamlined operations with Admin Room Management, ensuring optimal room allocation and maintenance. Prepare for a new era of efficiency and exceptional guest experiences with our Hotel Management project.

<details>
  <summary>Click to expand</summary>
  
  <div align="center">
    <p><a href="#screenshots-">Login Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129465-c2478b2f-e73e-4d96-952a-61317cc7c8a6.png" alt="Login Page">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">SignUp Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128418-56ed93c4-11cc-474d-8c16-6c3534699fa3.png" alt="SignUp Page">
  </div>

<div align="center">
    <p><a href="#screenshots-">Reset Password Page 1</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128697-d1766cdc-5c50-4136-bf1d-34a495bc2bbb.png" alt="Reset Password Page 1">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Reset Password Page 2</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128742-30944029-8ce8-4bd7-a7f9-96ee4aa4ca3d.png" alt="Reset Password Page 2">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Reset Password Page 3</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128843-816393fd-019e-49e1-be37-bbc2a3d154f6.png" alt="Reset Password Page 3">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">User DasBoard Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128853-bee0f571-cda6-446c-bd5e-62d7c70d0b4f.png" alt="User DasBoard">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">User Profile</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128904-1f585bcc-c1e4-466f-8374-6e7a0f2d0e0e.png" alt="User Profile">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">User Information Edit Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128935-296613c9-8654-4921-be27-dd92bff455e3.png" alt="Information Edit">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">User ChechIn Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243128973-f3a5b514-aaa5-4523-b169-01cd989773d2.png" alt="User CheckIn">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">User CheckOut Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129078-103b9174-3e0e-4521-aece-ab2a55f8f48d.png" alt="User CheckOut">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Payment Option Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129152-68da9f1a-3801-453c-8042-5d2b2ef992c1.png" alt="Payment Option Page">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Bkash Payment Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129194-b39f10ef-507c-4d1a-854a-95e3b2667e26.png" alt="Bkash Payment">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Nagad Payment Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129316-e1bb235f-e0b2-4f88-9f93-78a6e4821f8c.png" alt="Nagad Payment">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Admin DashBoard Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129353-cffb33a9-b030-44d4-b79b-574229aebfb3.png" alt="Admin DashBoard">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Manage Room Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129365-9bd4d3eb-b154-4c10-a583-fbb9cc5aafb3.png" alt="Manage Room">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Admin CheckIn page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129403-6501bfa0-b84f-4c38-bb3c-be2332c008c8.png" alt="Admin CheckIn">
  </div>
  
  <div align="center">
    <p><a href="#screenshots-">Admin CheckOut Page</a></p>
    <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/116294325/243129445-7fe75df4-ae18-4b68-81a9-431c1d8d9eaa.png" alt="Admin CheckOut">
  </div>
  
  </details>
