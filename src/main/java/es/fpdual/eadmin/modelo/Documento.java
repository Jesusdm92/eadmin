package es.fpdual.eadmin.modelo;

import java.util.Date;
import java.util.Objects;

public class Documento extends ModeloBasicoAdministracionElectronica {

	
	private Boolean publico;
	private EstadoDocumento estado;
	private Integer codigoVerificacion;
	
	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,Date fechaModificacion) {
		super(codigo,nombre,fechaCreacion,fechaModificacion);
		this.publico = publico;
		this.estado = estado;
		codigoVerificacion = hashCode();
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}


	@Override
	public String toString() {
		return "Documento [codigo=" + super.getCodigo() + "]";
	}

	
	
}
