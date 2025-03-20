/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectoroman.persistencia;

import com.pruebajsp.proyectoroman.logica.Gasto;
import com.pruebajsp.proyectoroman.logica.Odontologo;
import com.pruebajsp.proyectoroman.logica.Paciente;
import com.pruebajsp.proyectoroman.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 * Controladora de persistencia que se encarga de gestionar la comunicación con
 * la capa de persistencia. Proporciona métodos para realizar operaciones CRUD
 * sobre Odontólogos, Pacientes y Gastos.
 *
 * @author Usuario
 */
public class ControladoraPersistencia {

    private OdontologoJpaController odonJpa = new OdontologoJpaController();
    private PacienteJpaController paciJpa = new PacienteJpaController();
    private GastoJpaController gastoJpa = new GastoJpaController();

    /**
     * Crea un nuevo odontólogo en la base de datos.
     *
     * @param odontologo Objeto Odontologo a ser almacenado.
     */
    public void crearOdontologo(Odontologo odontologo) {
        odonJpa.create(odontologo);
    }

    /**
     * Obtiene la lista de todos los odontólogos almacenados en la base de
     * datos.
     *
     * @return Lista de objetos Odontologo.
     */
    public List<Odontologo> traerListaOdontologo() {
        return odonJpa.findOdontologoEntities();
    }

    /**
     * Crea un nuevo paciente en la base de datos.
     *
     * @param paciente Objeto Paciente a ser almacenado.
     */
    public void crearPaciente(Paciente paciente) {
        System.out.println("Guardando paciente: " + paciente);
        paciJpa.create(paciente);
        System.out.println("Paciente guardado con éxito.");
    }

    /**
     * Obtiene la lista de todos los pacientes almacenados en la base de datos.
     *
     * @return Lista de objetos Paciente.
     */
    public List<Paciente> traerPacientes() {
        return paciJpa.findPacienteEntities();
    }

    /**
     * Obtiene un paciente por su ID.
     *
     * @param idPaciente ID del paciente a buscar.
     * @return Objeto Paciente si se encuentra, de lo contrario null.
     */
    public Paciente traerPaciente(Long idPaciente) {
        return paciJpa.findPaciente(idPaciente);
    }

    /**
     * Elimina un paciente de la base de datos.
     *
     * @param idPaciente ID del paciente a eliminar.
     * @throws NonexistentEntityException Si el paciente no existe en la base de
     * datos.
     */
    public void eliminarPaciente(Long idPaciente) throws NonexistentEntityException {
        paciJpa.destroy(idPaciente);
    }

    /**
     * Obtiene un odontólogo por su ID.
     *
     * @param idOdontologo ID del odontólogo a buscar.
     * @return Objeto Odontologo si se encuentra, de lo contrario null.
     */
    public Odontologo traerOdontologo(Long idOdontologo) {
        return odonJpa.findOdontologo(idOdontologo);
    }

    /**
     * Elimina un odontólogo de la base de datos.
     *
     * @param idOdontologo ID del odontólogo a eliminar.
     * @throws NonexistentEntityException Si el odontólogo no existe en la base
     * de datos.
     */
    public void eliminarOdontologo(Long idOdontologo) throws NonexistentEntityException {
        odonJpa.destroy(idOdontologo);
    }

    /**
     * Edita los datos de un paciente existente en la base de datos.
     *
     * @param paciente Objeto Paciente con los datos actualizados.
     * @throws Exception Si ocurre un error al actualizar el paciente.
     */
    public void editPaciente(Paciente paciente) throws Exception {
        paciJpa.edit(paciente);
    }

    /**
     * Obtiene el total facturado por mes.
     *
     * @return Lista de arreglos de objetos con los datos del total facturado
     * por mes.
     */
    public List<Object[]> obtenerTotalFacturadoPorMes() {
        return paciJpa.obtenerTotalFacturadoPorMes();
    }

    /**
     * Crea un nuevo gasto en la base de datos.
     *
     * @param gasto Objeto Gasto a ser almacenado.
     */
    public void crearGasto(Gasto gasto) {
        gastoJpa.create(gasto);
    }

    /**
     * Obtiene la lista de todos los gastos almacenados en la base de datos.
     *
     * @return Lista de objetos Gasto.
     */
    public List<Gasto> traerGastos() {
        return gastoJpa.findGastoEntities();
    }

    /**
     * Obtiene un gasto por su ID.
     *
     * @param idGasto ID del gasto a buscar.
     * @return Objeto Gasto si se encuentra, de lo contrario null.
     */
    public Gasto traerGasto(Long idGasto) {
        return gastoJpa.findGasto(idGasto);
    }

    /**
     * Edita los datos de un gasto existente en la base de datos.
     *
     * @param gasto Objeto Gasto con los datos actualizados.
     * @throws Exception Si ocurre un error al actualizar el gasto.
     */
    public void editGasto(Gasto gasto) throws Exception {
        gastoJpa.edit(gasto);
    }

    /**
     * Obtiene el total de gastos por mes.
     *
     * @return Lista de arreglos de objetos con los datos del total de gastos
     * por mes.
     */
    public List<Object[]> obtenerTotalGastosPorMes() {
        return gastoJpa.getSumaDebePorMes();
    }

    /**
     * Elimina un gasto de la base de datos.
     *
     * @param idGasto ID del gasto a eliminar.
     * @throws NonexistentEntityException Si el gasto no existe en la base de
     * datos.
     */
    public void eliminarGasto(Long idGasto) throws NonexistentEntityException {
        gastoJpa.destroy(idGasto);
    }

}
