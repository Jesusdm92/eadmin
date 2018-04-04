package es.fpdual.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.servicios.impl.ServicioDocumentoImpl;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private List<Documento> listaDocumentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando del metodo alta documento");
		if (listaDocumentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		listaDocumentos.add(documento);
		System.out.println("Documento almacenado");
		logger.info(documento.toString() + " creado correctamente");
		logger.info("Saliendo del metodo alta documento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entrando en el metodo modificar");
		if (!listaDocumentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		logger.info("Documento a modificar: " + documento.toString());
		listaDocumentos.set(listaDocumentos.indexOf(documento), documento);
		logger.info(documento.toString() + " modificado");
		logger.info("Saliendo el método modificar");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando en el metodo eliminar");
		/*
		 * for(int i = 0; i<listaDocumentos.size(); i++) {
		 * if(listaDocumentos.get(i).getCodigo().equals(codigo)) { documentoEncontrado =
		 * listaDocumentos.get(i); break; } }
		 */
		Optional<Documento> documentoEncontrado = listaDocumentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			logger.info("Eliminando: " + documentoEncontrado.get().toString());
			listaDocumentos.remove(documentoEncontrado.get());
		}
		logger.info("Saliendo del metodo eliminar");
	}

	public List<Documento> getListaDocumentos() {
		return listaDocumentos;
	}

	@Override
	public Documento obtenerDocumentoporCodigo(Integer codigo) {
		logger.info("Entrando en el metodo obtener documento por codigo");
		Optional<Documento> documentoEncontrado = listaDocumentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		logger.info("Saliendo del metodo obtener documento por codigo");
		return null;

	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		return listaDocumentos;
	}

}
