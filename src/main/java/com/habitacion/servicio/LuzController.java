package com.habitacion.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.habitacion.json.Luz;
import com.habitacion.repositorio.RepositorioLuz;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class LuzController {
//	@RequestMapping("/hello")
//	String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return "Hello" + name;
//	}

	@GetMapping("/luces/{id}")
	public ResponseEntity<?> traerLuzById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(RepositorioLuz.getInstance().searchById(id).get(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(path = "/actualizarEstadoLuz", consumes = "application/json")
	public ResponseEntity<String> actualizarLuz(@RequestBody Luz luzJson) {
		try {
			RepositorioLuz.getInstance().update(luzJson);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception error) {

			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping(path = "/luces", consumes = "application/json")
	public ResponseEntity<Object> comandoLuz(@RequestBody Luz luzJson) throws Exception {
		try {
			RepositorioLuz.getInstance().update(luzJson);
			RepositorioLuz.getInstance().searchById(luzJson.getId()).get().run();
			
//			luzJson.run();
			this.retardo();
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception error) {

			return new ResponseEntity(error.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	public void retardo() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {

		}
	}
}
