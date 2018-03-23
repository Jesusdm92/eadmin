package es.fpdual.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	public void almacenarExpediente(Expediente expediente);
	public void modificarExpediente(Expediente expediente);
	public void eliminarExpediente(Integer codigo);
	public Expediente asociarDocumento(Integer codigoExpediente,Documento documento);
	public Expediente desasociarDocumento(Integer codigoExpediente, Integer codigoDocumento);

}
