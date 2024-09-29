package Model;

import static View.MainTutorMenu_GUI.attemptFeedback_cb;
import static View.MainTutorMenu_GUI.cpfResidentFeedback_cb;
import static View.MainTutorMenu_GUI.feedback_txt;
import static View.MainTutorMenu_GUI.phaseFeedback_cb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                    PreparedStatement insert = con.prepareStatement(sql)) {

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

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(query)) {

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
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static void updatePhaseCombobox(){
        String selectedCpf = (String) cpfResidentFeedback_cb.getSelectedItem();
        String query = "SELECT GP.IDSelectedPhase " +
                   "FROM PHASE_TRAIN PT " +
                   "JOIN TRAIN T ON PT.IDattempt = T.IDattempt " +
                   "JOIN GAME_PHASE GP ON PT.IDSelectedPhase = GP.IDSelectedPhase " +
                   "WHERE T.cpf_residente = ?";
    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(query)) {

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
    
    int selectedPhaseInt;
    try {
        selectedPhaseInt = Integer.parseInt(selectedPhase);
    } catch (NumberFormatException e) {
        e.printStackTrace(); // Lidar com erro se o valor não puder ser convertido
        return; // Retorna se houver erro
    }
    
    String query = "SELECT T.IDattempt " +  // Corrigido: adicionado espaço aqui
                   "FROM PHASE_TRAIN PT " +
                   "JOIN TRAIN T ON PT.IDattempt = T.IDattempt " +
                   "WHERE T.cpf_residente = ? AND PT.IDSelectedPhase = ?";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(query)) {

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
    public static void setPreviousFeedback(){
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
    
        String query = "SELECT feedback "+
                "FROM PHASE_TRAIN "+
                "WHERE IDSelectedPhase = ? AND IDAttempt = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, selectedPhaseInt); // Definindo o CPF do residente selecionado na consulta
        stmt.setInt(2, selectedAttemptInt); // Definindo o ID da fase selecionada na consulta
        
        ResultSet rs = stmt.executeQuery();

        
        while (rs.next()) {
            String feedback = rs.getString("feedback");  // Obtém o valor da coluna 'feedback'
            if (feedback != null && !feedback.trim().isEmpty()) {
            feedback_txt.setText(feedback);  // Atualiza apenas se não for nulo ou vazio
        }
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
    
    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmtPrev = conn.prepareStatement(queryPreviousFeedback)) {

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
                "Já existe um feedback para esta tentativa. Deseja realmente alterar?"+
                        "\nFeedback atual: " + previousFeedback, 
                "Confirmar alteração", 
                JOptionPane.YES_NO_OPTION);

        // Se o usuário clicar em "Não", cancelar a operação
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Cancela a atualização do feedback
        }
    }

    // Atualiza o feedback
    String queryUpdate = "UPDATE PHASE_TRAIN " +  
                         "SET FEEDBACK = ? " +
                         "WHERE IDSelectedPhase = ? AND IDAttempt = ?";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(queryUpdate)) {

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
    
}
