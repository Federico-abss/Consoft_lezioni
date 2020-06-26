package library;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Libri {
	
	private int id;
	private String titolo;
	private String titoloOriginale;
	private Date dataPrimaPubblicazione;
	private String riassunto;
	private ArrayList<Autore> autoriSecondari;
	
	
	public Libri() {}
	
	public Libri(int id, String titolo, String titoloOriginale, Date dataPrimaPubblicazione, String riassunto,
			ArrayList<Autore> autoriSecondari, Autore autore) {
		this.id = id;
		this.titolo = titolo;
		this.titoloOriginale = titoloOriginale;
		this.dataPrimaPubblicazione = dataPrimaPubblicazione;
		this.riassunto = riassunto;
		this.autoriSecondari = autoriSecondari;
		this.autore = autore;
	}

	public List<Autore> getAutoriSecondari() {
		return autoriSecondari;
	}

	public void setAutoriSecondari(ArrayList<Autore> autoriSecondari) {
		this.autoriSecondari = autoriSecondari;
	}

	private Autore autore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTitoloOriginale() {
		return titoloOriginale;
	}

	public void setTitoloOriginale(String titoloOriginale) {
		this.titoloOriginale = titoloOriginale;
	}

	public Date getDataPrimaPubblicazione() {
		return dataPrimaPubblicazione;
	}

	public void setDataPrimaPubblicazione(Date dataPrimaPubblicazione) {
		this.dataPrimaPubblicazione = dataPrimaPubblicazione;
	}

	public String getRiassunto() {
		return riassunto;
	}

	public void setRiassunto(String riassunto) {
		this.riassunto = riassunto;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	public String toString() {
		return "id: " + id + ", titolo: " + titolo + ", autore: " + autore.toString() +"";
	}

}
