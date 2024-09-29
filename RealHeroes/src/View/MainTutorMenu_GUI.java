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
        cpfSingUp_lbl2 = new javax.swing.JLabel();
        cpfResidentFeedback_cb = new javax.swing.JComboBox();
        readFeedback_btn = new javax.swing.JButton();
        addAlterFeedback_btn = new javax.swing.JButton();
        cpfSingUp_lbl3 = new javax.swing.JLabel();
        phaseFeedback_cb = new javax.swing.JComboBox();
        cpfSingUp_lbl4 = new javax.swing.JLabel();
        attemptFeedback_cb = new javax.swing.JComboBox();
        cpfSingUp_lbl5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedback_txt = new javax.swing.JTextArea();
        deleteFeedback_btn = new javax.swing.JButton();
        residentsBG_lbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit_btn1 = new javax.swing.JButton();
        logOut_btn1 = new javax.swing.JButton();
        sendSingUp_btn = new javax.swing.JButton();
        cpfAddResident_txt = new javax.swing.JTextField();
        nameAddResident_txt = new javax.swing.JTextField();
        emailAddResident_txt = new javax.swing.JTextField();
        addressAddResident_txt = new javax.swing.JTextField();
        residentData_lbl = new javax.swing.JLabel();
        addressSingUp_lbl1 = new javax.swing.JLabel();
        emailSingUp_lbl1 = new javax.swing.JLabel();
        nameSingUp_lbl1 = new javax.swing.JLabel();
        cpfSingUp_lbl1 = new javax.swing.JLabel();
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

        cpfSingUp_lbl2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl2.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl2.setText("CPF:");
        jPanel2.add(cpfSingUp_lbl2);
        cpfSingUp_lbl2.setBounds(20, 100, 70, 30);

        cpfResidentFeedback_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLIQUE NUM ITEM PARA ATUALZAR" }));
        cpfResidentFeedback_cb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cpfResidentFeedback_cbFocusGained(evt);
            }
        });
        cpfResidentFeedback_cb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpfResidentFeedback_cbMouseClicked(evt);
            }
        });
        cpfResidentFeedback_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfResidentFeedback_cbActionPerformed(evt);
            }
        });
        jPanel2.add(cpfResidentFeedback_cb);
        cpfResidentFeedback_cb.setBounds(120, 100, 240, 30);

        readFeedback_btn.setText("CONSULTAR FEEDBACK");
        readFeedback_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFeedback_btnActionPerformed(evt);
            }
        });
        jPanel2.add(readFeedback_btn);
        readFeedback_btn.setBounds(90, 380, 220, 40);

        addAlterFeedback_btn.setText("ADICIONAR/ALTERAR FEEDBACK");
        addAlterFeedback_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlterFeedback_btnActionPerformed(evt);
            }
        });
        jPanel2.add(addAlterFeedback_btn);
        addAlterFeedback_btn.setBounds(90, 440, 220, 40);

        cpfSingUp_lbl3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl3.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl3.setText("FASE:");
        jPanel2.add(cpfSingUp_lbl3);
        cpfSingUp_lbl3.setBounds(20, 140, 70, 30);

        phaseFeedback_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE A TENTATIVA" }));
        phaseFeedback_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phaseFeedback_cbActionPerformed(evt);
            }
        });
        jPanel2.add(phaseFeedback_cb);
        phaseFeedback_cb.setBounds(120, 140, 240, 30);

        cpfSingUp_lbl4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl4.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl4.setText("FEEDBACK:");
        jPanel2.add(cpfSingUp_lbl4);
        cpfSingUp_lbl4.setBounds(20, 230, 110, 30);

        attemptFeedback_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE A TENTATIVA" }));
        jPanel2.add(attemptFeedback_cb);
        attemptFeedback_cb.setBounds(140, 180, 220, 30);

        cpfSingUp_lbl5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl5.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl5.setText("TENTATIVA:");
        jPanel2.add(cpfSingUp_lbl5);
        cpfSingUp_lbl5.setBounds(20, 180, 110, 30);

        feedback_txt.setColumns(20);
        feedback_txt.setRows(5);
        feedback_txt.setText("ESCREVA SEU FEEDBACK AQUI");
        jScrollPane1.setViewportView(feedback_txt);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(140, 230, 220, 90);

        deleteFeedback_btn.setText("EXCLUIR FEEDBACK");
        jPanel2.add(deleteFeedback_btn);
        deleteFeedback_btn.setBounds(90, 500, 220, 40);

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

        sendSingUp_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendSingUp_btn.setText("CADASTRAR");
        sendSingUp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendSingUp_btnActionPerformed(evt);
            }
        });
        jPanel3.add(sendSingUp_btn);
        sendSingUp_btn.setBounds(100, 450, 200, 30);

        cpfAddResident_txt.setText("CPF");
        cpfAddResident_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfAddResident_txtActionPerformed(evt);
            }
        });
        jPanel3.add(cpfAddResident_txt);
        cpfAddResident_txt.setBounds(110, 180, 260, 30);

        nameAddResident_txt.setText("NOME COMPLETO");
        nameAddResident_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAddResident_txtActionPerformed(evt);
            }
        });
        jPanel3.add(nameAddResident_txt);
        nameAddResident_txt.setBounds(110, 240, 260, 30);

        emailAddResident_txt.setText("EMAIL");
        jPanel3.add(emailAddResident_txt);
        emailAddResident_txt.setBounds(110, 300, 260, 30);

        addressAddResident_txt.setText("ENDERECO");
        jPanel3.add(addressAddResident_txt);
        addressAddResident_txt.setBounds(110, 360, 260, 30);

        residentData_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        residentData_lbl.setForeground(new java.awt.Color(255, 255, 255));
        residentData_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        residentData_lbl.setText("Dados do residente");
        jPanel3.add(residentData_lbl);
        residentData_lbl.setBounds(10, 110, 370, 30);

        addressSingUp_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addressSingUp_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        addressSingUp_lbl1.setText("Endereco:");
        jPanel3.add(addressSingUp_lbl1);
        addressSingUp_lbl1.setBounds(10, 360, 110, 30);

        emailSingUp_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailSingUp_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        emailSingUp_lbl1.setText("Email:");
        jPanel3.add(emailSingUp_lbl1);
        emailSingUp_lbl1.setBounds(10, 300, 70, 30);

        nameSingUp_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameSingUp_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        nameSingUp_lbl1.setText("Nome:");
        jPanel3.add(nameSingUp_lbl1);
        nameSingUp_lbl1.setBounds(10, 240, 70, 30);

        cpfSingUp_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl1.setText("CPF:");
        jPanel3.add(cpfSingUp_lbl1);
        cpfSingUp_lbl1.setBounds(10, 180, 70, 30);

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
        cpfProfile_txt.setDisabledTextColor(new java.awt.Color(255, 102, 102));
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
            passwordProfile_txt.setEchoChar('\u25cf'); 
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

    private void nameAddResident_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameAddResident_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameAddResident_txtActionPerformed

    private void cpfAddResident_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfAddResident_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfAddResident_txtActionPerformed

    private void sendSingUp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendSingUp_btnActionPerformed
        String cpf = cpfAddResident_txt.getText();
        String name = nameAddResident_txt.getText();
        String email = emailAddResident_txt.getText();
        String address = addressAddResident_txt.getText();
        Model.ResidentFuncs_DAO.addResident(cpf, name, email, address, Controller.LoggedUser_Controller.getLoggedUser().getCpf());
    }//GEN-LAST:event_sendSingUp_btnActionPerformed

    private void phaseFeedback_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phaseFeedback_cbActionPerformed
        Model.ResidentFuncs_DAO.updateAttemptCombobox();
    }//GEN-LAST:event_phaseFeedback_cbActionPerformed

    private void readFeedback_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFeedback_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readFeedback_btnActionPerformed

    private void cpfResidentFeedback_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfResidentFeedback_cbActionPerformed
        Model.ResidentFuncs_DAO.updateCombobox();
        Model.ResidentFuncs_DAO.updatePhaseCombobox();
    }//GEN-LAST:event_cpfResidentFeedback_cbActionPerformed

    private void cpfResidentFeedback_cbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpfResidentFeedback_cbMouseClicked
   
    }//GEN-LAST:event_cpfResidentFeedback_cbMouseClicked

    private void cpfResidentFeedback_cbFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpfResidentFeedback_cbFocusGained
 
    }//GEN-LAST:event_cpfResidentFeedback_cbFocusGained

    private void addAlterFeedback_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlterFeedback_btnActionPerformed
        Model.ResidentFuncs_DAO.setUpdateFeedback();
    }//GEN-LAST:event_addAlterFeedback_btnActionPerformed

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
    private javax.swing.JButton addAlterFeedback_btn;
    public static javax.swing.JTextField addressAddResident_txt;
    public static javax.swing.JTextField addressProfile_txt;
    private javax.swing.JLabel addressSingUp_lbl;
    private javax.swing.JLabel addressSingUp_lbl1;
    public static javax.swing.JComboBox attemptFeedback_cb;
    public static javax.swing.JTextField cpfAddResident_txt;
    public static javax.swing.JTextField cpfProfile_txt;
    public static javax.swing.JComboBox cpfResidentFeedback_cb;
    private javax.swing.JLabel cpfSingUp_lbl;
    private javax.swing.JLabel cpfSingUp_lbl1;
    private javax.swing.JLabel cpfSingUp_lbl2;
    private javax.swing.JLabel cpfSingUp_lbl3;
    private javax.swing.JLabel cpfSingUp_lbl4;
    private javax.swing.JLabel cpfSingUp_lbl5;
    public static javax.swing.JButton deleteAccountProfile_btn;
    private javax.swing.JButton deleteFeedback_btn;
    public static javax.swing.JTextField emailAddResident_txt;
    public static javax.swing.JTextField emailProfile_txt;
    private javax.swing.JLabel emailSingUp_lbl;
    private javax.swing.JLabel emailSingUp_lbl1;
    public static javax.swing.JButton exit_btn;
    public static javax.swing.JButton exit_btn1;
    public static javax.swing.JButton exit_btn2;
    public static javax.swing.JTextArea feedback_txt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JButton logOut_btn;
    public static javax.swing.JButton logOut_btn1;
    public static javax.swing.JButton logOut_btn2;
    public static javax.swing.JTextField nameAddResident_txt;
    public static javax.swing.JTextField nameProfile_txt;
    private javax.swing.JLabel nameSingUp_lbl;
    private javax.swing.JLabel nameSingUp_lbl1;
    private javax.swing.JLabel newResidentBG_lbl;
    public static javax.swing.JPasswordField passwordProfile_txt;
    private javax.swing.JLabel passwordSingUp_lbl;
    public static javax.swing.JComboBox phaseFeedback_cb;
    private javax.swing.JLabel profileBG_lbl;
    private javax.swing.JButton readFeedback_btn;
    public static javax.swing.JButton refreshFields_btn;
    private javax.swing.JLabel residentData_lbl;
    private javax.swing.JLabel residentsBG_lbl;
    public static javax.swing.JButton sendSingUp_btn;
    private javax.swing.JToggleButton showPassword_btn;
    public static javax.swing.JButton updateProfile_btn;
    // End of variables declaration//GEN-END:variables
}
