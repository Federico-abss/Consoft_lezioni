package src;

public class Studente { 

	String nome;
	String cognome;
	String matricola;
	String data_nascita;
		
	public Studente () {
		nome = "default";
		cognome = "default";
		matricola = "default";
		data_nascita = "default";
	}
	
	public Studente (String cognome, String matricola,	String data) {
		this();
		this.cognome = cognome;
		this.matricola = matricola;
		this.data_nascita = data;
	}
	
	public Studente (String nome, String cognome, String matricola,	String data) {
		this(cognome, matricola, data);
		this.nome = nome;
	}
}
