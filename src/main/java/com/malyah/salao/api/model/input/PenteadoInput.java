package com.malyah.salao.api.model.input;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PenteadoInput {

	
	private String nome;
	private String descricao;
	private String categoria;
	private BigDecimal preco;
	private String duracao;
	private String foto;
}
