package com.malyah.salao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malyah.salao.domain.model.Penteado;

@Repository
public interface PenteadoRepository extends JpaRepository<Penteado, Long>{

}
