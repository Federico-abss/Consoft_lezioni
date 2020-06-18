package main;
import java.util.ArrayList;
import esercizio1.*;
import esercizio2.*;
import esercizio3.*;
import esercizio4.*;

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
		
		// esercizio 3		
		Catalogo<Articolo> catalogo = new Catalogo<Articolo>();
		Mobile a = new Mobile("Mannu", 420, 5, 5, 5);
		Mobile b = new Mobile("Pasto", 69, 6, 3, 2);
		Mobile c = new Mobile("Cobu", 42, 10, 8, 5);
		
		catalogo.aggiungiArticolo(a);
		catalogo.aggiungiArticolo(b);
		catalogo.aggiungiArticolo(c);
		ArrayList<Articolo> list = catalogo.getArticoliSottoPrezzo(70);
		
		System.out.println("Articoli con prezzo minore di 70");
		for (Articolo l:list) {
			System.out.println(l.toString());
		}
		System.out.println();
		
		ArrayList<Mobile> mlist = ProvaMobile.scegliMobile(catalogo, 100, 10, 10, 10);
		
		System.out.println("Mobili con prezzo e dimensioni specificate");
		for (Articolo l:mlist) {
			System.out.println(l.toString());
		}
		System.out.println();
		
		System.out.println(catalogo.toString());
		
		// esercizio 4
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(3);		
		array.add(5);
		array.add(2);
		array.add(6);
		
		ArrayList<Integer> res = MinoriDi.minoriDi(array, 5);
		for (Integer i:res) {
			System.out.println(i);
		}
		
	}

}
