package com.habitacion.json;

import java.io.IOException;

import com.habitacion.repositorio.Entidad;

public class Luz extends Entidad {
	

//		Integer id;
		Integer intensidad;
		public Luz () {};
		public Luz (Integer _id, Integer _intensidad){
			
			this.setId(_id);
			this.intensidad = _intensidad;
		}
		public void setIntensidad(Integer _intensidad) {
			this.intensidad= _intensidad;
		}
		public Integer getIntensidad(){
			return this.intensidad;
		}
		
		public void run() throws Exception {
			Runtime.getRuntime().exec("sudo python2.7 /usr/lib/python2.7/dist-packages/RPi/ejecutarLuz.py " + this.getId() + " " + this.intensidad );
		}

}
