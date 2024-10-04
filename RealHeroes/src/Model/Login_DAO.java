package Model;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login_DAO {

    public static int login(String cpf, String insertedPassword) { // Retorna -1 se nao ocorrer login, 0 se for login de tutor, 1 se for login de residente
        if (!Funcs_DAO.isCpfValid(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF Invalido!\nESPERADO: Somente numeros/ 11 digitos");
            View.SetUp_GUI.cpfSignUp_txt.setText("");
            return -1;
        }
        try {
            Tutor tutor = TutorFuncs_DAO.getTutorByCpf(cpf);
            if (tutor != null) {
                if (tutor.getPassword().equals(insertedPassword)) {
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo " + tutor.getName().split(" ")[0]);
                    Controller.LoggedUser_Controller.setLoggedUser(tutor);
                    return 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    return -1;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o Tutor no banco de dados", "ERRO!", 0);
            return -1;
        }
        
        try {
            Resident resident = ResidentFuncs_DAO.getResidentByCpf(cpf);
            if (resident != null) {
                if (resident.getPassword().equals(insertedPassword)) {
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo " + resident.getName().split(" ")[0]);
                    Controller.LoggedUser_Controller.setLoggedUser(resident);
                    return 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    return -1;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o Residente no banco de dados", "ERRO!", 0);
            return -1;
        }
        JOptionPane.showMessageDialog(null, "Usuario com CPF: " + cpf + " nao foi encontrado:");
        return -1;
    }
}
