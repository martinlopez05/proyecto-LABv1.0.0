/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pruebajsp.proyectolab.vista;

import com.pruebajsp.proyectolab.vista.CrearPacienteVista;
import com.pruebajsp.proyectolab.logica.Controladora;
import com.pruebajsp.proyectolab.logica.ExportarExcel;
import com.pruebajsp.proyectolab.logica.Gasto;
import com.pruebajsp.proyectolab.logica.Paciente;
import com.pruebajsp.proyectolab.persistencia.exceptions.NonexistentEntityException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * Clase que representa la interfaz gráfica para gestionar los gastos. Permite
 * crear, modificar, eliminar y visualizar los gastos, así como exportar los
 * datos a un archivo Excel.
 *
 * @author Lopez Martin
 */
public class GastosVista extends javax.swing.JFrame {

    /**
     * Controladora que gestiona la lógica de negocio relacionada con los
     * gastos.
     */
    Controladora control = new Controladora();

    public GastosVista() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.cmbMes.setSelectedIndex(13);
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/medical-59_icon-icons.com_73933.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                VerPacienteVista verPacienteVista = new VerPacienteVista();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtDebe = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();
        cmbMes = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblGastos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDeuda = new javax.swing.JLabel();

        txtNombre2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "GASTOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDebe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtDebe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDebeActionPerformed(evt);
            }
        });

        txtPago.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });

        jLabel5.setText("NOMBRE:");

        jLabel6.setText("DEBE:");

        jLabel7.setText("PAGO:");

        btnCrear.setBackground(new java.awt.Color(33, 150, 243));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setText("CREAR");
        btnCrear.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnCrear.setFocusPainted(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new Color(52,152,219));
        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel8.setText("FECHA:");

        btnEliminar.setBackground(new Color(52,152,219));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(49, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        JTableHeader header = tablaGastos.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12)); // Cambia la fuente a negrita

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaGastos);

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE", "TODOS" }));
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(183, 63, 65));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/volver.png"))); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(56, 142, 60));
        btnExcel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("EXPORTAR EXCEL");
        btnExcel.setBorder(null);
        btnExcel.setFocusPainted(false);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("TOTAL :");

        lblGastos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGastos.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("DEUDA:");

        lblDeuda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDeuda.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGastos)
                                .addGap(73, 73, 73)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDeuda))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGastos)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDeuda))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDebeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDebeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebeActionPerformed

    private void txtNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre2ActionPerformed

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Crear". Valida los
     * campos de entrada y crea un nuevo gasto en la base de datos.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombreProveedor = txtNombre.getText();
        String debeTxt = txtDebe.getText();
        String pagoTxt = txtPago.getText();
        Date fecha = dateFecha.getDate();

        if (pagoTxt.isEmpty()) {
            pagoTxt = "0";
            txtPago.setText("0");
        }
        if (nombreProveedor.isEmpty() || fecha == null || debeTxt.isEmpty()) {
            VistaUtils.mostrarMensaje("Hay campos sin completar", "error", "Error al guardar");
            return;
        }

        try {

            Double pago = Double.parseDouble(pagoTxt);
            Double debe = Double.parseDouble(debeTxt);

            control.crearGasto(nombreProveedor, debe, pago, fecha);
            VistaUtils.mostrarMensaje("Gasto guardado correctamente", "info", "Guardado exitoso");

            txtNombre.setText("");

            dateFecha.setDate(null);

            txtPago.setText("");
            txtDebe.setText("");
            this.cargarTablaGasto();
            this.cmbMes.setSelectedIndex(13);

        } catch (NumberFormatException e) {
            VistaUtils.mostrarMensaje("Ingrese valores numéricos válido para Debe y Pago", "error", "Error en los datos");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Modificar". Abre
     * una ventana para editar el gasto seleccionado en la tabla.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (tablaGastos.getRowCount() > 0) {
            if (tablaGastos.getSelectedRow() != -1) {
                long id_gasto = Integer.parseInt(String.valueOf(tablaGastos.getValueAt(tablaGastos.getSelectedRow(), 0)));
                EditarGastoVista editarGastoVista = new EditarGastoVista(id_gasto);
                editarGastoVista.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
                        String totalFormateado = formatoMoneda.format(calcularGastosTotales(control.traerGastos()));
                        cmbMes.setSelectedIndex(13);
                        lblGastos.setText(String.valueOf(totalFormateado));
                        String deudaTotal = formatoMoneda.format(calcularSaldo(control.traerGastos()));
                        lblDeuda.setText(deudaTotal);
                        cargarTablaGasto();

                    }
                });
            } else {
                VistaUtils.mostrarMensaje("No se selecciono ningún gasto", "error", "Error al editar");

            }
        } else {
            VistaUtils.mostrarMensaje("No hay nada para eliminar en la tabla", "error", "Error al editar");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Eliminar". Elimina
     * el gasto seleccionado en la tabla después de confirmar la acción.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Gasto gasto = null;

        if (tablaGastos.getRowCount() > 0) {
            if (tablaGastos.getSelectedRow() != -1) {
                long id_gasto = Integer.parseInt(String.valueOf(tablaGastos.getValueAt(tablaGastos.getSelectedRow(), 0)));
                gasto = control.traerGasto(id_gasto);

                boolean confirmacion = VistaUtils.mostrarConfirmacion(this,
                        "Estas seguro que deseas eliminar el gasto del proveedor  " + gasto.getNombreProveedor(),
                        "Confirmacion de eliminacion"
                );

                if (confirmacion) {
                    try {
                        control.eliminarGasto(id_gasto);
                        cmbMes.setSelectedIndex(13);

                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(CrearPacienteVista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (com.pruebajsp.proyectoroman.exceptions.NonexistentEntityException ex) {
                        Logger.getLogger(GastosVista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    VistaUtils.mostrarMensaje("Gasto eliminado correctamente", "info", "Eliminacion correcta");
                    this.cargarTablaGasto();
                } else {
                    VistaUtils.mostrarMensaje("Operacion de eliminacion cancelada", "info", "Operacion cancelada");
                }

            } else {
                VistaUtils.mostrarMensaje("No se selecciono ningún gasto", "error", "Error al editar");

            }
        } else {
            VistaUtils.mostrarMensaje("No hay nada para eliminar en la tabla", "error", "Error al editar");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Método que se ejecuta cuando se selecciona un mes en el ComboBox. Filtra
     * los gastos según el mes seleccionado y actualiza la tabla y el total de
     * gastos. Si se selecciona "TODOS" o "-", se cargan todos los gastos sin
     * filtrar por mes.
     *
     * @param evt Evento de acción generado por la selección en el ComboBox.
     */
    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        this.cargarTablaGastoPorMes();

        if (cmbMes.getSelectedItem().equals("TODOS") || cmbMes.getSelectedItem().equals("-")) {
            this.cargarTablaGasto();
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
            String totalFormateado = formatoMoneda.format(calcularGastosTotales(control.traerGastos()));
            String deudaTotal = formatoMoneda.format(calcularSaldo(control.traerGastos()));
            lblDeuda.setText(deudaTotal);
            lblGastos.setText(totalFormateado);
            return;
        }

        int mesSeleccionado = cmbMes.getSelectedIndex();

        List<Gasto> gastosPorMes = new ArrayList<>();
        for (Gasto gasto : control.traerGastos()) {
            if (gasto.getMesRegistro() == mesSeleccionado) {
                gastosPorMes.add(gasto);
            }
        }

        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
        String totalFormateado = formatoMoneda.format(calcularGastosTotales(gastosPorMes));
        lblGastos.setText(totalFormateado);
        String deudaTotal = formatoMoneda.format(calcularSaldo(gastosPorMes));
        lblDeuda.setText(deudaTotal);

    }//GEN-LAST:event_cmbMesActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Volver". Cierra la
     * ventana actual y abre la vista de pacientes.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        VerPacienteVista verPacienteVista = new VerPacienteVista();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Exportar Excel".
     * Exporta los datos de la tabla a un archivo Excel.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(tablaGastos);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    /**
     * Calcula el total de los gastos sumando el campo "Debe" de cada gasto en
     * la lista.
     *
     * @param gastos Lista de gastos.
     * @return El total de los gastos.
     */
    public Double calcularGastosTotales(List<Gasto> gastos) {
        Double total = 0.0;
        for (Gasto gasto : gastos) {
            total += gasto.getDebe();
        }
        return total;
    }

    public Double calcularSaldo(List<Gasto> gastos) {
        Double saldo = 0.0;
        for (Gasto gasto : gastos) {
            saldo += (gasto.getDebe() - gasto.getPago());
        }
        return saldo;
    }

    /**
     * Carga los gastos filtrados por el mes seleccionado en el ComboBox en la
     * tabla. Formatea los valores monetarios y las fechas para su
     * visualización.
     */
    public void cargarTablaGastoPorMes() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DecimalFormat formatoMoneda = new DecimalFormat("$ #,##0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        tablaGastos.setRowHeight(30);
        DefaultTableModel modelotabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Gasto> gastos = control.traerGastos();

        String titulo[] = {"id", "Nombre Proveedor", "Debe", "Pago", "Fecha"};
        modelotabla.setColumnIdentifiers(titulo);
        int mesSeleccionado = cmbMes.getSelectedIndex();
        for (Gasto gasto : gastos) {
            if (gasto.getMesRegistro() == mesSeleccionado) {
                Object objeto[] = {gasto.getIdGasto(), gasto.getNombreProveedor(), formatoMoneda.format(gasto.getDebe()), formatoMoneda.format(gasto.getPago()), (gasto.getFecha() != null) ? sdf.format(gasto.getFecha()) : ""};
                modelotabla.addRow(objeto);
            }

        }

        tablaGastos.setModel(modelotabla);
        // Suponiendo que "tablaPacientes" es tu JTable
        TableColumnModel columnModel = tablaGastos.getColumnModel();

        // Ajustamos el ancho de cada columna
        tablaGastos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaGastos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaGastos.getColumnModel().getColumn(0).setWidth(0);   // ID oculto

        columnModel.getColumn(1).setPreferredWidth(130);  // Nombre
        columnModel.getColumn(2).setPreferredWidth(130);
        tablaGastos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaGastos.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);// Trabajo
        columnModel.getColumn(4).setPreferredWidth(90);   // Cantidad (reducido)
        columnModel.getColumn(3).setPreferredWidth(130);
        tablaGastos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);// Total Trabajo (aumentado)
        columnModel.getColumn(0).setResizable(false);

    }

    /**
     * Carga todos los gastos en la tabla sin filtrar por mes. Formatea los
     * valores monetarios y las fechas para su visualización.
     */
    public void cargarTablaGasto() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DecimalFormat formatoMoneda = new DecimalFormat("$ #,##0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        tablaGastos.setRowHeight(30);
        DefaultTableModel modelotabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Gasto> gastos = control.traerGastos();

        String titulo[] = {"id", "Nombre Proveedor", "Debe", "Pago", "Fecha"};
        modelotabla.setColumnIdentifiers(titulo);

        for (Gasto gasto : gastos) {

            Object objeto[] = {gasto.getIdGasto(), gasto.getNombreProveedor(), formatoMoneda.format(gasto.getDebe()), formatoMoneda.format(gasto.getPago()), (gasto.getFecha() != null) ? sdf.format(gasto.getFecha()) : ""};
            modelotabla.addRow(objeto);
        }

        tablaGastos.setModel(modelotabla);
        // Suponiendo que "tablaPacientes" es tu JTable
        TableColumnModel columnModel = tablaGastos.getColumnModel();

        // Ajustamos el ancho de cada columna
        tablaGastos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaGastos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaGastos.getColumnModel().getColumn(0).setWidth(0);   // ID oculto

        columnModel.getColumn(1).setPreferredWidth(130);  // Nombre
        columnModel.getColumn(2).setPreferredWidth(130);
        tablaGastos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaGastos.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);// Trabajo
        columnModel.getColumn(4).setPreferredWidth(90);   // Cantidad (reducido)
        columnModel.getColumn(3).setPreferredWidth(130);
        tablaGastos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);// Total Trabajo (aumentado)
        columnModel.getColumn(0).setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbMes;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeuda;
    private javax.swing.JLabel lblGastos;
    private javax.swing.JTable tablaGastos;
    private javax.swing.JTextField txtDebe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
