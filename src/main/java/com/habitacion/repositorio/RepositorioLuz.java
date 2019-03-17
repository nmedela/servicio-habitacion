package com.habitacion.repositorio;

import java.util.Optional;

import com.habitacion.json.Luz;

public class RepositorioLuz extends Repositorio<Luz> {

	public static RepositorioLuz instance;

	public static RepositorioLuz getInstance() {
		if (instance == null) {
			instance = new RepositorioLuz();
		}

		return instance;
	}

	@Override
	public void doUpdate(Luz object) {
		Luz luz;
		Optional<Luz> oldObject = this.searchById(object.getId());
		if (oldObject.isPresent()) {
			luz = oldObject.get();
			luz.setIntensidad(object.getIntensidad());
		} else {
			new Exception("No existe el usuario que quiere actualizar");
		}

	}
	}
