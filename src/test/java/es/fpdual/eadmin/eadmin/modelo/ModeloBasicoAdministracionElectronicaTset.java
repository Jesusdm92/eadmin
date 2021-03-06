package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModeloBasicoAdministracionElectronicaTset {

	private static final Date Fecha_Creacion = new Date();
	private static final String Nombre_Documento = "Factura";
    private static final Integer CODIGO = 1; 
	
	private ModeloBasicoAdministracionElectronicaFake documento;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		documento = new ModeloBasicoAdministracionElectronicaFake(CODIGO, Nombre_Documento, Fecha_Creacion);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deberiaComprobarGetters() {

		assertEquals(Nombre_Documento, documento.getNombre());
		assertEquals(Fecha_Creacion, documento.getFechaCreacion());
		assertEquals(CODIGO, documento.getCodigo());

	}
	
	@Test
	public void deberiaComprobarDocumentoSiEsVerdadero() {
		
		assertTrue(documento.equals( new ModeloBasicoAdministracionElectronicaFake(CODIGO, Nombre_Documento, Fecha_Creacion)));
	}
	@Test
	public void deberiaComprobarDocumentoNoEsVerdadero() {
		
		assertFalse(documento.equals( new ModeloBasicoAdministracionElectronicaFake(2, Nombre_Documento, Fecha_Creacion)));
	}
}

class ModeloBasicoAdministracionElectronicaFake extends ModeloBasicoAdministracionElectronica {

	public ModeloBasicoAdministracionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion) {
		super(codigo, nombre, fechaCreacion);
		// TODO Auto-generated constructor stub
	}
	
}
