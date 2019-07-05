package controllers;

import models.CategoriaPublicacao;
import models.Publicacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PublicacaoController extends DefaultController{
    public static void list(Integer id){
        List<Publicacao> publicacao = new ArrayList<>();

        publicacao = Publicacao.find("id_professor = :id_professor")
                .setParameter("id_professor", id)
                .fetch();

        Collections.reverse(publicacao);

        renderJSON(publicacao);
    }

    public static void save(Publicacao publicacao) {

        if(publicacao == null || publicacao.nomeTituloPublicacao == null) {
            renderError("Erro ao Salvar!");
            return;
        }

        publicacao.categoriaPublicacao = CategoriaPublicacao.findById(publicacao.categoriaPublicacao.id);

        if(publicacao.projeto.id == null) {
            publicacao.projeto = null;
        }

        publicacao.save();

        renderText("Cadastro Realizado com sucesso!");
    }

    public static void edit(Long id, Publicacao publicacao) throws Exception{

        if(publicacao == null || publicacao.nomeTituloPublicacao == null) {
            renderText("Erro ao Editar!");
            return;
        }

        Publicacao publicacaoNoBanco = Publicacao.findById(id);

        Publicacao publicacaoSalva;
        publicacaoSalva = publicacaoNoBanco.editar(publicacao);

        if (publicacaoSalva != null) {

            renderText("Edição Realizada com sucesso!");
        } else {
            renderText("Erro ao Editar!");
        }
    }
}
