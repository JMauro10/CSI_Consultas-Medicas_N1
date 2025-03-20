package com.senai.josemauro.consultasmedicas.service;


import com.senai.josemauro.consultasmedicas.entidade.Paciente;
import com.senai.josemauro.consultasmedicas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    public Paciente findById( int id) {
        return pacienteRepository.findById(id).orElse(null);
    }
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }
    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    public List<Paciente> findByPacienteCPF(String CPF) {
        return pacienteRepository.findAll();
    }
    public List<Paciente> findByPacienteNome(String nome) {
        return pacienteRepository.findAll();
    }

}
