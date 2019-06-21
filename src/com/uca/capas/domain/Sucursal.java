package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="sucursal")
public class Sucursal {
	@Id
	//@GeneratedValue(generator="sucursal_codigo_seq", strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "sucursal_codigo_seq", sequenceName = "public.sucursal_codigo_seq")
	@Column(name="codigo")
	Integer codigo;
	@Column(name="nombre")
	String nombre;
	@Column(name="ubicacion")
	String ubicacion;
	@Column(name="nmesa")
	Integer nMesa;
	@Column(name="nomgerente")
	String nomGerente;
	@Column(name="horario_ini")
	String horarioInicio;
	@Column(name="horario_fin")
	String horarioFin;
	
	public Sucursal() {
		super();
	}

	public Sucursal(String nombre, String ubicacion, Integer nMesa, String nomGerente, String horarioInicio,
			String horarioFin) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.nMesa = nMesa;
		this.nomGerente = nomGerente;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
	}

	public Integer getCodigo() {
		return codigo;
	}

	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getUbicacion() {
		return ubicacion;
	}

	
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	public Integer getnMesa() {
		return nMesa;
	}

	
	public void setnMesa(Integer nMesa) {
		this.nMesa = nMesa;
	}

	
	public String getNomGerente() {
		return nomGerente;
	}

	
	public void setNomGerente(String nomGerente) {
		this.nomGerente = nomGerente;
	}

	
	public String getHorarioInicio() {
		return horarioInicio;
	}

	
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	
	public String getHorarioFin() {
		return horarioFin;
	}

	
	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}
}
