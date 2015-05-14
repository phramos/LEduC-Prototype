package models;

import play.*;
import play.db.jpa.*;
import util.HibernateUtil;

import javax.persistence.*;

import org.hibernate.Criteria;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.criterion.Restrictions;

import flexjson.JSONSerializer;

import java.util.*;

@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"disciplina_id", "aluno_id", "semestreLetivo"})
	)

@Entity
public class Matricula extends Model {
	@ManyToOne
	public Disciplina disciplina;
	
	@ManyToOne
	public Aluno aluno;
	
	public Integer notaFinal;
	
	public String semestreLetivo;
	
	public static List<Matricula> listarPorAluno(Aluno aluno){
		Criteria criteria = HibernateUtil.createCriteria(Matricula.class);
		criteria.add(Restrictions.eq("alunos.id", aluno.id));
		return criteria.list();
	}
}


