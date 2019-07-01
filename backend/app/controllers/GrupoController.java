package controllers;

import models.Grupo;
import models.Professor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrupoController extends DefaultController{

    public static void list(Integer id){
        List<Grupo> grupos = new ArrayList<>();

        grupos = Grupo.find("id_professor = :id_professor")
                .setParameter("id_professor", id)
                .fetch();

        Collections.reverse(grupos);

        renderJSON(grupos);
    }

    public static void save(Grupo grupo) {

        if(grupo == null || grupo.nomeGrupo == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        grupo.professor = Professor.findById(grupo.professor.id);

        grupo.save();

        renderText("Cadastro Realizado com sucesso!");
    }
}
