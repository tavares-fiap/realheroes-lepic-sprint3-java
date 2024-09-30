package Model;

import static View.MainTutorMenu_GUI.attemptFeedback_cb;
import static View.MainTutorMenu_GUI.cpfResidentFeedback_cb;
import static View.MainTutorMenu_GUI.cpfResidentMyResidents_cb;
import static View.MainTutorMenu_GUI.feedback_txt;
import static View.MainTutorMenu_GUI.phaseFeedback_cb;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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

    public static void updateCombobox() {
        String tutorCpf = Controller.LoggedUser_Controller.getLoggedUser().getCpf(); // Obtendo o CPF do tutor logado
        String query = "SELECT cpf FROM RESIDENT WHERE cpf_tutor = ?";
        cpfResidentFeedback_cb.removeAllItems();
        cpfResidentMyResidents_cb.removeAllItems();
        
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, tutorCpf); // Definindo o CPF do tutor logado na consulta
            ResultSet rs = stmt.executeQuery();

            // Verificando e adicionando os CPFs à JComboBox, se ainda não estiverem presentes
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                boolean alreadyExists = false;
                
                
                // Verifica se o CPF já está na combobox
                for (int i = 0; i < cpfResidentFeedback_cb.getItemCount(); i++) {
                    if (cpfResidentFeedback_cb.getItemAt(i).equals(cpf)) {
                        alreadyExists = true;
                        break;
                    }
                }
                
                // Adiciona o CPF apenas se ele ainda não estiver na combobox
                if (!alreadyExists) {
                    cpfResidentFeedback_cb.addItem(cpf);
                }
                
                alreadyExists = false;
                
                for (int i = 0; i < cpfResidentMyResidents_cb.getItemCount(); i++) {
                    if (cpfResidentMyResidents_cb.getItemAt(i).equals(cpf)) {
                        alreadyExists = true;
                        break;
                    }
                }

                if (!alreadyExists) {
                    cpfResidentMyResidents_cb.addItem(cpf);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePhaseCombobox() {
        String selectedCpf = (String) cpfResidentFeedback_cb.getSelectedItem();
        String query = "SELECT GP.IDSelectedPhase "
                + "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "JOIN GAME_PHASE GP ON PT.IDSelectedPhase = GP.IDSelectedPhase "
                + "WHERE T.cpf_residente = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedCpf); // Definindo o CPF do tutor logado na consulta
            ResultSet rs = stmt.executeQuery();

            // Verificando e adicionando os CPFs à JComboBox, se ainda não estiverem presentes
            while (rs.next()) {
                String phase = rs.getString("IDSelectedPhase");
                boolean alreadyExists = false;

                // Verifica se o CPF já está na combobox
                for (int i = 0; i < phaseFeedback_cb.getItemCount(); i++) {
                    if (phaseFeedback_cb.getItemAt(i).equals(phase)) {
                        alreadyExists = true;
                        break;
                    }
                }

                // Adiciona o CPF apenas se ele ainda não estiver na combobox
                if (!alreadyExists) {
                    phaseFeedback_cb.addItem(phase);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAttemptCombobox() {
        String selectedCpf = (String) cpfResidentFeedback_cb.getSelectedItem();
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();

        // Verifica se o item selecionado é um valor válido e não a opção padrão "SELECIONE A FASE"
        if (selectedPhase.equals("SELECIONE A FASE")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma fase válida.");
            return;  // Cancela a operação se a fase não for válida
        }

        int selectedPhaseInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro
        }

        // Consulta para obter o phaseName e dificulty da tabela GAME_PHASE
        String queryPhaseInfo = "SELECT phaseName, Dificulty FROM GAME_PHASE WHERE IDSelectedPhase = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmtPhase = conn.prepareStatement(queryPhaseInfo)) {

            stmtPhase.setInt(1, selectedPhaseInt); // Definindo o ID da fase selecionada na consulta

            ResultSet rsPhase = stmtPhase.executeQuery();

            // Se as informações da fase forem encontradas, exibe um JOptionPane com o phaseName e Dificulty
            if (rsPhase.next()) {
                String phaseName = rsPhase.getString("phaseName");
                String dificulty = rsPhase.getString("Dificulty");

                // Exibe o JOptionPane com as informações da fase
                String message = "Informações da Fase:\n"
                        + "Nome da Fase: " + phaseName + "\n"
                        + "Dificuldade: " + dificulty;
                JOptionPane.showMessageDialog(null, message, "Informações da Fase", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Consulta para obter as tentativas
        String query = "SELECT T.IDattempt "
                + // Corrigido: adicionado espaço aqui
                "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "WHERE T.cpf_residente = ? AND PT.IDSelectedPhase = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedCpf); // Definindo o CPF do residente selecionado na consulta
            stmt.setInt(2, selectedPhaseInt); // Definindo o ID da fase selecionada na consulta

            ResultSet rs = stmt.executeQuery();

            // Verificando e adicionando os tentativas à JComboBox, se ainda não estiverem presentes
            while (rs.next()) {
                String attempt = rs.getString("IDattempt"); // A coluna é chamada IDattempt
                boolean alreadyExists = false;

                // Verifica se a tentativa já está na combobox
                for (int i = 0; i < attemptFeedback_cb.getItemCount(); i++) {
                    if (attemptFeedback_cb.getItemAt(i).equals(attempt)) {
                        alreadyExists = true;
                        break;
                    }
                }

                // Adiciona a tentativa apenas se ela ainda não estiver na combobox
                if (!alreadyExists) {
                    attemptFeedback_cb.addItem(attempt);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setPreviousFeedback() {
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();

        int selectedPhaseInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro
        }

        String selectedAttempt = (String) attemptFeedback_cb.getSelectedItem();

        // Verifica se o item selecionado é um valor válido, e não a opção padrão "SELECIONE A TENTATIVA"
        if (selectedAttempt.equals("SELECIONE A TENTATIVA")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma tentativa válida.");
            return;  // Cancela a operação se a tentativa não for válida
        }

        int selectedAttemptInt;
        try {
            selectedAttemptInt = Integer.parseInt(selectedAttempt);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro
        }

        // Continuar com a lógica do feedback se a tentativa for válida
        String query = "SELECT PT.feedback, T.score, PT.date_of_completion, PT.completion_time "
                + "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "WHERE PT.IDSelectedPhase = ? AND PT.IDattempt = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, selectedPhaseInt); // Definindo o ID da fase selecionada na consulta
            stmt.setInt(2, selectedAttemptInt); // Definindo o ID da tentativa selecionada na consulta

            ResultSet rs = stmt.executeQuery();

            // Se os dados sobre a tentativa forem encontrados, exibe um JOptionPane com as informações
            if (rs.next()) {
                String feedback = rs.getString("feedback");
                int score = rs.getInt("score");  // Obtém o valor da coluna 'score'
                Date dateOfCompletion = rs.getDate("date_of_completion");  // Obtém a data de conclusão
                Time completionTime = rs.getTime("completion_time");  // Obtém o tempo de conclusão
                View.MainTutorMenu_GUI.playerScore_txt.setText(String.valueOf(score));
                View.MainTutorMenu_GUI.completionDate_txt.setText(String.valueOf(dateOfCompletion));
                View.MainTutorMenu_GUI.completionTime_txt.setText(String.valueOf(completionTime));
                View.MainTutorMenu_GUI.feedback_txt.setText(String.valueOf(feedback));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma tentativa encontrada para os parâmetros fornecidos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setUpdateFeedback() {
        String feedbackText = feedback_txt.getText();

        // Obter o ID da fase selecionada
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

        // Verifica se já existe um feedback anterior
        String previousFeedback = null;
        String queryPreviousFeedback = "SELECT feedback FROM PHASE_TRAIN WHERE IDSelectedPhase = ? AND IDAttempt = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmtPrev = conn.prepareStatement(queryPreviousFeedback)) {

            stmtPrev.setInt(1, selectedPhaseInt);  // Definindo o ID da fase selecionada
            stmtPrev.setInt(2, selectedAttemptInt);  // Definindo o ID da tentativa selecionada

            ResultSet rs = stmtPrev.executeQuery();
            if (rs.next()) {
                previousFeedback = rs.getString("feedback");  // Obtem o feedback anterior
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return; // Retorna se houver erro na consulta
        }

        // Se houver um feedback anterior e ele não for vazio ou nulo, exibe um JOptionPane de confirmação
        if (previousFeedback != null && !previousFeedback.trim().isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Já existe um feedback para esta tentativa. Deseja realmente alterar?"
                    + "\nFeedback atual: " + previousFeedback,
                    "Confirmar alteração",
                    JOptionPane.YES_NO_OPTION);

            // Se o usuário clicar em "Não", cancelar a operação
            if (confirm != JOptionPane.YES_OPTION) {
                return; // Cancela a atualização do feedback
            }
        }

        // Atualiza o feedback
        String queryUpdate = "UPDATE PHASE_TRAIN "
                + "SET FEEDBACK = ? "
                + "WHERE IDSelectedPhase = ? AND IDAttempt = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(queryUpdate)) {

            stmt.setString(1, feedbackText);  // Definindo o novo texto do feedback
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

    public static void readFeedback() {
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();

        int selectedPhaseInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro
        }

        String selectedAttempt = (String) attemptFeedback_cb.getSelectedItem();

        int selectedAttemptInt;
        try {
            selectedAttemptInt = Integer.parseInt(selectedAttempt);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
            return; // Retorna se houver erro
        }

        // Continuar com a lógica do feedback se a tentativa for válida
        String query = "SELECT PT.feedback "
                + "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "WHERE PT.IDSelectedPhase = ? AND PT.IDattempt = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, selectedPhaseInt); // Definindo o ID da fase selecionada na consulta
            stmt.setInt(2, selectedAttemptInt); // Definindo o ID da tentativa selecionada na consulta

            ResultSet rs = stmt.executeQuery();

            // Se os dados sobre a tentativa forem encontrados, exibe um JOptionPane com as informações
            if (rs.next()) {
                String feedback = rs.getString("feedback");
                // Se houver feedback, atualiza o campo de texto
                if (feedback != null && !feedback.trim().isEmpty()) {
                    feedback_txt.setText(feedback);  // Atualiza a JTextArea com o feedback
                    JOptionPane.showMessageDialog(null, "Feedback adicionado na caixa de texto destinada ao feedback.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ainda não há feedback vinculado a essa tentativa dessa fase");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Feedback não encontrado!");
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

    public static void updateMyResidentsTable() {
        String selectedCpf = (String) cpfResidentFeedback_cb.getSelectedItem();
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();
        Controller.Connect_DB.loadDriver();

        String sql = "SELECT T.IDATTEMPT, T.SCORE, PT.DATE_OF_COMPLETION, PT.COMPLETION_TIME "
                + "FROM TRAIN T "
                + "INNER JOIN PHASE_TRAIN PT "
                + "ON T.IDATTEMPT = PT.IDATTEMPT "
                + "WHERE T.cpf_residente = ? AND PT.IDSELECTEDPHASE = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, selectedCpf);
            stmt.setInt(2, Integer.parseInt(selectedPhase));

            ResultSet rs = stmt.executeQuery();
            View.MainTutorMenu_GUI.attemptInfo.setModel(View.MainTutorMenu_GUI.attemptInfoFunc(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
    
    public static boolean deleteResident(String residentCpf){

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

}
