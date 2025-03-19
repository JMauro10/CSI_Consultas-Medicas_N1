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

    @Column(name = "dataConsulta", nullable = false, length = 100)
    private Date dataConsulta;

    @Column(name = "horarioConsulta", nullable = false, length = 100)
    private Time horarioConsulta;

    @ManyToOne
    @JoinColumn(name = "medicos[id]")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "pacientes[id]")
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(Integer id, Date dataConsulta, Time horarioConsulta, Medico medico, Paciente paciente) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Time getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(Time horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
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
