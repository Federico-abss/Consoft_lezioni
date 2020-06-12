package animal_kingdom;

public class Rettili extends Animali {
	int zampe;
	
	public Rettili(int zampe, sesso s) {
		super(s);
		this.zampe = zampe;
	}

	public Rettili() {
		super();
		zampe = 4;
	}
}
