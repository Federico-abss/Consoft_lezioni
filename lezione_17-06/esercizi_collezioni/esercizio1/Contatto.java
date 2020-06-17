package esercizio1;

public class Contatto {
	String nome, cognome, numero;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Contatto(String nome, String cognome, String numero) {
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Contatto: nome=" + nome + ", cognome=" + cognome + ", numero=" + numero;
	}
	
	
}
