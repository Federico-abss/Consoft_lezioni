package src;

public class Primi {
	static int[] numeriPrimi = new int [0];

	public static void main(String[] args) {		
		
		for (int i = 0; i < 100; i++) {
			boolean is_prime = true;
			for (int j = 2; j <= i/2; j++) {
				if (i % j == 0) {
					is_prime = false;
					break;
				}
			}
			if (is_prime) {
				aggiungiElemento(i);
			}
		}
		
		for(int x:numeriPrimi) {
			System.out.println(x);
		}
	}
	
	static void aggiungiElemento(int nuovoElemento) {
		int[] temp = new int[numeriPrimi.length+1];
		for (int i = 0; i < numeriPrimi.length; i++) {
			temp[i] = numeriPrimi[i];
		}
		temp[temp.length-1] = nuovoElemento;
		numeriPrimi = temp;
	}

}
