package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
