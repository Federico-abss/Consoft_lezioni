package src;

public class prova {

	public static void main(String[] args) {

		COLORE c= COLORE.GIALLO;
		
		switch(c) {
		case GIALLO: 
			System.out.println("GIALLO");
			break;
		case ARANCIO: 
			System.out.println("ARANCIO");
			break;
		case ROSSO: 
			System.out.println("ROSSO");
			break;
		case VERDE: 
			System.out.println("VERDE");
			break;
		default:
			break;
		}
	}
	
	enum COLORE{GIALLO, ARANCIO, ROSSO, VERDE}
}
