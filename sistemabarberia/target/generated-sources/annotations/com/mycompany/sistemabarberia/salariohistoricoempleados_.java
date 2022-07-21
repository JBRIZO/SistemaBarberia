package com.mycompany.sistemabarberia;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(salariohistoricoempleados.class)
public abstract class salariohistoricoempleados_ {

	public static volatile SingularAttribute<salariohistoricoempleados, Integer> IDEmpleado;
	public static volatile SingularAttribute<salariohistoricoempleados, Integer> idsalario;
	public static volatile SingularAttribute<salariohistoricoempleados, Boolean> Activo;
	public static volatile SingularAttribute<salariohistoricoempleados, Date> FechaFinal;
	public static volatile SingularAttribute<salariohistoricoempleados, Date> FechaInicial;
	public static volatile SingularAttribute<salariohistoricoempleados, Double> Salario;

}

