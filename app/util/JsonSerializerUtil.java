package util;

import java.util.Iterator;

import flexjson.JSONSerializer;

/**
 * Classe de utilidades relacionadas ao JsonSerializer
 * 
 * @author Pedro Henrique Ramos Souza
 * @see JSONSerializer
 */
public final class JsonSerializerUtil {

	/**
	 * Construtor privado para impossibilitar a instanciação da classe
	 */
	private JsonSerializerUtil() {
		super();
	}

	/**
	 * Cria um {@link JSONSerializer} incluindo apenas o campo(s) passado(s) como parâmetro
	 * @param campos
	 *            Campo(s) que se deseja incluir no json a ser gerado pelo
	 *            serializer
	 * @return Um JsonSerializer incluindo apenas o(s) campo(s) passado(s) como parâmetro
	 */
	public static JSONSerializer createSerializer(String... campos) {
		return new JSONSerializer().include(campos).exclude("*");
	}
	
	/**Cria uma {@link String} em JSON do Objeto a ser serializado com o(s) campo(s) passado(s) como parâmetro
	 * @param o Objeto a ser serializado
	 * @param campos Campo(s) que se deseja incluir no {@link String} JSON do Objeto
	 * @return
	 */
	public static String serialize(Object o, String... campos){
		return new JSONSerializer().include(campos).exclude("*").serialize(o);
	}
}
