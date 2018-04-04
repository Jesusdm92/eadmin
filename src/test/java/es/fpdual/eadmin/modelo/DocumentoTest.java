package es.fpdual.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.modelo.EstadoDocumento;

public class DocumentoTest {
	
	private static final Date Fecha_Creacion = new Date();
	private static final Date Fecha_Modificacion = new Date();
	private static final String Nombre_Documento = "Factura";
	private static final boolean Documento_Publico = true;
	
    private Documento documento;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		documento = new Documento(1, Nombre_Documento, Fecha_Creacion, Documento_Publico, EstadoDocumento.ACTIVO,Fecha_Modificacion);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaComprobarGetters() {
		
		Integer resultadoReal = documento.getCodigo();
		Integer resultadoEsperado = 1;
		assertEquals(resultadoEsperado, resultadoReal, 0.01);
		assertEquals(Fecha_Creacion, documento.getFechaCreacion());
		assertEquals(Documento_Publico, documento.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, documento.getEstado());
		assertEquals(Nombre_Documento, documento.getNombre());
		

	}

	@Test
	public void deberiaComprobarToString() {
		String resultadoString = "Documento [codigo=" + 1 + "]";

		assertEquals(resultadoString, documento.toString());
	}
	
	@Test
	public void deberiaComprobarDocumentoSiEsVerdadero() {
		
		assertTrue(documento.equals( new Documento(1, Nombre_Documento, Fecha_Creacion, Documento_Publico, EstadoDocumento.ACTIVO,Fecha_Modificacion)));
	}
	@Test
	public void deberiaComprobarDocumentoNoEsVerdadero() {
		
		assertFalse(documento.equals( new Documento(2, Nombre_Documento, Fecha_Creacion, Documento_Publico, EstadoDocumento.ACTIVO,Fecha_Modificacion)));
	}
	@Test
	public void deberiaComprobarQueNoEsUnDocumento() {
		
		assertFalse(documento.equals("Comprobacion"));
	}
	
	@Test
	public void deberiaComprobarHasCode() {
		
		assertEquals(documento.getCodigo().hashCode(),documento.hashCode());
	}
	@Test
	public void comprobarToString() {
		assertNotNull(documento.toString());
	}
	

}
