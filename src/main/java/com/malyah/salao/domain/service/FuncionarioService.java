package com.malyah.salao.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salao.domain.model.Funcionario;
import com.malyah.salao.domain.repository.FuncionarioRepository;

import lombok.Data;

@Service
@Data
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}
	
	public Funcionario buscar(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public void remover(Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	public Funcionario atualizar(Long id, Funcionario funcionario) {
		Funcionario funcionarioAtual = funcionarioRepository.findById(id).orElse(null);

		if (funcionarioAtual != null) {
			BeanUtils.copyProperties(funcionario, funcionarioAtual, "id");
			funcionarioAtual = funcionarioRepository.save(funcionarioAtual);
		}

		return funcionarioAtual;
	}
}
