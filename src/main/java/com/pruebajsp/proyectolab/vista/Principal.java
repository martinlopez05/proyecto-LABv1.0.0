/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pruebajsp.proyectolab.vista;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Clase que representa la ventana principal de la aplicación. Contiene la
 * interfaz gráfica principal con opciones para gestionar pacientes,
 * odontólogos, y otras funcionalidades como la visualización de la hora actual.
 *
 * @author Lopez Martin
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.iniciarReloj();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/medical-59_icon-icons.com_73933.png")).getImage());

    }

    /**
     * Inicia el reloj que actualiza la hora actual en la interfaz gráfica.
     * Utiliza un Timer para actualizar la hora cada segundo.
     */
    private void iniciarReloj() {
        Timer timer = new Timer(1000, e -> actualizarHora());
        timer.start();
    }

    /**
     * Actualiza la hora actual en la etiqueta correspondiente de la interfaz
     * gráfica. Formatea la hora en el formato "HH:mm:ss" y ajusta la zona
     * horaria a "America/Argentina/Buenos_Aires".
     */
    private void actualizarHora() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        formatoHora.setTimeZone(TimeZone.getTimeZone("America/Argentina/Buenos_Aires")); // Ajustar zona horaria si es necesario
        labelHora.setText(formatoHora.format(new Date()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        labelHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        oPaciente = new javax.swing.JMenu();
        oPacientes = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton3.setText("Inicio");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createEmptyBorder()); // Ajusta según el tamaño real
        jPanel1.setBackground(new java.awt.Color(2, 12, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnInicio.setBackground(new java.awt.Color(33, 152, 243));
        btnInicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Inicio");
        btnInicio.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnInicio.setFocusPainted(false);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnAyuda.setBackground(new java.awt.Color(33, 152, 243));
        btnAyuda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(255, 255, 255));
        btnAyuda.setText("ayuda");
        btnAyuda.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnAyuda.setFocusPainted(false);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(220, 20, 60));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("salir");
        btnSalir.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelHora.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelHora.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/360_F_306124857_EoRE4KeltvnQH1vN5adZYrkMlzzUc0Wh (1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel4)))
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel6)
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(89, 89, 89))))
        );

        jLabel3.setText("jLabel3");

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));

        oPaciente.setBackground(new java.awt.Color(102, 102, 102));
        oPaciente.setText("Odontologos");

        oPacientes.setText("Pacientes");
        oPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oPacientesMouseClicked(evt);
            }
        });
        oPaciente.add(oPacientes);

        jMenuBar1.add(oPaciente);

        ayuda.setBackground(new java.awt.Color(102, 102, 102));
        ayuda.setText("ayuda");
        ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ayudaMouseClicked(evt);
            }
        });
        jMenuBar1.add(ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta cuando se hace clic en la opción "Pacientes" del
     * menú. Abre la vista de gestión de pacientes.
     *
     * @param evt Evento de ratón generado por el clic en la opción del menú.
     */
    private void oPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oPacientesMouseClicked
        VerPacienteVista verPacienteVista = new VerPacienteVista();
    }//GEN-LAST:event_oPacientesMouseClicked

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Salir". Muestra
     * una confirmación antes de cerrar la aplicación.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        boolean confirm = VistaUtils.mostrarConfirmacion(this,
                "¿Seguro que deseas salir?", "Confirmar salida");

        if (confirm == true) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Inicio". Abre la
     * vista de gestión de pacientes y cierra la ventana actual.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        VerPacienteVista verPacienteVista = new VerPacienteVista();
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Ayuda". Abre la
     * vista de ayuda.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        AyudaVista ayudaVista = new AyudaVista();
    }//GEN-LAST:event_btnAyudaActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Ayuda". Abre la
     * vista de ayuda.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaMouseClicked
        AyudaVista ayudaVista = new AyudaVista();
    }//GEN-LAST:event_ayudaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ayuda;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelHora;
    private javax.swing.JMenu oPaciente;
    private javax.swing.JMenu oPacientes;
    // End of variables declaration//GEN-END:variables
}
