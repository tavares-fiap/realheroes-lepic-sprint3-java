package Model;

import static View.MainTutorMenu_GUI.attemptFeedback_cb;
import static View.MainTutorMenu_GUI.feedback_txt;
import static View.MainTutorMenu_GUI.phaseFeedback_cb;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ResidentFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    private static final String standardPassword = "12345678"; //deve ser alterada pelo residente quando logar a primeira vez
    private static Map<String, String> resultMap = new HashMap<>();

    public static void addResident(String cpf, String name, String email, String address, String cpfTutor) {
        Controller.Connect_DB.loadDriver();

        if (Funcs_DAO.isCpfValid(cpf) && Funcs_DAO.isCpfValid(cpfTutor) && Funcs_DAO.isNameValid(name)) {
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

    public static void showSelectedAttemptInfo(String selectedPhase, String selectedAttempt) {
       
        int selectedPhaseInt;
        int selectedAttemptInt;

        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
            selectedAttemptInt = Integer.parseInt(selectedAttempt);
        } catch (NumberFormatException e) {
            System.out.println("Fase ou tentativa nao sao numeros! showSelectedAttemptInfo:" + e);
            return; // Retorna se houver erro
        }

        Map<String, String> attemptInfo = getAttemptDetails(selectedPhaseInt, selectedAttemptInt);

        if (attemptInfo == null) {
            return;
        }
        
        String feedback = attemptInfo.get("feedback");
        String score = attemptInfo.get("score");
        String dateOfCompletion = attemptInfo.get("dateOfCompletion");
        String completionTime = attemptInfo.get("completionTime");

        View.MainTutorMenu_GUI.playerScore_txt.setText(score);
        View.MainTutorMenu_GUI.completionDate_txt.setText(dateOfCompletion);
        View.MainTutorMenu_GUI.completionTime_txt.setText(completionTime);
        View.MainTutorMenu_GUI.feedback_txt.setText(feedback);
        return;
    }

    public static Map<String, String> getAttemptDetails(Integer selectedPhase, Integer selectedAttempt) {
        String query = "SELECT PT.feedback, T.score, PT.date_of_completion, PT.completion_time "
                + "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "WHERE PT.IDSelectedPhase = ? AND PT.IDattempt = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, selectedPhase); // Definindo o ID da fase selecionada na consulta
            stmt.setInt(2, selectedAttempt); // Definindo o ID da tentativa selecionada na consulta

            ResultSet rs = stmt.executeQuery();
            

            if (rs.next()) {
                String feedback = rs.getString("feedback");
                int score = rs.getInt("score");  // Obtém o valor da coluna 'score'
                Date dateOfCompletion = rs.getDate("date_of_completion");  // Obtém a data de conclusão
                Time completionTime = rs.getTime("completion_time");  // Obtém o tempo de conclusão

                resultMap.put("feedback", feedback);
                resultMap.put("score", String.valueOf(score));
                resultMap.put("dateOfCompletion", String.valueOf(dateOfCompletion));
                resultMap.put("completionTime", String.valueOf(completionTime));

                return resultMap;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma tentativa encontrada para os parâmetros fornecidos.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void updateAttemptFeedback(String feedback) {
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();
        String selectedAttempt = (String) attemptFeedback_cb.getSelectedItem();
        int selectedPhaseInt;
        int selectedAttemptInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
            selectedAttemptInt = Integer.parseInt(selectedAttempt);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            JOptionPane.showMessageDialog(null, "Fase ou tentativa nao sao numeros!");
            return; // Retorna se houver erro
        }
        Map<String, String> attemptInfo = getAttemptDetails(selectedPhaseInt, selectedAttemptInt);
        String previousFeedback = attemptInfo.get("feedback");

        // Se houver um feedback anterior e ele não for vazio ou nulo, exibe um JOptionPane de confirmação
        if (previousFeedback != null && !previousFeedback.trim().isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Já existe um feedback para esta tentativa. Deseja realmente alterar?"
                    + "\nFeedback atual: " + previousFeedback,
                    "Confirmar alteração",
                    JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
        }
        // Atualiza o feedback
        String queryUpdate = "UPDATE PHASE_TRAIN "
                + "SET FEEDBACK = ? "
                + "WHERE IDSelectedPhase = ? AND IDAttempt = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(queryUpdate)) {

            stmt.setString(1, feedback);  // Definindo o novo texto do feedback
            stmt.setInt(2, selectedPhaseInt);  // Definindo o ID da fase selecionada
            stmt.setInt(3, selectedAttemptInt);  // Definindo o ID da tentativa selecionada

            int rowsAffected = stmt.executeUpdate();  // Use executeUpdate para atualizações

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Feedback atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma linha foi atualizada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteFeedback() {
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();

        int selectedPhaseInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro

        }
        // Obter o ID da tentativa selecionada
        String selectedAttempt = (String) attemptFeedback_cb.getSelectedItem();
        int selectedAttemptInt;
        try {
            selectedAttemptInt = Integer.parseInt(selectedAttempt);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro
        }
        String query = "UPDATE PHASE_TRAIN "
                + "SET feedback = " + null + " "
                + "WHERE IDSelectedPhase = ? AND IDAttempt = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, selectedPhaseInt);  // Definindo o ID da fase selecionada
            stmt.setInt(2, selectedAttemptInt);  // Definindo o ID da tentativa selecionada

            int rowsAffected = stmt.executeUpdate();  // Use executeUpdate para atualizações

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Feedback excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma linha foi atualizada.");
            }
            feedback_txt.setText("ESCREVA SEU FEEDBACK AQUI");
        } catch (SQLException e) {
            e.printStackTrace();
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
