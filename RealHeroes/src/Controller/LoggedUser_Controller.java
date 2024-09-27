
package Controller;

import Model.User;

public class LoggedUser_Controller {
    private static User loggedUser = null;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User user) {
        loggedUser = user;
    }
    
    public static void logout(){
        loggedUser = null;
    }
    
    
}
