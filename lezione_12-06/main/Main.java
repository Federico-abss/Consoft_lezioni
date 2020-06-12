package main;
import model.*;
import animal_kingdom.*;
import animal_kingdom.Animali.sesso;

public class Main {

	public static void main(String[] args) {
		Studente s = new Studente();
		s.setNome("Federico");
		
		Umano Fede = new Umano();
		Umano Gio = new Umano(12, sesso.FEMMINA, "Giorgia", "Pastore");
		System.out.println(Fede.getS());
		System.out.println(Gio.getNome());
		System.out.println(Gio.calcolaEta());
		
		Serpente snake = new Serpente(true);
		if (snake.isVelenoso()) {
			System.out.println("Attenti! e' velenoso!");
		}
		else {
			System.out.println("E' un serpente innocuo");
		}
	}

}




