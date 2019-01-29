package com.habitacion.servicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.habitacion.json.User;

@RestController
public class HelloWordService {
	@RequestMapping("/hello")
	String hello (@RequestParam(value="name", defaultValue ="World") String name) {
		return "Hello" + name;
	}

	
	@GetMapping("/usuario")
	public User usuario(){
		User userUsuario = new User("nico", 25);
		return (userUsuario);
	}
	
	@PostMapping(path="/libros",consumes="application/json")
    public ResponseEntity<String>  poner( @RequestBody User usuario) {
        if(usuario.getNombre().equals("nico")) {
        	System.out.println("Hasta acá llego  ");
        	return new ResponseEntity(HttpStatus.OK);	
        }else {
        	System.out.println("Hasta acá llego 2 " + usuario.getNombre());
        	return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
         
    }
	
}
