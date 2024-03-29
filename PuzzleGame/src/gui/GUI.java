/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controller;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vank4
 */
public class GUI extends javax.swing.JFrame {
    Controller control;
    /**
     * Creates new form GUI
     */
    public GUI() {
        control = new Controller(this);
        initComponents();
    }

    public JComboBox<String> getCbSize() {
        return cbSize;
    }

    public JPanel getPnPlay() {
        return pnPlay;
    }

    public JLabel getTxtElapsed() {
        return txtElapsed;
    }


    public JLabel getLbStepCount() {
        return lbStepCount;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPlay = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbStepCount = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        cbSize = new javax.swing.JComboBox<>();
        btnNewGame = new javax.swing.JButton();
        lbElapsed = new javax.swing.JLabel();
        txtElapsed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnPlay.setPreferredSize(new java.awt.Dimension(200, 200));
        pnPlay.setLayout(new java.awt.GridLayout(3, 3));
        getContentPane().add(pnPlay, java.awt.BorderLayout.PAGE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 200));

        lbStepCount.setText("Step count: 0");

        lbSize.setText("Size");

        cbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" }));

        btnNewGame.setText("New Game");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        lbElapsed.setText("Elapsed:");

        txtElapsed.setText("0 sec");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStepCount)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSize)
                        .addGap(18, 18, 18)
                        .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNewGame)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbElapsed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtElapsed)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(lbStepCount)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbElapsed)
                    .addComponent(txtElapsed))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSize)
                    .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnNewGame)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        // TODO add your handling code here:
        control.pressNewGame();
    }//GEN-LAST:event_btnNewGameActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewGame;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbElapsed;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbStepCount;
    private javax.swing.JPanel pnPlay;
    private javax.swing.JLabel txtElapsed;
    // End of variables declaration//GEN-END:variables
}
