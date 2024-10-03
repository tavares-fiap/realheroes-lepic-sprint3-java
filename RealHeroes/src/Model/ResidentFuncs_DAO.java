package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ResidentFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    private static final String standardPassword = "12345678"; //deve ser alterada pelo residente quando logar a primeira vez


    public static void addResident(String cpf, String name, String email, String address, String cpfTutor) {
        Controller.Connect_DB.loadDriver();

        if (Funcs_DAO.isCpfValid(cpf) && Funcs_DAO.isCpfValid(cpfTutor) && Funcs_DAO.isNameValid(name) && !Funcs_DAO.isCpfRegistered(cpf)) {
            String sql = "INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement insert = con.prepareStatement(sql)) {

                // Configurando os parâmetros do PreparedStatement
                insert.setString(1, cpf);
                insert.setString(2, name);
                insert.setString(3, email);
                insert.setString(4, address);
                insert.setString(5, standardPassword);
                insert.setString(6, cpfTutor);

                // Executando a inserção
                insert.executeUpdate();
                JOptionPane.showMessageDialog(null, "Residente inserido com sucesso em sua lista!", "", JOptionPane.INFORMATION_MESSAGE);

                Model.Funcs_DAO.cleanAddResidentFields();

            } catch (SQLException ex) {
                if ("23000".equals(ex.getSQLState())) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Erro: CPF já cadastrado no sistema!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome ou CPF Invalido!\nCPF ESPERADO: Somente numeros/ 11 digitos\nNOME ESPERADO: Somente letras e espaços");
            View.SetUp_GUI.cpfSignUp_txt.setText("");
        }
    }

    public static boolean transferResident(String residentCpf, String newTutorCpf) {
        if (Funcs_DAO.isCpfValid(residentCpf) && Funcs_DAO.isCpfValid(newTutorCpf)) {
            try {
                com.mysql.jdbc.Connection con = null;
                try {
                    con = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                } catch (SQLException ex) {
                    Logger.getLogger(View.SetUp_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sql = "SELECT name FROM TUTOR WHERE cpf = ?";
                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
                pstmt.setString(1, newTutorCpf);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String name = rs.getString("name");
                    if (Funcs_DAO.transferResidentConfirmation(name)) {
                        pstmt = con.prepareStatement("UPDATE RESIDENT SET cpf_tutor=? WHERE cpf=?");
                        pstmt.setString(1, newTutorCpf);
                        pstmt.setString(2, residentCpf);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Residente transferido com sucesso!");
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Residente não encontrado!");
                            return false;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tutor com CPF: " + newTutorCpf + " não foi encontrado.");
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
        return false;
    }

    public static boolean deleteResident(String residentCpf) {

        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(View.MainTutorMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //apaga registro do usuario
            String sqlDelete = "DELETE FROM RESIDENT WHERE cpf = ?";
            PreparedStatement pstmtDelete = (PreparedStatement) con.prepareStatement(sqlDelete);
            pstmtDelete.setString(1, residentCpf);
            int rowsAffected = pstmtDelete.executeUpdate(); //executeUpdate para saber se houveram linhas afetadas pelo comando.

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Residente deletado com sucesso!");
                //refresh();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Residente com CPF: " + residentCpf + " inexistente...\nVerifique as informacoes!");
                return false;
            }
        } catch (SQLException e) {
            // Verifica se o código do erro é 1451 (violação de chave estrangeira)
            if (e.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir dados! Não é possível excluir este usuário pois há RESIDENTES vinculados a ele.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir dados! Por favor, tente novamente.");
            }
            //Logger.getLogger(View.MainTutorMenu_GUI.class.getName()).log(Level.SEVERE, null, e);
            return false;

        } catch (Exception e) {
            // Tratamento para quaisquer outras exceções não previstas
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados!");
            return false;
        }
    }

    public static boolean readResident(String residentCpf) {
        if (Funcs_DAO.isCpfValid(residentCpf)) {
            try {
                com.mysql.jdbc.Connection con = null;
                try {
                    con = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                } catch (SQLException ex) {
                    Logger.getLogger(View.SetUp_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sql = "SELECT * FROM RESIDENT WHERE cpf = ?";
                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
                pstmt.setString(1, residentCpf);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    View.MainTutorMenu_GUI.residentName_txt.setText(name);
                    View.MainTutorMenu_GUI.residentEmail_txt.setText(email);
                    View.MainTutorMenu_GUI.residentAddress_txt.setText(address);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Residente com CPF: " + residentCpf + " não foi encontrado.");
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

    public static boolean updateResidentInfo(String cpf, String name, String email, String address) {
        if (Funcs_DAO.isNameValid(name)) {
            try (java.sql.Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                    PreparedStatement pstmt = con.prepareStatement("UPDATE RESIDENT SET name=?, email=?, address=? WHERE cpf=?")) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, address);
                pstmt.setString(4, cpf);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do residente atualizados com sucesso!");
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
        JOptionPane.showMessageDialog(null, "Nome inválido!");
        return false;
    }

}
