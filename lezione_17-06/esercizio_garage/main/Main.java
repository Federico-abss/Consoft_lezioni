package main;
import module.*;

public class Main {

	public static void main(String[] args) {
		Veicolo[] num = new Veicolo[3];
		
		for (Veicolo i:num) {
			System.out.println(i == null);
		}
		
		Garage garage = new Garage();
		Automobile A = new Automobile();
		Moto M = new Moto();
		garage.immettiVeicolo(A);
		garage.immettiVeicolo(M);
		garage.stampaPosti();
	}

}
