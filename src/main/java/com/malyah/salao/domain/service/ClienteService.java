package com.malyah.salao.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salao.domain.model.Cliente;
import com.malyah.salao.domain.repository.ClienteRepository;

import lombok.Data;

@Service
@Data
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void remover(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteAtual = clienteRepository.findById(id).orElse(null);

		if (clienteAtual != null) {
			BeanUtils.copyProperties(cliente, clienteAtual, "id");
			clienteAtual = clienteRepository.save(clienteAtual);
		}

		return clienteAtual;
	}
	
}
