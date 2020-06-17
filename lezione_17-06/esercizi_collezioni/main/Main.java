package main;
import java.util.ArrayList;

import esercizio1.*;
import esercizio2.*;
//import esercizio3.*;
//import esercizio4.*;

public class Main {

	public static void main(String[] args) {
		// esercizio 1
		Rubrica rub = new Rubrica();
		Contatto f = new Contatto("Fede", "Mannu", "420");
		Contatto g = new Contatto("Gio", "Pasto", "69");
		Contatto m = new Contatto("Marco", "Cobu", "42");
		rub.aggiungiContatto(f);
		rub.aggiungiContatto(f);
		rub.rimuoviContatto("Fede", "Mannu");
		rub.aggiungiContatto(m);
		rub.aggiungiContatto(g);
		
		System.out.println(rub.toString());
		
		// esercizio 2		
		Catalogo<Articolo> catalogo = new Catalogo<Articolo>();
		Articolo a = new Articolo("Mannu", 420);
		Articolo b = new Articolo("Pasto", 69);
		Articolo c = new Articolo("Cobu", 42);
		
		catalogo.aggiungiArticolo(a);
		catalogo.aggiungiArticolo(b);
		catalogo.aggiungiArticolo(c);
		ArrayList<Articolo> list = catalogo.getArticoliSottoPrezzo(70);
		
		for (Articolo l:list) {
			System.out.println(l.toString());
		}
		System.out.println();
		
		System.out.println(catalogo.toString());
	}

}
