import com.narola.carrental.common.Constant;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.manager.LoginManager;
import com.narola.carrental.manager.SignUpManager;
import com.narola.carrental.common.MenuInput;


public class CarRentalApplication {
    public static void main(String[] args) throws DAOException {
        int choice;
        do {
            displayMainMenu();
            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.MENU_SIGN_UP:
                    SignUpManager signUpManager = new SignUpManager();
                    signUpManager.doSignUp();
                    break;
                case Constant.MENU_LOGIN:
                    LoginManager loginManager = new LoginManager();
                    loginManager.doLogin();
                    break;
                default:
                    break;
            }
        } while (choice != 3);
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to Car Rental!");
        System.out.println("Please select an option:");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
    }
}
