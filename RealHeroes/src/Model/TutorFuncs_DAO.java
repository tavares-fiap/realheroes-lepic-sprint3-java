package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TutorFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static boolean signUp(String cpf, String name, String email, String address, String password) {
        Controller.Connect_DB.loadDriver();
        if (Funcs_DAO.isCpfValid(cpf)) {
            try {
                Connection con = null;
                try {
                    con = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                } catch (SQLException ex) {
                    Logger.getLogger(View.SetUp_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                String sql = "INSERT INTO TUTOR (cpf, name, email, address, password) VALUES ('" + cpf + "','" + name + "','" + email + "','" + address + "','" + password + "')";

                try {
                    PreparedStatement insert = (PreparedStatement) con.prepareStatement(sql);
                    insert.execute(); // Executando a inserção 
                    JOptionPane.showMessageDialog(null, "\nCadastro realizado com sucesso!\n", "", -1);
                    Controller.LoggedUser_Controller.setLoggedUser(new Tutor(cpf, name, email, address, password));
                    //refresh();
                    Model.Funcs_DAO.cleanSingUpFields();
                    return true;
                } catch (SQLException ex) {
                    if (ex.getSQLState().equals("23000")) {  // Verifica se o código SQL é de violação de chave primária
                        JOptionPane.showMessageDialog(null, "\nErro: CPF já cadastrado no sistema!", "ERRO!", 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "\nOcorreu algum erro na inserção!", "ERRO!", 0);
                    }
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu algum erro durante conexao!!", "ERRO", 0);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "CPF Invalido!\nESPERADO: Somente numeros/ 11 digitos");
            View.SetUp_GUI.cpfSingUp_txt.setText("");
            return false;
        }
    }

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

    public static boolean deleteAccount() {
        User loggedUser = Controller.LoggedUser_Controller.getLoggedUser();
        String cpf = loggedUser.getCpf();
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(View.MainTutorMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //apaga registro do usuario
            String sqlDelete = "DELETE FROM TUTOR WHERE cpf = ?";
            PreparedStatement pstmtDelete = (PreparedStatement) con.prepareStatement(sqlDelete);
            pstmtDelete.setString(1, cpf);
            int rowsAffected = pstmtDelete.executeUpdate(); //executeUpdate para saber se houveram linhas afetadas pelo comando.

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Conta deletada com sucesso!\nAguardamos seu retorno " + loggedUser.getName().split(" ")[0] + "!");
                //refresh();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario com CPF: " + cpf + " inexistente...\nVerifique as informacoes!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados!");
            return false;
        }
    }

}
