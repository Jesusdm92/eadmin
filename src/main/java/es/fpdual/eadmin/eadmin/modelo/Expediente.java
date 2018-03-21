package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.List;

public class Expediente {

	private Integer codigoExpediente;
	private String nombreExpediente;
	private Date fechaCreacion;
	private Date fechaArchivado;
	private Boolean publico;
	private EstadoExpediente estado;

	private List<Documento> documentos;
	
	

	public Expediente(Integer codigoExpediente, String nombreExpediente, Date fechaCreacion, Date fechaArchivado,
			Boolean publico, EstadoExpediente estado, List<Documento> documentos) {
		super();
		this.codigoExpediente = codigoExpediente;
		this.nombreExpediente = nombreExpediente;
		this.fechaCreacion = fechaCreacion;
		this.fechaArchivado = fechaArchivado;
		this.publico = publico;
		this.estado = estado;
		this.documentos = documentos;
	}

	public Integer getCodigoExpediente() {
		return codigoExpediente;
	}

	public String getNombreExpediente() {
		return nombreExpediente;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			return codigoExpediente.equals(((Expediente) obj).getCodigoExpediente()) 
					&&  nombreExpediente.equals(((Expediente) obj).getNombreExpediente())  
					&& fechaCreacion.equals(((Expediente) obj).getFechaCreacion()) 
					&& fechaArchivado.equals(((Expediente) obj).getFechaArchivado())
					&& publico.equals(((Expediente) obj).getPublico())
					&& estado.equals(((Expediente) obj).getEstado())
					;
		}
		return false;
	}
	
	public int hashCode() {
		return codigoExpediente.hashCode();
	}

	

}
