/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Vargas.Util;
import beu.Curso;
import beu.Estudiante;
import bll.Gestion_Curso;
import bll.Gestion_Estudiante;
import bll.Gestion_Matricula;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author labctr
 */
public class frmRegistrodeMatricula extends javax.swing.JInternalFrame {

    private final String titulo = "Registro de Matricula";
    private Gestion_Curso cursosBll = new Gestion_Curso();
    private Gestion_Matricula matriculaBll = new Gestion_Matricula();
    private Gestion_Estudiante estudiantesBll = new Gestion_Estudiante();
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;

    public boolean Validar() {
        Curso cr = (Curso) cmbCurso.getSelectedItem();
        if (cr.getTitulo().equals("--Seleccione--")) {
            vtnPrincipal.verMensaje("Curso no valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;

        }
        Estudiante est = (Estudiante) cmbEstudiante.getSelectedItem();
        if (est.getCedula().equals("--Seleccione--")) {
            vtnPrincipal.verMensaje("Estudiante no valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;

        }
        return true;

    }

    public void CrearMatricula() throws IOException {
        if (Validar()) {
            Curso cr = (Curso) this.cmbCurso.getSelectedItem();
            Estudiante est = (Estudiante) this.cmbEstudiante.getSelectedItem();
            matriculaBll.crear();
            matriculaBll.configurar(cr, est);
            matriculaBll.archivar();
        }

    }

    private void leerCursos() {
        try {
            Curso ficticio = new Curso("-Seleccione-", 0.0f, "");
            this.cmbCurso.addItem(ficticio);
            cursos = cursosBll.getCurso();
            cursos.forEach((c) -> {
                this.cmbCurso.addItem(c);
            });

        } catch (Exception e) {
            Util.imprimir("Error: " + e.toString());
            vtnPrincipal.verMensaje("Error al leer los cursos", titulo, JOptionPane.ERROR_MESSAGE);
        }

    }

    private void leerEstudiante() {
        try {
            Estudiante ficticio = new Estudiante();
            ficticio.setNombre("-Seleccione-");
            ficticio.setApellido("");
            this.cmbEstudiante.addItem(ficticio);
            estudiantes = estudiantesBll.leerEstudiantes();
            estudiantes.forEach((est) -> {
                this.cmbEstudiante.addItem(est);
            });

        } catch (Exception e) {
            Util.imprimir("Error: " + e.toString());
            vtnPrincipal.verMensaje("Error al leer los cursos", titulo, JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Creates new form RegistrodeMatricula
     */
    public frmRegistrodeMatricula() {
        initComponents();
        leerCursos();
        leerEstudiante();
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
        pnlRegistroMatricula = new javax.swing.JPanel();
        cmbEstudiante = new javax.swing.JComboBox<>();
        cmbCurso = new javax.swing.JComboBox<>();
        lblEstuduante = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblRegistro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblRegistro.setText("Registro de Matricula");

        pnlRegistroMatricula.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Matricula"));

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        lblEstuduante.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblEstuduante.setText("Estudiante");

        lblCurso.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCurso.setText("Curso: ");

        btnGuardar.setBackground(new java.awt.Color(236, 207, 207));
        btnGuardar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(132, 70, 70));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroMatriculaLayout = new javax.swing.GroupLayout(pnlRegistroMatricula);
        pnlRegistroMatricula.setLayout(pnlRegistroMatriculaLayout);
        pnlRegistroMatriculaLayout.setHorizontalGroup(
            pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroMatriculaLayout.createSequentialGroup()
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstuduante)
                            .addComponent(lblCurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEstudiante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        pnlRegistroMatriculaLayout.setVerticalGroup(
            pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstuduante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lblRegistro)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRegistroMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblRegistro)
                .addGap(18, 18, 18)
                .addComponent(pnlRegistroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(Validar()){
            CrearMatricula();
            vtnPrincipal.verMensaje("Matricula creada Correctamente", titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Util.imprimir("Error: " + e.toString());
            vtnPrincipal.verMensaje("Error al Buscar la matricula", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Curso> cmbCurso;
    private javax.swing.JComboBox<Estudiante> cmbEstudiante;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstuduante;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JPanel pnlRegistroMatricula;
    // End of variables declaration//GEN-END:variables
}
