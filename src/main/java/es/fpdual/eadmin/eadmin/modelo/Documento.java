package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento {

	private Integer codigo;
	private String nombre;
	private Date fecha;
	private Boolean publico;
	private EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fecha, Boolean publico, EstadoDocumento estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.publico = publico;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			return codigo.equals(((Documento) obj).getCodigo());
		}
		return false;
	}

	public int hashCode() {
		return codigo.hashCode();
	}

	@Override
	public String toString() {
		return "Documento [codigo=" + codigo + "]";
	}

	
}
