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
            /*StringBuilder availableDevices = new StringBuilder("Óculos disponíveis:\n");
            boolean hasDevices = false;

            while (rs.next()) {
                hasDevices = true;
                int idDevice = rs.getInt("IDdevice");
                String description = rs.getString("Description");
                String marca = rs.getString("Marca");

                availableDevices.append("ID: ").append(idDevice)
                                .append(", Descrição: ").append(description)
                                .append(", Marca: ").append(marca).append("\n");
            }

            if (!hasDevices) {
                availableDevices.append("Nenhum óculos disponível.");
            }

            // Exibe os óculos disponíveis em um JOptionPane
            JOptionPane.showMessageDialog(null, availableDevices.toString(), "Óculos Disponíveis", JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar óculos disponíveis.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
