package com.malyah.salao.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salao.api.model.FuncionarioModel;
import com.malyah.salao.domain.model.Funcionario;

@Component
public class FuncionarioModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	 public FuncionarioModel toModel(Funcionario funcionario) {
	 	return modelMapper.map(funcionario, FuncionarioModel.class);
	 }
	
	 public List<FuncionarioModel> toCollectionModel(List<Funcionario> funcionarios) {
	 	return funcionarios.stream()
	 			.map(funcionario -> toModel(funcionario))
	 			.collect(Collectors.toList());
	 }
	
}
