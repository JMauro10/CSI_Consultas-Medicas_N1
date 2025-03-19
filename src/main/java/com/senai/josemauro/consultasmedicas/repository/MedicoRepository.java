package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
