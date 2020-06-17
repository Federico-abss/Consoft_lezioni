package esercizio2;

public class Articolo {
	String nome;
	double prezzo;
	
	public Articolo(String nome, double prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "Articolo: nome=" + nome + ", prezzo=" + prezzo;
	}
	
}
