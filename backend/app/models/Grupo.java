package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Grupo extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="nome")
    public String nomeGrupo;

    @Column(name="area_estudo")
    public String areaEstudo;

    @OneToMany
    @JoinColumn(name = "id_professor", referencedColumnName="id")
    public List<Professor> professores;

    @Column(name="ano_publicacao")
    public Date anoPublicacao;

}
