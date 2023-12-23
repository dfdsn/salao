package com.malyah.salao.api.assembler.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salao.api.model.input.PenteadoInput;
import com.malyah.salao.domain.model.Penteado;

@Component
public class PenteadoInputDisAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
		public Penteado toDomainObject(PenteadoInput penteadoInput) {
			return modelMapper.map(penteadoInput, Penteado.class);
		}
	
	public void copyToDomainObject(PenteadoInput penteadoInput, Penteado penteado) {
		modelMapper.map(penteadoInput, penteado);
	}
}
