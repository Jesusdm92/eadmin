package es.fpdual.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento{
	
	private List<Documento> listaDocumentos = new ArrayList<Documento>();

	@Override
	public void altaDocumento(Documento documento) {
		
		if(listaDocumentos.contains(documento)) {
		  throw new IllegalArgumentException("El documento ya existe");
		}
		
		listaDocumentos.add(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if(!listaDocumentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		
		listaDocumentos.set(listaDocumentos.indexOf(documento), documento);
		
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		
		/*
		for(int  i = 0; i<listaDocumentos.size(); i++) {
			if(listaDocumentos.get(i).getCodigo().equals(codigo)) {
				documentoEncontrado = listaDocumentos.get(i);
				break;
			}
		}
		*/	
		Optional<Documento> documentoEncontrado = listaDocumentos.stream().filter(d -> d.getCodigo().equals(codigo)).findFirst();
		
		if(documentoEncontrado.isPresent()) {
			listaDocumentos.remove(documentoEncontrado.get());
		}

		
	}

	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}
	
	

}
