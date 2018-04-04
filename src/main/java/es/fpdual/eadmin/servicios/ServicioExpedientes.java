package es.fpdual.eadmin.servicios;

import java.util.List;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.modelo.Expediente;

public interface ServicioExpedientes {


	public void almacenarExpediente(Expediente expediente);
	public void modificarExpediente(Expediente expediente);
	public void eliminarExpediente(Integer codigo);
	public Expediente asociarDocumento(Integer codigoExpediente,Documento documento);
	public Expediente desasociarDocumento(Integer codigoExpediente, Integer codigoDocumento);
	
	public Expediente obtenerExpediente (Integer codigo);
	public List<Expediente> obtenerListaExpediente();
	
}
