
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
import javax.swing.JOptionPane;


public class AttemptFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    private static Map<String, String> resultMap = new HashMap<>();
    
    public static void showSelectedAttemptInfoForTutor(String selectedPhase, String selectedAttempt) {
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
    
    public static void showSelectedAttemptInfoForResident(String selectedPhase, String selectedAttempt) {
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

        View.MainResidentMenu_GUI.playerScore_txt.setText(score);
        View.MainResidentMenu_GUI.completionDate_txt.setText(dateOfCompletion);
        View.MainResidentMenu_GUI.completionTime_txt.setText(completionTime);
        View.MainResidentMenu_GUI.feedback_txt.setText(feedback);
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
    
    public static void deleteAttemptFeedback() {
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
}
