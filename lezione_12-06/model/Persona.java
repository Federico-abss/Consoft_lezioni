package model;

public class Persona {
	String nome;
	String cognome;
	
	public String stampa() {
		String s = nome + cognome;
		return s;
	}
	
	public Persona() {
		nome = "default";
		cognome = "default";
	}
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}
