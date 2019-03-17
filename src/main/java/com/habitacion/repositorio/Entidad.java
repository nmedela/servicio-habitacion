package com.habitacion.repositorio;

public abstract class Entidad {
	int id;
	
	public void setId(int _id) {
		this.id=_id;
	}
	public int getId() {
		return this.id;
	}
	public void esValido() {}
}
