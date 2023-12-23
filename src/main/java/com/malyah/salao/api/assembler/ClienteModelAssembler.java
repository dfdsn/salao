package com.malyah.salao.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salao.api.model.ClienteModel;
import com.malyah.salao.domain.model.Cliente;

@Component
public class ClienteModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
		public ClienteModel toModel(Cliente cliente) {
			return modelMapper.map(cliente, ClienteModel.class);
		}
	
		public List<ClienteModel> toCollectionModel(List<Cliente> clientes) {
			return clientes.stream()
					.map(cliente -> toModel(cliente))
					.collect(Collectors.toList());
		}
}
