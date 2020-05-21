package tamabase;


import java.util.Scanner;

public class Tamabase {
	
	
	static final int SOGLIA_MIN_SAZIETA = 30;
	static final int SOGLIA_MIN_SODDISF = 30;
	static final int SOGLIA_MAX_SAZIETA = 80;
	static final int SOGLIA_MAX_SODDISF = 80;
	static final int MAX_BISCOTTI_PER_VOLTA = 20;
	static final int MAX_CAREZZE_PER_VOLTA = 20;
	static final int MAX_SODDISFAZIONE = 100;
	static final int MAX_SAZIETA = 100;
	static final int RIDUX = 5;
	
	private String nome;
	private int soddisfazione;
	private int sazieta;
	
	Scanner sc = new Scanner(System.in);
	
	public Tamabase (String _nome, int _soddisfazione, int _sazieta) {
		this.nome = _nome;
		this.soddisfazione = _soddisfazione;
		this.sazieta = _sazieta;
		
	}
	
	public boolean isInfelice () {
		boolean isInfelice = false;
		if (this.soddisfazione < SOGLIA_MIN_SODDISF || this.sazieta < SOGLIA_MIN_SAZIETA )
			isInfelice = true;
		return isInfelice;		
	}
	
	public boolean isFelice () {
		boolean isFelice = true;
		if (this.soddisfazione < SOGLIA_MAX_SODDISF && this.sazieta < SOGLIA_MAX_SAZIETA )
			isFelice = false;
		return isFelice;		
	}
	
	public void aggiungiCarezze(int carezze) {
		System.out.println("Quante carezze vuoi aggiungere? (max 20)"); 
		 carezze = sc.nextInt();
		 
		do {
			this.soddisfazione += carezze;
			this.sazieta -= (carezze * RIDUX);
		}while (carezze <- MAX_CAREZZE_PER_VOLTA);
		System.out.println("Soddisfazione: " + soddisfazione);
		System.out.println("Sazietà: " + sazieta);
		
	}
	
	public void daiBiscotti(int biscotti) {
		System.out.println("Quanti biscotti vuoi dare? (max 20)"); 
		 biscotti = sc.nextInt();
		do {
			this.soddisfazione -= (biscotti * RIDUX);
			this.sazieta += biscotti;
		}while (biscotti <- MAX_BISCOTTI_PER_VOLTA);
		System.out.println("Sazietà: " + sazieta);
		System.out.println("Soddisfazione: " + soddisfazione);
	}
	public void stato() {
		if(isInfelice()) {
			System.out.println("Sono triste");
		}
		if(isFelice()) {
			System.out.println("Sono felice");
		}
	}
	
}
