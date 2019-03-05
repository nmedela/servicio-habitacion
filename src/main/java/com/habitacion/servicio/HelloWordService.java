package com.habitacion.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.habitacion.json.Luz;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class HelloWordService {
	@RequestMapping("/hello")
	String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello" + name;
	}

//	@GetMapping("/luces")
//	public Luz usuario(){
//		Luz userUsuario = new Luz(0, 25);
//		try {
//			
//		}catch (Exception e) {
//			return userUsuario;
//		}
//		
//		return (userUsuario);
//	}

	@PostMapping(path = "/luces", consumes = "application/json")
	public ResponseEntity<String> comandoLuz(@RequestBody Luz luzJson) {
		try {
			luzJson.run();
			this.retardo();
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception error) {

			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

	}

	public void retardo() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			
		}
	}

}
