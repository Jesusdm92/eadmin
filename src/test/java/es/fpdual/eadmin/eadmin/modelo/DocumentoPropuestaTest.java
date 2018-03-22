package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DocumentoPropuestaTest {

	private static final Date Fecha_Creacion = new Date();
	private static final String Nombre_Documento = "Factura";
	private static final Date Fecha_Modificacion = new Date();
	private static final boolean Documento_Publico = true;
	private static final Integer CODIGO_PROPUESTA = 1;
	private static final Integer EJERCICIO = 2018;
	private static final String GRUPO_POLITICO= "PSOE";

	private DocumentoPropuesta documento;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		documento = new DocumentoPropuesta(1, Nombre_Documento, Fecha_Creacion, Documento_Publico,
				EstadoDocumento.ACTIVO,Fecha_Modificacion,CODIGO_PROPUESTA, EJERCICIO, GRUPO_POLITICO);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaComprobarGetters() {

		assertEquals(CODIGO_PROPUESTA, documento.getCodigoDocumentoPropuesta());
		assertEquals(EJERCICIO, documento.getEjercicio());
		assertEquals(GRUPO_POLITICO, documento.getGrupoPolitico());

	}

}
