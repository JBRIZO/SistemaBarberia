package com.mycompany.sistemabarberia;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(empleado.class)
public abstract class empleado_ {

	public static volatile SingularAttribute<empleado, Date> FechaNacimiento;
	public static volatile SingularAttribute<empleado, Date> FechaInicio;
	public static volatile SingularAttribute<empleado, Boolean> Activo;
	public static volatile SingularAttribute<empleado, String> NomEmpleado;
	public static volatile SingularAttribute<empleado, String> NumCelular;
	public static volatile SingularAttribute<empleado, String> ApeEmpleado;
	public static volatile SingularAttribute<empleado, String> Direccion;
	public static volatile SingularAttribute<empleado, Date> FechaFinal;
	public static volatile SingularAttribute<empleado, Character> GenEmpleado;
	public static volatile SingularAttribute<empleado, Integer> idempleado;
	public static volatile SingularAttribute<empleado, Integer> IDTipoDocumento;
	public static volatile SingularAttribute<empleado, String> NumDoc;

}

