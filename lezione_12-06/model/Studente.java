package model;

public class Studente extends Persona {
	private String matricola;
	private String data_nascita;
	
	// getters
	
	public String getMatricola() {
		return matricola;
	}
	
	public String getData() {
		return data_nascita;
	}
	
	// setters
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public void setData(String data) {
		this.data_nascita = data;
	}
	
	// constructors
	
	public Studente () {
		super();
		matricola = "default";
		data_nascita = "default";
	}
	
	public Studente (String cognome, String matricola,	String data) {
		super();
		this.cognome = cognome;
		this.matricola = matricola;
		this.data_nascita = data;
	}
	
	public Studente (String nome, String cognome, String matricola,	String data) {
		this(cognome, matricola, data);
		this.nome = nome;
	}
	
	@Override
	public String stampa( ) {
		String s = super.stampa() + matricola + data_nascita;
		return s;
	}
}
