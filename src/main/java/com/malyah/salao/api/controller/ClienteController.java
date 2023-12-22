package com.malyah.salao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malyah.salao.domain.model.Cliente;
import com.malyah.salao.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@GetMapping("/{clienteId}")
	public Cliente buscar(@PathVariable  Long clienteId) {
		return clienteService.buscar(clienteId);
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public void remover(@PathVariable Long clienteId) {
		clienteService.remover(clienteId);
	}
	
	@PutMapping("/{clienteId}")
	public Cliente atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
		return clienteService.atualizar(clienteId, cliente);
	}
}
