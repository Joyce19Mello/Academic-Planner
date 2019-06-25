package controllers;

import models.Aula;
import java.util.ArrayList;
import java.util.List;

public class AulaController extends DefaultController {

    public static void list(){
        List<Aula> aula = new ArrayList<>();

        aula = Aula.findAll();

        renderJSON(aula);
    }

    public static void save(Aula aula) {

        if(aula == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        aula.save();
        renderText("Cadastro Realizado com sucesso!");
    }
}
