package ecole;
/**
 * Classe metier de gestion de l'enseignant et du nbre d'heures
 * @see Classe
 * @version 1.0
 * @author Rayan
 */
public class EnsHeure {
    /**
     *Enseignant donnant cours
     */
    protected Enseignant en;
    /**
     *Nombre d'heures
     */
    protected int NbrHeure;

    /**
     *constructeur parametre
     * @param en
     * @param nbrHeure
     */
    public EnsHeure(Enseignant en, int nbrHeure){
        this.en=en;
        this.NbrHeure=nbrHeure;
    }

    /**
     *getter enseignant
     *
     * @return enseignant
     */
    public Enseignant getEn() {
        return en;
    }

    /**
     *setter enseignant
     *
     * @param en
     */
    public void setEn(Enseignant en) {
        this.en = en;
    }

    /**
     *getter nombre d'heures
     *
     * @return nombre d'heures
     */
    public int getNbrHeure() {
        return NbrHeure;
    }

    /**
     * setter nombre d'heures
     *
     * @param nbrHeure
     */
    public void setNbrHeure(int nbrHeure) {
        this.NbrHeure = nbrHeure;
    }
}
