package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DocumentoRegistroTest {

	private static final Date Fecha_Creacion = new Date();
	private static final String Nombre_Documento = "Factura";
	private static final boolean Documento_Publico = true;
	private static final String DNI_Interesado = "15455638Y";
	private static final String Codigo_Registro = "2018-1";

	private DocumentoRegistro documento;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		documento = new DocumentoRegistro(1, Nombre_Documento, Fecha_Creacion, Documento_Publico,
				EstadoDocumento.ACTIVO,Codigo_Registro,DNI_Interesado);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaComprobarGetters() {

		assertEquals(DNI_Interesado, documento.getDNI_interesado());
		assertEquals(Codigo_Registro, documento.getCodigoRegistro());

	}

}
