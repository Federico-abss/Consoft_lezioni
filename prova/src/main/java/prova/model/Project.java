package prova.model;

import java.io.Serializable;

public class Project implements Serializable {
	
	private int id;
	private String titolo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

}
