# MoroVolo
Il progetto **MoroVolo** nato per supportare la creazione di una sonda, ha la funzionalit� di controllare quest'ultima indicando quando essa dovr� staccarsi  e quando il paracadute dovr� scangiarsi.


# Le Classi

Le classi presenti in questo progetto sono due:
**Sonda** in cui si va a definire i comandi sopra citati;
**Barometro** simula un barometro. Attraverso un calcolo, avendo in entrata **pressione attuale** e **pressione a livello del mare** avremo come risultato l'altezza, che varier� ogni istante.


## Gli argomenti

La **pressione al livello del mare** cambier� giorno per giorno,  la **pressione attuale** dovr� essere variabile, e la **percentuale di apertura paracadute** (che ci ricaveremo dall'altezza di sgancio) dovranno essere inserite manualmente da chi andr� ad eseguire il codice. pertanto saranno 3 gli argomenti necessari per far s� che il programma parta.

## Il calcolo dell'altezza
Avendo  la **pressione al livello del mare** e  ** la pressione attuale** per ricavare l'altezza bisogner� operare una formula che prevede oltre a questi due fattori un terzo, chiamato **esponente** che equivale a 0,190 ovvero il risultato di 1/5255. L'altezza ricavata da questo calcolo sar� poi ripetuta in un ciclo per simulare il barometro che sale fino ad arrivare all'altezza di sgancio e poi scende incontrando l'altezza di apertura del paracadute.

## "Barometro b = new Barometro"
Attraverso questo comando presente nella classe **Sonda** noi andremo a portare da una classe (quale **Barometro**)  gli argomenti interessati utilizzati in quest'ultima classe ma necessari anche nella prima(ovvero **Sonda**). Gli argomenti interessati sono **pressione al livello del mare** e **pressione attuale** utili nei 2 cicli presenti nella classe.

## I cicli della classe Sonda
I due cicli presenti nella classe **Sonda** servono per far rispettivamente salire la sonda e poi farla riatterrare. il **ciclo** continuer� a girare fin quando l'altezza calcolata con il metodo **getAltezza** sar� maggiore di **altezzaDiSganciov2** (ovvero un valore massimo dato da tastiera) nel primo caso, nel secondo il ciclo continuer� a funzionare fin quando l'altezza sar� maggiore dell' **altezza di sgancio**.


## Il file MoroVolo
per creare un file bisogna cliccare su:  **file --> export --> Java --> runnable jar file -->**   e selezionare il secondo package ovvero **Package required libraries into generated JAR**.  
Per eseguirlo bisogna aprire la Console e digitare: **cd Desktop --> java -jar MoroVolo.jar**... (qui bisogna inserire il nome del programma)...  e in caso ci siano aggiungere i parametri.

d


Synchr