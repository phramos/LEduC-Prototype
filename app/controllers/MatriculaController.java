package controllers;

import java.util.List;

import models.Aluno;
import models.Matricula;
import play.mvc.*;
import util.JsonSerializerUtil;

public class MatriculaController extends Controller {
    public static void index() {
        render();
    }

    public static void listAll(){
    	renderJSON(JsonSerializerUtil.serialize(Matricula.findAll(), "aluno.nome", "disciplina.nome", "semestreLetivo"));
    }
    
    public static void buscarPorAluno(Long id){
    	Aluno aluno = new Aluno(id);
    	List<Matricula> matriculas = Matricula.listarPorAluno(aluno);
    	renderJSON(JsonSerializerUtil.serialize(matriculas, "aluno.nome", "disciplina.nome", "semestreLetivo", "notaFinal"));
    }
    
    public static void buscarPorAlunoSemestre(Long id, String semestre){
    	Aluno aluno = new Aluno(id);
    	List<Matricula> matriculas = Matricula.listarPorAlunoSemestre(aluno, semestre);
    	renderJSON(JsonSerializerUtil.serialize(matriculas, "aluno.nome", "disciplina.nome", "semestreLetivo", "notaFinal"));
    }
}
