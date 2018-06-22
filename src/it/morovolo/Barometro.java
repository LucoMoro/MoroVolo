package it.morovolo;
/**
 * @author LucoMoro
 * simulazione di un barometro
 * */
public class Barometro {
	double b = 0.190; // esponente 1/5.255
	double a; // pressione attuale/pressione livello del mare
	double c; // potenza di a e b
	double h; // altezza
	int altezza;
	double pressioneLivelloMare;//pressione al livello del mare
	double pressioneAttuale;//pressione attuale
	//private double HPA;

	public Barometro(double _pressioneLivelloMare, double _pressioneAttuale) {//questa classe associa alcuni double in modo che si possano portare in SOnda
		pressioneLivelloMare = _pressioneLivelloMare;
		pressioneAttuale = _pressioneAttuale;
		new Thread() {// questo thread simula l'alzarsi del barometro e quindi l abbassarsi della pressione
			/**essendo un void non deve ritornare nessun valore */
			public void run() {
				System.out.println("Thread: " + getName() + " running");// qua ci comparià a video dicendo che il thread sta correndo
				for (int i = 1012; i>800; i--) {
					 pressioneAttuale=i;// impostiamo la pressione attuale a i che è il nostro contatore
					System.out.println("altezza barometro: " + (int) getAltezza() + "m\n");//qui vedremo l'altezza attuale ogni volta che il ciclo verrà eseguito
						 	
							
					try {//try catch serve per passare su eventuali errori
						Thread.sleep(10);//sleep serve per il riposo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("*********************\n");//3 output per dividere in videata i due cicli
				System.out.println("*********************\n");
				System.out.println("*********************\n");
				for (int k = 800; k < 1012; k++) {// il barometro si sta abbassando di quota quindi la pressione aumenta
					pressioneAttuale = k;// impostiamo la pressione attuale a k che è il nostro contatore
					System.out.println("altezza barometro: " + (int) getAltezza() + "m\n");//qui vedremo l'altezza attuale ogni volta che il ciclo verrà eseguito
					try {//try catch serve per passare su eventuali errori
						Thread.sleep(10);//sleep serve per il riposo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public double GetHPA() {
		return 0;
	}

//	public void setHPA(double d) {
//		HPA = d;
//	}

	/**
	 * 
	 * @return altezza in metri calcolata a partire dalla pressione attuale
	 */
	public double getAltezza() {// con questo  metodo ci calcoliamo l'altezza
		a = pressioneAttuale / pressioneLivelloMare;
		c = Math.pow(a, b);
		h = 44330 * (1 - c);
		return h;
	}


}
