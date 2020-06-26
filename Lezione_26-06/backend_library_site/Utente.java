package library;
import java.util.ArrayList;

public class Utente {
	
	private int id;
	private String email;
	private String passwordHash;
	private String tessera;
	private ArrayList<Ruoli> ruoli;
	private boolean attivo;
	
	private Persona persona;
	
	enum Ruoli{bibliotecario, lettore, amministratore}
	
	
	public Utente() {
		//creo una listi di ruoli vuota quando creo un Utente
		this.ruoli = new ArrayList<Ruoli>();
	}
	
	public Utente(int id, String email, String passwordHash, String tessera, ArrayList<Ruoli> ruoli, Persona persona) {
		this.id = id;
		this.email = email;
		this.passwordHash = passwordHash;
		this.tessera = tessera;
		this.ruoli = ruoli;
		this.attivo = true;
		this.persona = persona;
	}
	
	public boolean isAdmin() {
		
		for (Ruoli r:ruoli) {
			if (r.equals(Ruoli.bibliotecario) || r.equals(Ruoli.amministratore)) {
				return true;
			}
		}
			
		return false;
	}
	
	public ArrayList<Ruoli> getListRuoli() {
		return ruoli;
	}
	
	public void addRuolo(String ruolo) {
		Ruoli r = null;
		if (ruolo.equals("amministratore")) {
			r = Ruoli.amministratore;
		}
		else if (ruolo.equals("bibliotecario")) {
			r = Ruoli.bibliotecario;		
		}
		else if (ruolo.equals("lettore")) {
			r = Ruoli.lettore;
		}
		
		ruoli.add(r);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getTessera() {
		return tessera;
	}

	public void setTessera(String tessera) {
		this.tessera = tessera;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
