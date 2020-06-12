package module;

public class Libero_Professionista extends Cliente {
	private String PIVA;
	private int fatture;
	
	public String getPIVA() {
		return PIVA;
	}
	public void setPIVA(String pIVA) {
		PIVA = pIVA;
	}
	public int getFatture() {
		return fatture;
	}
	public void setFatture(int fatture) {
		this.fatture = fatture;
	}
	
	public Libero_Professionista(String nome, String cognome, String CF, String PIVA, int fatture) {
		super(nome, cognome, CF);
		this.PIVA = PIVA;
		this.fatture = fatture;
	}
	
	public double calcoloQuota(Commercialista c) {
		return super.calcoloQuota(c) + c.getFattura() * fatture;
	}
}
