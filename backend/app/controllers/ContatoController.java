package controllers;

import models.Contato;
import models.Professor;
import java.util.List;

public class ContatoController extends DefaultController{
    public static void contact(Contato contato){

        contato.professor = Professor.findById(contato.professor.id);

        contato.save();
    }

    public static void getContatos(Integer idProfessor){
        List<Contato> contatos = Contato.find("id_professor = :id_professor")
                .setParameter("id_professor", idProfessor)
                .fetch();

        renderJSON(contatos);
    }
}
