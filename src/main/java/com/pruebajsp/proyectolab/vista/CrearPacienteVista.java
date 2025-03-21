/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pruebajsp.proyectolab.vista;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.pruebajsp.proyectolab.logica.Controladora;
import com.pruebajsp.proyectolab.logica.ExportarExcel;
import com.pruebajsp.proyectolab.logica.Odontologo;
import com.pruebajsp.proyectolab.logica.Paciente;
import com.pruebajsp.proyectolab.persistencia.exceptions.NonexistentEntityException;
import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.image.Bitonal;
import com.github.anastaciocintra.escpos.image.BitonalThreshold;
import com.github.anastaciocintra.escpos.image.CoffeeImage;
import com.github.anastaciocintra.escpos.image.CoffeeImageImpl;
import com.github.anastaciocintra.escpos.image.EscPosImage;
import com.github.anastaciocintra.escpos.image.GraphicsImageWrapper;
import com.github.anastaciocintra.escpos.image.ImageWrapperInterface;
import com.github.anastaciocintra.escpos.image.RasterBitImageWrapper;
import com.pruebajsp.proyectolab.ProyectoLAB;
import com.pruebajsp.proyectolab.logica.ExportarExcel;
import com.pruebajsp.proyectolab.persistencia.exceptions.NonexistentEntityException;
import com.pruebajsp.proyectolab.vista.EditarPacienteVista;
import com.pruebajsp.proyectolab.vista.VerPacienteVista;
import com.pruebajsp.proyectolab.vista.VistaUtils;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.print.PrintException;
import javax.print.attribute.standard.Copies;
import javax.swing.ImageIcon;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * Clase que representa la ventana para la creación de pacientes en la
 * aplicación. Permite registrar un nuevo paciente asociado a un odontólogo y
 * gestionar su información.
 *
 * <p>
 * Esta ventana proporciona opciones para ingresar los datos del paciente y
 * mostrar información relacionada con el odontólogo seleccionado.</p>
 *
 * @author Lopez Martin
 */
public class CrearPacienteVista extends javax.swing.JFrame {

    /**
     * Controladora principal de la aplicación, utilizada para gestionar la
     * lógica de negocio.
     */
    Controladora control = new Controladora();

    private Odontologo odontologo;
    private Double saldoAnterior;

