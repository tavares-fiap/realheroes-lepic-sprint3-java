/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeviceFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static void getAvaiableDevices(){
    String query = "SELECT D.IDdevice, D.Description, D.Marca " +
                       "FROM DEVICE D " +
                       "LEFT JOIN STOCK S ON D.IDdevice = S.IDdevice AND S.DataDev IS NULL " +
                       "WHERE S.IDdevice IS NULL";
        
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            View.MainResidentMenu_GUI.deviceInfo.setModel(View.MainResidentMenu_GUI.deviceInfoFunc(rs));

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar óculos disponíveis.", "Erro", JOptionPane.ERROR_MESSAGE);
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

    
}
