package controllers;

import models.CategoriaAluno;
import models.CategoriaPublicacao;
import models.ClassificacaoAula;
import models.Projeto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaController extends DefaultController{
    public static void listCategoriaPublicacao() {
        List<CategoriaPublicacao> categorias = new ArrayList<>();

        categorias = CategoriaPublicacao.findAll();

        renderJSON(categorias);
    }

    public static void listcategoriaAluno(){
        List<CategoriaAluno> categorias = new ArrayList<>();

        categorias = CategoriaAluno.findAll();

        renderJSON(categorias);
    }

    public static void listclassificacaoAula(){
        List<ClassificacaoAula> classificacoes = new ArrayList<>();

        classificacoes = ClassificacaoAula.findAll();

        renderJSON(classificacoes);
    }
}
