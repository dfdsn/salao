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

import com.malyah.salao.api.assembler.FuncionarioModelAssembler;
import com.malyah.salao.api.assembler.disassembler.FuncionarioInputDisAssembler;
import com.malyah.salao.api.model.FuncionarioModel;
import com.malyah.salao.api.model.input.FuncionarioInput;
import com.malyah.salao.domain.model.Funcionario;
import com.malyah.salao.domain.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private FuncionarioModelAssembler funcionarioModelAssembler;

	@Autowired
	private FuncionarioInputDisAssembler funcionarioInputDisassembler;

	@GetMapping
	public List<FuncionarioModel> listar() {

		return funcionarioModelAssembler.toCollectionModel(funcionarioService.listar());
	}

	@GetMapping("/{funcionarioId}")
	public FuncionarioModel buscar(@PathVariable Long funcionarioId) {
		return funcionarioModelAssembler.toModel(funcionarioService.buscar(funcionarioId));
	}

	@PostMapping
	public FuncionarioModel salvar(@RequestBody FuncionarioInput funcionarioInput) {
		
		Funcionario funcionario = funcionarioInputDisassembler.toDomainObject(funcionarioInput);
		
		return funcionarioModelAssembler.toModel(funcionarioService.salvar(funcionario));
	}

	@DeleteMapping("/{funcionarioId}")
	public void remover(@PathVariable Long funcionarioId) {
		funcionarioService.remover(funcionarioId);
	}

	@PutMapping("/{funcionarioId}")
	public Funcionario atualizar(@PathVariable Long funcionarioId, @RequestBody FuncionarioInput funcionarioInput ) {
		
	    Funcionario funcionarioAtual = funcionarioService.buscar(funcionarioId);
        
        funcionarioInputDisassembler.copyToDomainObject(funcionarioInput, funcionarioAtual);
        
        return funcionarioService.salvar(funcionarioAtual);
	}
}