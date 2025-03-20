package com.senai.josemauro.consultasmedicas.controller;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.entidade.Paciente;
import com.senai.josemauro.consultasmedicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAllPaciente(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findPacienteById(@PathVariable int id){
        return pacienteService.findById(id);
    }
    @GetMapping("/{CPF}")
    public List<Paciente> findPacienteByCPF(@PathVariable String CPF){
        return pacienteService.findByPacienteCPF(CPF);
    }
    @GetMapping("/{nome}")
    public List<Paciente> findPacienteByNome(@PathVariable String nome){
        return pacienteService.findByPacienteNome(nome);
    }

    @PostMapping
    public Paciente savePaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @PutMapping
    public Paciente updatePaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable int id){
        pacienteService.delete(id);
    }

}
