package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Disciplina extends Model {
	
	public String codigo;
    public String nome;
    public int creditos;
    
    @OneToMany(mappedBy="disciplina")
    public List<Matricula> matriculas;

	public Disciplina(String codigo, String nome, int creditos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.creditos = creditos;
		this.matriculas = new ArrayList<Matricula>();
	}
    
}
