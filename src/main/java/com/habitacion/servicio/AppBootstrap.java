package com.habitacion.servicio;

import com.habitacion.json.Luz;
import com.habitacion.repositorio.RepositorioLuz;

public class AppBootstrap {
	public static void crearContenidoInicial() {
		Luz luz0 = new Luz(0,35);
		Luz luz1 = new Luz(1,35);
		RepositorioLuz.instance.create(luz0);
		RepositorioLuz.instance.create(luz1);
}
}
