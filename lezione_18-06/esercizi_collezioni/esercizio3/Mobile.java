package esercizio3;
import esercizio2.Articolo;

public class Mobile implements Articolo {
	String nome;
	double prezzo;
	int larghezza;
	int altezza;
	int profondita;
		
	public Mobile(String nome, double prezzo, int larghezza, int altezza, int profondita) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.profondita = profondita;
	}

	public int getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getProfondita() {
		return profondita;
	}

	public void setProfondita(int profondita) {
		this.profondita = profondita;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;		
	}

	@Override
	public double getPrezzo() {
		return prezzo;
	}

	@Override
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;		
	}
	
	@Override
	public String toString() {
		return "Articolo categoria Mobile: nome=" + nome + ", prezzo=" + prezzo;
	}
}
