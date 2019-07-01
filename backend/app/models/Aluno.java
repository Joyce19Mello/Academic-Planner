package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Aluno extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="nome")
    public String nomeAluno;

    @Column(name="codigo")
    public String codigoDisciplina;

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

}
