package controllers;

import models.Professor;
import models.Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjetoController extends DefaultController{
    public static void list(){
        List<Projeto> projetos = new ArrayList<>();

        projetos = Projeto.findAll();

        Collections.reverse(projetos);

        renderJSON(projetos);
    }

    public static void save(Projeto projeto) {

        if(projeto == null || projeto.nomeTituloProjeto == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        projeto.save();

        renderText("Cadastro Realizado com sucesso!");
    }
}
