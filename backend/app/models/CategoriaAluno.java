package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

@Entity
public class CategoriaAluno extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="tipo_categoria_aluno")
    public String tipoCategoriaAluno;
}
