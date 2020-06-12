package module;

public class Dipendente extends Cliente {
	public Dipendente(String nome,	String cognome,	String cf) {
		super(nome, cognome, cf);
	}
	
	public double calcoloQuota(Commercialista c) {
		return super.calcoloQuota(c);
	}
}
