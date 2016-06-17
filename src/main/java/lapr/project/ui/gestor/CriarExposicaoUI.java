/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.gestor;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import lapr.project.controller.gestor.CriarExposicaoController;
import lapr.project.model.Recurso;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.users.GestorExposicoes;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class CriarExposicaoUI extends javax.swing.JFrame {

    private Exposicao expo;
    private CriarExposicaoController controller;
    private CentroExposicoes centroExpo;
    private ListaOrganizadores lstOrgAux;
    private Utilizador user;
    
    /**
     * Creates new form CriarExposicaoUI
     * @param centroExpo
     */
    public CriarExposicaoUI(CentroExposicoes centroExpo, Utilizador user) {
        this.user = user;
        this.centroExpo = centroExpo;
        this.controller = new CriarExposicaoController(centroExpo);
        this.lstOrgAux = new ListaOrganizadores();
        
        
        super.setTitle("Create Exhibition Window");
        initComponents();
        inicializarLista();
        setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    
    private void inicializarLista() {
        final List<Utilizador> lstUsers = this.centroExpo.getRegistoUtilizadores().getListaUtilizadoresRegistados();

        if (lstUsers.isEmpty()) {
            this.jLstUtilizadores.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem recursos");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return lstUsers.size();
            }

            @Override
            public Object getElementAt(int i) {
                return lstUsers.get(i);
            }
        };

        this.jLstUtilizadores.setModel(listModel);
        this.jLstUtilizadores.setCellRenderer(new CellRenderer());
    }

    private class CellRenderer extends JLabel implements ListCellRenderer<Utilizador> {

        public CellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Utilizador> list, Utilizador user, int index, boolean isSelected, boolean cellHasFocus) {
            setText(user.getUsername());

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

        jPanelNorth = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtLocal = new javax.swing.JTextField();
        jPanelCenter = new javax.swing.JPanel();
        lblPeriodoRealizacao = new javax.swing.JLabel();
        lblPeriodoRealizacaoInicio = new javax.swing.JLabel();
        lblPeriodoRealizacaoFim = new javax.swing.JLabel();
        lblPeriodoSubmissao = new javax.swing.JLabel();
        lblPeriodoSubmissaoInicio = new javax.swing.JLabel();
        lblPeriodoSubmissaoFim = new javax.swing.JLabel();
        fTxtPeriodoRealizacaoInicio = new javax.swing.JFormattedTextField();
        fTxtPeriodoRealizacaoFim = new javax.swing.JFormattedTextField();
        fTxtPeriodoSubmissaoInicio = new javax.swing.JFormattedTextField();
        fTxtPeriodoSubmissaoFim = new javax.swing.JFormattedTextField();
        jPanelSouth = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstUtilizadores = new javax.swing.JList<Utilizador>();
        btnAddOrg = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Exposição");

        lblTitulo.setText("Título:");

        lblDescricao.setText("Descrição:");

        lblLocal.setText("Local:");

        txtDescricao.setToolTipText("Descrição da Exposição");

        txtTitulo.setToolTipText("Título da Exposição");

        txtLocal.setToolTipText("Local da Exposição");

        javax.swing.GroupLayout jPanelNorthLayout = new javax.swing.GroupLayout(jPanelNorth);
        jPanelNorth.setLayout(jPanelNorthLayout);
        jPanelNorthLayout.setHorizontalGroup(
            jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(lblTitulo)
                    .addComponent(lblLocal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao)
                    .addComponent(txtTitulo)
                    .addComponent(txtLocal))
                .addContainerGap())
        );
        jPanelNorthLayout.setVerticalGroup(
            jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocal)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPeriodoRealizacao.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblPeriodoRealizacao.setText("Período de Realização");

        lblPeriodoRealizacaoInicio.setText("Início: ");

        lblPeriodoRealizacaoFim.setText("Fim:");

        lblPeriodoSubmissao.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblPeriodoSubmissao.setText("Período de Submissão");

        lblPeriodoSubmissaoInicio.setText("Início:");

        lblPeriodoSubmissaoFim.setText("Fim:");

        fTxtPeriodoRealizacaoInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        fTxtPeriodoRealizacaoInicio.setText("dd-mm-aaaa");
        fTxtPeriodoRealizacaoInicio.setToolTipText("Data de início da realização da Exposição");

        fTxtPeriodoRealizacaoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        fTxtPeriodoRealizacaoFim.setText("dd-mm-aaaa");
        fTxtPeriodoRealizacaoFim.setToolTipText("Data do fim da realização da Exposição");

        fTxtPeriodoSubmissaoInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        fTxtPeriodoSubmissaoInicio.setText("dd-mm-aaaa");
        fTxtPeriodoSubmissaoInicio.setToolTipText("Data do início da submissão da Exposição");

        fTxtPeriodoSubmissaoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        fTxtPeriodoSubmissaoFim.setText("dd-mm-aaaa");
        fTxtPeriodoSubmissaoFim.setToolTipText("Data do fim da submissão da Exposição");

        javax.swing.GroupLayout jPanelCenterLayout = new javax.swing.GroupLayout(jPanelCenter);
        jPanelCenter.setLayout(jPanelCenterLayout);
        jPanelCenterLayout.setHorizontalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeriodoRealizacao)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPeriodoRealizacaoInicio)
                            .addComponent(lblPeriodoRealizacaoFim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fTxtPeriodoRealizacaoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(fTxtPeriodoRealizacaoFim))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPeriodoSubmissao)
                    .addGroup(jPanelCenterLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPeriodoSubmissaoInicio)
                            .addComponent(lblPeriodoSubmissaoFim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fTxtPeriodoSubmissaoFim, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(fTxtPeriodoSubmissaoInicio))))
                .addContainerGap())
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodoRealizacao)
                    .addComponent(lblPeriodoSubmissao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodoRealizacaoInicio)
                    .addComponent(lblPeriodoSubmissaoInicio)
                    .addComponent(fTxtPeriodoRealizacaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fTxtPeriodoSubmissaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodoRealizacaoFim)
                    .addComponent(lblPeriodoSubmissaoFim)
                    .addComponent(fTxtPeriodoRealizacaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fTxtPeriodoSubmissaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSouthLayout = new javax.swing.GroupLayout(jPanelSouth);
        jPanelSouth.setLayout(jPanelSouthLayout);
        jPanelSouthLayout.setHorizontalGroup(
            jPanelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSouthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanelSouthLayout.setVerticalGroup(
            jPanelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSouthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnOk))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jLstUtilizadores);

        btnAddOrg.setText("Adicionar Organizador");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelSouth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelCenter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelNorth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddOrg, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddOrg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jPanelSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if(!txtTitulo.getText().equalsIgnoreCase("") && !txtDescricao.getText().equalsIgnoreCase("") && !txtLocal.getText().equalsIgnoreCase("")){
            this.controller.addListaOrganizador(lstOrgAux);
            Data dRinicio = this.controller.convertStringToData(fTxtPeriodoRealizacaoInicio.getText());
            Data dRfim = this.controller.convertStringToData(fTxtPeriodoRealizacaoFim.getText());
            Data dSinicio = this.controller.convertStringToData(fTxtPeriodoSubmissaoInicio.getText());
            Data dSfim = this.controller.convertStringToData(fTxtPeriodoSubmissaoFim.getText());
            
            this.controller.criarExpo(txtTitulo.getText(), txtDescricao.getText(), txtLocal.getText(), dSinicio, dSinicio, dSinicio, dSfim);
            if(!this.lstOrgAux.getLstOrganizadores().isEmpty()){
                this.controller.addListaOrganizador(lstOrgAux);
            }
            GestorExposicoes ge = new GestorExposicoes(this.user);
            this.controller.addGestor(ge);
            JOptionPane.showMessageDialog(CriarExposicaoUI.this,
                    "Exposição criada", "Utilizadores", JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
        }else{
           JOptionPane.showMessageDialog(CriarExposicaoUI.this,
                    "Preencha os campos obrigatórios", "Falta de dados", JOptionPane.ERROR_MESSAGE);
             
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        Utilizador user = jLstUtilizadores.getSelectedValue();
        if(user == null){
            JOptionPane.showMessageDialog(CriarExposicaoUI.this,
                    "Nenhum utilizador seleccionado", "Utilizadores", JOptionPane.ERROR_MESSAGE);
        }else{
            lstOrgAux.addOrganizador(user);
            JOptionPane.showMessageDialog(CriarExposicaoUI.this,
                    "Organizador adicionado", "Utilizadores", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAddOrgActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAddOrg;
    private javax.swing.JButton btnOk;
    private javax.swing.JFormattedTextField fTxtPeriodoRealizacaoFim;
    private javax.swing.JFormattedTextField fTxtPeriodoRealizacaoInicio;
    private javax.swing.JFormattedTextField fTxtPeriodoSubmissaoFim;
    private javax.swing.JFormattedTextField fTxtPeriodoSubmissaoInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<Utilizador> jLstUtilizadores;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelNorth;
    private javax.swing.JPanel jPanelSouth;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblPeriodoRealizacao;
    private javax.swing.JLabel lblPeriodoRealizacaoFim;
    private javax.swing.JLabel lblPeriodoRealizacaoInicio;
    private javax.swing.JLabel lblPeriodoSubmissao;
    private javax.swing.JLabel lblPeriodoSubmissaoFim;
    private javax.swing.JLabel lblPeriodoSubmissaoInicio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
