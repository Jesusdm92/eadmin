package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.Date;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public class ExpedienteBuilder {
	
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaModificacion;
	protected Date fechaArchivado;
	protected Boolean publico;
	protected EstadoExpediente estado;
	protected List<Documento> documentos;
	
	public Expediente construir() {
		
		return new Expediente(codigo,nombre,fechaCreacion, fechaArchivado,publico, estado, documentos, fechaModificacion);
	}

	public ExpedienteBuilder conCodigo(Integer codigo) {
		this.codigo = codigo;
		return this;
	}
	
	public ExpedienteBuilder conNombre(String nombre) {
		this.nombre = nombre;
	    return this;
	}
	
	public ExpedienteBuilder conFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}
	
	public ExpedienteBuilder conFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
		return this;
	}
	
	public ExpedienteBuilder conFechaArchivado(Date fechaArchivado ) {
		this.fechaArchivado = fechaArchivado;
		return this;
	}
	
	public ExpedienteBuilder conPublico(Boolean publico) {
		this.publico = publico;
		return this;
	}
	
	public ExpedienteBuilder conEstadoExpediente(EstadoExpediente estado) {
		this.estado = estado;
		return this;
	}
	
	public ExpedienteBuilder conListaDocumento(List<Documento> documentos) {
		this.documentos = documentos;
		return this;
	}
	
	public ExpedienteBuilder clonar(Expediente expediente) {
		this.codigo = expediente.getCodigo();
		this.nombre = expediente.getNombre();
		this.fechaArchivado = expediente.getFechaArchivado();
		this.fechaCreacion = expediente.getFechaCreacion();
		this.fechaModificacion = expediente.getFechaModificacion();
		this.publico = expediente.getPublico();
		this.estado = expediente.getEstado();
		this.documentos = expediente.getDocumentos();
		
		return this;
	}
}
