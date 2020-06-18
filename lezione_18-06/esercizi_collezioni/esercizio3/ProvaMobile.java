package esercizio3;
import java.util.ArrayList;
import esercizio2.Articolo;
import esercizio2.Catalogo;

public class ProvaMobile {
	public static ArrayList<Mobile> scegliMobile(Catalogo<Articolo> c, double prezzo, int larghezza, int altezza, int profondita) {
		ArrayList<Mobile> listaMobili = new ArrayList<Mobile>();
		for (Articolo a:c.list) {
			if (a instanceof Mobile) {
				Mobile m = (Mobile) a;
				if (prezzo > m.getPrezzo() && larghezza > m.getLarghezza() && profondita > m.getProfondita() && altezza > m.getAltezza()) {
					listaMobili.add(m);
				}
			}
		}
		return listaMobili;
	}
}
