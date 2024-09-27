package Model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Funcs_DAO {

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
    
    public static boolean isCpfValid(String cpf){
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
    
    public static void cleanSingUpFields(){
        View.SetUp_GUI.cpfSingUp_txt.setText("");
        View.SetUp_GUI.nameSingUp_txt.setText("");
        View.SetUp_GUI.emailSingUp_txt.setText("");
        View.SetUp_GUI.addressSingUp_txt.setText("");
        View.SetUp_GUI.passwordSingUp_txt.setText("");
    }
    
    public static void profileRefresh(){
        View.MainTutorMenu_GUI.cpfProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getCpf());
        View.MainTutorMenu_GUI.nameProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getName());
        View.MainTutorMenu_GUI.emailProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getEmail());
        View.MainTutorMenu_GUI.addressProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getAddress());
        View.MainTutorMenu_GUI.passwordProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getPassword());
    }
}
