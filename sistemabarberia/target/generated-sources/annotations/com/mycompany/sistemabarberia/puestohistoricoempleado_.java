package com.mycompany.sistemabarberia;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(puestohistoricoempleado.class)
public abstract class puestohistoricoempleado_ {

	public static volatile SingularAttribute<puestohistoricoempleado, Integer> IDEmpleado;
	public static volatile SingularAttribute<puestohistoricoempleado, Integer> numpuesto;
	public static volatile SingularAttribute<puestohistoricoempleado, Boolean> Activo;
	public static volatile SingularAttribute<puestohistoricoempleado, Integer> IDPuesto;
	public static volatile SingularAttribute<puestohistoricoempleado, Date> FechaFinal;
	public static volatile SingularAttribute<puestohistoricoempleado, Date> FechaInicial;

}

