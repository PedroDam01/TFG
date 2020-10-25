/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.Ventanas.paneles;

import buysale4u.control.Chat;
import buysale4u.control.Login;
import entidades.Conversacion;

/**
 *
 * @author PedroFB
 */
public class PanelChat extends javax.swing.JPanel {

    /**
     * Creates new form PanelChat
     */
    public PanelChat() {
        initComponents();
        Chat.listar(listaConversaciones);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLista = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaConversaciones = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoEnviar = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelLista.setLayout(new java.awt.GridBagLayout());

        listaConversaciones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaConversacionesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaConversaciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 258;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLista.add(jScrollPane3, gridBagConstraints);

        jButton2.setText("Nuevo Mensaje");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 53, 0);
        panelLista.add(jButton2, gridBagConstraints);

        add(panelLista, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        texto.setEditable(false);
        jScrollPane1.setViewportView(texto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 373;
        gridBagConstraints.ipady = 228;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        textoEnviar.setColumns(20);
        textoEnviar.setRows(5);
        jScrollPane2.setViewportView(textoEnviar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 235;
        gridBagConstraints.ipady = 33;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 12, 0);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaConversacionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaConversacionesValueChanged
        String cadena=null;
        Conversacion[] conversacion= Chat.insertarTexto(Login.extraer(listaConversaciones.getModel().getElementAt(listaConversaciones.getSelectedIndex())));
        for (Conversacion c : conversacion) {
            cadena= cadena+"\n"+c.toString();
        }
        texto.setText(cadena);
    }//GEN-LAST:event_listaConversacionesValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaConversaciones;
    private javax.swing.JPanel panelLista;
    private javax.swing.JTextPane texto;
    private javax.swing.JTextArea textoEnviar;
    // End of variables declaration//GEN-END:variables
}
