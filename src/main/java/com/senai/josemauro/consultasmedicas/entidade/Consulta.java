package com.senai.josemauro.consultasmedicas.entidade;


import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dataConsulta", length = 100)
    private String dataConsulta;

    @Column(name = "horarioConsulta", length = 100)
    private String horarioConsulta;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "medicos[id]")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "pacientes[id]")
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(Integer id, String dataConsulta, String horarioConsulta, StatusConsulta status, Medico medico, Paciente paciente) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.status = status;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
