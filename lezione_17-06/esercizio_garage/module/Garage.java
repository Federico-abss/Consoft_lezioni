package module;

public class Garage {
	Veicolo[] veicoli = new Veicolo[15];
	
	public void immettiVeicolo(Veicolo o) {
		int i = 0;
		for (Veicolo v:veicoli) {
			if (v == null) {
				veicoli[i] = o;
				System.out.println("Veicolo inserito.");
				return;
			}
			i++;
		}
		System.out.println("Il garage e' pieno.");
	}
	
	public Veicolo estraiVeicolo(int i) {
		Veicolo veicolo = veicoli[i];
		veicoli[i] = null;
		return veicolo;
	}
	
	public void stampaPosti() {
		int i = 0;
		for (Veicolo v:veicoli) {
			i++;
			if (v != null) {
				System.out.println("Posizione " + i + ": " + v.toString());
			}
			else {
				System.out.println("Posizione " + i + ": Libero.");
			}
		}
	}
}
