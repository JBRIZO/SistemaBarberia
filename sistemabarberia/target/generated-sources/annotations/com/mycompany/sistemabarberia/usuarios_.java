package com.mycompany.sistemabarberia;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(usuarios.class)
public abstract class usuarios_ {

	public static volatile SingularAttribute<usuarios, Integer> IDEmpleado;
	public static volatile SingularAttribute<usuarios, Boolean> Activo;
	public static volatile SingularAttribute<usuarios, String> Contrasena;
	public static volatile SingularAttribute<usuarios, Integer> Intentos;
	public static volatile SingularAttribute<usuarios, String> NomCuenta;
	public static volatile SingularAttribute<usuarios, Integer> idusuario;

}

