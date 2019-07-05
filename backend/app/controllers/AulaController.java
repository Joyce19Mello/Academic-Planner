package controllers;

import models.Aula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AulaController extends DefaultController {

    public static void list(Integer id){
        List<Aula> aulas = new ArrayList<>();

        aulas = Aula.find("id_professor = :id_professor")
                .setParameter("id_professor", id)
                .fetch();

        Collections.reverse(aulas);


        renderJSON(aulas);
    }

    public static void save(Aula aula) {

        if(aula == null) {
            renderText("Erro ao Salvar!");
            return;
        }

        aula.save();
        renderText("Cadastro Realizado com sucesso!");
    }

    public static void edit(Long id, Aula aula) throws Exception{

        if(aula == null || aula.nomeDisciplina == null) {
            renderText("Erro ao Editar!");
            return;
        }

        Aula aulaNoBanco = Aula.findById(id);

        Aula aulaSalva = aulaNoBanco.editar(aula);

        if (aulaSalva != null) {

            renderText("Edição Realizada com sucesso!");
        } else {
            renderText("Erro ao Editar!");
        }
    }
}
