package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.TO.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService vehiculoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> buscarTodos() {

		List<VehiculoTO> lista = this.vehiculoService.buscarTodos();

		for (VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoControllerRestful.class).consultar(v.getPlaca()))
					.withRel("vehiculos");
			v.add(myLink);

		}

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehiculo> consultar(@PathVariable String placa) {
		return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.consultar(placa));
	}

}
