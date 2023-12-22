package com.malyah.salao.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salao.domain.model.Cliente;
import com.malyah.salao.domain.repository.ClienteRepository;
import com.malyah.salao.domain.service.ClienteService;

@ExtendWith(MockitoExtension.class)
public class ClienteService2Test {

	
	@Mock
    private ClienteRepository clienteRepository;
	
	 @InjectMocks
	    private ClienteService clienteService;
	 
		@BeforeEach
        public void setup() {
            MockitoAnnotations.initMocks(this);
		}
            
		@Test
		void quandoListar_entaoRetornaListaClientes() {
		    List<Cliente> clientesMock = Arrays.asList(new Cliente(1, ""), new Cliente(2, "teste"));
		    when(clienteRepository.findAll()).thenReturn(clientesMock);

		    List<Cliente> resultado = clienteService.listar();

		    assertEquals(clientesMock.size(), resultado.size());
		    verify(clienteRepository, times(1)).findAll();
		}
		
		@Test
		void quandoBuscarComIdValido_entaoRetornaCliente() {
		    Cliente clienteMock = new Cliente(1, "teste");
		    when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteMock));

		    Cliente resultado = clienteService.buscar(1L);

		    assertEquals(clienteMock, resultado);
		}
		
		@Test
		void quandoBuscarComIdInvalido_entaoRetornaNull() {
		    when(clienteRepository.findById(anyLong())).thenReturn(Optional.empty());

		    Cliente resultado = clienteService.buscar(1L);

		    assertNull(resultado);
		}
		
		@Test
		void quandoSalvar_entaoRetornaClienteSalvo() {
		    Cliente clienteParaSalvar = new Cliente(1, "teste");
		    when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteParaSalvar);

		    Cliente salvo = clienteService.salvar(clienteParaSalvar);

		    assertNotNull(salvo);
		    verify(clienteRepository, times(1)).save(clienteParaSalvar);
		}
		
		@Test
		void quandoRemover_entaoRepositorioDeleta() {
		    doNothing().when(clienteRepository).deleteById(anyLong());

		    clienteService.remover(1L);

		    verify(clienteRepository, times(1)).deleteById(1L);
		}
		
		@Test
		void quandoAtualizarComIdValido_entaoRetornaClienteAtualizado() {
		    Cliente clienteOriginal = new Cliente(1, "teste");
		    Cliente clienteAtualizado = new Cliente(1, "teste2");
		    when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(clienteOriginal));
		    when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteAtualizado);

		    Cliente resultado = clienteService.atualizar(1L, clienteAtualizado);

		    assertNotNull(resultado);
		    // Verifique se os campos foram copiados corretamente...
		}

		@Test
		void quandoAtualizarComIdInvalido_entaoRetornaNull() {
		    when(clienteRepository.findById(anyLong())).thenReturn(Optional.empty());

		    Cliente resultado = clienteService.atualizar(1L, new Cliente(1, "teste"));

		    assertNull(resultado);
		}


}
