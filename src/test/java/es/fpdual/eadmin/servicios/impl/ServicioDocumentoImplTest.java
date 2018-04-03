package es.fpdual.eadmin.servicios.impl;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

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
	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	private List<Documento> lista;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.servicio = spy(new ServicioDocumentoImpl(repositorioDocumento));
		documento =  mock (Documento.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void probarAlmacenarUnDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when((ServicioDocumentoImpl)this.servicio).obtenerDocumentoConFechaCorrecta(documento);
		final Documento resultado = servicio.altaDocumento(documento);
		verify(repositorioDocumento).altaDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);

	}
	
	@Test
	public void deberiaModificarDocumento() {
		
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when((ServicioDocumentoImpl)this.servicio).obtenerDocumentoConFechaCorrecta(documento);
		final Documento resultado = servicio.modificarDocumento(documento);
		verify(repositorioDocumento).modificarDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);
	}
	
	@Test
	public void deberiaEliminarDocumento() { 
		
		when (documento.getCodigo()).thenReturn(1);
		
		this.servicio.eliminarDocumento(documento.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
	
	@Test
	public void deberiaObtenerDocumento() {
		when (documento.getCodigo()).thenReturn(1);
		when (repositorioDocumento.obtenerDocumentoporCodigo(1)).thenReturn(documento);
		assertEquals(documento,servicio.obtenerDocumento(documento.getCodigo()));
		
	}
	
	@Test
	public void deberiaObtenerListaDocumentos() {
		when (repositorioDocumento.obtenerTodosLosDocumentos()).thenReturn(lista);
		assertSame(repositorioDocumento.obtenerTodosLosDocumentos(),servicio.obtenerListaDocumentos());
	}

}
