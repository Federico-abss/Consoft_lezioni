package module;

public class Societa {
	String PIVA;
	String ragione_sociale;
	int fatture;
	
	public String getPIVA() {
		return PIVA;
	}
	public void setPIVA(String pIVA) {
		PIVA = pIVA;
	}
	public String getRagione_sociale() {
		return ragione_sociale;
	}
	public void setRagione_sociale(String ragione_sociale) {
		this.ragione_sociale = ragione_sociale;
	}
	public int getFatture() {
		return fatture;
	}
	public void setFatture(int fatture) {
		this.fatture = fatture;
	}
	
	public Societa (String PIVA, String ragione_sociale, int fatture) {
		this.PIVA = PIVA;
		this.ragione_sociale = ragione_sociale;
		this.fatture = fatture;
	}
}
