package com.habitacion.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	String nombre;
	Integer edad;
	public User (String _nombre, Integer _edad){
		this.nombre = _nombre;
		this.edad = _edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public Integer getEdad(){
		return this.edad;
	}
}
