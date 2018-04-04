package es.fpdual.eadmin.servicios;

import java.util.List;

import es.fpdual.eadmin.modelo.Documento;

public interface ServicioDocumento {

	Documento altaDocumento(Documento documento);
	

	Documento modificarDocumento(Documento documento);


	void eliminarDocumento(Integer codigo);
	
	Documento obtenerDocumento(Integer codigo);
	
	List<Documento> obtenerListaDocumentos();

}
