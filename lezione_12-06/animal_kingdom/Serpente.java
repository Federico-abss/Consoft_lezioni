package animal_kingdom;

public class Serpente extends Rettili {
	private int zampe;
	private boolean velenoso;

	public boolean isVelenoso() {
		return velenoso;
	}

	public void setVelenoso(boolean velenoso) {
		this.velenoso = velenoso;
	}
	
	public Serpente(boolean velenoso) {
		super();
		this.zampe = 0;
		this.velenoso = velenoso;
	}
}
