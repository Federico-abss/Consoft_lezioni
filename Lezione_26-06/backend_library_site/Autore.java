package library;

public class Autore {

	private int id;
	private String biografia;
	private Persona persona;
	
	
	public Autore() {}
	
	public Autore(int id, String biografia, Persona persona) {
		this.id = id;
		this.biografia = biografia;
		this.persona = persona;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String toString() {
		return persona.toString();
	}
	
}