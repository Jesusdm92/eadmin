package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public abstract class ModeloBasicoAdministracionElectronica {
	
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	
	
	public ModeloBasicoAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
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
