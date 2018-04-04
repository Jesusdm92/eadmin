package es.fpdual.eadmin.repositorio.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.modelo.Documento;
import es.fpdual.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.modelo.Expediente;
import es.fpdual.eadmin.modelo.builder.ExpedienteBuilder;
import es.fpdual.eadmin.repositorio.impl.RepositorioExpedienteImpl;

public class RepositorioExpedienteImplTest {

	private RepositorioExpedienteImpl repositorio;
	private Expediente expediente;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		repositorio = new RepositorioExpedienteImpl();
		expediente = mock(Expediente.class);
		
		when(expediente.getCodigo()).thenReturn(1);
		when(expediente.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		when(expediente.getNombre()).thenReturn("nombre");
		when(expediente.getFechaArchivado()).thenReturn(new Date(1/1/2018));
		when(expediente.getFechaModificacion()).thenReturn(new Date(1/1/2018));
		when(expediente.getEstado()).thenReturn(EstadoExpediente.INICIADO);
		when(expediente.getPublico()).thenReturn(true);
		repositorio.almacenarExpediente(expediente);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void probarAltaExpediente() {
		
		assertSame(expediente, repositorio.getListaExpedientes().get(0) );
	}
	
	@Test 
	public void probarModificarExpediente() {
		
		Expediente expedienteModificado;
		expedienteModificado = new ExpedienteBuilder().clonar(expediente).conFechaModificacion(new Date(1/2/2018)).construir();
		
		repositorio.modificarExpediente(expedienteModificado);
		assertNotEquals(expediente, repositorio.getListaExpedientes().get(0));
	}
	
	@Test
	public void probarEliminarExpediente() {
		repositorio.eliminarExpediente(expediente.getCodigo());
		assertTrue(this.repositorio.getListaExpedientes().isEmpty());
	}
	
	@Test
	public void probarAsociarDocumento() {
		Documento documento = mock(Documento.class);
		when(documento.getCodigo()).thenReturn(1);
		when(repositorio.getListaExpedientes().get(0).getDocumentos()).thenReturn(new ArrayList<Documento>());
		expediente = repositorio.asociarDocumento(expediente.getCodigo(), documento);
		assertEquals(documento,repositorio.getListaExpedientes().get(0).getDocumentos().get(0));
		
	}
	
	@Test
	public void deberiaDesasociarDocumento() {
		Documento documento = mock(Documento.class);
		when(documento.getCodigo()).thenReturn(1);
		when(repositorio.getListaExpedientes().get(0).getDocumentos()).thenReturn(new ArrayList<Documento>());
		expediente = repositorio.asociarDocumento(expediente.getCodigo(), documento);
		expediente = repositorio.desasociarDocumento(expediente.getCodigo(), documento.getCodigo());
		assertTrue(repositorio.getListaExpedientes().get(0).getDocumentos().isEmpty());
	}
	
	


}
