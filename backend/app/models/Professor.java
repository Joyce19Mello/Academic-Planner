package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

@Entity
public class Professor extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "email")
    public String email;

    @Column(name = "sala")
    public String sala;

    @Column(name = "telefone")
    public String telefone;

    @Column(name = "senha")
    public String senha;

    @Column(name = "informacoes_profissionais")
    public String informacoesProfissionais;

}
