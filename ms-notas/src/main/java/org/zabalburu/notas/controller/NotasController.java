package org.zabalburu.notas.controller;

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
import org.zabalburu.notas.modelo.Nota;
import org.zabalburu.notas.service.NotasService;

@RestController
@RequestMapping("/notas")
public class NotasController {
	@Autowired
	private NotasService service;

	@GetMapping("")
	public List<Nota> getNotas() {
		return service.getNotas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Nota> getNota(@PathVariable Integer id) {
		Nota n = service.getNota(id);
		if (n == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(n);
	}

	@PostMapping
	public ResponseEntity<?> nuevoNota(@RequestBody Nota n)
			throws URISyntaxException {
		try {
			n = service.nuevoNota(n);
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e);
		}
		return ResponseEntity.created(new URI("/modulos/" + n.getId())).body(n);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Nota> eliminarNota(@PathVariable Integer id) {
		if (!service.eliminarNota(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Nota> modificarNota(@PathVariable Integer id,
			@RequestBody Nota n) {
		n.setId(id);
		n = service.modificarNota(n);
		if (n == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(n);
	}

}
