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

    public static void save(Projeto projeto) throws Exception {

        if(projeto == null || projeto.nomeTituloProjeto == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        Projeto projetoSalvo = projeto.salvar();

        if (projetoSalvo != null) {

            renderText("Cadastro Realizado com sucesso!");
        } else {
            renderText("Erro ao Salvar!");
        }
    }

    public static void edit(Long id, Projeto projeto) throws Exception {

        if(projeto == null || projeto.nomeTituloProjeto == null) {
            renderText("Erro ao Editar!");
            return;
        }

        Projeto projetoNoBanco = Projeto.findById(id);

        Projeto projetoSalvo = projetoNoBanco.editar(projeto);

        if (projetoSalvo != null) {

            renderText("Edição Realizada com sucesso!");
        } else {
            renderText("Erro ao Editar!");
        }
    }
}
