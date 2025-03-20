package com.senai.josemauro.consultasmedicas.controller;


import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas(){
        return consultaService.findAllPaciente();
    }

    @GetMapping("/{id}")
    public Consulta getConsultaById(@PathVariable Integer id){
        return consultaService.findByIdPaciente(id);
    }

    @PostMapping
    public Consulta saveConsulta(Consulta consulta){
        return consultaService.savePaciente(consulta);
    }

    @PutMapping
    public Consulta updateConsulta(Consulta consulta){
        return consultaService.savePaciente(consulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable Integer id){
        consultaService.deletePaciente(id);
    }
}
