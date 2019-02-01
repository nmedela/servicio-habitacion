package com.habitacion.json;

import java.io.IOException;

public class Luz {
	

		Integer id;
		Integer intensidad;
		public Luz (Integer _id, Integer _intensidad){
			this.id = _id;
			this.intensidad = _intensidad;
		}
		
		public Integer getId() {
			return this.id;
		}
		public Integer getIntensidad(){
			return this.intensidad;
		}
		
		public void run() throws Exception {
			Runtime.getRuntime().exec("sudo python2.7 /usr/lib/python2.7/dist-packages/RPi/ejecutarLuz.py " + this.id + " " + this.intensidad );
		}

}
