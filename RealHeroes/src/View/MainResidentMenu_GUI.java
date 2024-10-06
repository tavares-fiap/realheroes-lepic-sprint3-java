/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author labsfiap
 */
public class MainResidentMenu_GUI extends javax.swing.JFrame {

    public static TableModel deviceInfo(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form MainResidentMenu_GUI
     */
    public MainResidentMenu_GUI() {
        initComponents();
    }
    public static DefaultTableModel deviceInfoFunc(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            columnNames.addElement("IDdevice");
            columnNames.addElement("Description");
            columnNames.addElement("Marca");

            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            return null;
        }
    }
    
    //-- Inicio Jtable 
    public static DefaultTableModel attemptTableFunc(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            columnNames.addElement("ID");
            columnNames.addElement("SCORE");
            columnNames.addElement("DATA");
            columnNames.addElement("HR_CONCLUSÃO");

            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            return null;
        }
    }
    // ---Fim Jtable
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("realheroes?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        deviceQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Device d");
        deviceList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : deviceQuery.getResultList();
        entityManager0 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("REALHEROES?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        deviceQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT d FROM Device d");
        deviceList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : deviceQuery1.getResultList();
        deviceQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT d FROM Device d");
        deviceList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : deviceQuery2.getResultList();
        deviceQuery3 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT d FROM Device d");
        deviceList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : deviceQuery3.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deviceInfo = new javax.swing.JTable();
        searchDevices_btn = new javax.swing.JButton();
        idDevice_cb = new javax.swing.JComboBox();
        idDispositivo_lbl = new javax.swing.JLabel();
        playerScore_lbl = new javax.swing.JLabel();
        brand_lbl = new javax.swing.JLabel();
        brand_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        deviceDescription_txt = new javax.swing.JTextArea();
        brand_lbl1 = new javax.swing.JLabel();
        reserveDevice_btn = new javax.swing.JButton();
        logOut_btn2 = new javax.swing.JButton();
        exit_btn2 = new javax.swing.JButton();
        dataRetirada_txt = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        phaseFeedback_cb = new javax.swing.JComboBox();
        cpfSingUp_lbl3 = new javax.swing.JLabel();
        cpfSingUp_lbl5 = new javax.swing.JLabel();
        attemptFeedback_cb = new javax.swing.JComboBox();
        playerScore_lbl1 = new javax.swing.JLabel();
        playerScore_txt = new javax.swing.JTextField();
        playerScore_lbl2 = new javax.swing.JLabel();
        completionDate_txt = new javax.swing.JTextField();
        playerScore_lbl3 = new javax.swing.JLabel();
        completionTime_txt = new javax.swing.JTextField();
        cpfSingUp_lbl4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        attemptTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        feedback_txt = new javax.swing.JTextArea();
        logOut_btn4 = new javax.swing.JButton();
        exit_btn4 = new javax.swing.JButton();
        feedbackBG_lbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        myTutor_btn = new javax.swing.JButton();
        refreshFields_btn = new javax.swing.JButton();
        updateProfile_btn = new javax.swing.JButton();
        showPassword_btn = new javax.swing.JToggleButton();
        passwordProfile_txt = new javax.swing.JPasswordField();
        passwordSingUp_lbl = new javax.swing.JLabel();
        addressProfile_txt = new javax.swing.JTextField();
        addressSingUp_lbl = new javax.swing.JLabel();
        emailProfile_txt = new javax.swing.JTextField();
        emailSingUp_lbl = new javax.swing.JLabel();
        nameProfile_txt = new javax.swing.JTextField();
        nameSingUp_lbl = new javax.swing.JLabel();
        cpfProfile_txt = new javax.swing.JTextField();
        cpfProfile_lbl = new javax.swing.JLabel();
        logOut_btn3 = new javax.swing.JButton();
        exit_btn3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setLayout(null);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, deviceList3, deviceInfo);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${IDdevice}"));
        columnBinding.setColumnName("IDdevice");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Description");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${marca}"));
        columnBinding.setColumnName("Marca");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(deviceInfo);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 160, 390, 160);

        searchDevices_btn.setText("Buscar dispositivos disponíveis");
        searchDevices_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDevices_btnActionPerformed(evt);
            }
        });
        jPanel1.add(searchDevices_btn);
        searchDevices_btn.setBounds(10, 120, 370, 25);

        idDevice_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE O DISPOSITIVO DESEJADO" }));
        idDevice_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDevice_cbActionPerformed(evt);
            }
        });
        jPanel1.add(idDevice_cb);
        idDevice_cb.setBounds(150, 330, 230, 30);

        idDispositivo_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idDispositivo_lbl.setForeground(new java.awt.Color(255, 255, 255));
        idDispositivo_lbl.setText("ID Dispositivo:");
        jPanel1.add(idDispositivo_lbl);
        idDispositivo_lbl.setBounds(10, 330, 150, 30);

        playerScore_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        playerScore_lbl.setForeground(new java.awt.Color(255, 255, 255));
        playerScore_lbl.setText("Descrição:");
        jPanel1.add(playerScore_lbl);
        playerScore_lbl.setBounds(10, 400, 110, 30);

        brand_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        brand_lbl.setForeground(new java.awt.Color(255, 255, 255));
        brand_lbl.setText("MARCA:");
        jPanel1.add(brand_lbl);
        brand_lbl.setBounds(0, 480, 130, 30);

        brand_txt.setText("MARCA DO DISPOSITIVO");
        brand_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        brand_txt.setEnabled(false);
        brand_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_txtActionPerformed(evt);
            }
        });
        jPanel1.add(brand_txt);
        brand_txt.setBounds(150, 480, 230, 30);

        deviceDescription_txt.setEditable(false);
        deviceDescription_txt.setColumns(20);
        deviceDescription_txt.setRows(5);
        deviceDescription_txt.setText("DESCRIÇÂO");
        deviceDescription_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(deviceDescription_txt);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(150, 380, 230, 80);

        brand_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        brand_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        brand_lbl1.setText("DATA PARA RETIRAR:");
        jPanel1.add(brand_lbl1);
        brand_lbl1.setBounds(10, 80, 200, 30);

        reserveDevice_btn.setText("Reservar Dispositivo");
        reserveDevice_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveDevice_btnActionPerformed(evt);
            }
        });
        jPanel1.add(reserveDevice_btn);
        reserveDevice_btn.setBounds(220, 540, 160, 40);

        logOut_btn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOut_btn2.setText("LOGOUT");
        logOut_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(logOut_btn2);
        logOut_btn2.setBounds(270, 590, 110, 30);

        exit_btn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn2.setText("SAIR");
        exit_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn2);
        exit_btn2.setBounds(270, 630, 110, 30);
        jPanel1.add(dataRetirada_txt);
        dataRetirada_txt.setBounds(230, 80, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -20, 390, 740);

        jTabbedPane1.addTab("Reservar Óculos", jPanel1);

        jPanel2.setLayout(null);

        phaseFeedback_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE A FASE" }));
        phaseFeedback_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phaseFeedback_cbActionPerformed(evt);
            }
        });
        jPanel2.add(phaseFeedback_cb);
        phaseFeedback_cb.setBounds(120, 80, 260, 30);

        cpfSingUp_lbl3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl3.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl3.setText("FASE:");
        jPanel2.add(cpfSingUp_lbl3);
        cpfSingUp_lbl3.setBounds(20, 80, 70, 30);

        cpfSingUp_lbl5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl5.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl5.setText("TENTATIVA:");
        jPanel2.add(cpfSingUp_lbl5);
        cpfSingUp_lbl5.setBounds(20, 240, 110, 30);

        attemptFeedback_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE A TENTATIVA" }));
        attemptFeedback_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attemptFeedback_cbActionPerformed(evt);
            }
        });
        jPanel2.add(attemptFeedback_cb);
        attemptFeedback_cb.setBounds(140, 240, 240, 30);

        playerScore_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        playerScore_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        playerScore_lbl1.setText("SCORE:");
        jPanel2.add(playerScore_lbl1);
        playerScore_lbl1.setBounds(20, 280, 110, 30);

        playerScore_txt.setText("SCORE DA TENTATIVA");
        playerScore_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        playerScore_txt.setEnabled(false);
        playerScore_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerScore_txtActionPerformed(evt);
            }
        });
        jPanel2.add(playerScore_txt);
        playerScore_txt.setBounds(140, 280, 240, 30);

        playerScore_lbl2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        playerScore_lbl2.setForeground(new java.awt.Color(255, 255, 255));
        playerScore_lbl2.setText("CONCLUSÃO:");
        jPanel2.add(playerScore_lbl2);
        playerScore_lbl2.setBounds(20, 320, 130, 30);

        completionDate_txt.setText("DATA CONCLUSÃO");
        completionDate_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        completionDate_txt.setEnabled(false);
        completionDate_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completionDate_txtActionPerformed(evt);
            }
        });
        jPanel2.add(completionDate_txt);
        completionDate_txt.setBounds(140, 320, 240, 30);

        playerScore_lbl3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        playerScore_lbl3.setForeground(new java.awt.Color(255, 255, 255));
        playerScore_lbl3.setText("HORÁRIO:");
        jPanel2.add(playerScore_lbl3);
        playerScore_lbl3.setBounds(20, 360, 130, 30);

        completionTime_txt.setText("HORARIO DE CONCLUSAO");
        completionTime_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        completionTime_txt.setEnabled(false);
        completionTime_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completionTime_txtActionPerformed(evt);
            }
        });
        jPanel2.add(completionTime_txt);
        completionTime_txt.setBounds(140, 360, 240, 30);

        cpfSingUp_lbl4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfSingUp_lbl4.setForeground(new java.awt.Color(255, 255, 255));
        cpfSingUp_lbl4.setText("FEEDBACK:");
        jPanel2.add(cpfSingUp_lbl4);
        cpfSingUp_lbl4.setBounds(20, 400, 110, 30);

        attemptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(attemptTable);

        jPanel2.add(jScrollPane5);
        jScrollPane5.setBounds(10, 120, 370, 110);

        feedback_txt.setColumns(20);
        feedback_txt.setRows(5);
        feedback_txt.setText("ESCREVA SEU FEEDBACK AQUI");
        jScrollPane3.setViewportView(feedback_txt);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(140, 400, 240, 80);

        logOut_btn4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOut_btn4.setText("LOGOUT");
        logOut_btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(logOut_btn4);
        logOut_btn4.setBounds(270, 590, 110, 30);

        exit_btn4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn4.setText("SAIR");
        exit_btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(exit_btn4);
        exit_btn4.setBounds(270, 630, 110, 30);

        feedbackBG_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG7.png"))); // NOI18N
        jPanel2.add(feedbackBG_lbl);
        feedbackBG_lbl.setBounds(0, -10, 400, 710);

        jTabbedPane1.addTab("Visualizar Feedbacks", jPanel2);

        jPanel3.setLayout(null);

        myTutor_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        myTutor_btn.setText("ALTERAR");
        myTutor_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myTutor_btnActionPerformed(evt);
            }
        });
        jPanel3.add(myTutor_btn);
        myTutor_btn.setBounds(20, 450, 350, 30);

        refreshFields_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        refreshFields_btn.setText("RESETAR CAMPOS");
        refreshFields_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshFields_btnActionPerformed(evt);
            }
        });
        jPanel3.add(refreshFields_btn);
        refreshFields_btn.setBounds(200, 490, 170, 30);

        updateProfile_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateProfile_btn.setText("ALTERAR");
        updateProfile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfile_btnActionPerformed(evt);
            }
        });
        jPanel3.add(updateProfile_btn);
        updateProfile_btn.setBounds(20, 490, 170, 30);

        showPassword_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eyeIcon.png"))); // NOI18N
        showPassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword_btnActionPerformed(evt);
            }
        });
        jPanel3.add(showPassword_btn);
        showPassword_btn.setBounds(333, 380, 50, 30);

        passwordProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getPassword());
        jPanel3.add(passwordProfile_txt);
        passwordProfile_txt.setBounds(110, 380, 220, 30);

        passwordSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passwordSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        passwordSingUp_lbl.setText("Senha:");
        jPanel3.add(passwordSingUp_lbl);
        passwordSingUp_lbl.setBounds(10, 380, 70, 30);

        addressProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addressProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getAddress());
        jPanel3.add(addressProfile_txt);
        addressProfile_txt.setBounds(110, 330, 270, 30);

        addressSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addressSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        addressSingUp_lbl.setText("Endereco:");
        jPanel3.add(addressSingUp_lbl);
        addressSingUp_lbl.setBounds(10, 330, 110, 30);

        emailProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getEmail());
        jPanel3.add(emailProfile_txt);
        emailProfile_txt.setBounds(110, 280, 270, 30);

        emailSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        emailSingUp_lbl.setText("Email:");
        jPanel3.add(emailSingUp_lbl);
        emailSingUp_lbl.setBounds(10, 280, 70, 30);

        nameProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getName());
        jPanel3.add(nameProfile_txt);
        nameProfile_txt.setBounds(110, 230, 270, 30);

        nameSingUp_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameSingUp_lbl.setForeground(new java.awt.Color(255, 255, 255));
        nameSingUp_lbl.setText("Nome:");
        jPanel3.add(nameSingUp_lbl);
        nameSingUp_lbl.setBounds(10, 230, 70, 30);

        cpfProfile_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cpfProfile_txt.setText(Controller.LoggedUser_Controller.getLoggedUser().getCpf());
        cpfProfile_txt.setDisabledTextColor(new java.awt.Color(255, 102, 102));
        cpfProfile_txt.setEnabled(false);
        cpfProfile_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfProfile_txtActionPerformed(evt);
            }
        });
        jPanel3.add(cpfProfile_txt);
        cpfProfile_txt.setBounds(110, 180, 270, 30);

        cpfProfile_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpfProfile_lbl.setForeground(new java.awt.Color(255, 255, 255));
        cpfProfile_lbl.setText("CPF:");
        jPanel3.add(cpfProfile_lbl);
        cpfProfile_lbl.setBounds(10, 180, 70, 30);

        logOut_btn3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOut_btn3.setText("LOGOUT");
        logOut_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btn3ActionPerformed(evt);
            }
        });
        jPanel3.add(logOut_btn3);
        logOut_btn3.setBounds(270, 590, 110, 30);

        exit_btn3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn3.setText("SAIR");
        exit_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn3ActionPerformed(evt);
            }
        });
        jPanel3.add(exit_btn3);
        exit_btn3.setBounds(270, 630, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(-1, -10, 390, 720);

        jTabbedPane1.addTab("Perfil", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(396, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brand_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_txtActionPerformed

    private void searchDevices_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDevices_btnActionPerformed
    java.util.Date selectedDate = dataRetirada_txt.getDate();
    Model.DeviceFuncs_DAO.getAvaiableDevices(selectedDate);  // Passando a data para a função
    Model.DeviceFuncs_DAO.setDeviceIds(selectedDate);
    }//GEN-LAST:event_searchDevices_btnActionPerformed

    private void idDevice_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDevice_cbActionPerformed
        Integer selectedID = (Integer) idDevice_cb.getSelectedItem();
        Model.DeviceFuncs_DAO.showSelectedDeviceInfo(String.valueOf(selectedID));
    }//GEN-LAST:event_idDevice_cbActionPerformed

    private void reserveDevice_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveDevice_btnActionPerformed
        // Verifique se a JComboBox foi inicializada
    if (idDevice_cb == null) {
        System.out.println("JComboBox idDevice_cb não foi inicializada.");
        return;
    }

    // Verifique se há um item selecionado
    Integer selectedID = (Integer) idDevice_cb.getSelectedItem();
    if (selectedID == null) {
        System.out.println("Nenhum dispositivo foi selecionado.");
        return;
    }

    // Verifique o campo de texto da data
    if (dataRetirada_txt.getDate() == null) {
        System.out.println("Campo de texto dataRt_txt não foi inicializado.");
        return;
    }

    String selectedDataRt = String.valueOf(dataRetirada_txt.getDate());
    if (selectedDataRt.isEmpty()) {
        System.out.println("A data de reserva não foi inserida.");
        return;
    }

    // Verifique se o usuário logado está definido
    if (Controller.LoggedUser_Controller.getLoggedUser() == null) {
        System.out.println("Usuário não está logado.");
        return;
    }

    String selectedCPF = Controller.LoggedUser_Controller.getLoggedUser().getCpf();

    // Agora podemos chamar a função para reservar o dispositivo
    Model.DeviceFuncs_DAO.reserveDevice(selectedID, selectedCPF, selectedDataRt);
    }//GEN-LAST:event_reserveDevice_btnActionPerformed

    private void logOut_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btn2ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
    }//GEN-LAST:event_logOut_btn2ActionPerformed

    private void exit_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn2ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn2ActionPerformed

    private void logOut_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btn3ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
    }//GEN-LAST:event_logOut_btn3ActionPerformed

    private void exit_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn3ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn3ActionPerformed

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
            if (Model.ResidentFuncs_DAO.updateResident(cpf, name, email, address, password)) {
                Model.Funcs_DAO.profileRefresh();
            }
        }
    }//GEN-LAST:event_updateProfile_btnActionPerformed

    private void showPassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword_btnActionPerformed
        if (showPassword_btn.isSelected()) {
            // Mostrar os caracteres reais
            passwordProfile_txt.setEchoChar('\0');
        } else {
            // Ocultar os caracteres reais
            passwordProfile_txt.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_showPassword_btnActionPerformed

    private void cpfProfile_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfProfile_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfProfile_txtActionPerformed

    private void myTutor_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myTutor_btnActionPerformed
        Model.Resident logedResident = (Model.Resident) Controller.LoggedUser_Controller.getLoggedUser();
        JOptionPane.showMessageDialog(null, "-=-=-=-=-=-SEU TUTOR-=-=-=-=-=-\n" + logedResident.getTutor().toString());
    }//GEN-LAST:event_myTutor_btnActionPerformed

    private void phaseFeedback_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phaseFeedback_cbActionPerformed
        String selectedPhase = String.valueOf(phaseFeedback_cb.getSelectedItem());
        String cpf = Controller.LoggedUser_Controller.getLoggedUser().getCpf();
        Model.RefreshFuncs_DAO.refreshResidentAttemptOptions(selectedPhase, cpf);
        Model.RefreshFuncs_DAO.refreshAttemptsTable(selectedPhase, cpf); 
        Model.Funcs_DAO.resetResidentFeedbackFields();

    }//GEN-LAST:event_phaseFeedback_cbActionPerformed

    private void attemptFeedback_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attemptFeedback_cbActionPerformed
        String selectedPhase = (String) phaseFeedback_cb.getSelectedItem();
        String selectedAttempt = (String) attemptFeedback_cb.getSelectedItem();
        Model.AttemptFuncs_DAO.showSelectedAttemptInfoForResident(selectedPhase, selectedAttempt);
    }//GEN-LAST:event_attemptFeedback_cbActionPerformed

    private void playerScore_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerScore_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerScore_txtActionPerformed

    private void completionDate_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completionDate_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completionDate_txtActionPerformed

    private void completionTime_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completionTime_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completionTime_txtActionPerformed

    private void logOut_btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btn4ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new SetUp_GUI());
    }//GEN-LAST:event_logOut_btn4ActionPerformed

    private void exit_btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn4ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn4ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int selectedIndex = jTabbedPane1.getSelectedIndex(); // Obtém o índice da aba selecionada
        if (selectedIndex == 1) {
            Model.RefreshFuncs_DAO.refreshResidentPhaseOptions(Controller.LoggedUser_Controller.getLoggedUser().getCpf());
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
            java.util.logging.Logger.getLogger(MainResidentMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainResidentMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainResidentMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainResidentMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainResidentMenu_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField addressProfile_txt;
    private javax.swing.JLabel addressSingUp_lbl;
    public static javax.swing.JComboBox attemptFeedback_cb;
    public static javax.swing.JTable attemptTable;
    private javax.swing.JLabel brand_lbl;
    private javax.swing.JLabel brand_lbl1;
    public static javax.swing.JTextField brand_txt;
    public static javax.swing.JTextField completionDate_txt;
    public static javax.swing.JTextField completionTime_txt;
    private javax.swing.JLabel cpfProfile_lbl;
    public static javax.swing.JTextField cpfProfile_txt;
    private javax.swing.JLabel cpfSingUp_lbl3;
    private javax.swing.JLabel cpfSingUp_lbl4;
    private javax.swing.JLabel cpfSingUp_lbl5;
    private com.toedter.calendar.JDateChooser dataRetirada_txt;
    public static javax.swing.JTextArea deviceDescription_txt;
    public static javax.swing.JTable deviceInfo;
    private java.util.List<View.Device> deviceList;
    private java.util.List<View.Device> deviceList1;
    private java.util.List<View.Device> deviceList2;
    private java.util.List<View.Device> deviceList3;
    private javax.persistence.Query deviceQuery;
    private javax.persistence.Query deviceQuery1;
    private javax.persistence.Query deviceQuery2;
    private javax.persistence.Query deviceQuery3;
    public static javax.swing.JTextField emailProfile_txt;
    private javax.swing.JLabel emailSingUp_lbl;
    private javax.persistence.EntityManager entityManager;
    private javax.persistence.EntityManager entityManager0;
    public static javax.swing.JButton exit_btn2;
    public static javax.swing.JButton exit_btn3;
    public static javax.swing.JButton exit_btn4;
    private javax.swing.JLabel feedbackBG_lbl;
    public static javax.swing.JTextArea feedback_txt;
    public static javax.swing.JComboBox idDevice_cb;
    private javax.swing.JLabel idDispositivo_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JButton logOut_btn2;
    public static javax.swing.JButton logOut_btn3;
    public static javax.swing.JButton logOut_btn4;
    public static javax.swing.JButton myTutor_btn;
    public static javax.swing.JTextField nameProfile_txt;
    private javax.swing.JLabel nameSingUp_lbl;
    public static javax.swing.JPasswordField passwordProfile_txt;
    private javax.swing.JLabel passwordSingUp_lbl;
    public static javax.swing.JComboBox phaseFeedback_cb;
    private javax.swing.JLabel playerScore_lbl;
    private javax.swing.JLabel playerScore_lbl1;
    private javax.swing.JLabel playerScore_lbl2;
    private javax.swing.JLabel playerScore_lbl3;
    public static javax.swing.JTextField playerScore_txt;
    public static javax.swing.JButton refreshFields_btn;
    private javax.swing.JButton reserveDevice_btn;
    private javax.swing.JButton searchDevices_btn;
    private javax.swing.JToggleButton showPassword_btn;
    public static javax.swing.JButton updateProfile_btn;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
