package models;

import play.*;
import play.db.jpa.*;
import play.mvc.Scope.Session;
import util.HibernateUtil;

import javax.persistence.*;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import flexjson.JSONSerializer;

import java.util.*;

@Entity
public class Aluno extends Model {

	public Long numeroDeMatricula;
	public String nome;
	public String senha;
	@Column(nullable = false, unique = true)
	public String email;

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	public List<Matricula> matriculas;

	public Aluno(Long matricula, String nome, String senha, String email) {
		super();
		this.numeroDeMatricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.matriculas = new ArrayList<Matricula>();
	}

	public Aluno(Long id) {
		this.id = id;
		matriculas = new ArrayList<Matricula>();
	}

	public static List<Aluno> buscarPorNome(String nome) {
		org.hibernate.Session session = (org.hibernate.Session) JPA.em()
				.getDelegate();
		Criteria criteria = session.createCriteria(Aluno.class);
		criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
		return criteria.list();
	}

	public static List<Aluno> buscarEmailSenha() {
		Criteria criteria = HibernateUtil.createCriteria(Aluno.class);
		criteria.setProjection(
				Projections.projectionList()
						.add(Projections.property("senha"), "senha")
						.add(Projections.property("email"), "email"))
				.setResultTransformer(Transformers.aliasToBean(Aluno.class));
		return criteria.list();
	}

}
