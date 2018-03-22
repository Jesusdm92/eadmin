package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public abstract class ModeloBasicoAdministracionElectronica {
	
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaModificacion;
	
	
	public ModeloBasicoAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	
	
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeloBasicoAdministracionElectronica) {
			return codigo.equals(((ModeloBasicoAdministracionElectronica) obj).getCodigo());
		}
		return false;
	}

	public int hashCode() {
		return codigo.hashCode();
	}
	
	
}
