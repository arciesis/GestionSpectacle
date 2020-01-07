import java.util.Objects;

public class SeanceFilm extends Seance implements Comparable<Seance>{

    /**
     * champ representant la salle de projection du film
     */
    private Salle laSalle;

    /**
     * champ representant le nombre de places vendues a tarif reduit
     */
    private int nbplacesTarifReduit;


    /**
     * Constructeur de la classe
     *
     * @param leCreneau                  le creneau du film
     * @param nbPlacesVenduesTarifNormal le nombre de places vendu au tarif normal
     * @param laSalle                    la salle de projection
     * @param nbplacesTarifReduit        le nombre de places vendu a tarid reduit
     */
    public SeanceFilm(Creneau leCreneau,  Salle laSalle, int nbPlacesVenduesTarifNormal, int nbplacesTarifReduit) {
        super(leCreneau, nbPlacesVenduesTarifNormal);
        this.laSalle = laSalle;
        this.nbplacesTarifReduit = nbplacesTarifReduit;
    }

    /**
     * getteur de la salle
     *
     * @return la salle de projection du film
     */
    public Salle getLaSalle() {
        return laSalle;
    }

    /**
     * getteur du nombre de place vendu a tarif reduit
     *
     * @return le nombre de place vendu a tarif reduit
     */
    public int getNbplacesTarifReduit() {
        return nbplacesTarifReduit;
    }

    @Override
    public String toString() {
        return "SeanceFilm{" +
                "laSalle=" + laSalle +
                ", nbplacesTarifReuit=" + nbplacesTarifReduit +
                ", leCreneau=" + leCreneau +
                ", nbPlacesVenduesTarifNormal=" + nbPlacesVenduesTarifNormal +
                '}';
    }

    /**
     * Calcul le taux de remplissage d'une seance de film
     *
     * @return le taux de remplissage du film
     */
    public double tauxRemplissage() {
        if (this.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit != 0)
            return (this.nbplacesTarifReduit + this.nbPlacesVenduesTarifNormal) * 100 / this.laSalle.places;
        else
            return 0.0;
    }

    /**
     *
     * @return le chiffre d'affaire de la séance
     */
    public double chiffreAffaire(){
        double CA=0;
        CA=(nbplacesTarifReduit*(laSalle.getTarif()*0.6))+(super.nbPlacesVenduesTarifNormal*(laSalle.getTarif()));
        return CA;

    }

    /**
     * methode permettant de vendre des laces
     *
     * @param nbre le nombre de places a vendre
     */
    public void vendrePlacesTN(int nbre) throws ArithmeticException {
        if (laSalle.places - (super.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit) >= nbre) {
            super.nbPlacesVenduesTarifNormal += nbre;
        } else
            throw new ArithmeticException("nombre de places insuffisantes");
    }


    /**
     * methode permettant de vendre des places a tarif reduit
     *
     * @param nbre le nombre de places a vendre
     */
    public void vendrePlacesTR(int nbre) throws ArithmeticException{
        if (laSalle.places - (super.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit) >= nbre) {
            this.nbplacesTarifReduit += nbre;
        } else
            throw new ArithmeticException("nombre de places insuffisantes");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeanceFilm)) return false;
        if (!super.equals(o)) return false;
        SeanceFilm that = (SeanceFilm) o;
        return nbplacesTarifReduit == that.nbplacesTarifReduit &&
                Objects.equals(laSalle, that.laSalle);
    }

    /**
     *
     * @param seanceFilm
     * @return Compare les séances films entre elles
     */
    public int compareTo(Seance seanceFilm) {
        if ( this.getLaSalle().getNuméro() != ((SeanceFilm)seanceFilm).getLaSalle().getNuméro())  {
            return 1;
        }else {
            if (this.leCreneau.getJour() < ((SeanceFilm)seanceFilm).leCreneau.getJour()) {
                return -1;
            } else if (this.leCreneau.getJour() > ((SeanceFilm)seanceFilm).leCreneau.getJour()) {
                return 1;
            } else {
                if (this.leCreneau.getHeureDebut().getHeures() == seanceFilm.leCreneau.getHeureFin().getHeures()) {
                    if (this.leCreneau.getHeureDebut().getMinutes() >= seanceFilm.leCreneau.getHeureFin().getMinutes()) {
                        return -1;
                    } else return 0;
                } else if (this.leCreneau.getHeureFin().getHeures() == seanceFilm.leCreneau.getHeureDebut().getHeures()) {
                    if (this.leCreneau.getHeureFin().getMinutes() <= seanceFilm.leCreneau.getHeureDebut().getMinutes()) {
                        return 1;
                    } else return 0;
                } else if (this.leCreneau.getHeureDebut().getHeures() > seanceFilm.leCreneau.getHeureFin().getHeures()) {
                    return -1;

                } else if (this.leCreneau.getHeureFin().getHeures() < seanceFilm.leCreneau.getHeureDebut().getHeures()) {
                    return 1;
                } else return 0;

            }
        }
    }
}
