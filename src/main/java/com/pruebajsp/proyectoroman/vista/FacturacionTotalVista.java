/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pruebajsp.proyectoroman.vista;

import com.pruebajsp.proyectoroman.logica.Controladora;
import com.pruebajsp.proyectoroman.logica.ExportarExcel;
import com.pruebajsp.proyectoroman.logica.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Clase que representa la interfaz gráfica para visualizar la facturación total
 * por mes. Muestra una tabla con los datos de facturación, gastos y totales por
 * mes, y permite exportar estos datos a un archivo Excel.
 *
 * @author Lopez Martin
 */
public class FacturacionTotalVista extends javax.swing.JFrame {

    /**
     * Controladora que gestiona la lógica de negocio relacionada con la
     * facturación.
     */
    Controladora control;

    public FacturacionTotalVista() {
        initComponents();
        control = new Controladora();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.cargarTablaMes();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/medical-59_icon-icons.com_73933.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturacion = new javax.swing.JTable();
        btnExcel = new javax.swing.JButton();
        btnVolver2 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Facturación Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tablaFacturacion.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tablaFacturacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tablaFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaFacturacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

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

        btnVolver2.setBackground(new java.awt.Color(183, 63, 65));
        btnVolver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/volver.png"))); // NOI18N
        btnVolver2.setBorder(null);
        btnVolver2.setBorderPainted(false);
        btnVolver2.setFocusPainted(false);
        btnVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnVolver2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
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
            obj.exportarExcel(tablaFacturacion);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcelActionPerformed


    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Método que se ejecuta cuando se hace clic en el botón "Volver". Cierra la
     * ventana actual.
     *
     * @param evt Evento de acción generado por el clic en el botón.
     */
    private void btnVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolver2ActionPerformed

    /**
     * Carga los datos de facturación y gastos por mes en la tabla. Obtiene los
     * datos de la controladora, los procesa y los muestra en la tabla. Los
     * datos incluyen el mes, el monto facturado, los gastos y el total
     * (facturación - gastos).
     */
    public void cargarTablaMes() {
        List<Object[]> resultados = control.obtenerTotalPorMes();
        List<Object[]> gastosPorMes = control.obtenerTotalGastosporMes();

        DefaultTableModel modelotabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Definir encabezados de la tabla
        String titulo[] = {"MES", "FACTURADO", "GASTOS", "TOTAL"};
        modelotabla.setColumnIdentifiers(titulo);

        List<String> meses = Arrays.asList("Enero", "Febrero", "Marzo", "Abril",
                "Mayo", "Junio", "Julio", "Agosto",
                "Septiembre", "Octubre", "Noviembre", "Diciembre");

        Map<Integer, Double> facturacionPorMes = new HashMap<>();
        Map<Integer, Double> gastosPorMesMap = new HashMap<>();

        for (int i = 1; i <= 12; i++) {
            facturacionPorMes.put(i, 0.00);
            gastosPorMesMap.put(i, 0.00);
        }

        for (Object[] fila : resultados) {
            int mes = (int) fila[0];
            double total = (double) fila[1];
            facturacionPorMes.put(mes, total);
        }

        for (Object[] fila : gastosPorMes) {
            int mes = (int) fila[0];
            double totalGasto = (double) fila[1];
            gastosPorMesMap.put(mes, totalGasto);
        }

        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));

        for (int i = 1; i <= 12; i++) {
            double facturado = facturacionPorMes.get(i);
            double gastos = gastosPorMesMap.get(i);
            double total = facturado - gastos;

            String facturadoFormateado = formatoMoneda.format(facturado);
            String gastosFormateado = formatoMoneda.format(gastos);
            String totalFormateado = formatoMoneda.format(total);

            Object objeto[] = {meses.get(i - 1), facturadoFormateado, gastosFormateado, totalFormateado};
            modelotabla.addRow(objeto);
        }

        tablaFacturacion.setModel(modelotabla);

        tablaFacturacion.getColumnModel().getColumn(0).setPreferredWidth(100); // Mes
        tablaFacturacion.getColumnModel().getColumn(1).setPreferredWidth(120); // Facturado
        tablaFacturacion.getColumnModel().getColumn(2).setPreferredWidth(120); // Gastos
        tablaFacturacion.getColumnModel().getColumn(3).setPreferredWidth(120); // Total

        tablaFacturacion.setRowHeight(30);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolver2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturacion;
    // End of variables declaration//GEN-END:variables
}
