package com.pruebajsp.proyectolab.logica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-21T10:51:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Gasto.class)
public class Gasto_ { 

    public static volatile SingularAttribute<Gasto, Long> idGasto;
    public static volatile SingularAttribute<Gasto, String> nombreProveedor;
    public static volatile SingularAttribute<Gasto, Date> fecha;
    public static volatile SingularAttribute<Gasto, Double> debe;
    public static volatile SingularAttribute<Gasto, Double> pago;

}