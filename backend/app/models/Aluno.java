package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Aluno extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="nome")
    public String nomeAluno;

    @ManyToOne
    @JoinColumn(name = "id_tipo_categoria_aluno", referencedColumnName="id")
    public CategoriaAluno categoriaAluno;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName="id")
    public Professor professor;

    @Column(name="data_inicio")
    public String dataInicio;

    @Column(name="data_fim")
    public String dataFim;

    @Column(name = "flg_orientacao")
    public Boolean orientacao;

    @Column(name = "arquivo_digital")
    public String arquivoDigitalAluno;

    public Aluno editar(Aluno aluno) throws  Exception {

        this.nomeAluno = aluno.nomeAluno;
        this.categoriaAluno = CategoriaAluno.findById(aluno.categoriaAluno.id);
        this.dataInicio = aluno.dataInicio;
        this.dataFim = aluno.dataFim;
        this.orientacao = aluno.orientacao;

        this.merge();

        return this.save();

    }

}
