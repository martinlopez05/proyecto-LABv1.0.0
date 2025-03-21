/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectolab.logica;

import com.pruebajsp.proyectolab.persistencia.ControladoraPersistencia;
import com.pruebajsp.proyectolab.persistencia.exceptions.IllegalOrphanException;
import com.pruebajsp.proyectoroman.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase Controladora que gestiona la lógica de negocio de la aplicación
 * odontológica. Se encarga de la administración de odontólogos, pacientes y
 * gastos, interactuando con la ControladoraPersistencia para realizar
 * operaciones en la base de datos.
 *
 * @author Lopez Martin
 */
public class Controladora {

    private ControladoraPersistencia controlpersis = new ControladoraPersistencia();

    /**
     * Crea un nuevo odontólogo y lo guarda en la base de datos.
     *
     * @param nombreOdon Nombre del odontólogo.
     * @param direccionOdontologo Dirección del odontólogo.
     */
    public void crearOdontologo(String nombreOdon, String direccionOdontologo) {
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre(nombreOdon);
        odontologo.setDireccion(direccionOdontologo);
        controlpersis.crearOdontologo(odontologo);
    }

    /**
     * Obtiene la lista de todos los odontólogos almacenados en la base de
     * datos.
     *
     * @return Lista de odontólogos.
     */
    public List<Odontologo> traerListaOdontologos() {
        return controlpersis.traerListaOdontologo();
    }

