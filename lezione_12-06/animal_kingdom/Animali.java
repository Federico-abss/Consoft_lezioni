package animal_kingdom;

public class Animali extends EssereVivente {
	public enum sesso{MASCHIO, FEMMINA}
	sesso s;

	public sesso getS() {
		return s;
	}

	public void setS(sesso s) {
		this.s = s;
	}
	
	public Animali() {
		super();
		this.s = s.MASCHIO;
	}
	
	public Animali(int eta, sesso s) {
		super(eta);
		this.s = s;
	}
	
	@Override
	public int calcolaEta() {
		return super.calcolaEta()*2;
	}
}

