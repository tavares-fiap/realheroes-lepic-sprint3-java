package Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UpdateTutor_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    
    public static boolean updateTutor(String cpf, String name, String email, String address, String password) {
        try (java.sql.Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            PreparedStatement pstmt = con.prepareStatement("UPDATE TUTOR SET name=?, email=?, address=?, password=? WHERE cpf=?")) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, address);
            pstmt.setString(4, password);
            pstmt.setString(5, cpf);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                Controller.LoggedUser_Controller.setLoggedUser(new User(cpf, name, email, address, password));
                JOptionPane.showMessageDialog(null, "Perfil atualizado com sucesso!");
                return true;
                //refresh();
            } else {
                JOptionPane.showMessageDialog(null, "CPF não encontrado!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados!");
            return false;
        }
    }
}
