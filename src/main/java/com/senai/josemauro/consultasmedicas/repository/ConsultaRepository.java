package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    List<Consulta> findByNomeMedico(String nomeMedico);

    List<Consulta> findByCrm(int crm);

    List<Consulta> findByEspecialidade(String especialidade);

    List<Consulta> findByPacienteCPF(String CPF);



}
