package com.malyah.salao.api.assembler.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salao.api.model.input.FuncionarioInput;
import com.malyah.salao.domain.model.Funcionario;

@Component
public class FuncionarioInputDisAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public FuncionarioInputDisAssembler() {
	}
	
		public Funcionario toDomainObject(FuncionarioInput funcionarioInput) {
			return modelMapper.map(funcionarioInput, Funcionario.class);
		}
	
		public void copyToDomainObject(FuncionarioInput funcionarioInput, Funcionario funcionario) {
		
			modelMapper.map(funcionarioInput, funcionario);
		}
	
	
}
