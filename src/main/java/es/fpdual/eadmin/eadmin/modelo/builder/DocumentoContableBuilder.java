package es.fpdual.eadmin.eadmin.modelo.builder;

import java.math.BigDecimal;

import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

public class DocumentoContableBuilder extends DocumentoBuilder{
	
	private BigDecimal importe;
	private String dniInteresado;
	
	@Override
	public DocumentoContable construir() {
		return new DocumentoContable(this.codigo,this.nombre, this.fechaCreacion, this.publico, this.estado, this.fechaModificacion, this.importe, this.dniInteresado);
	}

	public DocumentoContableBuilder conImporte(BigDecimal importe) {
		this.importe = importe;
		return this;
	}
	
	public DocumentoContableBuilder conDNIInteresado(String dni) {
		this.dniInteresado = dni;
		return this;
	}

	public DocumentoContableBuilder clonar(DocumentoContable documento) {
		
		super.clonar(documento);
		this.importe = documento.getImporte();
		this.dniInteresado = documento.getDNI_interesado();
		return this;
		
	}
	
}
