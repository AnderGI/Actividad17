package org.zabalburu.modulos.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.modulos.modelo.Modulo;
import org.zabalburu.modulos.service.ModulosService;

@RestController
@RequestMapping("/modulos")
public class ModulosREST {
	@Autowired
	private ModulosService service;

	@GetMapping("")
	public List<Modulo> getModulos() {
		return service.getModulos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Modulo> getModulo(@PathVariable Integer id) {
		Modulo a = service.getModulo(id);
		if (a == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(a);
	}

	@PostMapping
	public ResponseEntity<Modulo> nuevoModulo(@RequestBody Modulo a)
			throws URISyntaxException {
		a = service.nuevoModulo(a);
		if (a == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.created(new URI("/modulos/" + a.getId())).body(a);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Modulo> eliminarModulo(@PathVariable Integer id) {
		if (!service.eliminarModulo(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Modulo> modificarModulo(@PathVariable Integer id,
			@RequestBody Modulo a) {
		a.setId(id);
		a = service.modificarModulo(a);
		if (a == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(a);
	}
}
