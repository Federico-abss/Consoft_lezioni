package library;

import java.sql.Date;

public class Persona {
	
	private int id;
	private String cognome;
	private String nome;
	private Date dataNascita;	
	
	
	public Persona() {}
	
	public Persona(int id, String cognome, String nome, Date dataNascita) {
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String toString() {
		return cognome  + " " + nome;
	}
	
}
