package es.fpdual.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.modelo.Expediente;
import es.fpdual.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private List<Expediente> listaExpedientes = new ArrayList<Expediente>();
	
	@Override
	public void almacenarExpediente(Expediente expediente) {
		
		if(listaExpedientes.contains(expediente)) {
			  throw new IllegalArgumentException("El expediente ya existe");
			}
			
			listaExpedientes.add(expediente);
		
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		
		if(!listaExpedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente no existe");
		}
		
		listaExpedientes.set(listaExpedientes.indexOf(expediente), expediente);
		
	}
		

	@Override
	public void eliminarExpediente(Integer codigo) {
		
		Optional<Expediente> expedienteEncontrado = listaExpedientes.stream().filter(e -> e.getCodigo().equals(codigo)).findFirst();
		
		if(expedienteEncontrado.isPresent()) {
			listaExpedientes.remove(expedienteEncontrado.get());
		}
	}

	@Override
	public Expediente asociarDocumento(Integer codigoExpediente,Documento documento) {
		
		Optional<Expediente> expedienteEncontrado = listaExpedientes.stream().filter(e -> e.getCodigo().equals(codigoExpediente)).findFirst();
		
		if(expedienteEncontrado.isPresent()) {
			expedienteEncontrado.get().getDocumentos().add(documento);
			return expedienteEncontrado.get();	
		}
		
		return null;
	}

	@Override
	public Expediente desasociarDocumento(Integer codigoExpediente, Integer codigoDocumento) {
		
		Optional<Expediente> expedienteEncontrado = listaExpedientes.stream().filter(e -> e.getCodigo().equals(codigoExpediente)).findFirst();
		
		if(expedienteEncontrado.isPresent()) {
			List<Documento> documentos = expedienteEncontrado.get().getDocumentos();
			
			Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigoDocumento)).findFirst();
			
			if(documentoEncontrado.isPresent()) {
				
				expedienteEncontrado.get().getDocumentos().remove(documentoEncontrado.get());
				
				return expedienteEncontrado.get();
			}
			
			
		}
		
		return null;
	}

	public List<Expediente> getListaExpedientes() {
		return listaExpedientes;
	}

	@Override
	public Expediente obtenerExpediente(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = listaExpedientes.stream().filter(e -> e.getCodigo().equals(codigo)).findFirst();
		if(expedienteEncontrado.isPresent()) {
			return expedienteEncontrado.get();	
		}
		
		return null;
	}

	@Override
	public List<Expediente> obtenerListaExpedientes() {
		return listaExpedientes;
	}
	
	
	
	

}
