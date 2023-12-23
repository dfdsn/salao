package com.malyah.salao.api.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteModel {
	
    
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String sexo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String observacao;
    private LocalDate ultimaVisita;

}
