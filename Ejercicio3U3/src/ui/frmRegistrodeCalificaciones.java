/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Vargas.Util;
import bll.Gestion_Matricula;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author labctr
 */
public class frmRegistrodeCalificaciones extends javax.swing.JInternalFrame {
    
    private final String titulo="Registro de Calificacion";
     private Gestion_Matricula matriculaBll = new Gestion_Matricula();
     private boolean Validar(){
         float nota = (float) this.snnValor.getValue();
         if(nota==0.f){
            vtnPrincipal.verMensaje("Calificacion no valida",titulo,JOptionPane.WARNING_MESSAGE);
            return false;
         }
         return true;
     
     }
     
     private void ConsultarMatricula() throws IOException{
         String numero = this.txtnumeroMatricula.getText();
         matriculaBll.consultar(numero);
         this.txtDatosMatricula.setText(matriculaBll.imprimir());
     
     }
     private String Calificar() throws IOException{
         float nota = (float)this.snnValor.getValue();
         String mensaje = matriculaBll.calificar(nota);
         matriculaBll.archivar();
         return mensaje;
     
     }
    

    /**
     * Creates new form RegistrodeCalificaciones
     */
    public frmRegistrodeCalificaciones() {
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

        lblRegistro = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMatricula = new javax.swing.JLabel();
        txtnumeroMatricula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatosMatricula = new javax.swing.JTextArea();
        pnlCalificaciones = new javax.swing.JPanel();
        txtValor = new javax.swing.JLabel();
        snnValor = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setForeground(new java.awt.Color(215, 201, 203));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblRegistro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblRegistro.setText("Registro de Calificaciones");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Matricula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(144, 95, 95))); // NOI18N

        lblMatricula.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblMatricula.setText("N°Matricula");

        btnBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/NetBeansProjectsu/imagenes/search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(txtnumeroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnBuscar)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnumeroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMatricula)))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matricula Registrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(130, 76, 76))); // NOI18N

        txtDatosMatricula.setColumns(20);
        txtDatosMatricula.setRows(5);
        jScrollPane1.setViewportView(txtDatosMatricula);

        pnlCalificaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calificaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        txtValor.setText("Valor");

        snnValor.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), Float.valueOf(0.01f)));

        btnGuardar.setBackground(new java.awt.Color(235, 183, 183));
        btnGuardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(138, 100, 100));
        btnGuardar.setIcon(new javax.swing.ImageIcon("/home/labctr/NetBeansProjectsu/imagenes/save.png")); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCalificacionesLayout = new javax.swing.GroupLayout(pnlCalificaciones);
        pnlCalificaciones.setLayout(pnlCalificacionesLayout);
        pnlCalificacionesLayout.setHorizontalGroup(
            pnlCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalificacionesLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(txtValor)
                .addGap(51, 51, 51)
                .addComponent(snnValor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        pnlCalificacionesLayout.setVerticalGroup(
            pnlCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalificacionesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlCalificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor)
                    .addComponent(snnValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblRegistro)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblRegistro)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(Validar()){
            String mensaje= this.Calificar();
            vtnPrincipal.verMensaje(mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            Util.imprimir("Error: "+e.toString());
            vtnPrincipal.verMensaje("Error al calificar la matricula",titulo,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         try {
            
             ConsultarMatricula();
            
        } catch (Exception e) {
            Util.imprimir("Error: "+e.toString());
            vtnPrincipal.verMensaje("Error al crear la matricula",titulo,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JPanel pnlCalificaciones;
    private javax.swing.JSpinner snnValor;
    private javax.swing.JTextArea txtDatosMatricula;
    private javax.swing.JLabel txtValor;
    private javax.swing.JTextField txtnumeroMatricula;
    // End of variables declaration//GEN-END:variables
}
