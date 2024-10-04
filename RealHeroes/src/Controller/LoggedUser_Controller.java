
package Controller;

import Model.User;

public class LoggedUser_Controller {
    private static User loggedUser = null;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User user) {
        if (user != null) {
            loggedUser = user;
        } else {
            throw new IllegalArgumentException("O usuário não pode ser nulo");
        }
    }
    
    public static void logout(){
        loggedUser = null;
    }
    
    
}
