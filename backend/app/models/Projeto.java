package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Projeto extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="nome_projeto")
    public String nomeTituloProjeto;

    @OneToMany
    @JoinColumn(name = "id_aluno", referencedColumnName="id")
    public List<Aluno> alunos;

    @Column(name="data_inicio")
    public String dataInicio;

    @Column(name="data_fim")
    public String dataFim;

    @Column(name="resumo_publicacao")
    public String resumoProjeto;

    @Column(name="area_estudo")
    public String areaEstudo;

}
