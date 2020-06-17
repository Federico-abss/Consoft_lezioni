package esercizio2;
import java.util.ArrayList;

public class Catalogo<E extends Articolo> {
	ArrayList<E> list = new ArrayList<E>();
	
	public void aggiungiArticolo(E art) {
		list.add(art);
	}
	
	public ArrayList<E> getArticoliSottoPrezzo(double prezzo) {
		ArrayList<E> sottoPrezzo = new ArrayList<E>();
		for (E a:list) {
			if (a.getPrezzo() <= prezzo) {
				sottoPrezzo.add(a);
			}
		}
		return sottoPrezzo;
	}
	
	public String toString() {
		String catalogo = "";
		for (E a:list) {
			catalogo += a.toString() + "\n";
		}
		return catalogo;
	}

}
