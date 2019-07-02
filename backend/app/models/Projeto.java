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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "rel_aluno_projeto",
            joinColumns = @JoinColumn(name = "id_projeto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id", updatable = false))
    public List<Aluno> alunos;


    @Column(name="data_inicio")
    public String dataInicio;

    @Column(name="data_fim")
    public String dataFim;

    @Column(name="resumo_publicacao")
    public String resumoProjeto;

    @Column(name="area_estudo")
    public String areaEstudo;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName="id")
    public Professor professor;

    public Projeto salvar() throws Exception {

        this.validateAndSave();

        return this;
    }

    public Projeto editar(Projeto projeto) throws  Exception {

        this.nomeTituloProjeto = projeto.nomeTituloProjeto;
        this.areaEstudo = projeto.areaEstudo;
        this.dataFim = projeto.dataFim;
        this.dataInicio = projeto.dataInicio;
        this.resumoProjeto = projeto.resumoProjeto;
        this.alunos = projeto.alunos;

        this.merge();

        return this.save();

    }

}
