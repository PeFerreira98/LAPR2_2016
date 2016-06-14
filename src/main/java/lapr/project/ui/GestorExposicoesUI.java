/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import javax.swing.JOptionPane;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class GestorExposicoesUI extends javax.swing.JFrame {

    private CentroExposicoes centroExposicoes;
    private Utilizador user;

    /**
     * Creates new form GestorExpoUI
     */
    public GestorExposicoesUI(Utilizador user, CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
        this.user = user;
        
        super.setTitle("Gestor Exposicoes Menu (" + user.getUsername() + ")");
        
        initComponents();
        
        super.setLocationRelativeTo(null);
        super.setVisible(true);

        for (Exposicao exposicao : centroExposicoes.getListaExposicoes().getListaExposicoes()) {
            jlstExpo.add(exposicao.getTitle());
        }

        for (Utilizador utilizador : centroExposicoes.getRegistoUtilizadores().getListaUtilizadoresNaoRegistados()) {
            jlstUsers.add(utilizador.getUsername());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        choice1 = new java.awt.Choice();
        jMenu3 = new javax.swing.JMenu();
        btnExpoCreate = new javax.swing.JButton();
        btnAcceptUser = new javax.swing.JButton();
        jlstExpo = new java.awt.List();
        jlstUsers = new java.awt.List();
        btnViewExpo = new javax.swing.JButton();
        btnViewUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JToggleButton();
        jBRecurso = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAccount = new javax.swing.JMenu();
        jMenuItemSettings = new javax.swing.JMenuItem();
        jMenuItemLogout = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExpoCreate.setText("Create expo");
        btnExpoCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpoCreateActionPerformed(evt);
            }
        });

        btnAcceptUser.setText("Accept user");
        btnAcceptUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptUserActionPerformed(evt);
            }
        });

        jlstExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlstExpoActionPerformed(evt);
            }
        });

        jlstUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlstUsersActionPerformed(evt);
            }
        });

        btnViewExpo.setText("View Info");
        btnViewExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewExpoActionPerformed(evt);
            }
        });

        btnViewUser.setText("View client info");
        btnViewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewUserActionPerformed(evt);
            }
        });

        jLabel1.setText("Expo list");

        jLabel2.setText("Pending users");

        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRefreshMousePressed(evt);
            }
        });
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jBRecurso.setText("Definir Recurso");
        jBRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRecursoActionPerformed(evt);
            }
        });

        jMenuAccount.setText("My account");

        jMenuItemSettings.setText("Settings");
        jMenuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingsActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemSettings);

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenuAccount.add(jMenuItemLogout);

        jMenuBar1.add(jMenuAccount);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jlstExpo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlstUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(75, 75, 75))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExpoCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewExpo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnAcceptUser, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewUser)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBRecurso)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlstExpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlstUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewUser)
                    .addComponent(btnAcceptUser)
                    .addComponent(btnViewExpo)
                    .addComponent(btnExpoCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(jBRecurso))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptUserActionPerformed
       Utilizador u = centroExposicoes.getRegistoUtilizadores().checkUtilizadorByUsername(jlstUsers.getSelectedItem());
       if(u != null){
           this.centroExposicoes.getRegistoUtilizadores().registarUtilizador(u);
           this.jlstUsers.remove(u.getUsername());
           
       JOptionPane.showMessageDialog(GestorExposicoesUI.this,
                                    u.getUsername() + " foi aceite!", "Pending users", JOptionPane.INFORMATION_MESSAGE);
       }else{
        JOptionPane.showMessageDialog(GestorExposicoesUI.this,
                                    "Select a pending user", "Pending users", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnAcceptUserActionPerformed

    private void jlstExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlstExpoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlstExpoActionPerformed

    private void jlstUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlstUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlstUsersActionPerformed

    private void btnViewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewUserActionPerformed
        
        
    }//GEN-LAST:event_btnViewUserActionPerformed

    private void btnExpoCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpoCreateActionPerformed
        new CriarExposicaoUI(centroExposicoes, this.user);
    }//GEN-LAST:event_btnExpoCreateActionPerformed

    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingsActionPerformed
       new AlterarPerfiUtilizadorUI(user, centroExposicoes.getRegistoUtilizadores());
    }//GEN-LAST:event_jMenuItemSettingsActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        new LoginUI(centroExposicoes);
        dispose();
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void btnViewExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewExpoActionPerformed
        new ViewExpoUI(this.centroExposicoes.getListaExposicoes().getExpoByName(jlstExpo.getSelectedItem()));
    }//GEN-LAST:event_btnViewExpoActionPerformed

    private void btnRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMousePressed
       jlstExpo.removeAll();
        for (Exposicao exposicao : centroExposicoes.getListaExposicoes().getListaExposicoes()) {
            jlstExpo.add(exposicao.getTitle());
        }
    }//GEN-LAST:event_btnRefreshMousePressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        jlstExpo.removeAll();
        for (Exposicao exposicao : centroExposicoes.getListaExposicoes().getListaExposicoes()) {
            jlstExpo.add(exposicao.getTitle());
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jBRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRecursoActionPerformed
        new DefinirRecursoUI(centroExposicoes);
    }//GEN-LAST:event_jBRecursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptUser;
    private javax.swing.JButton btnExpoCreate;
    private javax.swing.JToggleButton btnRefresh;
    private javax.swing.JButton btnViewExpo;
    private javax.swing.JButton btnViewUser;
    private java.awt.Choice choice1;
    private javax.swing.JButton jBRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemSettings;
    private javax.swing.JScrollBar jScrollBar1;
    private java.awt.List jlstExpo;
    private java.awt.List jlstUsers;
    // End of variables declaration//GEN-END:variables
}
