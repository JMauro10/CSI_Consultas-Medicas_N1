package com.senai.josemauro.consultasmedicas.controller;


import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.entidade.Medico;
import com.senai.josemauro.consultasmedicas.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> findAllMedico() {
        return medicoService.findAllMedico();
    }

    @GetMapping("/{id}")
    public Medico findMedicoById(@PathVariable int id) {
        return medicoService.findByIdMedico(id);
    }

    @GetMapping("/especialidade/{especialidade}")
    public List<Medico> findMedicoByEspecialidade(@PathVariable String especialidade) {
        return  medicoService.findByEspecialidade(especialidade);
    }

    @GetMapping("/nome/{nomeMedico}")
    public List<Medico> findMedicoByNomeMedico(@PathVariable String nomeMedico) {
        return  medicoService.findByNomeMedico(nomeMedico);
    }

    @GetMapping("/crm/{crm}")
    public List<Medico> findMedicoByCrm(@PathVariable Integer crm) {
        return  medicoService.findByCrm(crm);
    }

    @PostMapping
    public Medico saveMedico(@RequestBody Medico medico){
        return medicoService.save(medico);
    }

    @PutMapping
    public Medico updateMedico(@RequestBody Medico medico){
        return medicoService.update(medico);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable int id){
        medicoService.delete(id);
    }

}
