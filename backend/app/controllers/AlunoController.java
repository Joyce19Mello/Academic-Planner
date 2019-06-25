package controllers;

import models.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoController extends DefaultController{

    public static void list(){
        List<Aluno> aluno = new ArrayList<>();

        aluno = Aluno.findAll();

        renderJSON(aluno);
    }

    public static void save(Aluno aluno) {

        if(aluno == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        aluno.save();
        renderText("Cadastro Realizado com sucesso!");
    }

}

