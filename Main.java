import myClasses.Login;

//TODO: setLocationRelativeTo(null)
//TODO: ConfirmDialogue button setFocusable(false)
//TODO: Terminal show state

public class Main {
    public static void main(String[] args) {

        new Login();

    }
}

/**
 * This class diagram represents the relationships and associations between classes in the hotel management project.
 * <p>
 * Class Diagram:
 * -------------------------
 *           BkashPayment
 *              ^  ^
 *              |  |
 *      ConfirmPayment (Interface)
 * <p>
 *           CheckIn
 *              ^
 *              |
 *          ShowRoom
 *              ^
 *              |
 *   WriteCheckInInfo (Interface)
 * <p>
 *           CheckOut
 *              ^
 *              |
 *  CheckOutRoomSearch
 *  ClearCheckOut (Interface)
 *  CustomerDataEntry (Interface)
 * <p>
 *        NagadPayment
 *           ^   ^
 *           |   |
 *  ConfirmPayment (Interface)
 * <p>
 *          UCheckIn
 *             ^ ^
 *             | |
 *         ShowRoom
 *             ^ ^
 *             | |
 *  WriteCheckInInfo (Interface)
 * <p>
 *         UCheckOut
 *             ^ ^
 *             | |
 *  CheckOutRoomSearch
 *  CustomerDataEntry (Interface)
 */

/**
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
*/

/**
// BkashPayment class for handling payments via Bkash
public class BkashPayment {
    // Inherits/extends: None
    // Implements: ConfirmPayment interface
}

// CheckIn class for handling the check-in process
public class CheckIn {
    // Inherits/extends: None
    // Associated with: ShowRoom class
    // Implements: WriteCheckInInfo interface
}

// CheckOut class for handling the check-out process
public class CheckOut {
    // Inherits/extends: None
    // Associated with: CheckOutRoomSearch, ClearCheckOut, CustomerDataEntry classes
}

// CheckOutRoomSearch interface for searching rooms during the check-out process
public interface CheckOutRoomSearch {
    // Inherits/extends: None
    // Associated with: CheckOut class
}

// ClearCheckOut interface for clearing check-out details
public interface ClearCheckOut {
    // Inherits/extends: None
    // Associated with: CheckOut class
}

// ConfirmPayment interface for confirming payment
public interface ConfirmPayment {
    // Inherits/extends: None
    // Associated with: BkashPayment, NagadPayment classes
}

// CustomerDataEntry interface for entering customer data
public interface CustomerDataEntry {
    // Inherits/extends: None
    // Associated with: CheckOut, UCheckOut classes
}

// DashBoard class for managing the hotel dashboard
public class DashBoard {
    // Inherits/extends: None
    // Implements: None
}

// Edit class for editing customer information
public class Edit {
    // Inherits/extends: None
    // Implements: None
}

// ForgetPass classes for handling the password recovery process
public class ForgetPass {
    // Inherits/extends: None
    // Implements: None
}

// ForgetPass2 classes for handling the password recovery process
public class ForgetPass2 {
    // Inherits/extends: None
    // Implements: None
}

// ForgetPass3 classes for handling the password recovery process
public class ForgetPass3 {
    // Inherits/extends: None
    // Implements: None
}

// Login class for managing user login
public class Login {
    // Inherits/extends: None
    // Implements: None
}

// Main class for the main entry point of the hotel management project
public class Main {
    // Inherits/extends: None
    // Implements: None
}

// ManageRoom class for managing hotel rooms
public class ManageRoom {
// Inherits/extends: None
// Implements: None
}

// NagadPayment class for handling payments via Nagad
public class NagadPayment {
// Inherits/extends: None
// Implements: ConfirmPayment interface
}

// Payment class for managing payments
public class Payment {
// Inherits/extends: None
// Implements: None
}

// Profile class for managing user profiles
public class Profile {
// Inherits/extends: None
// Implements: None
}

// ShowRoom class for displaying room information
public class ShowRoom {
// Inherits/extends: None
// Associated with: CheckIn, UCheckIn classes
}

// Signup class for managing user sign-up process
public class Signup {
// Inherits/extends: None
// Implements: None
}

// UCheckIn class for handling user check-in process
public class UCheckIn {
// Inherits/extends: None
// Associated with: ShowRoom class
// Implements: WriteCheckInInfo interface
}

// UCheckOut class for handling user check-out process
public class UCheckOut {
// Inherits/extends: None
// Associated with: CheckOutRoomSearch, CustomerDataEntry classes
}

// UDashBoard class for managing the user dashboard
public class UDashBoard {
// Inherits/extends: None
// Implements: None
}

// WriteCheckInInfo interface for writing check-in information
public interface WriteCheckInInfo {
// Inherits/extends: None
// Associated with: CheckIn, UCheckIn classes
}
*/

