package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();

    public static boolean login(String cpf, String insertedPassword) {
        if (Funcs_DAO.isCpfValid(cpf)) {
            try {
                // Estabelecendo a conexão
                Connection con = null;
                try {
                    con = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                } catch (SQLException ex) {
                    Logger.getLogger(View.SetUp_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Usando PreparedStatement para evitar erros de sintaxe
                String sql = "SELECT name, email, address, password FROM TUTOR WHERE cpf = ?";
                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
                pstmt.setString(1, cpf); // Atribui o valor da placa ao primeiro "?"

                // Executando a consulta
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Se o usuario foi encontrado
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    
                    System.out.println("Usuario com CPF: " + cpf + " foi encontrado:");
                    System.out.println("Nome: " + name + ", email: " + email + ", address: " + address);
                    
                    if (insertedPassword.equals(password)) {
                        JOptionPane.showMessageDialog(null, "Seja bem-vindo " + name.split(" ")[0]);
                        Controller.LoggedUser_Controller.setLoggedUser(new User(cpf, name, email, address, password));
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta!");
                        return false;
                    }
                } else {
                    // Se não há resultados
                    JOptionPane.showMessageDialog(null, "Usuario com CPF: " + cpf + " não foi encontrado.");
                    return false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o servidor", "ERRO!", 0);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "CPF Invalido!\nESPERADO: Somente numeros/ 11 digitos");
            View.SetUp_GUI.cpfSignUp_txt.setText("");
            return false;
        }
    }
}
