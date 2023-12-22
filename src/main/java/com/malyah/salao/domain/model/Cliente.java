package com.malyah.salao.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Cliente extends Pessoa{
	
public Cliente(long l, String string) {
		// TODO Auto-generated constructor stub
	}


	private LocalDate ultimaVisita;

}
