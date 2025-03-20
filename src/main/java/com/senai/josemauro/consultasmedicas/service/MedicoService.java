package com.senai.josemauro.consultasmedicas.service;

import com.senai.josemauro.consultasmedicas.entidade.Medico;
import com.senai.josemauro.consultasmedicas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }
    public Medico findByIdMedico(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }
    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }
    public void delete(int id) {
        medicoRepository.deleteById(id);
    }
    public Medico update(Medico medico) {
        return medicoRepository.save(medico);
    }
    public List<Medico> findByEspecialidade(String especialidade) {
        return medicoRepository.findAll();
    }
    public List<Medico> findByNomeMedico(String nomeMedico) {
        return medicoRepository.findAll();
    }
    public List<Medico> findByCrm(Integer crm) {
        return medicoRepository.findAll();
    }

}
