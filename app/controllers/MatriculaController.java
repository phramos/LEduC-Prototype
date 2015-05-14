package controllers;

import models.Matricula;
import play.mvc.*;

public class MatriculaController extends Controller {
    public static void index() {
        render();
    }

    public static void listAll(){
    	renderText(Matricula.findAll());
    }
}
