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

    public static int login(String cpf, String insertedPassword) { // Retorna -1 se nao ocorrer login, 0 se for login de tutor, 1 se for login de residente
        if (!Funcs_DAO.isCpfValid(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF Invalido!\nESPERADO: Somente numeros/ 11 digitos");
            View.SetUp_GUI.cpfSignUp_txt.setText("");
            return -1;
        }

        try {
            Connection con = null;
            try {
                con = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            } catch (SQLException ex) {
                Logger.getLogger(View.SetUp_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sql = "SELECT * FROM TUTOR WHERE cpf = ?";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { // Se for tutor
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                System.out.println("Tutor com CPF: " + cpf + " foi encontrado:");
                System.out.println("Nome: " + name + ", email: " + email + ", address: " + address);
                if (insertedPassword.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo " + name.split(" ")[0]);
                    Controller.LoggedUser_Controller.setLoggedUser(new Tutor(cpf, name, email, address, password));
                    return 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    return -1;
                }
            }

            System.out.println("Pulou o if do tutor");

            sql = "SELECT * FROM RESIDENT WHERE cpf = ?";
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1, cpf);

            rs = pstmt.executeQuery();

            if (rs.next()) { //Se for residente
                System.out.println("entrou no if next do resident");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String cpfTutor = rs.getString("cpf_tutor");
                System.out.println(cpfTutor);

                //Busca tutor do residente
                sql = "SELECT * FROM TUTOR WHERE cpf = ?";
                pstmt = (PreparedStatement) con.prepareStatement(sql);
                pstmt.setString(1, cpfTutor);
                rs = pstmt.executeQuery();
                //rs.next();
                if (rs.next()) { // NAO SEI COMO, mas o rs.next() faz alguma coisa no if, sem rs.next() a funcao nao funciona
                    System.out.println("a");
                    String tutorName = rs.getString("name");
                    String tutorEmail = rs.getString("email");
                    String tutorAddress = rs.getString("address");
                    String tutorPassword = rs.getString("password");
                    System.out.println("Residente com CPF: " + cpf + " foi encontrado:");
                    System.out.println("Nome: " + name + ", email: " + email + ", address: " + address + "Tutor: " + tutorName);
                    if (insertedPassword.equals(password)) {
                        System.out.println("senha correta");
                        JOptionPane.showMessageDialog(null, "Seja bem-vindo " + name.split(" ")[0]);
                        Controller.LoggedUser_Controller.setLoggedUser(new Resident(cpf, name, email, address, password, new Tutor(cpfTutor, tutorName, tutorEmail, tutorAddress, tutorPassword)));
                        return 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha incorreta!");
                        return -1;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario com CPF: " + cpf + " nao foi encontrado:");
            return -1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o servidor", "ERRO!", 0);
            return -1;
        }
    }
}
