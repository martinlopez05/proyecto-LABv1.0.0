package com.pruebajsp.proyectolab.logica;

import com.pruebajsp.proyectolab.logica.Paciente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-21T14:16:17", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ { 

    public static volatile SingularAttribute<Odontologo, String> apellido;
    public static volatile SingularAttribute<Odontologo, String> direccion;
    public static volatile ListAttribute<Odontologo, Paciente> pacientes;
    public static volatile SingularAttribute<Odontologo, Long> idOdontologo;
    public static volatile SingularAttribute<Odontologo, String> nombre;

}