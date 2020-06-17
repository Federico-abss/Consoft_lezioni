package module;

public class Moto extends Veicolo {
	String tipologia;
	int numeroTempiMotore;
	
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public int getNumeroTempiMotore() {
		return numeroTempiMotore;
	}
	public void setNumeroTempiMotore(int numeroTempiMotore) {
		this.numeroTempiMotore = numeroTempiMotore;
	}
	
	public String toString() {
		String stringa = "Motocicletta marca " + marca + " con cilindrata " + cilindrata + ", " + 
				"tipologia " + tipologia + ", numero tempi motore " + numeroTempiMotore + 
				", alimentazione " + alimentazione + " immatricolata nel " + annoImmatricolazione;
		return stringa;
	}
}
