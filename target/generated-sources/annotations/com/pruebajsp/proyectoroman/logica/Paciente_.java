package com.pruebajsp.proyectoroman.logica;

import com.pruebajsp.proyectoroman.logica.Odontologo;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-20T13:46:50", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Long> idPaciente;
    public static volatile SingularAttribute<Paciente, Date> fecha;
    public static volatile SingularAttribute<Paciente, Double> totalTrabajo;
    public static volatile SingularAttribute<Paciente, String> trabajo;
    public static volatile SingularAttribute<Paciente, Double> debe;
    public static volatile SingularAttribute<Paciente, Integer> cantidad;
    public static volatile SingularAttribute<Paciente, Double> saldo;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, Double> pago;
    public static volatile SingularAttribute<Paciente, Odontologo> odontologo;

}