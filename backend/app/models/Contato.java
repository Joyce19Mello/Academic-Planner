package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

@Entity
public class Contato extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "email")
    public String email;

    @Column(name = "assunto")
    public String assunto;

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName="id")
    public Professor professor;

    @Column(name = "mensagem")
    public String mensagem;

}
