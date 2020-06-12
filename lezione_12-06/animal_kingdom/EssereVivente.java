package animal_kingdom;

public class EssereVivente {
	private int eta;

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int calcolaEta() {
		return eta;
	}
	
	public EssereVivente() {
		this.eta = 0;
	}
	
	public EssereVivente(int eta) {
		this.eta = eta;
	}
}
