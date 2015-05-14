package controllers;

import java.util.ArrayList;
import java.util.List;

import flexjson.JSONSerializer;
import models.Aluno;
import play.mvc.*;
import util.JsonSerializerUtil;

public class AlunoController extends Controller {
	public static JSONSerializer serializerAlunoMatriculas = JsonSerializerUtil
			.createSerializer("numeroDeMatricula", "nome", "email",
					"matriculas.disciplina.codigo",
					"matriculas.disciplina.nome", "matriculas.notaFinal");
	
	public static JSONSerializer serializerAlunoEmailSenha = JsonSerializerUtil
			.createSerializer("email", "senha");
	
	public static void index() {
		render();
	}

	public static void listAll() {
		List<Aluno> alunos = Aluno.findAll();
		renderJSON(serializerAlunoMatriculas.serialize(alunos));
	}

	public static void listarEmailSenha() {
		List<Aluno> alunos = Aluno.buscarEmailSenha();
		renderJSON(JsonSerializerUtil.serialize(alunos, "email", "senha"));
	}

	public static void buscarPorNome(String nome) {
		List<Aluno> alunos = Aluno.buscarPorNome(nome);
		renderJSON(serializerAlunoMatriculas.serialize(alunos));
	}
}
