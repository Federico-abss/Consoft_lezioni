package module;

public class Automobile extends Veicolo {
	int numPorte;

	public int getNumPorte() {
		return numPorte;
	}

	public void setNumPorte(int numPorte) {
		this.numPorte = numPorte;
	}
	
	public String toString() {
		String stringa = "Automobile marca " + marca + " con cilindrata " + cilindrata + ", " + numPorte 
				+ " porte, " + "alimentazione " + alimentazione + " immatricolata nel " + annoImmatricolazione;
		return stringa;
	}
}
