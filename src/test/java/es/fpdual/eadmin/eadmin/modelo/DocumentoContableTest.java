package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DocumentoContableTest {

	private static final Date Fecha_Creacion = new Date();
	private static final Date Fecha_Modificacion = new Date();
	private static final String Nombre_Documento = "Factura";
	private static final boolean Documento_Publico = true;
	private static final String DNI_Interesado = "15455638Y";
	private static final BigDecimal Importe = new BigDecimal(23);
	
	private DocumentoContable documento;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		documento = new DocumentoContable(1, Nombre_Documento, Fecha_Creacion, Documento_Publico,
				EstadoDocumento.ACTIVO, Fecha_Modificacion,Importe, DNI_Interesado);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaComprobarGetters() {

		assertEquals(DNI_Interesado, documento.getDNI_interesado());
		assertEquals(Importe, documento.getImporte());


	}

}
