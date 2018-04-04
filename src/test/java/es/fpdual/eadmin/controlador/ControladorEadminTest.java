package es.fpdual.eadmin.controlador;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.servicios.ServicioDocumento;

public class ControladorEadminTest {

	private ControladorEadmin controlador;
	private ServicioDocumento servicioDocumento = mock(ServicioDocumento.class);
	List<Documento> lista = new ArrayList<Documento>();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		controlador = new ControladorEadmin(servicioDocumento);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		when(servicioDocumento.obtenerListaDocumentos()).thenReturn(lista);
		assertSame(lista, controlador.getTodosDocumentos().getBody());
	}
	
	@Test
	public void deberiaObtenerUnDocumentoPorCodigo() {
		Documento documento = mock (Documento.class);
		when(servicioDocumento.obtenerDocumento(1)).thenReturn(documento);
		assertSame(documento,controlador.getDocumentoPorCodigo(1).getBody());
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		assertEquals(HttpStatus.OK, controlador.eliminarDocumento(1).getStatusCode());
		verify(servicioDocumento).eliminarDocumento(1);
	}
}
