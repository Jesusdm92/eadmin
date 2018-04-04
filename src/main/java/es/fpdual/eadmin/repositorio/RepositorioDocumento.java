package es.fpdual.eadmin.repositorio;

import java.util.List;

import es.fpdual.eadmin.modelo.Documento;

public interface RepositorioDocumento {

	public abstract void altaDocumento(Documento documento);
	
	public abstract void modificarDocumento(Documento documento);
	
	public abstract void eliminarDocumento(Integer codigo);
	
	public abstract Documento obtenerDocumentoporCodigo(Integer codigo);
	
	public abstract List<Documento> obtenerTodosLosDocumentos();
	
	
}
