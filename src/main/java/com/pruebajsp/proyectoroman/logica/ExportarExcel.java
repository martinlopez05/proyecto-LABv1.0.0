/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebajsp.proyectoroman.logica;

import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Clase para exportar datos de una JTable a un archivo de Excel (.xlsx).
 * Utiliza la biblioteca Apache POI para la manipulación de archivos Excel.
 *
 * @author Lopez Martin
 */
public class ExportarExcel {

    /**
     * Exporta el contenido de una JTable a un archivo de Excel e incluye el
     * total indicado en un JLabel.
     *
     * @param t La JTable con los datos a exportar.
     * @param lblTotal JLabel que contiene el total a incluir en el archivo.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void exportarExcel(JTable t, JLabel lblTotal) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xlsx");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx");

            try {
                File archivoXLSX = new File(ruta);
                if (archivoXLSX.exists()) {
                    archivoXLSX.delete();
                }
                archivoXLSX.createNewFile();

                Workbook libro = new XSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLSX);
                Sheet hoja = libro.createSheet("Hoja 1");
                hoja.setDisplayGridlines(true);

                CellStyle estiloConBordes = libro.createCellStyle();
                estiloConBordes.setBorderTop(BorderStyle.THIN);
                estiloConBordes.setBorderBottom(BorderStyle.THIN);
                estiloConBordes.setBorderLeft(BorderStyle.THIN);
                estiloConBordes.setBorderRight(BorderStyle.THIN);

                CellStyle estiloNegrita = libro.createCellStyle();
                org.apache.poi.ss.usermodel.Font fontNegrita = libro.createFont();
                fontNegrita.setBold(true);
                estiloNegrita.setFont(fontNegrita);

                int maxFilas = 100;
                int maxColumnas = 26;
                for (int f = 0; f < maxFilas; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < maxColumnas; c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellValue("");
                        celda.setCellStyle(estiloConBordes);
                    }
                }

                Row headerRow = hoja.getRow(0);
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda = headerRow.createCell(c);
                    celda.setCellValue(t.getColumnName(c));
                    celda.setCellStyle(estiloNegrita);
                }

                int filaActual = 1;
                for (int f = 0; f < t.getRowCount(); f++, filaActual++) {
                    Row fila = hoja.getRow(filaActual);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        Object valor = t.getValueAt(f, c);

                        if (valor instanceof Number) {
                            celda.setCellValue(((Number) valor).doubleValue());
                        } else {
                            celda.setCellValue(valor != null ? valor.toString() : "");
                        }
                        celda.setCellStyle(estiloConBordes);
                    }
                }

                Row filaTotal = hoja.getRow(filaActual + 1);
                Cell celdaEtiquetaTotal = filaTotal.createCell(3);
                celdaEtiquetaTotal.setCellValue("Total:");
                celdaEtiquetaTotal.setCellStyle(estiloNegrita);

                Cell celdaTotal = filaTotal.createCell(4);
                String totalTexto = lblTotal.getText().replaceAll("[^0-9,.-]", "").replace(",", ".");
                int firstPoint = totalTexto.indexOf(".");
                int lastPoint = totalTexto.lastIndexOf(".");
                if (firstPoint != lastPoint) {
                    totalTexto = totalTexto.substring(0, lastPoint).replace(".", "") + totalTexto.substring(lastPoint);
                }
                double total = Double.parseDouble(totalTexto);
                celdaTotal.setCellValue(total);
                celdaTotal.setCellStyle(estiloNegrita);

                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLSX);
            } catch (IOException e) {
                throw e;
            }
        }
    }

    /**
     * Exporta el contenido de una JTable a un archivo de Excel sin incluir un
     * total.
     *
     * @param t La JTable con los datos a exportar.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xlsx");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xlsx");

            try {
                File archivoXLSX = new File(ruta);
                if (archivoXLSX.exists()) {
                    archivoXLSX.delete();
                }
                archivoXLSX.createNewFile();

                Workbook libro = new XSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLSX);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(true);

                // **Estilo con bordes**
                CellStyle estiloConBordes = libro.createCellStyle();
                estiloConBordes.setBorderTop(BorderStyle.THIN);
                estiloConBordes.setBorderBottom(BorderStyle.THIN);
                estiloConBordes.setBorderLeft(BorderStyle.THIN);
                estiloConBordes.setBorderRight(BorderStyle.THIN);

                int maxFilas = 100;
                int maxColumnas = 26;

                for (int f = 0; f < maxFilas; f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < maxColumnas; c++) {
                        Cell celda = fila.createCell(c);
                        celda.setCellValue("");
                        celda.setCellStyle(estiloConBordes);
                    }
                }

                Row headerRow = hoja.getRow(0);
                if (headerRow == null) {
                    headerRow = hoja.createRow(0);
                }
                for (int c = 0; c < t.getColumnCount(); c++) {
                    Cell celda = headerRow.getCell(c);
                    if (celda == null) {
                        celda = headerRow.createCell(c);
                    }
                    celda.setCellValue(t.getColumnName(c));
                    celda.setCellStyle(estiloConBordes);
                }

                // **Agregamos datos de la tabla**
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++, filaInicio++) {
                    Row fila = hoja.getRow(filaInicio);
                    if (fila == null) {
                        fila = hoja.createRow(filaInicio);
                    }
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.getCell(c);
                        if (celda == null) {
                            celda = fila.createCell(c);
                        }
                        Object valor = t.getValueAt(f, c);

                        if (valor instanceof Number) {
                            celda.setCellValue(((Number) valor).doubleValue());
                        } else {
                            celda.setCellValue(valor != null ? valor.toString() : "");
                        }
                        celda.setCellStyle(estiloConBordes);
                    }
                }

                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLSX);
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
