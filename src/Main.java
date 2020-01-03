import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Main {
    public static void main(String args[]) {

        // write your code here
        GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
        gps.ajouterFilm("le titre d'un film", "J.J Abrams", 150);
        gps.ajouterFilm("un autre titre", "Cristopher Nolan", 184);
        gps.ajouterFilm("un autre titre le retour", "Cristopher Nolan", 184);


        gps.ajouterInterprete(100, "JeNeSaisPlus");
        gps.ajouterInterprete(101, "bah la nonplus");
        //gps.ajouterInterprete(102,"bah la idem");

        gps.ajouterPiece("les fourberies de scapin", "didier",2);
        gps.ajouterPiece("Romeo et Juliette", "didier",2);


        Spectacle lordOfRings = new Film("Le Seignieur des Anneaux", 180, "peter Jackson", "Vigo");

        Salle A=new Salle("A1",500,10.70);
        ((Film) lordOfRings).ajouterSeanceFilm(new SeanceFilm(new Creneau(1,new Horaire(13,00),new Horaire(14,00)),A,200,80));
        ((Film) lordOfRings).ajouterSeanceFilm(new SeanceFilm(new Creneau(1,new Horaire(10,00),new Horaire(13,00)),A,200,80));

        SalleTheatre B=new SalleTheatre("B1",500,15.0,250,18.50);
        Spectacle LesMiserables = new PieceTheatre("les miserables","hugo",2,"rose","paul");
        //((PieceTheatre) LesMiserables).ajouterSeanceTheatre(new SeanceTheatre(new Creneau(1,new Horaire(13,00),new Horaire(14,00)),200,B,80));
        //((PieceTheatre) LesMiserables).ajouterSeanceTheatre(new SeanceTheatre(new Creneau(2,new Horaire(10,00),new Horaire(12,00)),100,B,80));

        System.out.println(gps.lesFilms());
        System.out.println(gps.lesPieces());

        System.out.println(gps.toString());



    }

}
