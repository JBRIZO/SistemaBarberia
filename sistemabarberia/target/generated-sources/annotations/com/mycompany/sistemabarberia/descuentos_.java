package com.mycompany.sistemabarberia;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(descuentos.class)
public abstract class descuentos_ {

	public static volatile SingularAttribute<descuentos, Integer> iddescuento;
	public static volatile SingularAttribute<descuentos, Date> FechaInicio;
	public static volatile SingularAttribute<descuentos, Boolean> Activo;
	public static volatile SingularAttribute<descuentos, Integer> IDTipoDescuento;
	public static volatile SingularAttribute<descuentos, Date> FechaFinal;
	public static volatile SingularAttribute<descuentos, Double> Valor;

}

