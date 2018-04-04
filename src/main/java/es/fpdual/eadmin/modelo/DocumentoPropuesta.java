package es.fpdual.eadmin.modelo;

import java.util.Date;

public class DocumentoPropuesta extends Documento {
	
	private Integer codigoDocumentoPropuesta;
	private Integer ejercicio;
	private String grupoPolitico;
	

	public DocumentoPropuesta(Integer codigo, String nombre, Date fecha, Boolean publico, EstadoDocumento estado,Date fechaModificacion, Integer codigoDocumentoPropuesta, Integer ejercicio, String grupoPolitico) {
		super(codigo, nombre, fecha, publico, estado,fechaModificacion);
		this.codigoDocumentoPropuesta = codigoDocumentoPropuesta;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico; 

	}


	public Integer getCodigoDocumentoPropuesta() {
		return codigoDocumentoPropuesta;
	}


	public Integer getEjercicio() {
		return ejercicio;
	}


	public String getGrupoPolitico() {
		return grupoPolitico;
	}
	
	

}
