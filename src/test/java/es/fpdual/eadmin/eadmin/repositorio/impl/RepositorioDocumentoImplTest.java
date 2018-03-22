package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoImplTest {
	
	private static final Date Fecha_Creacion = new Date();
	private static final String Nombre_Documento = "Factura";
	private static final boolean Documento_Publico = true;
	

	private RepositorioDocumentoImpl repositorio;
	private Documento documento;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		repositorio = new RepositorioDocumentoImpl();
		documento =  new Documento(1, Nombre_Documento, Fecha_Creacion, Documento_Publico, EstadoDocumento.ACTIVO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void probarAltaDocumento() {
		
		repositorio.altaDocumento(documento);
		assertSame(documento, repositorio.getListaDocumentos().get(0) );
		
		
	}

	@Test (expected=IllegalArgumentException.class)
	public void probarErrorAltaDocumento() {
		repositorio.altaDocumento(documento);
		repositorio.altaDocumento(documento);
		
		
	}
	
	@Test
	public void probarModificarDocumento() {
		repositorio.getListaDocumentos().add(documento);
		Documento documento2 = new Documento(1, "NombreCambiado", Fecha_Creacion, Documento_Publico, EstadoDocumento.ACTIVO);
		repositorio.modificarDocumento(documento2);
		assertSame("NombreCambiado", repositorio.getListaDocumentos().get(repositorio.getListaDocumentos().indexOf(documento2)).getNombre());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void probarModificarDocumentoNoExiste() {
		repositorio.modificarDocumento(documento);
	}
	 
	
	@Test 
	public void probarEliminarDocumento() {
		repositorio.getListaDocumentos().add(documento);
		repositorio.eliminarDocumento(documento.getCodigo());
		assertTrue(this.repositorio.getListaDocumentos().isEmpty());
		
	}
	
	@Test 
	public void probarEliminarDocumentoNoExiste() {
		repositorio.eliminarDocumento(documento.getCodigo());
		assertTrue(this.repositorio.getListaDocumentos().isEmpty());
		
	}
	
	
	
	
	
}
