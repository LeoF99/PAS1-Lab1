package br.ufpb.pas.pratica1;

public class Disciplina implements Comparable<Disciplina>{
	private final int id;
	private String nome;
	private Double nota;
	
	public Disciplina(int id, String nome, double nota) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getNome() {
		return this.nome;
	}
	
	public Double getNota() {
		return this.nota;
	}

	@Override
	public int compareTo(Disciplina arg0) {
		return this.getNota().compareTo(arg0.getNota());
	}
}