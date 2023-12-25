import Controllers.LoginController;
import Helpers.Helper;
import Helpers.Query;
import Views.LoginUI;

// https://app.patika.dev/moduller/java-102/patikaklon-8
public class PatikaClone {
    public static void main(String[] args) {
        Helper.setLayout();

        Query query = new Query();

        LoginUI loginUI = new LoginUI(query, new LoginController(query));

    }
}
