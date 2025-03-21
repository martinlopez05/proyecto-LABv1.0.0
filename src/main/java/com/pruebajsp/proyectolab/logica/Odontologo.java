/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectolab.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa un Odontologo en el sistema.
 * 
 * @author Lopez Martin
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Odontologo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idOdontologo;
    
    private String nombre;
    private String apellido;
    private String direccion;
    
    @OneToMany(mappedBy = "odontologo",cascade = CascadeType.REMOVE, orphanRemoval = true )
    private List<Paciente> pacientes;
    
    
}
