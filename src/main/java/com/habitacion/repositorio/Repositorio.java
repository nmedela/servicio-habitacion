package com.habitacion.repositorio;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.habitacion.json.Luz;

public abstract class Repositorio<T extends Entidad> {
	Set<T> contenidoRepositorio = new HashSet<T>();

	public void create(T entidad) {
//		entidad.esValido();
		entidad.setId(this.getNewId());
		this.contenidoRepositorio.add(entidad);

	}
	public Set getContenidoRepositrio() {
		return this.contenidoRepositorio;
	}
	
	public int getNewId() {
		if (this.contenidoRepositorio.size() == 0) {
			return 0;
		} else {
			return this.contenidoRepositorio.size();
		}
	}

	public Optional<T> searchById(int id) {
		return this.contenidoRepositorio.stream().filter(item -> item.id == id).findFirst();
	}

	public void update(T entidad) {
		entidad.esValido();
		this.doUpdate(entidad);
	}

	abstract public void doUpdate(T object);
}
