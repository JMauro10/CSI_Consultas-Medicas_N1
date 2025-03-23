package com.senai.josemauro.consultasmedicas.repository;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.entidade.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    //List<Paciente> findByPacienteCPF(String CPF);

    //List<Paciente> findByNomePaciente(String nome);


    @Query("select pa from Paciente pa where pa.CPF like concat('%',:CPF, '%') ")
    List<Paciente> findByPacienteCPF(@Param("CPF") String CPF);

    @Query("select pa from Paciente pa where pa.nome like concat('%',:nome, '%') ")
    List<Paciente> findByNomePaciente(@Param("nome") String nome);

}
