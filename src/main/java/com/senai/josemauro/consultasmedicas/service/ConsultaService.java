package com.senai.josemauro.consultasmedicas.service;

import com.senai.josemauro.consultasmedicas.entidade.Consulta;
import com.senai.josemauro.consultasmedicas.entidade.Medico;
import com.senai.josemauro.consultasmedicas.entidade.Paciente;
import com.senai.josemauro.consultasmedicas.entidade.StatusConsulta;
import com.senai.josemauro.consultasmedicas.repository.ConsultaRepository;
import com.senai.josemauro.consultasmedicas.repository.MedicoRepository;
import com.senai.josemauro.consultasmedicas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public List<Consulta> findAllPaciente() {
        return consultaRepository.findAll();
    }

    public Consulta findByIdPaciente(int id) {
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public List<Consulta> consultasPaciente(String nome){
        return consultaRepository.buscaConsultaPaciente(nome);
    }


    public Consulta salvarConsulta(Consulta consulta) {
        boolean consultaExiste = consultaRepository.existsByPacienteIdAndHorarioConsultaAndDataConsulta(
                consulta.getPaciente().getId(),
                consulta.getHorarioConsulta(),
                consulta.getDataConsulta()
        );
        if (consultaExiste) {
            throw new RuntimeException("Paciente com consulta nesse dia e horário");
        }

        consulta.getPaciente().getConsultas().add(consulta);
        consulta.getMedico().getConsultas().add(consulta);
        consulta.setStatus(StatusConsulta.AGENDADA);

        return consultaRepository.save(consulta);
    }


    public void delete(Integer id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.getPaciente().getConsultas().remove(consulta);
        pacienteRepository.save(consulta.getPaciente());

        consulta.getMedico().getConsultas().remove(consulta);
        medicoRepository.save(consulta.getMedico());

        if (consulta.getStatus() == StatusConsulta.REALIZADA) {
            throw new RuntimeException("Consulta ja realizada");
        }
        consulta.setStatus(StatusConsulta.CANCELADA);
        consultaRepository.deleteById(id);
    }


    public Consulta atualizarConsulta(Consulta consulta) {
        Consulta consultaAntiga = consultaRepository.findById(consulta.getId())
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consultaAntiga.getPaciente().getConsultas().remove(consultaAntiga);
        pacienteRepository.save(consultaAntiga.getPaciente());

        consultaAntiga.getMedico().getConsultas().remove(consultaAntiga);
        medicoRepository.save(consultaAntiga.getMedico());

        if (consulta.getStatus() == StatusConsulta.CANCELADA) {
            throw new RuntimeException("Não é possível atualizar uma consulta cancelada.");
        }

        if (LocalDate.parse(consulta.getDataConsulta()).isAfter(LocalDate.now()) ||
                (LocalDate.parse(consulta.getDataConsulta()).isEqual(LocalDate.now()) &&
                        LocalTime.parse(consulta.getHorarioConsulta()).isAfter(LocalTime.now()))) {
            throw new RuntimeException("Não é possível atualizar uma consulta antes do horário.");
        }
        consulta.setStatus(StatusConsulta.REALIZADA);

        return consultaRepository.save(consulta);
    }

}
