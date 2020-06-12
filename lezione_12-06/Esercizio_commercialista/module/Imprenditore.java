package module;

public class Imprenditore extends Cliente {
	Societa s;
	
	public Societa getS() {
		return s;
	}
	public void setS(Societa s) {
		this.s = s;
	}

	public Imprenditore(String nome, String cognome, String CF, Societa s) {
		super(nome, cognome, CF);
		this.s = s;
	}
	
	@Override
	public double calcoloQuota(Commercialista c) {
		double totale = c.getQuota_imprenditore();
		if (s.getFatture() > 100) {
			totale += (s.getFatture() - 100) * c.getFattura_imprenditore();
		}
		return totale; 
	}
}
