package ecole;
/**
 * Classe metier de gestion d'une salle et des cours
 * @see Classe
 * @version 1.0
 * @author Rayan
 */
public class SalCours {
    /**
     * salle de cours
     */
    protected Salle sa;
    /**
     *cours dispense dans la salle
     */
    protected Cours ue;

    /**
     * constructeur parametre
     * @param sa
     * @param ue
     */
    public SalCours(Salle sa, Cours ue){
        this.sa=sa;
        this.ue=ue;
    }

    /**
     * getter dalle
     *
     * @return la salle
     */
    public Salle getSa() {
        return sa;
    }

    /**
     * setter salle
     *
     * @param sa
     */
    public void setSa(Salle sa) {
        this.sa = sa;
    }

    /**
     * getter cours
     *
     * @return le cours
     */
    public Cours getUe() {
        return ue;
    }

    /**
     * setter cours
     *
     * @param ue
     */
    public void setUe(Cours ue) {
        this.ue = ue;
    }
}
