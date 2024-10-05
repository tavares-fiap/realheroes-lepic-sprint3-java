/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

public class DeviceFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    private static Map<String, String> residentResultMap = new HashMap<>();
    
    public static void getAvaiableDevices(String dataRT) {
    String query = "SELECT D.IDdevice, D.Description, D.Marca " +
                   "FROM DEVICE D " +
                   "LEFT JOIN ( " +
                   "   SELECT IDdevice, MAX(DataDev) AS UltimaDataDev " +
                   "   FROM STOCK " +
                   "   GROUP BY IDdevice " +
                   ") S ON D.IDdevice = S.IDdevice " +
                   "WHERE S.IDdevice IS NULL " +  // Dispositivo nunca foi reservado
                   "OR datediff(S.UltimaDataDev, ?) < 0";  // Considera apenas o registro mais recente e verifica se foi devolvido antes da data solicitada

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Convertendo a String para java.sql.Date
        Date dataRTDate = Date.valueOf(dataRT);  // dataRT deve estar no formato "yyyy-MM-dd"
        stmt.setDate(1, dataRTDate);

        ResultSet rs = stmt.executeQuery();

        // Preenchendo a JComboBox com os IDs dos dispositivos disponíveis
        View.MainResidentMenu_GUI.idDevice_cb.removeAllItems();
        while (rs.next()) {
            int idDevice = rs.getInt("IDdevice");
            System.out.println("Dispositivo disponível: " + idDevice);
            View.MainResidentMenu_GUI.idDevice_cb.addItem(idDevice);
        }

        if (View.MainResidentMenu_GUI.idDevice_cb.getItemCount() > 0) {
            JOptionPane.showMessageDialog(null, "Dispositivos disponíveis carregados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum dispositivo disponível para essa data.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao buscar dispositivos disponíveis.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}



    public static void setDeviceIds() {
    String query = "SELECT D.IDdevice " +
                       "FROM DEVICE D " +
                       "LEFT JOIN STOCK S ON D.IDdevice = S.IDdevice AND S.DataDev IS NULL " +
                       "WHERE S.IDdevice IS NULL";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        // Limpa a JComboBox antes de adicionar novos itens
        View.MainResidentMenu_GUI.idDevice_cb.removeAllItems();

        // Itera sobre o ResultSet e adiciona cada ID à JComboBox
        while (rs.next()) {
            int idDevice = rs.getInt("IDdevice");
            // Adiciona o ID à JComboBox
            View.MainResidentMenu_GUI.idDevice_cb.addItem(idDevice);
        }

        // Mensagem de sucesso ou nenhuma disponível
        if (View.MainResidentMenu_GUI.idDevice_cb.getItemCount() > 0) {
            JOptionPane.showMessageDialog(null, "Dispositivos carregados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum dispositivo encontrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao buscar dispositivos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

    public static void showSelectedDeviceInfo(String selectedID) {
       
        int selectedIDInt;

        try {
            selectedIDInt = Integer.parseInt(selectedID);
        } catch (NumberFormatException e) {
            System.out.println("ID nao numérico! showSelectedIDInfo:" + e);
            return; // Retorna se houver erro
        }

        Map<String, String> attemptInfo = getDeviceDetails(selectedIDInt);

        if (attemptInfo == null) {
            return;
        }
        
        String desc = attemptInfo.get("description");
        String brand = attemptInfo.get("brand");
        View.MainResidentMenu_GUI.deviceDescription_txt.setText(desc);
        View.MainResidentMenu_GUI.brand_txt.setText(brand);
        return;
    }

    public static Map<String, String> getDeviceDetails(Integer selectedID) {
        String query = "SELECT description, marca "
                + "FROM DEVICE "
                + "WHERE IDdevice = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, selectedID); // Definindo o ID do dispositivo selecionado na consulta

            ResultSet rs = stmt.executeQuery();
            

            if (rs.next()) {
                String description = rs.getString("description");
                String brand = rs.getString("marca");

                residentResultMap.put("description", description);
                residentResultMap.put("brand", String.valueOf(brand));
                
                return residentResultMap;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma tentativa encontrada para os parâmetros fornecidos.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void reserveDevice (int idDevice, String cpfResidente, String dataRT){
        String query = "INSERT INTO STOCK VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Convertendo a String para java.sql.Date
            Date dataRTDate = Date.valueOf(dataRT);  // dataRT deve estar no formato "yyyy-MM-dd"

            stmt.setInt(1, idDevice);
            stmt.setString(2, cpfResidente);
            stmt.setDate(3, dataRTDate);  // Inserindo a data no formato correto
            stmt.setDate(4, null);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Registro inserido com sucesso!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
