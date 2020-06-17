package module;

public class Furgone extends Veicolo {
	int capacitaCarico;

	public int getCapacitaCarico() {
		return capacitaCarico;
	}

	public void setCapacitaCarico(int capacitaCarico) {
		this.capacitaCarico = capacitaCarico;
	}
	
	public String toString() {
		String stringa = "Furgone marca " + marca + " con cilindrata " + cilindrata + ", " + capacitaCarico 
				+ " litri di capacita, " + "alimentazione " + alimentazione + " immatricolata nel " + annoImmatricolazione;
		return stringa;
	}
}
