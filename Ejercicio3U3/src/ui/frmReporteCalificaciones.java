/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Vargas.Util;
import beu.Curso;
import beu.Matricula;
import bll.Gestion_Curso;
import bll.Gestion_Estudiante;
import bll.Gestion_Matricula;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author labctr
 */
public class frmReporteCalificaciones extends javax.swing.JInternalFrame {
    private Gestion_Curso cursosBll = new Gestion_Curso();
    private List<Curso> cursos;
    private final String titulo = "Reporte de Calificaciones";
    private final DefaultTableModel dtmCalificaciones = new DefaultTableModel();
    private Gestion_Matricula matriculaBll = new Gestion_Matricula();
    private List<Matricula> calificaciones;
    
    
    private void MostrarCalificaciones(){
        int lim = dtmCalificaciones.getRowCount()-1;
        for(int i = lim; i>=0; i--){
            this.dtmCalificaciones.removeRow(i);
        }
        
        for (Matricula m : calificaciones) {
            Vector fila = new Vector();
            fila.addElement(Util.mostrarFecha(m.getFecha()));
            fila.addElement(m.getEstudiante());
            fila.addElement(m.getPromedio());
            fila.addElement(m.getEstado());
            this.dtmCalificaciones.addRow(fila);
        }
        this.tblCalificaciones.setModel(dtmCalificaciones);
    
    }
    private void BuscarMatriculas() throws IOException{
        Curso seleccionado = (Curso)this.cmbCurso1.getSelectedItem();
        calificaciones = matriculaBll.reportar(seleccionado.getTitulo());
        MostrarCalificaciones();
    
    
    }
    private void ConfigurarModeloTabla(){
        String[] columnas ={"Nombre", "Promedio","Estado"};
        this.dtmCalificaciones.setColumnIdentifiers(columnas);
        this.tblCalificaciones.setModel(dtmCalificaciones);
        
    }
    
    private void leerCursos() {
        try {
            Curso ficticio = new Curso("-Seleccione-", 0.0f, "");
            this.cmbCurso1.addItem(ficticio);
            cursos = cursosBll.getCurso();
            cursos.forEach((c) -> {
                this.cmbCurso1.addItem(c);
            });

        } catch (Exception e) {
            Util.imprimir("Error: " + e.toString());
            vtnPrincipal.verMensaje("Error al leer los cursos", titulo, JOptionPane.ERROR_MESSAGE);
        }

    }


    /**
     * Creates new form frmReporteCalificaciones
     */
    public frmReporteCalificaciones() {
        initComponents();
        leerCursos();
        ConfigurarModeloTabla();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCurso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblRegistro = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cmbCurso1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCalificaciones = new javax.swing.JTable();

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REporte de calificaciones");

        lblRegistro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblRegistro.setText("Reporte de Calificaciones");

        lblMatricula.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblMatricula.setText("Curso");

        btnBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/NetBeansProjectsu/imagenes/search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cmbCurso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCurso1ActionPerformed(evt);
            }
        });

        tblCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblCalificaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(lblRegistro)
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMatricula)
                .addGap(18, 18, 18)
                .addComponent(cmbCurso1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(92, 92, 92)
                .addComponent(btnBuscar)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMatricula)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
           
           BuscarMatriculas();

        } catch (Exception e) {
            Util.imprimir("Error: "+e.toString());
            vtnPrincipal.verMensaje("Error al crear la matricula",titulo,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void cmbCurso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCurso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCurso1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Curso> cmbCurso;
    private javax.swing.JComboBox<Curso> cmbCurso1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JTable tblCalificaciones;
    // End of variables declaration//GEN-END:variables
}
