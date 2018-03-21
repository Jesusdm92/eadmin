package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DocumentoRegistro extends Documento {

	private String codigoRegistro;
	private String DNI_interesado;

	public DocumentoRegistro(Integer codigo, String nombre, Date fecha, Boolean publico, EstadoDocumento estado,
			String codigoRegistro, String DNI_interesado) {
		super(codigo, nombre, fecha, publico, estado);
		this.codigoRegistro = codigoRegistro;
		this.DNI_interesado = DNI_interesado;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public String getDNI_interesado() {
		return DNI_interesado;
	}

}
