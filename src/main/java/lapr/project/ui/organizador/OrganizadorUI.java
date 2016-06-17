/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.organizador;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
import lapr.project.ui.AlterarPerfiUtilizadorUI;
import lapr.project.ui.LoginUI;

/**
 *
 * @author Marcos
 */
public class OrganizadorUI extends javax.swing.JFrame {

    /**
     * Creates new form OrganizadorUI
     */
    private final Utilizador user;
    private final CentroExposicoes centroExpo;

    public OrganizadorUI(Utilizador u, CentroExposicoes centroExpo) {
        this.user = u;
        this.centroExpo = centroExpo;
        
        super.setTitle("Organizador menu (" + this.user.getUsername() + ")");

        initComponents();
        inicializarListaCandidaturas();
        
        for (Exposicao expo : this.centroExpo.getListaExposicoes().getListaExposicoes()) {

            Organizador o = new Organizador(user);
            if (expo.isOrganizador(o)) {
                jLstExpo.add(expo.getTitle());
            }

        }

        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    private void inicializarListaCandidaturas() {
        final List<Candidatura> lstCandidaturas = getCandidaturasAvaliadas();

        if (lstCandidaturas.isEmpty()) {
            this.jLstCandidaturas.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem decisões");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return lstCandidaturas.size();
            }

            @Override
            public Object getElementAt(int i) {
                return lstCandidaturas.get(i);
            }
        };

        this.jLstCandidaturas.setModel(listModel);
        this.jLstCandidaturas.setCellRenderer(new OrganizadorUI.CellRendererCandidaturas());
    }
    
    private class CellRendererCandidaturas extends JLabel implements ListCellRenderer<Candidatura> {

        public CellRendererCandidaturas() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Candidatura> list, Candidatura c, int index, boolean isSelected, boolean cellHasFocus) {
            setText(c.getNomeEmpresa());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            return this;
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

        btnDefinirFAE = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLstExpo = new java.awt.List();
        btnDemoCreate = new javax.swing.JToggleButton();
        btnAtribCandid = new javax.swing.JToggleButton();
        btnAvaliar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jLstCandidaturas = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnDefinirFAE.setText("Definir FAE");
        btnDefinirFAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinirFAEActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista de exposições");

        jLstExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLstExpoActionPerformed(evt);
            }
        });

        btnDemoCreate.setText("Criar demonstração");
        btnDemoCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoCreateActionPerformed(evt);
            }
        });

        btnAtribCandid.setText("Atribuir Candidaturas");
        btnAtribCandid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtribCandidActionPerformed(evt);
            }
        });

        btnAvaliar.setText("Avaliar");
        btnAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista de candidaturas");

        jLstCandidaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane.setViewportView(jLstCandidaturas);

        jMenu1.setText("My account");

        jMenuItem1.setText("Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAtribCandid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnDemoCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDefinirFAE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLstExpo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAvaliar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLstExpo, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDefinirFAE)
                    .addComponent(btnAvaliar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDemoCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtribCandid)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDefinirFAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinirFAEActionPerformed
        String expo = jLstExpo.getSelectedItem();
        if (expo == null) {
            JOptionPane.showMessageDialog(OrganizadorUI.this,
                    "Nenhuma exposiçao seleccionada", "Exposições", JOptionPane.ERROR_MESSAGE);
        }else {
            new DefinirFAEUI(this.centroExpo.getRegistoUtilizadores(), this.centroExpo.getListaExposicoes().getExpoByName(expo));
        }

    }//GEN-LAST:event_btnDefinirFAEActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AlterarPerfiUtilizadorUI(user, centroExpo.getRegistoUtilizadores());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new LoginUI(centroExpo);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jLstExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLstExpoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLstExpoActionPerformed

    private void btnDemoCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoCreateActionPerformed
        String expo = jLstExpo.getSelectedItem();
        if (expo == null) {
            JOptionPane.showMessageDialog(OrganizadorUI.this,
                    "Nenhuma exposiçao seleccionada", "Exposições", JOptionPane.ERROR_MESSAGE);
        } else {
            new CriarDemonstracaoUI(centroExpo, this.centroExpo.getListaExposicoes().getExpoByName(expo));
        }
    }//GEN-LAST:event_btnDemoCreateActionPerformed

    private void btnAtribCandidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtribCandidActionPerformed
        new AtribuirCandidaturaUI(centroExpo);
    }//GEN-LAST:event_btnAtribCandidActionPerformed

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        Candidatura c = jLstCandidaturas.getSelectedValue();
        if (c == null) {
            JOptionPane.showMessageDialog(OrganizadorUI.this,
                    "Nenhuma candidatura seleccionada", "Candidaturas", JOptionPane.ERROR_MESSAGE);
        } else {
            new AvaliarCandidaturaInfoUI(c);
        }
    }//GEN-LAST:event_btnAvaliarActionPerformed

    public List<Candidatura> getCandidaturasAvaliadas(){
        List<Candidatura> lstCandidaturas = new ArrayList<>();
        
        for(Candidatura c : this.centroExpo.getListaCandidaturas().getListaCandidaturas()){
            if(c.isAvaliada()){
                lstCandidaturas.add(c);
            }
        }
        return lstCandidaturas;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAtribCandid;
    private javax.swing.JToggleButton btnAvaliar;
    private javax.swing.JToggleButton btnDefinirFAE;
    private javax.swing.JToggleButton btnDemoCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Candidatura> jLstCandidaturas;
    private java.awt.List jLstExpo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
