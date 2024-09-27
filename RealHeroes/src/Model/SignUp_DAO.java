package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SignUp_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();

    public static void signUp(String cpf, String name, String email, String address, String password) {
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
                    //refresh();
                    Model.Funcs_DAO.cleanSingUpFields();
                } catch (SQLException ex) {
                    if (ex.getSQLState().equals("23000")) {  // Verifica se o código SQL é de violação de chave primária
                        JOptionPane.showMessageDialog(null, "\nErro: CPF já cadastrado no sistema!", "ERRO!", 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "\nOcorreu algum erro na inserção!", "ERRO!", 0);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu algum erro durante conexao!!", "ERRO", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "CPF Invalido, insira somente numeros!");
            View.SetUp_GUI.cpfSingUp_txt.setText("");
        }
    }
}
