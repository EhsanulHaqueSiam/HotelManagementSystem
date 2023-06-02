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

## Disclaimer

Please note that this project has the following limitations:

- No dedicated database: Instead of using a dedicated database like SQL or NoSQL, this project utilizes a simple text file as the database. All data will be stored and accessed from the text file.

- JavaFX not implemented: This project exclusively uses Java Swing for the user interface. JavaFX is not utilized in any part of the application.

## Installation

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

# Contributors

Thanks to all the people who contribute. [[Contributors](https://github.com/EhsanulHaqueSiam/HotelManagementSystem/graphs/contributors)].

<a href="https://github.com/EhsanulHaqueSiam/HotelManagementSystem/graphs/contributors"><img src="https://contributors-img.web.app/image?repo=EhsanulHaqueSiam/HotelManagementSystem" /></a>
## Usage

Once the application is running, you can perform various tasks such as managing hotel bookings, checking room availability, and more. Please refer to the application's user documentation for detailed instructions on how to use the system.

<details>
  <summary>Click to expand screenshots of the project</summary>
  
  <div align="center">
    <p>Login Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/6750ea53937ed54b9b4e766f97ef5b10.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T195714Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=8a949a8fa5be823459bcd592428b760d28203b08edbf77023b43b15c0c11ffa0" alt="Login Page">
  </div>
  
  <div align="center">
    <p>SignUp Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/bba49005ab1f8566163f0a52d332da1f.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T200927Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=18efb5fd71de31f6c720dda588a024ffc1ad1dd309c3b4bc987388228cf7c84f" alt="SignUp Page">
  </div>

<div align="center">
    <p>Reset Password Page 1</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/a261d4db07e7440985f7c7625fedb6dd.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T204530Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=c8674c8d6bd0ab4814070d34c050098be5455439b78563c31cbdd825cd464318" alt="Reset Password Page 1">
  </div>
  
  <div align="center">
    <p>Reset Password Page 2</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/f1a52ae8c6874c68a81606bc9d3f5fa5.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T204931Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=a0d5f00d8785ff5da89e990387103c70b8082d258ed4ec9073d268557b51d802" alt="Reset Password Page 2">
  </div>
  
  <div align="center">
    <p>Reset Password Page 3</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/892c88dc4e2a2e1b1256893417ad213c.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205109Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=939f18f17ca3bbcb87136bdee06a30fa94fedb7562569fe19c73c9d519014cc2" alt="Reset Password Page 3">
  </div>
  
  <div align="center">
    <p>User DasBoard Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/6f5469faca448ac2d203b2ec1d7adc17.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205127Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=31fd183e89cb9d75d6ca859671760746e55dc6650a29d4bc689733bca779dbd9" alt="User DasBoard">
  </div>
  
  <div align="center">
    <p>User Profile</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/811092918ab23e4167756737812f5033.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205219Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=b71c4aa32a280bf97ce6b961b5509aff977b9022dbf856cd9891f9361ad620dc" alt="User Profile">
  </div>
  
  <div align="center">
    <p>User Information Edit Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/6dcd3d4b3e99afa932b2e37ef0ffeec1.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205314Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=30348b8ed87e732d7fd0060055ec7e2e2fde3319379ea01353e999c57d56aaa3" alt="Information Edit">
  </div>
  
  <div align="center">
    <p>User ChechIn Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/e27db128643160752b6f896cf78bcfe0.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205359Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=dbf9fda9cb212e48b9e1307db23a36ba64a5ed3cd313e8e8f0c474b7541586c8" alt="User CheckIn">
  </div>
  
  <div align="center">
    <p>User CheckOut Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/d5a1b00e868c57bb0444fb31a38333f4.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205523Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=226c280acba76c6b698f65e33fd0e37b5389f812853de90cbc7c67a030c2f3d6" alt="User CheckOut">
  </div>
  
  <div align="center">
    <p>Payment Option Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/228dd0bb4fde635a8a41a7a2f02d0130.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205611Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=6697eb667f78aa288de52fdb9ddf7a798352c247fff11873495991270df49261" alt="Payment Option Page">
  </div>
  
  <div align="center">
    <p>Bkash Payment Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/1035130c1a4477854f603a407db13e3e.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205709Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=e1cb4302be319af250cb036b5721443da384504dcc9aaaf7b96bdc8cc4e8c655" alt="Bkash Payment">
  </div>
  
  <div align="center">
    <p>Nagad Payment Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/a69ff4858cda5e18f4ea22733cb30159.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205821Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=02d5ab8d2ae52a7c809cc9d474253422d2ffd9a05cf6bd118ae937fb193a7f95" alt="Nagad Payment">
  </div>
  
  <div align="center">
    <p>Admin DashBoard Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/91fdc604e0a64dfb2f6e708cb5a1085e.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205839Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=97ce985ef423b4af0ef6a8eeda6a2cf6a3e8ce55662c111508cd2a6e8077060b" alt="Admin DashBoard">
  </div>
  
  <div align="center">
    <p>Manage Room Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/fda936c1f5ccd062471486dc83937842.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T205920Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=5adc1fc8e7f9db976a6952bb71d2998b3b78cedb178ef15759d23d459deef97f" alt="Manage Room">
  </div>
  
  <div align="center">
    <p>Admin CheckIn page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/fdf9fce4a2378c945918f79c101c485a.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T210005Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=16881f0a5c683046ff911447269b8435c0a6753b8c2801f138bd5c510ee2d3ad" alt="Admin CheckIn">
  </div>
  
  <div align="center">
    <p>Admin CheckOut Page</p>
    <img src="https://gemootest.s3.us-east-2.amazonaws.com/s/res/523291570463973376/52c90cef0203e539fa61797328522d34.png?X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIARLZICB6QQHKRCV7K%2F20230602%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20230602T210043Z&X-Amz-SignedHeaders=host&X-Amz-Expires=7200&X-Amz-Signature=44b6e85fd37017a885f1503dfbceac6aa4f1073ac27da27d4cebf86574285df1" alt="Admin CheckOut">
  </div>
  
  </details>
