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

import com.malyah.salao.domain.model.Funcionario;
import com.malyah.salao.domain.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioService.listar();
	}
	
	@GetMapping("/{funcionarioId}")
	public Funcionario buscar(@PathVariable Long funcionarioId) {
		return funcionarioService.buscar(funcionarioId);
	}
	
	@PostMapping
	public Funcionario salvar(@RequestBody Funcionario funcionario) {
		return funcionarioService.salvar(funcionario);
	}
	
	@DeleteMapping("/{funcionarioId}")
	public void remover(@PathVariable Long funcionarioId) {
		funcionarioService.remover(funcionarioId);
	}
	
	@PutMapping("/{funcionarioId}")
	public Funcionario atualizar(@PathVariable Long funcionarioId, @RequestBody Funcionario funcionario) {
		return funcionarioService.atualizar(funcionarioId, funcionario);
	}
}
