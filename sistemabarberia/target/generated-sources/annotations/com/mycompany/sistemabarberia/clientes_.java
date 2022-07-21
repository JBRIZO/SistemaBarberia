package com.mycompany.sistemabarberia;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(clientes.class)
public abstract class clientes_ {

	public static volatile SingularAttribute<clientes, Date> FechaNacimiento;
	public static volatile SingularAttribute<clientes, String> NumDocumento;
	public static volatile SingularAttribute<clientes, Boolean> Activo;
	public static volatile SingularAttribute<clientes, String> ApeCliente;
	public static volatile SingularAttribute<clientes, Integer> idcliente;
	public static volatile SingularAttribute<clientes, String> NomCliente;
	public static volatile SingularAttribute<clientes, Integer> IDTipoDocumento;
	public static volatile SingularAttribute<clientes, Integer> IDServicio;
	public static volatile SingularAttribute<clientes, String> NumTelefono;

}

