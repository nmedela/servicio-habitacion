package com.habitacion.servicio;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.habitacion.json.Luz;
import com.habitacion.repositorio.RepositorioLuz;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicioApplicationTests {
	RepositorioLuz repoLuz;
	Luz luz1;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void initialize() {
		repoLuz = repoLuz.getInstance();
		Luz luz0 = new Luz(0,35);
		repoLuz.create(luz0);
	}

	@Test
	public void tamañoRepo() {
		assertEquals(1, repoLuz.getContenidoRepositrio().size());
	}

	@Test
	public void probarIntensidadLuz0() {
		assertEquals(10, repoLuz.searchById(0).get().getIntensidad(),0);
	}
	@Test
	public void actualizarLuz() {
		repoLuz.update(new Luz(0,20));
		assertEquals(10, repoLuz.searchById(0).get().getIntensidad(),0);
	}
	

}
