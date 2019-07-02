package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

@Entity
public class Aula extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="nome")
    public String nomeDisciplina;

    @Column(name="codigo")
    public String codigoDisciplina;

    @ManyToOne
    @JoinColumn(name = "id_tipo_classificacao_aula", referencedColumnName="id")
    public ClassificacaoAula classificacaoAula;

    @Column(name = "arquivo_digital")
    public String arquivoDigital;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName="id")
    public Professor professor;

    public Aula editar(Aula aula) throws  Exception {

        this.nomeDisciplina = aula.nomeDisciplina;
        this.codigoDisciplina = aula.codigoDisciplina;
        this.classificacaoAula = aula.classificacaoAula;

        this.merge();

        return this.save();

    }
}
