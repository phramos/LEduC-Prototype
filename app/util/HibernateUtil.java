package util;

import org.hibernate.Criteria;
import org.hibernate.Session;

import play.db.jpa.JPA;

/**
 * Classe de utilidades relacionadas ao Hibernate
 * 
 * @author Pedro Henrique Ramos Souza
 * @see Criteria
 */
public final class HibernateUtil {

	/**
	 * Construtor privado para impossibilitar a instanciação da classe
	 */
	private HibernateUtil() {
		super();
	}

	/**
	 * Classe que cria um Criteria usando o Play Framework
	 * 
	 * @param classe
	 *            A classe para qual se deseja criar um Criteria(ex:
	 *            Usuario.class)
	 * @return Um Criteria criado com basse na classe passada como parâmetro
	 */
	public static Criteria createCriteria(Class classe) {
		Session session = (Session) JPA.em().getDelegate();
		return session.createCriteria(classe);
	}
}
