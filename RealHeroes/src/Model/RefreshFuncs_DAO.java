
package Model;

import static View.MainTutorMenu_GUI.attemptFeedback_cb;
import static View.MainTutorMenu_GUI.cpfResidentFeedback_cb;
import static View.MainTutorMenu_GUI.cpfResidentMyResidents_cb;
import static View.MainTutorMenu_GUI.phaseFeedback_cb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class RefreshFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static void refreshFeedbackTable(String selectedPhase, String selectedCpf) {
        int selectedPhaseInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter para int em refreshFeedbackTable" + e); // Lidar com erro se o valor não puder ser convertido
            View.MainTutorMenu_GUI.attemptInfo.setModel(View.MainTutorMenu_GUI.clearAttemptInfoFunc());
            return; // Retorna se houver erro
        }
        
        Controller.Connect_DB.loadDriver();
        String sql = "SELECT T.IDATTEMPT, T.SCORE, PT.DATE_OF_COMPLETION, PT.COMPLETION_TIME "
                + "FROM TRAIN T "
                + "INNER JOIN PHASE_TRAIN PT "
                + "ON T.IDATTEMPT = PT.IDATTEMPT "
                + "WHERE T.cpf_residente = ? AND PT.IDSELECTEDPHASE = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, selectedCpf);
            stmt.setInt(2, selectedPhaseInt);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.isBeforeFirst()){ // rs.next() MOVE o cursor, por isso, quando so tem um registro, ele pula aquele registro.
                View.MainTutorMenu_GUI.attemptInfo.setModel(View.MainTutorMenu_GUI.attemptInfoFunc(rs));
            } else {
                View.MainTutorMenu_GUI.attemptInfo.setModel(View.MainTutorMenu_GUI.clearAttemptInfoFunc());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void refreshMyResidentsTable() {
        String tutorCpf = Controller.LoggedUser_Controller.getLoggedUser().getCpf();
        Controller.Connect_DB.loadDriver();

        String sql = "SELECT * FROM RESIDENT WHERE cpf_tutor = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tutorCpf);

            ResultSet rs = stmt.executeQuery();
            View.MainTutorMenu_GUI.residentInfo.setModel(View.MainTutorMenu_GUI.residentInfoFunc(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void refreshResidentCpfOptions() {
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

    public static void refreshPhaseOptions(String selectedCpf) {
        phaseFeedback_cb.removeAllItems();
        
        String query = "SELECT GP.IDSelectedPhase "
                + "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "JOIN GAME_PHASE GP ON PT.IDSelectedPhase = GP.IDSelectedPhase "
                + "WHERE T.cpf_residente = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedCpf); // Definindo o CPF do tutor logado na consulta
            ResultSet rs = stmt.executeQuery();
            
            phaseFeedback_cb.addItem("SELECIONE UMA FASE");
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

    public static void refreshAttemptOptions(String selectedPhase, String selectedCpf) {
        // Verifica se o item selecionado é um valor válido e não a opção padrão "SELECIONE A FASE"
        //if (selectedPhase.equals("SELECIONE A FASE")) {
        //    JOptionPane.showMessageDialog(null, "Por favor, selecione uma fase válida.");
        //    return false;  // Cancela a operação se a fase não for válida
        //}
        
        attemptFeedback_cb.removeAllItems();
        
        int selectedPhaseInt;
        try {
            selectedPhaseInt = Integer.parseInt(selectedPhase);
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter para int em updateAttemptCombobox" + e); // Lidar com erro se o valor não puder ser convertido
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
                //String message = "Informações da Fase:\n"
                //       + "Nome da Fase: " + phaseName + "\n"
                //        + "Dificuldade: " + dificulty;
                //JOptionPane.showMessageDialog(null, message, "Informações da Fase", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Consulta para obter as tentativas
        String query = "SELECT T.IDattempt "
                + "FROM PHASE_TRAIN PT "
                + "JOIN TRAIN T ON PT.IDattempt = T.IDattempt "
                + "WHERE T.cpf_residente = ? AND PT.IDSelectedPhase = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); 
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, selectedCpf); // Definindo o CPF do residente selecionado na consulta
            stmt.setInt(2, selectedPhaseInt); // Definindo o ID da fase selecionada na consulta

            ResultSet rs = stmt.executeQuery();
            
            attemptFeedback_cb.addItem("SELECIONE UMA TENTATIVA");
            
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
            return;
        }
    }
}
