package it.morovolo;

/**
 * @author LucoMoro
 * @version 0.1.0
 * simulazione di una sonda
 * */

public class Sonda {
	public static void main(String[] args) throws InterruptedException {
		if(!(args.length < 3)) {//verifica mancanza del primo argomento: pa livello mare
			double  percentuale=Double.parseDouble(args[2]);//altezza paracadute nuova
			double altezzaDiSganciov2 = Double.parseDouble(args[1]);//altezza sgancio nuova
			int altezzaDiSgancio;
			Barometro b = new Barometro(Double.parseDouble(args[0]));//definizione di pressioneAttuale e pressioneLivelloMare. parte il thread
			b.getAltezza();//ci stiamo passando il parametro della classe Barometro
			System.out.println("l'altezza � di " + b.getAltezza() + " m ");//facciamo comparire a video a quanti metri siamo
			/**qui andremo a capire quando la sondra dovr� sganciarsi*/
			System.out.println("la sonda si sgancer� a " + altezzaDiSganciov2);
			altezzaDiSgancio= (int) ((percentuale*altezzaDiSganciov2)/100);
			System.out.println("il paracadute si aprir� a " + altezzaDiSgancio);
			while (b.getAltezza() < altezzaDiSganciov2) {
				Thread.sleep(10);//sleep serve per il riposo
			}
			System.out.println("\nLa sonda si � sganciata all altitudine di " + altezzaDiSganciov2 + " m\n");//qui comparir� a video a quanti metri la sonda si sar� sganciata
			/**qui andremo a capire quando si apri� il paracadute*/
			while(b.getAltezza() > altezzaDiSgancio) {
				Thread.sleep(10);//sleep serve per il riposo
			}
			System.out.println("\nIl paracadute si � aperto all altitudine di " + altezzaDiSgancio + " m\n");//qui comparir� a video a quanti metri il paracadute si sar� aperto
		}
		else {System.out.println("Manca un argomento");
		}
	}
} 




