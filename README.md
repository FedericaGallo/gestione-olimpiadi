#Gestionale Olimpiadi
Si vuole creare un database in grado di tenere traccia degli sport che si giocano alle olimpiadi e agli atleti che partecipano in tale olimpiade. Realizzare:
1.	 lo schema E-R;
2.	lo schema logico;
3.	i comandi di DDL in grado di creare il database degli sport olimpici e le tabelle previste dal modello logico;
4.	i comandi di DML in grado di inserire  almeno cinque righe in ogni tabella;
5.	le query in grado di mostrare: 
* l'elenco degli sport di squadra (sono gli sport in cui possono giocare almeno due giocatori);
*	l'elenco degli atleti che giocano a  tennis nati a partire dagli anni 2000;
*	per ogni sport indicare il numero di atleti che  praticano tale sport;
*	indicare i nomi degli sport  che hanno almeno  2 atleti che lo praticano;
*	indicare i nomi  degli atleti  che sono più alti della media.

## Entity
### Sport
* nome
* numero giocatori
* id
### Atleta
* nome
* cognome
* data di nascita
* altezza
* nazionalità
* id
### Olimpiade
* anno
* paese ospitante
* id
### Gara (olimpiade_sport)
* id_olimpiadi
* id_sport
* id
### Partecipazione (olimpiade_sport_atleta)
* id_olimpiadi_sport
* id_atleta
* risultato
* id
