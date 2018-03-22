package es.fpdual.eadmin.servicios.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.servicios.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	
	RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	@Override
	public void altaDocumento(Documento documento) {
		repositorioDocumento.altaDocumento(documento);
		
	}
	@Override
	public Documento modificarDocumento(Documento documento) {
		final Documento nuevoDocumento = new Documento(documento.getCodigo(), documento.getNombre(), dameFechaActual(), documento.getPublico(), documento.getEstado(),documento.getFechaModificacion());
		
		repositorioDocumento.modificarDocumento(nuevoDocumento);
		
		
		return nuevoDocumento;
	}
	
	protected Date dameFechaActual() {
		
		return new Date();
	}
	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}

}
