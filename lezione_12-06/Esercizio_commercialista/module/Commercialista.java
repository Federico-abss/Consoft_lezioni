package module;

public class Commercialista {
	private String nome;
	private String cognome;
	
	private int quota = 50;
	private double fattura = 0.5;
	private int quota_imprenditore = 500;
	private int fattura_imprenditore = 1;
	
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

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public double getFattura() {
		return fattura;
	}

	public void setFattura(double fattura) {
		this.fattura = fattura;
	}

	public int getQuota_imprenditore() {
		return quota_imprenditore;
	}

	public void setQuota_imprenditore(int quota_imprenditore) {
		this.quota_imprenditore = quota_imprenditore;
	}

	public int getFattura_imprenditore() {
		return fattura_imprenditore;
	}

	public void setFattura_imprenditore(int fattura_imprenditore) {
		this.fattura_imprenditore = fattura_imprenditore;
	}
	
	public Commercialista(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
}
