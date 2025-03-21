/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectolab.vista;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Clase utilitaria para mostrar mensajes y confirmaciones en la interfaz
 * gráfica. Proporciona métodos estáticos para mostrar mensajes de información,
 * errores y cuadros de diálogo de confirmación.
 *
 * @author Lopez Martin
 */
public class VistaUtils {

    /**
     * Muestra un mensaje en un cuadro de diálogo con un tipo específico
     * (información o error).
     *
     * @param mensaje El mensaje que se desea mostrar.
     * @param tipo El tipo de mensaje ("info" para información, "error" para
     * error).
     * @param titulo El título del cuadro de diálogo.
     */
    public static void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionpane = new JOptionPane(mensaje);
        if (tipo.equals("info")) {
            optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        if (tipo.equals("error")) {
            optionpane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog = optionpane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    /**
     * Muestra un cuadro de diálogo de confirmación con opciones "Sí" y "No".
     *
     * @param parentComponent El componente padre sobre el que se mostrará el
     * diálogo.
     * @param mensajeAmostrar El mensaje que se desea mostrar en el diálogo.
     * @param titulo El título del cuadro de diálogo.
     * @return `true` si el usuario selecciona "Sí", `false` si selecciona "No".
     */
    public static boolean mostrarConfirmacion(java.awt.Component parentComponent, String mensajeAmostrar, String titulo) {
        UIManager.put("Button.focus", new Color(0, 0, 0, 0));
        String[] opciones = {"Sí", "No"};
        int respuesta = JOptionPane.showOptionDialog(
                parentComponent,
                mensajeAmostrar,
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        return respuesta == 0;

    }
}