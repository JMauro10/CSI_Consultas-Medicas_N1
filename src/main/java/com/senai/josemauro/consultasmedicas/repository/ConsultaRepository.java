package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.entidade.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    boolean existsByPacienteIdAndHorarioConsultaAndDataConsulta(Integer id, String horarioConsulta, String dataConsulta);


    @Query("select con from Consulta con where con.paciente.nome like concat('%',:nome, '%') ")
    List<Consulta> buscaConsultaPaciente(@Param("nome") String nome);

    @Query("select c from Consulta c where c.paciente.id = :id and c.horarioConsulta = :horarioConsulta and c.dataConsulta = :dataConsulta")
    List<Consulta> findByPacienteAndHorario(@Param("id") Integer id, @Param("horarioConsulta") String horarioConsulta, @Param("dataConsulta") String dataConsulta);

}
