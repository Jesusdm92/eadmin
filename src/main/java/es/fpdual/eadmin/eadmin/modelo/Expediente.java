package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.List;

public class Expediente extends ModeloBasicoAdministracionElectronica{


	private Date fechaArchivado;
	private Boolean publico;
	private EstadoExpediente estado;

	private List<Documento> documentos;
	

	public Expediente(Integer codigoExpediente, String nombreExpediente, Date fechaCreacion, Date fechaArchivado,
			Boolean publico, EstadoExpediente estado, List<Documento> documentos) {
		super(codigoExpediente, nombreExpediente, fechaCreacion);
		this.fechaArchivado = fechaArchivado;
		this.publico = publico;
		this.estado = estado;
		this.documentos = documentos;
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
			return super.getCodigo().equals(((Expediente) obj).getCodigo())
					&&  getNombre().equals(((Expediente) obj).getNombre())  
					&& getFechaCreacion().equals(((Expediente) obj).getFechaCreacion()) 
					&& fechaArchivado.equals(((Expediente) obj).getFechaArchivado())
					&& publico.equals(((Expediente) obj).getPublico())
					&& estado.equals(((Expediente) obj).getEstado())
					;
		}
		return false;
	}
	

	

}
