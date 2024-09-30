package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Funcs_DAO {
    
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static void changeScreen(JFrame currentScreen, JFrame nextScreen) {
        currentScreen.dispose();
        nextScreen.setVisible(true);
    }

    public static void exit() {
        String response = JOptionPane.showInputDialog(null, "Certeza que deseja sair?\n1 - Sim\n2 - Cancelar");
        try {
            if (Integer.parseInt(response) == 1) {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Encerramento do programa cancelado.");
        }
    }

    public static boolean updateConfirmation() {
        String response = JOptionPane.showInputDialog(null, "Certeza que deseja alterar os dados?\n1 - Sim\n2 - Cancelar");
        try {
            if (Integer.parseInt(response) == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    public static boolean transferResidentConfirmation(String tutorName) {
        String response = JOptionPane.showInputDialog(null, "Tem certeza que deseja transferir o residente para " + tutorName + "?\n1 - Sim\n2 - Cancelar");
        try {
            if (Integer.parseInt(response) == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean deleteAccountConfirmation() {
        User loggedUser = Controller.LoggedUser_Controller.getLoggedUser();
        String response = JOptionPane.showInputDialog(null, "Você tem certeza de que deseja excluir? Essa ação é irreversível!\n1 - Sim\n2 - Cancelar");
        try {
            if (Integer.parseInt(response) == 1) {
                response = JOptionPane.showInputDialog(null, "Para confirmar a exclusão, digite seu CPF no campo abaixo:");
                if (response.equals(loggedUser.getCpf())) {
                    return true;
                }
                JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
        return false;
    }
    

    public static boolean isCpfValid(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        for (char c : cpf.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNameValid(String name) {
        if (name == null || name.length() < 1) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') { // Verifica se o caractere não é uma letra nem um espaço
                return false;
            }
        }
        return true;
    }

    public static void cleanSingUpFields() {
        View.SetUp_GUI.cpfSignUp_txt.setText("");
        View.SetUp_GUI.nameSignUp_txt.setText("");
        View.SetUp_GUI.emailSignUp_txt.setText("");
        View.SetUp_GUI.addressSignUp_txt.setText("");
        View.SetUp_GUI.passwordSignUp_txt.setText("");
    }

    public static void profileRefresh() {
        View.MainTutorMenu_GUI.cpfProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getCpf());
        View.MainTutorMenu_GUI.nameProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getName());
        View.MainTutorMenu_GUI.emailProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getEmail());
        View.MainTutorMenu_GUI.addressProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getAddress());
        View.MainTutorMenu_GUI.passwordProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getPassword());
    }

    public static void cleanAddResidentFields() {
        View.MainTutorMenu_GUI.cpfAddResident_txt.setText("");
        View.MainTutorMenu_GUI.nameAddResident_txt.setText("");
        View.MainTutorMenu_GUI.emailAddResident_txt.setText("");
        View.MainTutorMenu_GUI.addressAddResident_txt.setText("");
    }
}
        