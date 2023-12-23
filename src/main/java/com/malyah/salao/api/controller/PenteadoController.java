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

import com.malyah.salao.api.assembler.PenteadoModelAssembler;
import com.malyah.salao.api.assembler.disassembler.PenteadoInputDisAssembler;
import com.malyah.salao.api.model.PenteadoModel;
import com.malyah.salao.api.model.input.PenteadoInput;
import com.malyah.salao.domain.model.Penteado;
import com.malyah.salao.domain.service.PenteadoService;

@RestController
@RequestMapping("/penteados")
public class PenteadoController {
	
	@Autowired
	private PenteadoService penteadoService;

	@Autowired
	private PenteadoModelAssembler penteadoModelAssembler;
	
	@Autowired
	private PenteadoInputDisAssembler penteadoInputDisassembler;
	
	
	
	@GetMapping
	public List<PenteadoModel> listar(){
		return penteadoModelAssembler.toCollectionModel(penteadoService.listar());
	}
	
	@GetMapping("/{penteadoId}")
	public PenteadoModel buscar(@PathVariable Long penteadoId) {
		return penteadoModelAssembler.toModel(penteadoService.buscar(penteadoId));
	}
	
	@PostMapping
	public PenteadoModel salvar(@RequestBody PenteadoInput penteadoInput) {
		Penteado penteado = penteadoInputDisassembler.toDomainObject(penteadoInput);
        return penteadoModelAssembler.toModel(penteadoService.salvar(penteado));		
	}
	
	@DeleteMapping("/{penteadoId}")
	public void remover(@PathVariable Long penteadoId) {
		penteadoService.remover(penteadoId);
	}
	
	public PenteadoModel atualizar(@PathVariable Long penteadoId, @RequestBody PenteadoInput penteadoInput) {
		
		Penteado penteadoAtual = penteadoService.buscar(penteadoId);
		penteadoInputDisassembler.copyToDomainObject(penteadoInput, penteadoAtual);
		return penteadoModelAssembler.toModel(penteadoService.salvar(penteadoAtual));
	}
}
