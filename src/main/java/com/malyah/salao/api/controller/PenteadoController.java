package com.malyah.salao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malyah.salao.domain.model.Penteado;
import com.malyah.salao.domain.service.PenteadoService;

@RestController
@RequestMapping("/penteados")
public class PenteadoController {
	
	@Autowired
	private PenteadoService penteadoService;

	@GetMapping
	public List<Penteado> listar(){
		return penteadoService.listar();
	}
	
	@GetMapping("/{penteadoId}")
	public Penteado buscar(@PathVariable Long penteadoId) {
		return penteadoService.buscar(penteadoId);
	}
	
	@PostMapping
	public Penteado salvar(@RequestBody Penteado penteado) {
		return penteadoService.salvar(penteado);
	}
	
	@DeleteMapping("/{penteadoId}")
	public void remover(@PathVariable Long penteadoId) {
		penteadoService.remover(penteadoId);
	}
	
	public Penteado atualizar(@PathVariable Long penteadoId, @RequestBody Penteado penteado) {
		return penteadoService.atualizar(penteadoId, penteado);
	}
}
