package tamabase;

import java.util.Scanner;
import it.unibs.fp.mylib.InputDati;

public class TamaMain {
	
	private final static String INSERT_NAME = "Inserire il nome del Tamagotchi: ";
	
	private final static String DAI_SODDISFAZIONE = "Inserisci il valore di soddisfazione iniziale: ";
	private final static String DAI_SAZIETA = "Inserisci il valore di sazietà iniziale: ";
	
	private final static String DAI_CAREZZE = "Quante carezze vuoi dare a %s: ";
	private final static String DAI_BISCOTTI = "Quanti biscotti vuoi dare a %s: ";
	
	
	private final static int MAX_BISCOTTI = Tamabase.MAX_BISCOTTI_PER_VOLTA;
	private final static int MAX_CAREZZE = Tamabase.MAX_CAREZZE_PER_VOLTA;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nome = "";
		int soddisfazione = 0;
		int sazieta = 0;
		int scelta = 0;
		
		Scanner sc = new Scanner(System.in);
		
		Tamabase tama;
		
		System.out.println("Benvenuto in TAMAGOTCHI™ 1.0");
	
		System.out.println("Inserisci il nome del Tamagotchi: ");
		nome = sc.next();
		System.out.println("Inserisci il livello di sazietà: ");
		sazieta = sc.nextInt();
		System.out.println("Inserisci il livello di soddisfazione: ");
		soddisfazione = sc.nextInt();
		
		
		tama = new Tamabase(nome, sazieta, soddisfazione);
		
		do {
			System.out.println(""
					+ "1. dare carezze \n"
					+ "2. dare biscotti \n"
					+ "3. stampa stato \n"
					+ "0. esci dal programma \n");
			scelta = sc.nextInt();
			
			switch(scelta) {
			
			case 1: 
				// aggiungi carezze
				int numCarezze = InputDati.leggiIntero(DAI_CAREZZE, 1, MAX_CAREZZE);
				tama.aggiungiCarezze(0);
				break;
			
			case 2:
				//aggiungi biscotti
			int numBiscotti = InputDati.leggiIntero(DAI_BISCOTTI, 1, MAX_BISCOTTI);
				tama.daiBiscotti(0);
				break;
			case 3:
				tama.stato();
				break;
			}
			
		}while (scelta != 0);
	}
	
	public static Tamabase creaTamagotchi() {
		String nome = InputDati.leggiStringaNonVuota(INSERT_NAME);
		int soddisfazione = InputDati.leggiIntero(DAI_SODDISFAZIONE, 0, Tamabase.MAX_SODDISFAZIONE);
		int sazieta = InputDati.leggiIntero(DAI_SAZIETA, 0, Tamabase.MAX_SAZIETA);
		return new Tamabase(nome, soddisfazione, sazieta);

}

}