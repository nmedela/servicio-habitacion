package com.habitacion.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicioApplication {

	public static void main(String[] args) {
		AppBootstrap.crearContenidoInicial();
		SpringApplication.run(ServicioApplication.class, args);
	}

}

