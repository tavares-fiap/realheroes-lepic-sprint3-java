/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author labsfiap
 */
public class MainResidentMenu_GUI extends javax.swing.JFrame {

    /**
     * Creates new form MainResidentMenu_GUI
     */
    public MainResidentMenu_GUI() {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("realheroes?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        deviceQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Device d");
        deviceList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : deviceQuery.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        idDevice_cb = new javax.swing.JComboBox();
        idDispositivo_lbl = new javax.swing.JLabel();
        playerScore_lbl = new javax.swing.JLabel();
        brand_lbl = new javax.swing.JLabel();
        brand_txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        deviceDescription_txt = new javax.swing.JTextArea();
        brand_lbl1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, deviceList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${IDdevice}"));
        columnBinding.setColumnName("IDdispositivo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Descrição");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${marca}"));
        columnBinding.setColumnName("Marca");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 90, 390, 90);

        jButton1.setText("Buscar dispositivos disponíveis");
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 190, 370, 23);

        idDevice_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE O DISPOSITIVO DESEJADO" }));
        jPanel1.add(idDevice_cb);
        idDevice_cb.setBounds(150, 230, 230, 30);

        idDispositivo_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        idDispositivo_lbl.setForeground(new java.awt.Color(255, 255, 255));
        idDispositivo_lbl.setText("ID Dispositivo:");
        jPanel1.add(idDispositivo_lbl);
        idDispositivo_lbl.setBounds(10, 230, 150, 30);

        playerScore_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        playerScore_lbl.setForeground(new java.awt.Color(255, 255, 255));
        playerScore_lbl.setText("Descrição:");
        jPanel1.add(playerScore_lbl);
        playerScore_lbl.setBounds(10, 270, 110, 30);

        brand_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        brand_lbl.setForeground(new java.awt.Color(255, 255, 255));
        brand_lbl.setText("MARCA:");
        jPanel1.add(brand_lbl);
        brand_lbl.setBounds(10, 370, 130, 30);

        brand_txt.setText("MARCA DO DISPOSITIVO");
        brand_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        brand_txt.setEnabled(false);
        brand_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_txtActionPerformed(evt);
            }
        });
        jPanel1.add(brand_txt);
        brand_txt.setBounds(150, 370, 230, 30);

        deviceDescription_txt.setEditable(false);
        deviceDescription_txt.setColumns(20);
        deviceDescription_txt.setRows(5);
        deviceDescription_txt.setText("DESCRIÇÂO");
        deviceDescription_txt.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jScrollPane2.setViewportView(deviceDescription_txt);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(150, 270, 230, 80);

        brand_lbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        brand_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        brand_lbl1.setText("DATA PARA RETIRAR:");
        jPanel1.add(brand_lbl1);
        brand_lbl1.setBounds(10, 420, 200, 30);

        jTextField1.setText("AAAA-MM-DD");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(290, 420, 90, 30);

        jButton2.setText("Reservar Óculos");
        jPanel1.add(jButton2);
        jButton2.setBounds(260, 470, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/RealHeroesBG4.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
      
        jLabel1.setBounds(0, 0, 390, 720);


        jTabbedPane1.addTab("Reservar Óculos", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Visualizar Feedbacks", jPanel2);

        jPanel3.setLayout(null);

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
    private javax.swing.JLabel brand_lbl;
    private javax.swing.JLabel brand_lbl1;
    public static javax.swing.JTextField brand_txt;
    public static javax.swing.JTextArea deviceDescription_txt;
    private java.util.List<View.Device> deviceList;
    private javax.persistence.Query deviceQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JComboBox idDevice_cb;
    private javax.swing.JLabel idDispositivo_lbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel playerScore_lbl;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
