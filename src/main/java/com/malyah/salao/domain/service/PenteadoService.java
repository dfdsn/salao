package com.malyah.salao.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salao.domain.model.Penteado;
import com.malyah.salao.domain.repository.PenteadoRepository;

import lombok.Data;

@Service
@Data
public class PenteadoService {

	@Autowired
	private PenteadoRepository penteadoRepository;
	
	public List<Penteado> listar() {
		return penteadoRepository.findAll();
	}
	
	public Penteado buscar(Long id) {
		return penteadoRepository.findById(id).orElse(null);
	}
	
	public Penteado salvar(Penteado penteado) {
		return penteadoRepository.save(penteado);
	}
	
	public void remover(Long id) {
		penteadoRepository.deleteById(id);
	}
	
	public Penteado atualizar(Long id, Penteado penteado) {
		Penteado penteadoAtual = penteadoRepository.findById(id).orElse(null);

		if (penteadoAtual != null) {
			BeanUtils.copyProperties(penteado, penteadoAtual, "id");

			return penteadoRepository.save(penteadoAtual);
		}

		return null;
	}
}
