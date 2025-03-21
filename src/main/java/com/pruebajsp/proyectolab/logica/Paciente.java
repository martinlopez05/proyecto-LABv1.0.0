/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectolab.logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa a un Paciente en el sistema.
 *
 * @author Lopez Martin
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idPaciente;

    private String nombre;
    private String trabajo;
    private int cantidad;
    private Double debe;
    private Double pago;
    private Double saldo;
    private Date fecha;
    private Double totalTrabajo;

    public Paciente(long idPaciente, String nombre, String trabajo, int cantidad, Double debe, Double pago, Date fecha, Double totalTrabajo, Odontologo odontologo) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.trabajo = trabajo;
        this.cantidad = cantidad;
        this.debe = debe;
        this.pago = pago;
        this.fecha = fecha;
        this.odontologo = odontologo;
        this.totalTrabajo = totalTrabajo;
    }

    @ManyToOne
    @JoinColumn(name = "id_odontologo")
    private Odontologo odontologo;

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDebe(Double debe) {
        this.debe = debe;

    }

    public void setPago(Double pago) {
        this.pago = pago;

    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public int getMesRegistro() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public void setTotalTrabajo(Double totalTrabajo) {
        this.totalTrabajo = totalTrabajo;
    }

    public Double devolverSaldo() {
        return this.debe - this.pago;
    }

}
