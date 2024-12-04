import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Entity.Atleta;
import Service.AtletaService;
import Entity.Olimpiade;
import Service.OlimpiadeService;
import Entity.Sport;
import Service.SportService;
import Entity.OlimpiadeSportAtleta;
import Service.OlimpiadeSportAtletaService;
import Entity.OlimpiadeSport;
import Service.OlimpiadeSportService;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        int choiceEntity;
        System.out.println("1. Per gestire gli atleti");
        System.out.println("2. Per gestire le olimpiadi");
        System.out.println("3. Per gestire le gare");
        System.out.println("4. Per gestire gli sport ");
        System.out.println("5. Per gestire le partecipazioni alle gare ");
        choiceEntity = scanner.nextInt();

        switch (choiceEntity){
            case 1:
                gestisciAtleta();
                break;
            case 2:
                gestisciOlimpiadi();
                break;
            case 3:
                gestisciGara();
                break;
            case 4:
                gestisciSport();
                break;
            case 5:
                gestisciPartecipazioneAtleta();
                break;
            default:
                System.out.println("scelta errata. scegliere un numero da 1 a 4");
        }
    }
    private static void gestisciAtleta(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe atleta");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo atleta");
            System.out.println("2. Modifica un atleta");
            System.out.println("3. Visualizza la lista degli atleti");
            System.out.println("4. Elimina un atlete");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            //System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAtleta();
                    break;
                case 2:
                    updateAtleta();
                    break;
                case 3:
                    readAtleta();
                    break;
                case 4:
                    deleteAtleta();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciOlimpiadi(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe olimpiadi");

            System.out.println("***Menu***");
            System.out.println("1. Crea una nuova edizione Olimpiadi");
            System.out.println("2. Modifica un'edizione delle Olimpiadi");
            System.out.println("3. Visualizza la lista delle edizioni delle Olimpiadi");
            System.out.println("4. Elimina un'edizione delle Olimpiadi");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            //System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createOlimpiade();
                    break;
                case 2:
                    updateOlimpiade();
                    break;
                case 3:
                    readOlimpiade();
                    break;
                case 4:
                    deleteOlimpiade();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciSport(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe sport");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo atleta");
            System.out.println("2. Modifica un atleta");
            System.out.println("3. Visualizza la lista degli atleti");
            System.out.println("4. Elimina un atlete");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            //System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createSport();
                    break;
                case 2:
                    updateSport();
                    break;
                case 3:
                    readSport();
                    break;
                case 4:
                    deleteSport();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciGara(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe OlympicsSport");

            System.out.println("***Menu***");
            System.out.println("1. Crea una nuova gara");
            System.out.println("2. Modifica una gara");
            System.out.println("3. Visualizza la lista delle gare");
            System.out.println("4. Elimina una gara");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            //System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createGara();
                    break;
                case 2:
                    updateGara();
                    break;
                case 3:
                    readGara();
                    break;
                case 4:
                    deleteGara();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciPartecipazioneAtleta(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe OlympicsSportAthlete");

            System.out.println("***Menu***");
            System.out.println("1. Crea una nuova partecipazione");
            System.out.println("2. Modifica una partecipazione");
            System.out.println("3. Visualizza la lista deglle partecipazioni alle Olimpiadi");
            System.out.println("4. Elimina una partecipazione");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            //System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createPartecipazione();
                    break;
                case 2:

                    break;
                case 3:
                    readPartecipazione();
                    break;
                case 4:
                    deletePartecipazione();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    //CRUD ATLETA
    private static void readAtleta() {
        System.out.println("ecco la lista degli atleti: ");
        AtletaService oAtletaService = new AtletaService();
        List<Atleta> listaAtleta= oAtletaService.read();

        int i = 0;
        while(i<listaAtleta.size()){
            System.out.println(listaAtleta.get(i).getId()+". "+listaAtleta.get(i).getCognome()+" "+listaAtleta.get(i).getNome()+" "+listaAtleta.get(i).getNazionalità()+" "+listaAtleta.get(i).getAltezza());
            i++;}

    }
    private static void createAtleta () {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.nextLine();
        System.out.println("inserisci nazionalità: ");
        String nazionalità = scanner.next();
        System.out.println("inserisci altezza: ");
        int altezza = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Inserisci la data di nascita nel formato YYYY-MM-DD: ");
        String dataNascita = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascitaFormatted = LocalDate.parse(dataNascita, formatter);
        AtletaService oAtletaService = new AtletaService();
        oAtletaService.create(nome, cognome, altezza, dataNascitaFormatted, nazionalità);

    }
    private static void deleteAtleta () {
        readAtleta();
        System.out.println("Elimina l'atleta con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        AtletaService oAtletaService = new AtletaService();
        oAtletaService.delete(id);

    }
    private static void updateAtleta () {
        readAtleta();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id dell'atleta da modificare:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisci nome: ");
        String nome = scanner.nextLine();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.nextLine();
        System.out.println("inserisci nazionalità: ");
        String nazionalità = scanner.nextLine();
        System.out.println("inserisci altezza: ");
        int altezza = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Inserisci la data di nascita nel formato YYYY-MM-DD: ");
        String dataNascita = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascitaFormatted = LocalDate.parse(dataNascita, formatter);
        AtletaService oAtletaService = new AtletaService();
        oAtletaService.update(id, nome, cognome, nazionalità, altezza, dataNascitaFormatted);

    }
    //CRUD OLIMPIADI
    private static void readOlimpiade() {
        System.out.println("ecco la lista delle edizioni delle Olimpiadi: ");
        OlimpiadeService oOlimpiadeService = new OlimpiadeService();
        List<Olimpiade> listaOlimpiade= oOlimpiadeService.read();

        int i = 0;
        while(i<listaOlimpiade.size()){
            System.out.println(listaOlimpiade.get(i).getId()+" "+listaOlimpiade.get(i).getAnno()+" "+listaOlimpiade.get(i).getPaeseOspitante());
            i++;}

    }
    private static void createOlimpiade () {
        System.out.println("inserisci anno: ");
        Scanner scanner = new Scanner(System.in);
        int anno = scanner.nextInt();
        System.out.println("inserisci paese ospitante: ");
        String paeseOspitante = scanner.next();
        OlimpiadeService oOlimpiadeService = new OlimpiadeService();
        oOlimpiadeService.create(anno, paeseOspitante);

    }
    private static void deleteOlimpiade () {
        readOlimpiade();
        System.out.println("Elimina l'edizione dell'Olimpiade con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        OlimpiadeService oOlimpiadeService = new OlimpiadeService();
        oOlimpiadeService.delete(id);

    }
    private static void updateOlimpiade () {
        readOlimpiade();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id dell'olimpiade da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci nuovo anno: ");
        int anno = scanner.nextInt();
        System.out.println("inserisci nuovo paese ospitante: ");
        String paeseOspitante = scanner.next();
        OlimpiadeService oOlimpiadeService = new OlimpiadeService();
        oOlimpiadeService.update(id, anno, paeseOspitante);

    }
    //CRUD SPORT
    private static void readSport() {
        System.out.println("ecco la lista dei docenti: ");
        SportService oSportService = new SportService();
        List<Sport> listaSport= oSportService.readSport();

        int i = 0;
        while(i<listaSport.size()){
            System.out.println(listaSport.get(i).getId()+" ."+listaSport.get(i).getNome()+" numero giocatori:"+listaSport.get(i).getNumeroGiocatori());
            i++;}

    }
    private static void createSport () {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci il numero dei giocatori: ");
        int numeroGiocatori = scanner.nextInt();
        SportService oDocenteService = new SportService();
        oDocenteService.create(nome, numeroGiocatori);

    }
    private static void deleteSport () {
        readSport();
        System.out.println("Elimina lo sport con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        SportService oSportService = new SportService();
        oSportService.delete(id);

    }
    private static void updateSport () {
        readSport();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id dello sport da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci nome: ");
        String nome = scanner.next();
        System.out.println("inserisci il numero dei giocatori: ");
        int numeroGiocatori = scanner.nextInt();
        SportService oSportService = new SportService();
        oSportService.update(id, nome, numeroGiocatori);

    }
    //CRUD GARA
    private static void readGara() {
        System.out.println("ecco la lista delle gare: ");
        OlimpiadeSportService oOlimpiadeSportService = new OlimpiadeSportService();
        List<OlimpiadeSport> listaOlimpiadeSport= oOlimpiadeSportService.read();

        int i = 0;
        while(i<listaOlimpiadeSport.size()){
            System.out.println(listaOlimpiadeSport.get(i).getId()+" "+listaOlimpiadeSport.get(i).getOlimpiadeId()+" "+listaOlimpiadeSport.get(i).getSportId());
            i++;}

    }
    private static void createGara () {
        readSport();
        System.out.println("inserisci id sport: ");
        Scanner scanner = new Scanner(System.in);
        int idSport = scanner.nextInt();
        readSport();
        System.out.println("inserisci id olimpiade: ");
        int idOlimpiade = scanner.nextInt();
        OlimpiadeSportService oOlimpiadeSportService = new OlimpiadeSportService();
        oOlimpiadeSportService.create(idSport, idOlimpiade);

    }
    private static void deleteGara () {
        readGara();
        System.out.println("Elimina la gara con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        OlimpiadeSportService oOlimpiadeSportService = new OlimpiadeSportService();
        oOlimpiadeSportService.delete(id);

    }
    private static void updateGara () {
        readGara();
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id della gara da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci id sport: ");
        int idSport = scanner.nextInt();
        readSport();
        System.out.println("inserisci id olimpiade: ");
        int idOlimpiade = scanner.nextInt();
        OlimpiadeSportService oOlimpiadeSportService = new OlimpiadeSportService();
        oOlimpiadeSportService.update(id, idSport, idOlimpiade);

    }
    //CRUD PARTECIPAZIONI
    private static void readPartecipazione() {
        System.out.println("ecco la lista delle partecipazioni alle Olimpiadi: ");
        OlimpiadeSportAtletaService oOlimpiadiSportAtletaService = new OlimpiadeSportAtletaService();
        List<OlimpiadeSportAtleta> listaPartecipazioni= oOlimpiadiSportAtletaService.read();

        int i = 0;
        while(i<listaPartecipazioni.size()){
            System.out.println(listaPartecipazioni.get(i).getId()+" "+listaPartecipazioni.get(i).getAtletaId()+" "+listaPartecipazioni.get(i).getOlimpiadeSportId());
            i++;}

    }
    private static void createPartecipazione () {
        readAtleta();
        System.out.println("inserisci l'id dell'atleta: ");
        Scanner scanner = new Scanner(System.in);
        int idAtleta = scanner.nextInt();
        System.out.println("inserisci l'id della gara a cui partecipa: ");
        int idOlimpiadesSport = scanner.nextInt();
        OlimpiadeSportAtletaService oOlimpiadeSportAtletaService = new OlimpiadeSportAtletaService();
        oOlimpiadeSportAtletaService.create(idAtleta, idOlimpiadesSport);

    }
    private static void deletePartecipazione () {
        readPartecipazione();
        System.out.println("Elimina la partecipazione alla gara con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        OlimpiadeSportAtletaService oOlimpiadeSportAtletaService = new OlimpiadeSportAtletaService();
        oOlimpiadeSportAtletaService.delete(id);

    }


}