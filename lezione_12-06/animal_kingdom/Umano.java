package animal_kingdom;

public class Umano extends Animali {
	String nome;
	String cognome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public Umano() {
		super();
		nome = "John";
		cognome = "Doe";
	}
	
	public Umano(int age, sesso s, String nome, String cognome) {
		super(age, s);
		this.nome = nome;
		this.cognome = cognome;
	}
}
