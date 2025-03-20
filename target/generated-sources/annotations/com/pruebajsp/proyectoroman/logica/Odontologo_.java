package com.pruebajsp.proyectoroman.logica;

import com.pruebajsp.proyectoroman.logica.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-20T13:46:50", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ { 

    public static volatile SingularAttribute<Odontologo, String> apellido;
    public static volatile SingularAttribute<Odontologo, String> direccion;
    public static volatile ListAttribute<Odontologo, Paciente> pacientes;
    public static volatile SingularAttribute<Odontologo, Long> idOdontologo;
    public static volatile SingularAttribute<Odontologo, String> nombre;

}