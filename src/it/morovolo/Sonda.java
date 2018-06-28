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
  double x = Double.parseDouble(args[1]);//altezza sgancio nuova
  int altezzaDiSgancio;
  Barometro b = new Barometro(Double.parseDouble(args[0]));//definizione di pressioneAttuale e pressioneLivelloMare. parte il thread
  b.getAltezza();//ci stiamo passando il parametro della classe Barometro
  
  
  System.out.println("l'altezza è di " + b.getAltezza() + " m ");//facciamo comparire a video a quanti metri siamo

  /**qui andremo a capire quando la sondra dovrà sganciarsi*/
  System.out.println("la sonda si sgancerà a " + x);
  altezzaDiSgancio= (int) ((percentuale*x)/100);
  System.out.println("il paracadute si aprirà a " + altezzaDiSgancio);
  while (b.getAltezza() < x) {
   Thread.sleep(10);//sleep serve per il riposo
  }
  System.out.println("\nLa sonda si è sganciata all altitudine di " + x + " m\n");//qui comparirà a video a quanti metri la sonda si sarà sganciata

   
  /**qui andremo a capire quando si aprià il paracadute*/
  while(b.getAltezza() > altezzaDiSgancio) {

   Thread.sleep(10);//sleep serve per il riposo
  }
  System.out.println("\nIl paracadute si è aperto all altitudine di " + altezzaDiSgancio + " m\n");//qui comparirà a video a quanti metri il paracadute si sarà aperto

 }
 
 else {System.out.println("Manca un argomento");
 }
}
} 




