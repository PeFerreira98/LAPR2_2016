/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import static com.sun.management.jmx.Trace.isSelected;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Representante;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class RepresentanteUI extends javax.swing.JFrame {

    /**
     * Creates new form FaeUI
     */
    private Representante rep;
    private CentroExposicoes centroExpo;

    public RepresentanteUI(Utilizador utilizador, CentroExposicoes centroExposicoes) {
        this.centroExpo = centroExposicoes;
        this.rep = new Representante(utilizador);

        super.setTitle("Representante Menu (" + utilizador.getUsername() + ")");
        initComponents();
        inicializarListaExpo();
        super.setVisible(true);
    }

    private void inicializarListaExpo() {
        final List<Exposicao> listaExpo = getExpo();

        if (listaExpo.isEmpty()) {
            this.jLstExpo.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem recursos");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return listaExpo.size();
            }

            @Override
            public Object getElementAt(int i) {
                return listaExpo.get(i);
            }
        };

        this.jLstExpo.setModel(listModel);
        this.jLstExpo.setCellRenderer(new CellRenderer());
    }

    private class CellRenderer extends JLabel implements ListCellRenderer<Exposicao> {

        public CellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Exposicao> list, Exposicao expo, int index, boolean isSelected, boolean cellHasFocus) {
            setText(expo.getTitle());

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

    private void inicializarListaDemo(List<Demonstracao> lst) {
        final List<Demonstracao> lstDemo = lst;

        if (lstDemo.isEmpty()) {
            this.jLstDemos.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem recursos");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return lstDemo.size();
            }

            @Override
            public Object getElementAt(int i) {
                return lstDemo.get(i);
            }
        };

        this.jLstDemos.setModel(listModel);
        this.jLstDemos.setCellRenderer(new CellRendererDemo());
    }

    private class CellRendererDemo extends JLabel implements ListCellRenderer<Demonstracao> {

        public CellRendererDemo() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Demonstracao> jlist, Demonstracao e, int index, boolean isSelected, boolean cellHasFocus) {
            setText(e.getDesignacao());

            if (isSelected) {
                setBackground(jlist.getSelectionBackground());
                setForeground(jlist.getSelectionForeground());
            } else {
                setBackground(jlist.getBackground());
                setForeground(jlist.getForeground());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jLstExpo = new javax.swing.JList<Exposicao>();
        jLabel1 = new javax.swing.JLabel();
        btnCriarCandidaturaExpo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstDemos = new javax.swing.JList<Demonstracao>();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarDemo = new javax.swing.JButton();
        btnCriarCandidaturaDemo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jLstExpo);

        jLabel1.setText("Lista de exposições");

        btnCriarCandidaturaExpo.setText("Criar candidatura");
        btnCriarCandidaturaExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarCandidaturaExpoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jLstDemos);

        jLabel2.setText("Lista de demonstrações");

        btnMostrarDemo.setText("Mostrar demonstrações");
        btnMostrarDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDemoActionPerformed(evt);
            }
        });

        btnCriarCandidaturaDemo.setText("Criar candidatura");
        btnCriarCandidaturaDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarCandidaturaDemoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(btnMostrarDemo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCriarCandidaturaDemo)
                        .addGap(83, 83, 83))))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnCriarCandidaturaExpo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarDemo)
                    .addComponent(btnCriarCandidaturaDemo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriarCandidaturaExpo)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<Exposicao> getExpo() {
        List<Exposicao> lstExpo = new ArrayList<>();

        for (Exposicao expo : this.centroExpo.getListaExposicoes().getListaExposicoes()) {
            lstExpo.add(expo);
        }
        return lstExpo;
    }

    private void btnCriarCandidaturaExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarCandidaturaExpoActionPerformed
        Exposicao expo = jLstExpo.getSelectedValue();
        if (expo == null) {
            JOptionPane.showMessageDialog(RepresentanteUI.this,
                    "Seleccione uma exposição", "Exposição", JOptionPane.ERROR_MESSAGE);
        } else {
            new CriarCandidaturaUI(expo);
        }
    }//GEN-LAST:event_btnCriarCandidaturaExpoActionPerformed

    private void btnMostrarDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDemoActionPerformed
        Exposicao expo = jLstExpo.getSelectedValue();
        if (expo == null) {
            JOptionPane.showMessageDialog(RepresentanteUI.this,
                    "Seleccione uma exposição", "Exposição", JOptionPane.ERROR_MESSAGE);

        } else {
            List<Demonstracao> lstDemo = new ArrayList<>();
            for (Demonstracao demo : expo.getListaDemonstracoes().getListaDemonstracoes()) {
                lstDemo.add(demo);
            }
            inicializarListaDemo(lstDemo);
        }
    }//GEN-LAST:event_btnMostrarDemoActionPerformed

    private void btnCriarCandidaturaDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarCandidaturaDemoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCriarCandidaturaDemoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarCandidaturaDemo;
    private javax.swing.JButton btnCriarCandidaturaExpo;
    private javax.swing.JButton btnMostrarDemo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Demonstracao> jLstDemos;
    private javax.swing.JList<Exposicao> jLstExpo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
