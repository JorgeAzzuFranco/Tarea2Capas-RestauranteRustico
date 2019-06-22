package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="empleado")
public class Empleado {

	@Id
	//@GeneratedValue(generator="sucursal_codigo_seq", strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "sucursal_codigo_seq", sequenceName = "public.sucursal_codigo_seq")
	@Column(name="codigo")
	Integer codigo;
	@Column(name="nombre")
	String nombre;
	@Column(name="edad")
	Integer edad;
	@Column(name="genero")
	Character genero;
	@Column(name="estado")
	Boolean estado;
	@Column(name="id_sucursal")
	String id_sucursal;
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(String id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

}