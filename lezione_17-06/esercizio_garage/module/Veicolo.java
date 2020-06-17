package module;

public abstract class Veicolo {
	enum ALIMENTAZIONE{GAS, BENZINA, DIESEL, IBRIDA, ELETTRICA};
	int annoImmatricolazione;
	String marca;
	ALIMENTAZIONE alimentazione;
	int cilindrata;
	
	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public ALIMENTAZIONE getAlimentazione() {
		return alimentazione;
	}
	public void setAlimentazione(ALIMENTAZIONE alimentazione) {
		this.alimentazione = alimentazione;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	
	public abstract String toString();
	
}
