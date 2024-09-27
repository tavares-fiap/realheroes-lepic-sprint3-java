package Model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Funcs_DAO {

    public static void changeScreen(JFrame currentScreen, JFrame nextScreen) {
        currentScreen.dispose();
        nextScreen.setVisible(true);
    }

    public static void exit() {
        String response = JOptionPane.showInputDialog(null, "Certeza?\n1 - Sim\n2 - Cancelar");
        if (Integer.parseInt(response) == 1) {
            System.exit(0);
        }
    }
}
