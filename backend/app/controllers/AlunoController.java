package controllers;

import models.Aluno;
import models.Professor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoController extends DefaultController{

    public static void list(Integer id){
        List<Aluno> alunos = new ArrayList<>();

        alunos = Aluno.find("id_professor = :id_professor")
                .setParameter("id_professor", id)
                .fetch();

        Collections.reverse(alunos);

        renderJSON(alunos);
    }

    public static void save(Aluno aluno) {

        if(aluno == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        aluno.professor = Professor.findById(aluno.professor.id);

        aluno.save();

        renderText("Cadastro Realizado com sucesso!");
    }

}

