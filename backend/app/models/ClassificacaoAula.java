package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

@Entity
public class ClassificacaoAula extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="tipo_classificacao_aula")
    public String tipoClassificacaoAula;

}
