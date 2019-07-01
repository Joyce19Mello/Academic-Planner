package controllers;

import models.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorController extends DefaultController{
    public static void list(){
        List<Professor> professores = new ArrayList<>();

        professores = Professor.findAll();

        renderJSON(professores);
    }

    public static void save(Professor professor) {

        if(professor == null || professor.nome == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        professor.save();
        renderText("Cadastro Realizado com sucesso!");
    }
}
