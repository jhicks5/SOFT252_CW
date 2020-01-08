/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.SecretaryForms;

/**
 *
 * @author joshh
 */
public class SecretaryHome extends javax.swing.JFrame {

    /**
     * Creates new form SecretaryHome
     */
    public SecretaryHome() {
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

        btnCreateAppoint = new javax.swing.JButton();
        btnGiveMed = new javax.swing.JButton();
        btnOrderMed = new javax.swing.JButton();
        btnReqAppoint = new javax.swing.JButton();
        btnApproveAccCre = new javax.swing.JButton();
        btnApproveAccDel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCreateAppoint.setText("Create Appointment");
        btnCreateAppoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAppointActionPerformed(evt);
            }
        });

        btnGiveMed.setText("Give Medicine");
        btnGiveMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveMedActionPerformed(evt);
            }
        });

        btnOrderMed.setText("Order Medicine");
        btnOrderMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderMedActionPerformed(evt);
            }
        });

        btnReqAppoint.setText("Appointment Requests");
        btnReqAppoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReqAppointActionPerformed(evt);
            }
        });

        btnApproveAccCre.setText("Approve New Accounts");
        btnApproveAccCre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveAccCreActionPerformed(evt);
            }
        });

        btnApproveAccDel.setText("Approve Account Deletion");
        btnApproveAccDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveAccDelActionPerformed(evt);
            }
        });

        jLabel1.setText("Home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnApproveAccDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApproveAccCre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGiveMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreateAppoint, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOrderMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReqAppoint, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGap(0, 30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateAppoint)
                    .addComponent(btnReqAppoint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiveMed)
                    .addComponent(btnOrderMed))
                .addGap(57, 57, 57)
                .addComponent(btnApproveAccCre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApproveAccDel)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAppointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAppointActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new CreateAppointment().setVisible(true);
    }//GEN-LAST:event_btnCreateAppointActionPerformed

    private void btnReqAppointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReqAppointActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new AppointRequests().setVisible(true);
    }//GEN-LAST:event_btnReqAppointActionPerformed

    private void btnGiveMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveMedActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new GiveMedicine().setVisible(true);
    }//GEN-LAST:event_btnGiveMedActionPerformed

    private void btnOrderMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderMedActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new OrderMedicine().setVisible(true);
    }//GEN-LAST:event_btnOrderMedActionPerformed

    private void btnApproveAccCreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveAccCreActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new ApproveAccountCreation().setVisible(true);
    }//GEN-LAST:event_btnApproveAccCreActionPerformed

    private void btnApproveAccDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveAccDelActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        new ApproveAccountRemoval().setVisible(true);
    }//GEN-LAST:event_btnApproveAccDelActionPerformed

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
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveAccCre;
    private javax.swing.JButton btnApproveAccDel;
    private javax.swing.JButton btnCreateAppoint;
    private javax.swing.JButton btnGiveMed;
    private javax.swing.JButton btnOrderMed;
    private javax.swing.JButton btnReqAppoint;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
