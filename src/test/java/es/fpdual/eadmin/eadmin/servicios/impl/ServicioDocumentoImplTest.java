package es.fpdual.eadmin.eadmin.servicios.impl;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.servicios.ServicioDocumento;
import es.fpdual.eadmin.servicios.impl.ServicioDocumentoImpl;

public class ServicioDocumentoImplTest {
	
	private Documento documento;
	private ServicioDocumento servicio;
	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.servicio = new ServicioDocumentoImpl(repositorioDocumento);
		documento =  mock (Documento.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void probarAlmacenarUnDocumento() {
		
		this.servicio.altaDocumento(documento);
		verify(this.repositorioDocumento).altaDocumento(documento);

	}
	
	@Test
	public void deberiaModificarDocumento() {
		
		when(documento.getCodigo()).thenReturn(1);
		when(documento.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		when(documento.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.servicio.modificarDocumento(documento);
		
		verify(this.repositorioDocumento).modificarDocumento(any());
		assertEquals(resultado.getCodigo(),documento.getCodigo());
		assertEquals("nombre", documento.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), documento.getFechaCreacion());
	}
	
	@Test
	public void deberiaEliminarDocumento() { 
		
		when (documento.getCodigo()).thenReturn(1);
		
		this.servicio.eliminarDocumento(documento.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
	

}
