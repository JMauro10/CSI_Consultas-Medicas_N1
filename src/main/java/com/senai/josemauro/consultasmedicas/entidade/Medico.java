package com.senai.josemauro.consultasmedicas.entidade;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "especialidade", nullable = false, length = 100)
    private String especialidade;

    @Column(name = "crm", nullable = false, length = 6)
    private Integer crm;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Consulta> consultasMedico;

    public Medico() {
    }

    public Medico(Integer id, String nome, String especialidade, Integer crm) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }
}
