package animal_kingdom;

public class Rettili extends Animali {
	int zampe;
	
	public Rettili(int eta, sesso s, int zampe) {
		super(eta, s);
		this.zampe = zampe;
	}

	public Rettili() {
		super();
		zampe = 4;
	}
}
