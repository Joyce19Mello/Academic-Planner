package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Publicacao extends GenericModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="nome_publicacao")
    public String nomeTituloPublicacao;

    @ManyToOne
    @JoinColumn(name = "id_projeto", referencedColumnName="id")
    public Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "id_categoria_publicacao", referencedColumnName="id")
    public CategoriaPublicacao categoriaPublicacao;

    @Column(name="ano_publicacao")
    public String anoPublicacao;

    @Column(name="resumo_publicacao")
    public String resumoPublicacao;

//    @Column(name = "arquivo_digital")
//    public String arquivoDigitalBibtex;


}
