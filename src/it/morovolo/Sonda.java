package it.morovolo;
/**
 * @author LucoMoro
 * @version 0.1.0
 * simulazione di una sonda
 * */

public class Sonda {
	public static void main(String[] args) throws InterruptedException {
		//int altezza = 0;
		//int i=0;
		//		int s = 0; //sgancio flag
		//		int a = 0; //apertura flag
//		int altezzaSgancio = 1000;
//		int altezzaDiAperturaParacadute = 800;
		
		int percentuale=80;//altezza paracadute nuova
		double x = Double.parseDouble(args[1]);//altezza sgancio nuova
		Barometro b = new Barometro(Double.parseDouble(args[0]));//definizione di pressioneAttuale e pressioneLivelloMare. parte il thread
		b.getAltezza();//ci stiamo passando il parametro della classe Barometro
		System.out.println("l'altezza è di " + b.getAltezza() + " m ");//facciamo comparire a video a quanti metri siamo

		/**qui andremo a capire quando la sondra dovrà sganciarsi*/
		while (b.getAltezza() < x) {

			/*if (b.pressioneAttuale > altezzaSgancio) {// if in cui, nel caso sia vera la relazione; la sonda si sgancerà
				//s = 1;// si sgancia

				break;// una volta sganciata il ciclo si ferma
			} else {

				System.out.print(".");//nel caso la relazione sia falsa compariranno a video dei .
			}*/
			Thread.sleep(10);//sleep serve per il riposo
		}
		System.out.println("\nLa sonda si è sganciata all altitudine di " + x + "m\n");//qui comparirà a video a quanti metri la sonda si sarà sganciata

		int altezzaDiSgancio= (int) ((percentuale*x)/100);
		/**qui andremo a capire quando si aprià il paracadute*/
		while(b.getAltezza() > altezzaDiSgancio) {
			/*if (b.getAltezza() < altezzaDiAperturaParacadute) {//if in cui; nel caso la relazione fosse vera, il paracadute si aprirà
				//a = 1;//apre il paracadute 

				break;// una volta aperto il ciclo si ferma
			} else {
				System.out.print(".");//nel caso la relazione sia falsa compariranno a video dei .
			}*/
			Thread.sleep(10);//sleep serve per il riposo
		}
		System.out.println("\nIl paracadute si è aperto all altitudine di " + altezzaDiSgancio + " m\n");//qui comparirà a video a quanti metri il paracadute si sarà aperto

	}
}