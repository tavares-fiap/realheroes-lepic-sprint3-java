/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;

/**
 *
 * @author sapat
 */
public class MainTutorMenu_GUI extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen_GUI
     */
    public MainTutorMenu_GUI() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        exit_btn2 = new javax.swing.JButton();
        logOut_btn2 = new javax.swing.JButton();
        residentsBG_lbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit_btn1 = new javax.swing.JButton();
        logOut_btn1 = new javax.swing.JButton();
        newResidentBG_lbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        deleteAccountProfile_btn = new javax.swing.JButton();
        showPassword_btn = new javax.swing.JToggleButton();
        cpfProfile_txt = new javax.swing.JTextField();
        passwordProfile_txt = new javax.swing.JPasswordField();
        addressProfile_txt = new javax.swing.JTextField();
        emailProfile_txt = new javax.swing.JTextField();
        nameProfile_txt = new javax.swing.JTextField();
        cpfSingUp_lbl = new javax.swing.JLabel();
        nameSingUp_lbl = new javax.swing.JLabel();
        emailSingUp_lbl = new javax.swing.JLabel();
        addressSingUp_lbl = new javax.swing.JLabel();
        passwordSingUp_lbl = new javax.swing.JLabel();
        updateProfile_btn = new javax.swing.JButton();
        refreshFields_btn = new javax.swing.JButton();
        logOut_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        profileBG_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setPreferredSize(new java.awt.Dimension(396, 704));
        jPanel2.setLayout(null);

        exit_btn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn2.setText("SAIR");
        exit_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(exit_btn2);
        exit_btn2.setBounds(270, 630, 110, 30);

        logOut_btn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOut_btn2.setText("LOGOUT");
        logOut_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(logOut_btn2);
        logOut_btn2.setBounds(270, 590, 110, 30);

        residentsBG_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG1.png"))); // NOI18N
        jPanel2.add(residentsBG_lbl);
        residentsBG_lbl.setBounds(0, -10, 400, 710);

        jTabbedPane1.addTab("Meus Residentes", jPanel2);

        jPanel3.setLayout(null);

        exit_btn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn1.setText("SAIR");
        exit_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn1ActionPerformed(evt);
            }
        });
        jPanel3.add(exit_btn1);
        exit_btn1.setBounds(270, 630, 110, 30);

        logOut_btn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOut_btn1.setText("LOGOUT");
        logOut_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btn1ActionPerformed(evt);
            }
        });
        jPanel3.add(logOut_btn1);
        logOut_btn1.setBounds(270, 590, 110, 30);

        newResidentBG_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG5.png"))); // NOI18N
        jPanel3.add(newResidentBG_lbl);
        newResidentBG_lbl.setBounds(0, -10, 400, 710);

        jTabbedPane1.addTab("Adicionar Novo Residente", jPanel3);

        jPanel1.setLayout(null);

        deleteAccountProfile_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteAccountProfile_btn.setForeground(new java.awt.Color(255, 0, 0));
        deleteAccountProfile_btn.setText("EXCLUIR CONTA");
        deleteAccountProfile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountProfile_btnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteAccountProfile_btn);
        deleteAccountProfile_btn.setBounds(120, 490, 170, 30);

        showPassword_btn.setBackground(new java.awt.Color(255, 255, 255));
        showPassword_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eyeIcon.png"))); // NOI18N
        showPassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword_btnActionPerformed(evt);
            }
        });
        jPanel1.add(showPassword_btn);
        showPassword_btn.setBounds(333, 380, 50, 30);

        cpfProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cpfProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getCpf());
        cpfProfile_txt.setEnabled(false);
        jPanel1.add(cpfProfile_txt);
        cpfProfile_txt.setBounds(110, 180, 270, 30);

        passwordProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getPassword());
        jPanel1.add(passwordProfile_txt);
        passwordProfile_txt.setBounds(110, 380, 220, 30);

        addressProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getAddress());
        jPanel1.add(addressProfile_txt);
        addressProfile_txt.setBounds(110, 330, 270, 30);

        emailProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getEmail());
        jPanel1.add(emailProfile_txt);
        emailProfile_txt.setBounds(110, 280, 270, 30);

        nameProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getName());
        jPanel1.add(nameProfile_txt);
        nameProfile_txt.setBounds(110, 230, 270, 30);

        cpfSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl.setText("CPF:");
        jPanel1.add(cpfSingUp_lbl);
        cpfSingUp_lbl.setBounds(10, 180, 70, 30);

        nameSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        nameSingUp_lbl.setText("Nome:");
        jPanel1.add(nameSingUp_lbl);
        nameSingUp_lbl.setBounds(10, 230, 70, 30);

        emailSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        emailSingUp_lbl.setText("Email:");
        jPanel1.add(emailSingUp_lbl);
        emailSingUp_lbl.setBounds(10, 280, 70, 30);

        addressSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addressSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        addressSingUp_lbl.setText("Endereco:");
        jPanel1.add(addressSingUp_lbl);
        addressSingUp_lbl.setBounds(10, 330, 110, 30);

        passwordSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passwordSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        passwordSingUp_lbl.setText("Senha:");
        jPanel1.add(passwordSingUp_lbl);
        passwordSingUp_lbl.setBounds(10, 380, 70, 30);

        updateProfile_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateProfile_btn.setText("ALTERAR");
        updateProfile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfile_btnActionPerformed(evt);
            }
        });
        jPanel1.add(updateProfile_btn);
        updateProfile_btn.setBounds(30, 440, 170, 30);

        refreshFields_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        refreshFields_btn.setText("RESETAR CAMPOS");
        refreshFields_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshFields_btnActionPerformed(evt);
            }
        });
        jPanel1.add(refreshFields_btn);
        refreshFields_btn.setBounds(210, 440, 170, 30);

        logOut_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOut_btn.setText("LOGOUT");
        logOut_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btnActionPerformed(evt);
            }
        });
        jPanel1.add(logOut_btn);
        logOut_btn.setBounds(270, 590, 110, 30);

        exit_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn.setText("SAIR");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn);
        exit_btn.setBounds(270, 630, 110, 30);

        profileBG_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG6.png"))); // NOI18N
        jPanel1.add(profileBG_lbl);
        profileBG_lbl.setBounds(0, -10, 400, 710);

        jTabbedPane1.addTab("Perfil", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(396, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword_btnActionPerformed
        if (showPassword_btn.isSelected()) {
            // Mostrar os caracteres reais
            passwordProfile_txt.setEchoChar('\0');
        } else {
            // Ocultar os caracteres reais
            passwordProfile_txt.setEchoChar('*'); // Pode ser alterado para o caractere que você preferir
        }
    }//GEN-LAST:event_showPassword_btnActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void exit_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn1ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn1ActionPerformed

    private void exit_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn2ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn2ActionPerformed

    private void logOut_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btnActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
    }//GEN-LAST:event_logOut_btnActionPerformed

    private void logOut_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btn1ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
    }//GEN-LAST:event_logOut_btn1ActionPerformed

    private void logOut_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btn2ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
    }//GEN-LAST:event_logOut_btn2ActionPerformed

    private void refreshFields_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshFields_btnActionPerformed
        Model.Funcs_DAO.profileRefresh();
    }//GEN-LAST:event_refreshFields_btnActionPerformed

    private void updateProfile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfile_btnActionPerformed
        if (Model.Funcs_DAO.updateConfirmation()) {
            String cpf = cpfProfile_txt.getText();
            String name = nameProfile_txt.getText();
            String email = emailProfile_txt.getText();
            String address = addressProfile_txt.getText();
            String password = passwordProfile_txt.getText();
            if (Model.TutorFuncs_DAO.updateTutor(cpf, name, email, address, password)) {
                Model.Funcs_DAO.profileRefresh();
            }
        }
    }//GEN-LAST:event_updateProfile_btnActionPerformed

    private void deleteAccountProfile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountProfile_btnActionPerformed
        if (Model.Funcs_DAO.deleteAccountConfirmation()) {
            if (Model.TutorFuncs_DAO.deleteAccount()) {
                Controller.LoggedUser_Controller.logout();
                Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
            }
        }
    }//GEN-LAST:event_deleteAccountProfile_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainTutorMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTutorMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTutorMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTutorMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainTutorMenu_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField addressProfile_txt;
    private javax.swing.JLabel addressSingUp_lbl;
    public static javax.swing.JTextField cpfProfile_txt;
    private javax.swing.JLabel cpfSingUp_lbl;
    public static javax.swing.JButton deleteAccountProfile_btn;
    public static javax.swing.JTextField emailProfile_txt;
    private javax.swing.JLabel emailSingUp_lbl;
    public static javax.swing.JButton exit_btn;
    public static javax.swing.JButton exit_btn1;
    public static javax.swing.JButton exit_btn2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JButton logOut_btn;
    public static javax.swing.JButton logOut_btn1;
    public static javax.swing.JButton logOut_btn2;
    public static javax.swing.JTextField nameProfile_txt;
    private javax.swing.JLabel nameSingUp_lbl;
    private javax.swing.JLabel newResidentBG_lbl;
    public static javax.swing.JPasswordField passwordProfile_txt;
    private javax.swing.JLabel passwordSingUp_lbl;
    private javax.swing.JLabel profileBG_lbl;
    public static javax.swing.JButton refreshFields_btn;
    private javax.swing.JLabel residentsBG_lbl;
    private javax.swing.JToggleButton showPassword_btn;
    public static javax.swing.JButton updateProfile_btn;
    // End of variables declaration//GEN-END:variables
}
