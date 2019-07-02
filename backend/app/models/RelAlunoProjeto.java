package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

@Entity
@Table(name="rel_aluno_projeto")
public class RelAlunoProjeto extends GenericModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    public Aluno aluno;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_projeto", referencedColumnName = "id")
    public Projeto projeto;

}
