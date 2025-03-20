package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
