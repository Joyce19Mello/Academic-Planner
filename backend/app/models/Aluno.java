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
    public CategoriaAluno tipoCategoriaAluno;

    @Column(name="data_inicio")
    public Date dataInicio;

    @Column(name="data_fim")
    public Date dataFim;

    @Column(name = "flg_orientacao")
    public Boolean orientacao;

    @Column(name = "arquivo_digital")
    public String arquivoDigitalAluno;

}
