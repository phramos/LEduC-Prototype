package controllers;

import models.Disciplina;
import play.mvc.*;
import util.JsonSerializerUtil;

public class DisciplinaController extends Controller {

	public static void index() {
		render();
	}

	public static void listAll() {
		renderJSON(JsonSerializerUtil.serialize(Disciplina.findAll(), "codigo",
				"nome", "creditos", "matriculas.aluno.nome",
				"matriculas.notaFinal", "matriculas.semestreLetivo"));
	}

}
