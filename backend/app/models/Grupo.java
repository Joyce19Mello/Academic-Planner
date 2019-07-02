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

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName="id")
    public Professor professor;
//
//    @OneToMany
//    @JoinColumn(name = "id_professor", referencedColumnName="id")
//    public List<Professor> professores;

    @Column(name="data_inicio")
    public String dataInicio;

    public Grupo editar(Grupo grupo) throws  Exception {

        this.nomeGrupo = grupo.nomeGrupo;
        this.areaEstudo = grupo.areaEstudo;
        this.dataInicio = grupo.dataInicio;

        this.merge();

        return this.save();

    }

}
