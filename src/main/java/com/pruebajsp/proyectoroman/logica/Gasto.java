/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectoroman.logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa a un Gasto en el sistema.
 *
 * @author Lopez Martin
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gasto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idGasto;
    
    private String nombreProveedor;
    private Double debe;
    private Double pago;
    private Date fecha;
    
    public int getMesRegistro() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return calendar.get(Calendar.MONTH) + 1;
    }
    
}
