package com.malyah.salao.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.malyah.salao.api.model.PenteadoModel;
import com.malyah.salao.domain.model.Penteado;

public class PenteadoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
		public PenteadoModel toModel(Penteado penteado) {
			return modelMapper.map(penteado, PenteadoModel.class);
		}
	
		public List<PenteadoModel> toCollectionModel(List<Penteado> penteados) {
			return penteados.stream()
					.map(penteado -> toModel(penteado))
					.collect(Collectors.toList());
		}
	

}
