package es.fpdual.eadmin.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.servicios.ServicioDocumento;
import es.fpdual.eadmin.utilidades.*;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	
	private final RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
	@Override
	public Documento altaDocumento(Documento documento) {
		final Documento documentoConFechaCorrecta = obtenerDocumentoConFechaCorrecta(documento);
		repositorioDocumento.altaDocumento(documentoConFechaCorrecta);
		return documentoConFechaCorrecta;
		
	}
	@Override
	public Documento modificarDocumento(Documento documento) {
		
		final Documento documentoCorrecto = obtenerDocumentoConFechaCorrecta(documento);
		repositorioDocumento.modificarDocumento(documentoCorrecto);
		return documentoCorrecto;
		
	}
	
	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
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
		return new DocumentoBuilder().clonar(documento).
				conFechaCreacion(UtilidadesFecha.dameFechaActual()).
				construir();
		
		
	}
	
	
	
	
	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}

	@Override
	public Documento obtenerDocumento(Integer codigo) {
		return repositorioDocumento.obtenerDocumentoporCodigo(codigo);
		
	}

	@Override
	public List<Documento> obtenerListaDocumentos() {
		return repositorioDocumento.obtenerTodosLosDocumentos();
		
	}

}
