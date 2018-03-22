package es.fpdual.eadmin.servicios;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	void altaDocumento(Documento documento);
	

	Documento modificarDocumento(Documento documento);


	void eliminarDocumento(Integer codigo);

}
