package main;

import module.*;

public class Main {

	public static void main(String[] args) {
		Societa striscia =new Societa("SLN", "ragione sociale", 317);
		Imprenditore i =  new Imprenditore("Ezio", "Greggio", "GGEZ", striscia);
		Dipendente d = new Dipendente("Jerry", "Scotty", "SCJR");
		Libero_Professionista l = new Libero_Professionista("Mike", "Buongiorno", "BGMK", "PIVA", 98);
		
		Commercialista commercialista = new Commercialista("Sylvester", "Stallone");
		
		Cliente[] clienti = new Cliente[3];
		clienti[0] = i;
		clienti[1] = l;
		clienti[2] = d;
		
		double incassi = 0;
		for (Cliente x:clienti) {
			incassi += x.calcoloQuota(commercialista);
		}
		
		System.out.println(commercialista.getNome() + " " + commercialista.getCognome() + " ha incassato:");
		System.out.println(incassi);
	}

}