    /**
     * Busca un odontólogo por su nombre.
     *
     * @param nombre Nombre del odontólogo a buscar.
     * @return El odontólogo encontrado o {@code null} si no existe.
     */
    public Odontologo buscarOdontologoPorNombre(String nombre) {
        List<Odontologo> odontologos = this.traerListaOdontologos();
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getNombre().equals(nombre)) {
                return odontologo;
            }
        }
        return null;
    }

    /**
     * Crea un nuevo paciente y lo guarda en la base de datos.
     *
     * @param nombre Nombre del paciente.
     * @param trabajo Trabajo del paciente.
     * @param fecha Fecha de registro del paciente.
     * @param cantidad Cantidad de consultas o tratamientos.
     * @param debe Monto pendiente de pago.
     * @param pago Monto pagado.
     * @param odontologo Odontólogo asociado al paciente.
     */
    public void crearPaciente(String nombre, String trabajo, Date fecha, int cantidad, Double debe, Double pago, Odontologo odontologo) {
        Paciente paciente = new Paciente();
        paciente.setCantidad(cantidad);
        paciente.setDebe(debe);
        paciente.setFecha(fecha);
        paciente.setTrabajo(trabajo);
        paciente.setPago(pago);
        paciente.setNombre(nombre);
        paciente.setSaldo(paciente.devolverSaldo());
        paciente.setOdontologo(odontologo);
        System.out.println("Guardando paciente:");
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Trabajo: " + paciente.getTrabajo());
        System.out.println("Fecha: " + paciente.getFecha());
        System.out.println("Cantidad: " + paciente.getCantidad());
        System.out.println("Debe: " + paciente.getDebe());
        System.out.println("Pago: " + paciente.getPago());
        System.out.println("Saldo: " + paciente.getSaldo());
        System.out.println("Odontólogo: " + (paciente.getOdontologo() != null ? paciente.getOdontologo().getNombre() : "Ninguno"));

        controlpersis.crearPaciente(paciente);
    }

    /**
     * Obtiene una lista de pacientes asignados a un odontólogo específico.
     *
     * @param odontologo Odontólogo del cual se desean obtener los pacientes.
     * @return Lista de pacientes asignados al odontólogo.
     */
    public List<Paciente> traerPacientesPorOdontologo(Odontologo odontologo) {
        List<Paciente> pacientes = new ArrayList<>();
        for (Paciente paciente : this.traerPacientes()) {
            if (paciente.getOdontologo().getIdOdontologo() == odontologo.getIdOdontologo()) {
                pacientes.add(paciente);
            }
        }
        return pacientes;
    }

    /**
     * Obtiene la lista de todos los pacientes almacenados en la base de datos.
     *
     * @return Lista de pacientes.
     */
    public List<Paciente> traerPacientes() {
        List<Paciente> pacientes = controlpersis.traerPacientes();
        System.out.println("Total de pacientes en la BD: " + pacientes.size());
        return pacientes;
    }

    /**
     * Elimina un paciente de la base de datos.
     *
     * @param idPaciente ID del paciente a eliminar.
     * @throws NonexistentEntityException Si el paciente no existe.
     */
    public void eliminarPaciente(Long idPaciente) throws NonexistentEntityException, com.pruebajsp.proyectolab.persistencia.exceptions.NonexistentEntityException {
        controlpersis.eliminarPaciente(idPaciente);
    }

    /**
     * Obtiene un paciente específico por su ID.
     *
     * @param idPaciente ID del paciente a buscar.
     * @return El paciente encontrado o {@code null} si no existe.
     */
    public Paciente traerPaciente(Long idPaciente) {
        return controlpersis.traerPaciente(idPaciente);
    }

    /**
     * Obtiene un odontólogo específico por su ID.
     *
     * @param idOdontologo ID del odontólogo a buscar.
     * @return El odontólogo encontrado o {@code null} si no existe.
     */
    public Odontologo traerOdontologo(Long idOdontologo) {
        return controlpersis.traerOdontologo(idOdontologo);
    }

    /**
     * Elimina un odontólogo de la base de datos.
     *
     * @param idOdontologo ID del odontólogo a eliminar.
     * @throws NonexistentEntityException Si el odontólogo no existe.
     */
    public void eliminarOdontologo(Long idOdontologo) throws NonexistentEntityException, com.pruebajsp.proyectolab.persistencia.exceptions.NonexistentEntityException {
        controlpersis.eliminarOdontologo(idOdontologo);
    }

    /**
     * Edita la información de un paciente existente.
     *
     * @param paciente Paciente a modificar.
     * @param nombre Nuevo nombre.
     * @param trabajo Nuevo trabajo.
     * @param cantidad Nueva cantidad de consultas o tratamientos.
     * @param debe Nuevo monto pendiente de pago.
     * @param pago Nuevo monto pagado.
     * @param fecha Nueva fecha de registro.
     * @throws Exception Si ocurre un error en la edición.
     */
    public void editPaciente(Paciente paciente, String nombre, String trabajo, int cantidad, Double debe, Double pago, Date fecha) throws Exception {
        if (paciente != null) {
            paciente.setCantidad(cantidad);
            paciente.setDebe(debe);
            paciente.setFecha(fecha);
            paciente.setNombre(nombre);
            paciente.setTrabajo(trabajo);
            paciente.setPago(pago);
            paciente.setSaldo(paciente.devolverSaldo());
        }

        controlpersis.editPaciente(paciente);
    }

    /**
     * Obtiene el total facturado por mes.
     *
     * @return Lista de objetos con la información del total facturado por mes.
     */
    public List<Object[]> obtenerTotalPorMes() {
        return controlpersis.obtenerTotalFacturadoPorMes();
    }

    /**
     * Crea un nuevo gasto y lo guarda en la base de datos.
     *
     * @param nombreProveedor Nombre del proveedor del gasto.
     * @param debe Monto pendiente de pago.
     * @param pago Monto pagado.
     * @param fecha Fecha del gasto.
     */
    public void crearGasto(String nombreProveedor, Double debe, Double pago, Date fecha) {
        Gasto gasto = new Gasto();
        gasto.setPago(pago);
        gasto.setDebe(debe);
        gasto.setNombreProveedor(nombreProveedor);
        gasto.setFecha(fecha);
        controlpersis.crearGasto(gasto);

    }

    /**
     * Obtiene la lista de todos los gastos almacenados en la base de datos.
     *
     * @return Lista de gastos.
     */
    public List<Gasto> traerGastos() {
        return controlpersis.traerGastos();
    }

    /**
     * Obtiene un gasto específico por su ID.
     *
     * @param idGasto ID del gasto a buscar.
     * @return El gasto encontrado o {@code null} si no existe.
     */
    public Gasto traerGasto(Long idGasto) {
        return controlpersis.traerGasto(idGasto);
    }

    /**
     * Edita la información de un gasto existente.
     *
     * @param gasto Gasto a modificar.
     * @param nombreProveedor Nuevo nombre del proveedor.
     * @param debe Nuevo monto pendiente de pago.
     * @param pago Nuevo monto pagado.
     * @param fecha Nueva fecha del gasto.
     * @throws Exception Si ocurre un error en la edición.
     */
    public void editGasto(Gasto gasto, String nombreProveedor, Double debe, Double pago, Date fecha) throws Exception {
        if (gasto != null) {
            gasto.setNombreProveedor(nombreProveedor);
            gasto.setDebe(debe);
            gasto.setPago(pago);
            gasto.setFecha(fecha);
        }

        controlpersis.editGasto(gasto);
    }

    /**
     * Obtiene el total de gastos por mes.
     *
     * @return Lista de objetos con la información de la deuda de gastos por mes.
     */
    public List<Object[]> obtenerDeudaTotalGastosporMes() {
        return controlpersis.obtenerDeudaTotalGastosPorMes();
    }

    /**
     * Elimina un gasto de la base de datos.
     *
     * @param idGasto ID del gasto a eliminar.
     * @throws NonexistentEntityException Si el gasto no existe.
     */
    public void eliminarGasto(Long idGasto) throws NonexistentEntityException, com.pruebajsp.proyectolab.persistencia.exceptions.NonexistentEntityException {
        controlpersis.eliminarGasto(idGasto);
    }

    public void editOdontologo(Odontologo odontologo, String nombre, String direccion) throws Exception {
        if (odontologo != null) {
            odontologo.setNombre(nombre);
            odontologo.setDireccion(direccion);
        }
        controlpersis.editOdontologo(odontologo);
    }

}
