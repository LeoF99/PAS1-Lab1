package br.ufpb.pas.pratica1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class DisciplinasService {
	  
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private AtomicInteger counter = new AtomicInteger();
	
	//Adds a new Disciplina
	public Disciplina setNovaDisciplina(String nome, double nota) {
		Disciplina novaDisciplina = new Disciplina(counter.getAndIncrement(),nome, nota);
		this.disciplinas.add(novaDisciplina);
		return novaDisciplina;
	}
	
	//Returns all Disciplinas saved on system
	public ArrayList<Disciplina> getDisciplinas(){
		return this.disciplinas;
	}
	
	//Return Disciplina by ID
	public Disciplina getDisciplinaById(int id) {
		for (Disciplina d : this.disciplinas) {
			if(d.getId() == id) {return d;}
		}
		return null;
	}
	
	//Updates nome atribute from a Disciplina by ID
	public Disciplina updateName(int id, String newName) {
		for (Disciplina d : this.disciplinas) {
			if(d.getId() == id) {
				d.setNome(newName);
				return d;
			}
		}
		return null;
	}
	
	//Updates nota atribute from a Disciplina by ID
	public Disciplina updateNota(int id, Double newNota) {
		for (Disciplina d : this.disciplinas) {
			if(d.getId() == id) {
				d.setNota(newNota);
				return d;
			}
		}
		return null;
	}
	
	//Deletes a Disciplina from System
	public Disciplina deleteDisciplinaById(int id) {
		for (Disciplina d : this.disciplinas) {
			if(d.getId() == id) {
				Disciplina tempDisciplina = d;
				this.disciplinas.remove(d);
				return tempDisciplina;
			}
		}
		return null;
	}
	
	//Returns all Disciplinas sorted by ranking
	public ArrayList<Disciplina> getDisciplinasByRanking(){
		ArrayList<Disciplina> temp = this.disciplinas;
		Collections.sort(temp);
		return temp;
	}
}