    public CrearPacienteVista() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.cmbMes.setSelectedIndex(13);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/medical-59_icon-icons.com_73933.png")).getImage());
    }

    /**
     * Constructor que recibe un odontólogo, permitiendo asociar los nuevos
     * pacientes a él. También calcula el saldo anterior de los pacientes
     * relacionados con dicho odontólogo.
     *
     * @param odontologo Odontólogo al que se asociará el paciente.
     */
    public CrearPacienteVista(Odontologo odontologo) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.odontologo = odontologo;
        labelOdon.setFont(new Font("Arial", Font.BOLD, 16));
        labelOdon.setText("Odontólogo: " + this.odontologo.getNombre());
        this.cmbMes.setSelectedIndex(13);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/medical-59_icon-icons.com_73933.png")).getImage());
        this.saldoAnterior = this.calcularSaldo(control.traerPacientesPorOdontologo(odontologo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        txtDebe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtTrabajo = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaPacientes = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        labelOdon = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        cmbMes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblFacturado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Pacientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 18))); // NOI18N

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel2.setText("CANTIDAD:");

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

        jLabel4.setText("TRABAJO:");

        txtPago.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });

        txtDebe.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtDebe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDebeActionPerformed(evt);
            }
        });

        jLabel5.setText("NOMBRE:");

        jLabel6.setText("DEBE :");

        jLabel7.setText("PAGO :");

        dateFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("FECHA");

        txtTrabajo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrabajoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(204, 204, 204)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 98, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))))
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        tablaPacientes.setBackground(new java.awt.Color(255, 255, 255));
        tablaPacientes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tablaPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPacientes.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tablaPacientes);

        btnImprimir.setBackground(new java.awt.Color(96, 125, 139));
        btnImprimir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        btnImprimir.setBorderPainted(false);
        btnImprimir.setFocusPainted(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
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

        labelOdon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

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

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE", "TODOS" }));
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("TOTAL :");

        lblFacturado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFacturado.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("DEUDA:");

        lblSaldo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSaldo.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(labelOdon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFacturado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSaldo)))
                .addGap(99, 99, 99)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1051, 1051, 1051))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelOdon, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblFacturado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblSaldo))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.cargarTablaPaciente();
    }//GEN-LAST:event_formWindowOpened

    /**
     * Maneja el evento de impresión de un ticket para un paciente seleccionado
     * en la tabla.
     *
     * <p>
     * Este método verifica que haya pacientes en la tabla y que se haya
     * seleccionado uno. Luego, obtiene la información del paciente y del
     * odontólogo, y genera un ticket de atención utilizando la impresora
     * térmica predeterminada.</p>
     *
     * @param evt el evento de acción generado al hacer clic en el botón de
     * imprimir.
     */
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        Paciente paciente = null;

        if (tablaPacientes.getRowCount() > 0) {
            if (tablaPacientes.getSelectedRow() != -1) {
                long id_paciente = Integer.parseInt(String.valueOf(tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0)));
                paciente = control.traerPaciente(id_paciente);
            } else {
                VistaUtils.mostrarMensaje("No se seleccionó ningún paciente", "error", "Error al editar");
                return;
            }
        } else {
            VistaUtils.mostrarMensaje("No hay nada para editar en la tabla", "error", "Error al editar");
            return;
        }

        try {
            // Buscar la impresora térmica
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            if (printService == null) {
                System.out.println("No se encontró ninguna impresora.");
                return;
            }

            PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
            EscPos escpos = new EscPos(printerOutputStream);

            // Obtener fecha y hora actual
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

            // IMPRIMIR TEXTO
            escpos.writeLF("TICKET DE ATENCION");
            escpos.writeLF("\nFecha: " + fechaHora);
            escpos.writeLF("********************************");
            escpos.writeLF("\n");
            escpos.writeLF("DOCUMENTO NO Válido COMO factura");
            escpos.writeLF("********************************");
            escpos.writeLF("TD/LAB: LABORATORIO DENTAL");
            escpos.writeLF("Buenos Aires, Pcia Bs As");
            // Información del odontólogo
            escpos.writeLF("********************************");
            escpos.writeLF("ODONTOLOGO");
            escpos.writeLF("Dr/a: " + odontologo.getNombre());
            escpos.write("Dir: " + CrearPacienteVista.dividirTexto(odontologo.getDireccion(), 32));
            escpos.writeLF("********************************");

            // Información del paciente
            escpos.writeLF("PACIENTE");
            escpos.writeLF("Nombre: " + paciente.getNombre());
            escpos.writeLF("Trabajo: " + paciente.getTrabajo());
            escpos.writeLF("Cant: " + paciente.getCantidad());
            escpos.writeLF("Debe: $" + paciente.getDebe());
            escpos.writeLF("Saldo Anterior: $" + this.saldoAnterior);
            escpos.writeLF("********************************");

            // Pie de ticket
            escpos.writeLF("Gracias por su visita");

            escpos.feed(3);
            escpos.cut(EscPos.CutMode.FULL);
            escpos.close(); // Cerrar correctamente

            VistaUtils.mostrarMensaje("Impresión completada", "info", "Éxito");
            System.out.println("Ticket impreso correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * Exporta los datos de la tabla de pacientes a un archivo de Excel. Si
     * ocurre un error durante la exportación, se muestra un mensaje en la
     * consola.
     *
     * @param evt Evento de acción generado al hacer clic en el botón de
     * exportación.
     */
    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(tablaPacientes, lblFacturado);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    /**
     * Cierra la ventana actual y abre la vista de pacientes.
     *
     * @param evt Evento de acción generado al hacer clic en el botón de volver.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        VerPacienteVista verpacienteVista = new VerPacienteVista();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Filtra los pacientes según el mes seleccionado en el comboBox y actualiza
     * la tabla. También actualiza los valores de facturación y saldo
     * dependiendo de la selección.
     *
     * @param evt Evento de acción generado al cambiar la selección del comboBox
     * de meses.
     */
    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        this.cargarTablaPacientePorMes();

        if (cmbMes.getSelectedItem().equals("TODOS") || cmbMes.getSelectedItem().equals("-")) {
            this.cargarTablaPaciente();
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
            String totalFormateado = formatoMoneda.format(calcularTotal(control.traerPacientesPorOdontologo(odontologo)));
            lblFacturado.setText(totalFormateado);
            String saldoTotalFormateado = formatoMoneda.format(calcularSaldo(control.traerPacientesPorOdontologo(odontologo)));
            lblSaldo.setText(saldoTotalFormateado);
            return;
        }

        int mesSeleccionado = cmbMes.getSelectedIndex();

        List<Paciente> pacientesPorMes = new ArrayList<>();
        for (Paciente paciente : control.traerPacientes()) {
            if (paciente.getMesRegistro() == mesSeleccionado && paciente.getOdontologo().getIdOdontologo() == this.odontologo.getIdOdontologo()) {
                pacientesPorMes.add(paciente);
            }
        }

        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
        String totalFormateado = formatoMoneda.format(calcularTotal(pacientesPorMes));
        lblFacturado.setText(totalFormateado);
        String saldoTotalFormateado = formatoMoneda.format(calcularSaldo(pacientesPorMes));
        lblSaldo.setText(saldoTotalFormateado);
    }//GEN-LAST:event_cmbMesActionPerformed

    /**
     * Abre la vista para modificar un paciente seleccionado en la tabla. Si no
     * hay pacientes en la tabla o no se selecciona un paciente, muestra un
     * mensaje de error. Una vez cerrada la ventana de edición, se actualiza la
     * tabla de pacientes y el total facturado.
     *
     * @param evt Evento de acción generado al hacer clic en el botón de
     * modificar.
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (tablaPacientes.getRowCount() > 0) {
            if (tablaPacientes.getSelectedRow() != -1) {
                long id_paciente = Integer.parseInt(String.valueOf(tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0)));
                this.saldoAnterior = this.calcularSaldo(control.traerPacientesPorOdontologo(odontologo));
                EditarPacienteVista editarPacienteVista = new EditarPacienteVista(id_paciente);
                editarPacienteVista.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
                        String totalFormateado = formatoMoneda.format(calcularTotal(control.traerPacientesPorOdontologo(odontologo)));
                        cmbMes.setSelectedIndex(13);
                        lblFacturado.setText(String.valueOf(totalFormateado));
                        cargarTablaPaciente();

                    }
                });
            } else {
                VistaUtils.mostrarMensaje("No se selecciono ningún paciente", "error", "Error al editar");

            }
        } else {
            VistaUtils.mostrarMensaje("No hay nada para eliminar en la tabla", "error", "Error al editar");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Maneja la acción del botón "Crear". Obtiene los datos del formulario y
     * crea un nuevo paciente.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String nombre = txtNombre.getText().trim();
        String trabajo = txtTrabajo.getText().trim();
        Date fecha = dateFecha.getDate();
        String cantidadTxt = txtCantidad.getText().trim();
        String pagoTxt = txtPago.getText();
        String debeTxt = txtDebe.getText().trim();

        if (pagoTxt.isEmpty()) {
            pagoTxt = "0";
            txtPago.setText("0");
        }

        if (nombre.isEmpty() || trabajo.isEmpty() || fecha == null || cantidadTxt.isEmpty() || debeTxt.isEmpty()) {
            VistaUtils.mostrarMensaje("Hay campos sin completar", "error", "Error al guardar");
            return;
        }

        try {

            int cantidad = Integer.parseInt(cantidadTxt);
            Double pago = Double.parseDouble(pagoTxt);
            Double debe = Double.parseDouble(debeTxt);
            saldoAnterior = this.calcularSaldo(control.traerPacientesPorOdontologo(odontologo));
            control.crearPaciente(nombre, trabajo, fecha, cantidad, debe, pago, odontologo);
            VistaUtils.mostrarMensaje("Paciente guardado correctamente", "info", "Guardado exitoso");
            txtNombre.setText("");
            txtTrabajo.setText("");
            dateFecha.setDate(null);
            txtCantidad.setText("");
            txtPago.setText("");
            txtDebe.setText("");
            this.cargarTablaPaciente();
            this.cmbMes.setSelectedIndex(13);

        } catch (NumberFormatException e) {
            VistaUtils.mostrarMensaje("Ingrese valores numéricos válidos en los campos de cantidad, pago, debe", "error", "Error en los datos");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrabajoActionPerformed

    private void txtDebeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDebeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebeActionPerformed

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    /**
     * Maneja la acción del botón "Eliminar". Elimina el paciente seleccionado
     * de la tabla.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Paciente paciente = null;

        if (tablaPacientes.getRowCount() > 0) {
            if (tablaPacientes.getSelectedRow() != -1) {
                long id_paciente = Integer.parseInt(String.valueOf(tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0)));
                paciente = control.traerPaciente(id_paciente);

                boolean confirmacion = VistaUtils.mostrarConfirmacion(this,
                        "Estas seguro que deseas eliminar al empleado con el nombre " + paciente.getNombre(),
                        "Confirmacion de eliminacion"
                );

                if (confirmacion) {
                    try {

                        control.eliminarPaciente(id_paciente);
                        cmbMes.setSelectedIndex(13);
                        this.saldoAnterior = this.calcularSaldo(control.traerPacientesPorOdontologo(odontologo));
                    } catch (com.pruebajsp.proyectoroman.exceptions.NonexistentEntityException ex) {
                        Logger.getLogger(CrearPacienteVista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(CrearPacienteVista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    VistaUtils.mostrarMensaje("Paciente eliminado correctamente", "info", "Eliminacion correcta");
                    this.cargarTablaPaciente();
                } else {
                    VistaUtils.mostrarMensaje("Operacion de eliminacion cancelada", "info", "Operacion cancelada");
                }

            } else {
                VistaUtils.mostrarMensaje("No se selecciono ningún paciente", "error", "Error al editar");

            }
        } else {
            VistaUtils.mostrarMensaje("No hay nada para eliminar en la tabla", "error", "Error al editar");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        VerPacienteVista verPacienteVista = new VerPacienteVista();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Carga y muestra la tabla de pacientes filtrados por mes seleccionado en
     * la interfaz.
     */
    public void cargarTablaPacientePorMes() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DecimalFormat formatoMoneda = new DecimalFormat("$ #,##0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        tablaPacientes.setRowHeight(30);
        DefaultTableModel modelotabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Paciente> pacientes = control.traerPacientesPorOdontologo(odontologo);
        System.out.println("Pacientes encontrados: " + pacientes.size());

        String titulo[] = {"Id", "Nombre", "Trabajo", "Cantidad", "Debe", "Pagos", "Saldo", "Fecha"};
        modelotabla.setColumnIdentifiers(titulo);
        int mesSeleccionado = cmbMes.getSelectedIndex();
        for (Paciente paciente : pacientes) {
            if (paciente.getMesRegistro() == mesSeleccionado) {
                Object objeto[] = {paciente.getIdPaciente(), paciente.getNombre(), paciente.getTrabajo(), paciente.getCantidad(), formatoMoneda.format(paciente.getDebe()), formatoMoneda.format(paciente.getPago()), formatoMoneda.format(paciente.getSaldo()), (paciente.getFecha() != null) ? sdf.format(paciente.getFecha()) : ""};
                modelotabla.addRow(objeto);
            }
        }

        tablaPacientes.setModel(modelotabla);

        TableColumnModel columnModel = tablaPacientes.getColumnModel();

        tablaPacientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaPacientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaPacientes.getColumnModel().getColumn(0).setWidth(0);   // ID oculto

        columnModel.getColumn(1).setPreferredWidth(120);  // Nombre
        columnModel.getColumn(2).setPreferredWidth(200);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaPacientes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);// Trabajo
        columnModel.getColumn(4).setPreferredWidth(130);   // Cantidad (reducido)
        columnModel.getColumn(3).setPreferredWidth(60);  // Total Trabajo (aumentado)
        columnModel.getColumn(5).setPreferredWidth(130);
        tablaPacientes.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);// Debe
        columnModel.getColumn(6).setPreferredWidth(130);
        tablaPacientes.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);// Pagos
        columnModel.getColumn(7).setPreferredWidth(90);   // Saldo
        tablaPacientes.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

        columnModel.getColumn(0).setResizable(false);

    }

    /**
     * Carga la tabla de pacientes con los datos obtenidos de la base de datos.
     * Formatea los valores monetarios y las fechas, y ajusta el ancho de las
     * columnas.
     */
    public void cargarTablaPaciente() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        DecimalFormat formatoMoneda = new DecimalFormat("$ #,##0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        tablaPacientes.setRowHeight(30);
        DefaultTableModel modelotabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Paciente> pacientes = control.traerPacientesPorOdontologo(odontologo);
        System.out.println("Pacientes encontrados después de crear: " + pacientes.size());
        System.out.println("Pacientes encontrados: " + pacientes.size());

        String titulo[] = {"id", "Nombre", "trabajo", "cantidad", "Debe", "Pagos", "Saldo", "Fecha"};
        modelotabla.setColumnIdentifiers(titulo);

        for (Paciente paciente : pacientes) {
            System.out.println("Saldo antes de formatear: " + paciente.getSaldo());

            Object objeto[] = {paciente.getIdPaciente(), paciente.getNombre(), paciente.getTrabajo(), paciente.getCantidad(), formatoMoneda.format(paciente.getDebe()), formatoMoneda.format(paciente.getPago()), formatoMoneda.format(paciente.getSaldo()), (paciente.getFecha() != null) ? sdf.format(paciente.getFecha()) : ""};
            modelotabla.addRow(objeto);
        }

        tablaPacientes.setModel(modelotabla);

        TableColumnModel columnModel = tablaPacientes.getColumnModel();

        tablaPacientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaPacientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaPacientes.getColumnModel().getColumn(0).setWidth(0);

        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(200);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaPacientes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        columnModel.getColumn(4).setPreferredWidth(130);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(130);
        tablaPacientes.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        columnModel.getColumn(6).setPreferredWidth(130);
        tablaPacientes.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setPreferredWidth(90);
        tablaPacientes.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

        columnModel.getColumn(0).setResizable(false);

    }

    /**
     * Calcula el total adeudado por todos los pacientes en la lista.
     *
     * @param pacientes Lista de pacientes.
     * @return Total de deuda acumulada.
     */
    public Double calcularTotal(List<Paciente> pacientes) {
        Double total = 0.0;
        for (Paciente paciente : pacientes) {
            total += paciente.getDebe();
        }
        return total;
    }

    /**
     * Calcula el saldo total de todos los pacientes en la lista.
     *
     * @param pacientes Lista de pacientes.
     * @return Suma total de los saldos de los pacientes.
     */
    public Double calcularSaldo(List<Paciente> pacientes) {
        Double saldoTotal = 0.0;
        for (Paciente paciente : pacientes) {
            saldoTotal += (paciente.getSaldo());
        }
        return saldoTotal;
    }

    /**
     * Busca una impresora en el sistema por su nombre.
     *
     * @param nombre Nombre de la impresora a buscar.
     * @return La impresora encontrada o null si no se encuentra.
     */
    private static PrintService buscarImpresora(String nombre) {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService service : services) {
            if (service.getName().equalsIgnoreCase(nombre)) {
                return service;
            }
        }
        return null;
    }

    /**
     * Divide un texto en líneas de un ancho máximo especificado.
     *
     * @param texto Texto a dividir.
     * @param anchoMaximo Longitud máxima permitida por línea.
     * @return Texto dividido en líneas.
     */
    public static String dividirTexto(String texto, int anchoMaximo) {
        StringBuilder resultado = new StringBuilder();
        while (texto.length() > anchoMaximo) {
            int corte = texto.lastIndexOf(" ", anchoMaximo);
            if (corte == -1) {
                corte = anchoMaximo;
            }
            resultado.append(texto, 0, corte).append("\n");
            texto = texto.substring(corte).trim();
        }
        resultado.append(texto).append("\n");
        return resultado.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbMes;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOdon;
    private javax.swing.JLabel lblFacturado;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDebe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTrabajo;
    // End of variables declaration//GEN-END:variables
}
