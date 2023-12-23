package com.malyah.salao.api.assembler.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salao.api.model.input.ClienteInput;
import com.malyah.salao.domain.model.Cliente;

@Component
public class ClienteInputDisAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
		public Cliente toDomainObject(ClienteInput clienteInput) {
			return modelMapper.map(clienteInput, Cliente.class);
		}
	
	public void copyToDomainObject(ClienteInput clienteInput, Cliente cliente) {
		modelMapper.map(clienteInput, cliente);
	}
	
	
}
