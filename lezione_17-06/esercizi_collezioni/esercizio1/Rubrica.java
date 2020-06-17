package esercizio1;

import java.util.ArrayList;

public class Rubrica {
	ArrayList<Contatto> contatti = new ArrayList<Contatto>();
	
	public void aggiungiContatto(Contatto c) {
		contatti.add(c);
	}
	
	public void rimuoviContatto(String nome, String cognome) {
		for (Contatto c:contatti) {
			if (c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
				contatti.remove(c);
				return;
			}
		}
	}
	
	public String cerca(String nome, String cognome) {
		for (Contatto c:contatti) {
			if (c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
				return c.getNumero();
			}
		}
		return null;
	}
	
	public String toString() {
		String rubrica = "";
		for (Contatto c:contatti) {
			rubrica += c.toString() + "\n";
		}
		return rubrica;
	}

}
