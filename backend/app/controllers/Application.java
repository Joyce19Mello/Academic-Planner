package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {

//        Professor professor = new Professor();
//        professor.nome = "Rafael";
//        professor.email = "rafael@rafael";
//        professor.informacoesProfissionais = "Professor de WEB";
//        professor.sala = "32A";
//        professor.senha = "123";
//        professor.telefone = "31 99899-9899";
//
//        professor.save();

        Professor p = Professor.findById(1);
        renderJSON(p);
    }

}