package es.fpdual.eadmin.modelo.builder;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;

public class DocumentoBuilderTest {
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "Factura";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final EstadoDocumento ESTADO_DOCUMENTO = EstadoDocumento.ACTIVO;
	private static final Integer CODIGO = 1;
	Documento documentoConstruido;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 documentoConstruido = new DocumentoBuilder().conCodigo(CODIGO).
				conNombre(NOMBRE_DOCUMENTO).
				conFechaCreacion(FECHA_CREACION).
				conPublico(DOCUMENTO_PUBLICO).
				conEstado(ESTADO_DOCUMENTO).
				conFechaModificacion(FECHA_MODIFICACION).
				construir();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaComprobarConstruir() {
		Documento documentoEsperado =  new Documento(CODIGO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO, ESTADO_DOCUMENTO,FECHA_MODIFICACION);
		assertEquals(documentoEsperado, documentoConstruido);
				
	}
	
	@Test
	public void deberiaComprobarClonar() {
		Documento documentoClonado = new DocumentoBuilder().clonar(documentoConstruido).construir();
		assertEquals(documentoClonado.getCodigo(),documentoConstruido.getCodigo() );
		assertEquals(documentoClonado.getNombre(), documentoConstruido.getNombre());
		assertEquals(documentoClonado.getFechaCreacion(), documentoConstruido.getFechaCreacion());
		assertEquals(documentoClonado.getPublico(), documentoConstruido.getPublico());
		assertEquals(documentoClonado.getEstado(), documentoConstruido.getEstado());
	}
	
	

}
