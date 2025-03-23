package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.entidade.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    List<Medico> findByNomeMedico(String nomeMedico);

    List<Medico> findByCrm(int crm);

    List<Medico> findByEspecialidade(String especialidade);

}
