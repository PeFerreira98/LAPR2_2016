/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import lapr.project.controller.DefinirFAEController;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class DefinirFAEUI extends javax.swing.JFrame {

    private DefinirFAEController controller;
    private Exposicao exposicao;
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Creates new form DefinirFAEUI
     */
    public DefinirFAEUI(RegistoUtilizadores registoUtilizadores, Exposicao exposicao) {
        this.registoUtilizadores = registoUtilizadores;
        this.exposicao = exposicao;
        this.controller = new DefinirFAEController(this.registoUtilizadores, this.exposicao);

        super.setTitle("Define FAE");
        initComponents();
        jLblExpoName.setText(this.exposicao.getTitle());
        
        inicializarLista();
        super.setVisible(true);
    }

    private void inicializarLista() {
        final List<Utilizador> listaUtilizadores = this.controller.getListaUtilizadoresRegistados();

        if (listaUtilizadores.isEmpty()) {
            this.jUserList.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem utilizadores registados");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return listaUtilizadores.size();
            }

            @Override
            public Object getElementAt(int i) {
                return listaUtilizadores.get(i);
            }
        };

        this.jUserList.setModel(listModel);
        this.jUserList.setCellRenderer(new CellRenderer());
    }

    private class CellRenderer extends JLabel implements ListCellRenderer<Utilizador> {

        public CellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Utilizador> list, Utilizador utilizador, int index, boolean isSelected, boolean cellHasFocus) {
            setText(utilizador.getUsername());

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

        jScrollPane = new javax.swing.JScrollPane();
        jUserList = new javax.swing.JList<>();
        jOK = new javax.swing.JButton();
        jPromove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLblExpoNome = new javax.swing.JLabel();
        jLblExpoName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jUserList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane.setViewportView(jUserList);

        jOK.setText("OK");
        jOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKActionPerformed(evt);
            }
        });

        jPromove.setText("Promove User to FAE");
        jPromove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPromoveActionPerformed(evt);
            }
        });

        jLabel1.setText("Exposição:");

        jLblExpoName.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblExpoName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLblExpoNome)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPromove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLblExpoNome)
                            .addComponent(jLblExpoName))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPromove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jOK)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPromoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPromoveActionPerformed
        if (this.controller.addUtilizadorListaFAE(this.jUserList.getSelectedValue())) {
            JOptionPane.showMessageDialog(DefinirFAEUI.this,
                    "Utilizador definido com sucesso", "DefinirFAE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(DefinirFAEUI.this,
                    "Este Utilizador já está inserido", "DefinirFAE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jPromoveActionPerformed

    private void jOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOKActionPerformed
        super.dispose();
    }//GEN-LAST:event_jOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblExpoName;
    private javax.swing.JLabel jLblExpoNome;
    private javax.swing.JButton jOK;
    private javax.swing.JButton jPromove;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JList<Utilizador> jUserList;
    // End of variables declaration//GEN-END:variables

}
