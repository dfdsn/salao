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

import com.malyah.salao.api.assembler.ClienteModelAssembler;
import com.malyah.salao.api.assembler.disassembler.ClienteInputDisAssembler;
import com.malyah.salao.api.model.ClienteModel;
import com.malyah.salao.api.model.input.ClienteInput;
import com.malyah.salao.domain.model.Cliente;
import com.malyah.salao.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteModelAssembler clienteModelAssembler;
	
	@Autowired
	private ClienteInputDisAssembler clienteInputDisassembler;
	
	@GetMapping
	public List<ClienteModel> listar() {
		return clienteModelAssembler.toCollectionModel(clienteService.listar()); 
	}
	
	@GetMapping("/{clienteId}")
	public ClienteModel buscar(@PathVariable  Long clienteId) {

		return clienteModelAssembler.toModel(clienteService.buscar(clienteId));
	}
	
	@PostMapping
	public ClienteModel salvar(@RequestBody ClienteInput clienteInput) {

		Cliente cliente = clienteInputDisassembler.toDomainObject(clienteInput);
		
		return clienteModelAssembler.toModel(clienteService.salvar(cliente));
	}
	
	@DeleteMapping("/{clienteId}")
	public void remover(@PathVariable Long clienteId) {
		clienteService.remover(clienteId);
	}
	
	@PutMapping("/{clienteId}")
	public ClienteModel atualizar(@PathVariable Long clienteId, @RequestBody ClienteInput clienteInput) {
	
		Cliente clienteAtual = clienteService.buscar(clienteId);

		clienteInputDisassembler.copyToDomainObject(clienteInput, clienteAtual);

		return clienteModelAssembler.toModel(clienteService.salvar(clienteAtual));
	}
}
