package animal_kingdom;

public class Animali extends EssereVivente {
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
	
	public Animali(sesso s) {
		super();
		this.s = s;
	}
	
	@Override
	public int calcolaEta() {
		return super.calcolaEta()*2;
	}
}

enum sesso{MASCHIO, FEMMINA}
