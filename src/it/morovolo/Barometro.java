package it.morovolo;

/**
 * @author LucoMoro
 * @version 0.1.0    
 *  * simulazione di un barometro
 * */
public class Barometro implements BarometroInterface{
	double esponente = 0.190; // esponente 1/5.255
	double frazioneTraPressioni; // pressione attuale/pressione livello del mare
	double potenza; // potenza di a e b
	double altezza;
	double pressioneLivelloMare;//pressione al livello del mare
	double pressioneAttuale;//pressione attuale
	public Barometro(double _pressioneLivelloMare) {//questa classe associa alcuni double in modo che si possano portare in SOnda
		pressioneLivelloMare = _pressioneLivelloMare;
		new Thread() {// questo thread simula l'alzarsi del barometro e quindi l abbassarsi della pressione
			/**essendo un void non deve ritornare nessun valore */
			public void run() {
				System.out.println("Thread: " + getName() + " running");// qua ci compari� a video dicendo che il thread sta correndo
				for (int i = 1012; i>800; i--) {
					pressioneAttuale=i;// impostiamo la pressione attuale a i che � il nostro contatore
					System.out.println("altezza barometro: " + (int) getAltezza() + "m\n");//qui vedremo l'altezza attuale ogni volta che il ciclo verr� eseguito
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
					pressioneAttuale = k;// impostiamo la pressione attuale a k che � il nostro contatore
					System.out.println("altezza barometro: " + (int) getAltezza() + "m\n");//qui vedremo l'altezza attuale ogni volta che il ciclo verr� eseguito
					try {//try catch serve per passare su eventuali errori
						Thread.sleep(10);//sleep serve per il riposo
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	/**
	 * 
	 * @return altezza in metri calcolata a partire dalla pressione attuale
	 */
	public double getAltezza() {// con questo  metodo ci calcoliamo l'altezza
		frazioneTraPressioni = pressioneAttuale / pressioneLivelloMare;
		potenza = Math.pow(frazioneTraPressioni, esponente);
		altezza = (int) (44330 * (1 - potenza));
		return altezza;
	}
}