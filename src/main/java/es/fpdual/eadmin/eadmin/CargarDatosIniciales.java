package es.fpdual.eadmin.eadmin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.repositorio.RepositorioDocumento;

@Component
public class CargarDatosIniciales {

	private final RepositorioDocumento repositorioDocumento;
//	
//	private static final Date FECHA = new Date();
//	
	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		this.repositorioDocumentos.altaDocumento(new DocumentoBuilder().conCodigo(1).conNombre("1").conEstado(EstadoDocumento.ACTIVO).conFechaCreacion(new Date(1/1/2018)).conFechaModificacion(new Date(1/1/2018)).conPublico(true).construir());
//		this.repositorioDocumentos.altaDocumento(new DocumentoBuilder().conCodigo(2).conNombre("2").conEstado(EstadoDocumento.APROBADO).conFechaCreacion(new Date(1/1/2018)).conFechaModificacion(new Date(1/1/2018)).conPublico(true).construir());
//		this.repositorioDocumentos.altaDocumento(new DocumentoBuilder().conCodigo(3).conNombre("3").conEstado(EstadoDocumento.ELIMINADO).conFechaCreacion(new Date(1/1/2018)).conFechaModificacion(new Date(1/1/2018)).conPublico(true).construir());
//
//		
//	}
	
	
	

}
