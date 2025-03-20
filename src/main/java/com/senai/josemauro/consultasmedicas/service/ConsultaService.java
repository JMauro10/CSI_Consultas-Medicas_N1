package com.senai.josemauro.consultasmedicas.service;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.repository.ConsultaRepository;
import com.senai.josemauro.consultasmedicas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> findAllPaciente() {
        return consultaRepository.findAll();
    }

    public Consulta findByIdPaciente(int id) {
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public Consulta savePaciente(Consulta consulta) {
        if (consulta.getMedico() == null) {
            throw new RuntimeException("Consulta não encontrada");
        }
        return consultaRepository.save(consulta);
    }

    public void deletePaciente(Integer id) {
        this.consultaRepository.deleteById(id);
    }

    public Consulta updatePaciente(Consulta consulta) {
        return consultaRepository.save(consulta);
    }


}
