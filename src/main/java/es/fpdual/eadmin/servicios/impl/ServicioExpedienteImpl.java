package es.fpdual.eadmin.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.modelo.Expediente;
import es.fpdual.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.modelo.builder.ExpedienteBuilder;
import es.fpdual.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.servicios.ServicioExpedientes;
import es.fpdual.eadmin.utilidades.UtilidadesFecha;

@Service
public class ServicioExpedienteImpl implements ServicioExpedientes{

	RepositorioExpediente repositorioExpediente;
	
	@Autowired
	public ServicioExpedienteImpl(RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}
	
	
	@Override
	public void almacenarExpediente(Expediente expediente) {
		repositorioExpediente.almacenarExpediente(expediente);
		
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		repositorioExpediente.modificarExpediente(obtenerExpedienteConFechaCorrecta(expediente));;
		
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		repositorioExpediente.eliminarExpediente(codigo);
		
	}

	@Override
	public Expediente asociarDocumento(Integer codigoExpediente, Documento documento) {
		return repositorioExpediente.asociarDocumento(codigoExpediente, documento);
	}

	@Override
	public Expediente desasociarDocumento(Integer codigoExpediente, Integer codigoDocumento) {
		return repositorioExpediente.desasociarDocumento(codigoExpediente, codigoDocumento);
	}
	
	
	
	protected Expediente obtenerExpedienteConFechaCorrecta(Expediente expediente) {
		/**
		 * versiones anteriores de código
		return  new Documento(documento.getCodigo(), documento.getNombre(), dameFechaActual(), documento.getPublico(), documento.getEstado(),documento.getFechaModificacion());
		
		return new DocumentoBuilder().conCodigo(documento.getCodigo()).
				conNombre(documento.getNombre()).
				conFechaCreacion(dameFechaActual()).
				conPublico(documento.getPublico()).
				conEstado(documento.getEstado()).
				construir();
				*/
		return new ExpedienteBuilder().clonar(expediente).
				conFechaCreacion(UtilidadesFecha.dameFechaActual()).
				construir();
		
		
	}


	@Override
	public Expediente obtenerExpediente(Integer codigo) {
		return repositorioExpediente.obtenerExpediente(codigo);
	}


	@Override
	public List<Expediente> obtenerListaExpediente() {
		return repositorioExpediente.obtenerListaExpedientes();
	}

}
