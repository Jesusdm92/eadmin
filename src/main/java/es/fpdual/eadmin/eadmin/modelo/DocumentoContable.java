package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DocumentoContable extends Documento {

	private BigDecimal importe;

	private String DNI_interesado;

	public DocumentoContable(Integer codigo, String nombre, Date fecha, Boolean publico, EstadoDocumento estado,
			BigDecimal importe, String DNI_interesado) {
		super(codigo, nombre, fecha, publico, estado);
		this.importe = importe;
		this.DNI_interesado = DNI_interesado;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public String getDNI_interesado() {
		return DNI_interesado;
	}
	
	

}
