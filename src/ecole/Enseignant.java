package ecole;

import java.math.BigDecimal;
import java.util.*;
/**
 * Classe metier de gestion d'une salle
 * @see Infos
 * @see Salle
 * @version 1.0
 * @author Rayan
 */
public class Enseignant {
    /**
     *id unique de l'enseignant
     */
    protected int id_enseignant;
    /**
     *designation de l'enseignant
     */
    protected String matricule;
    /**
     *nom de l'enseignant
     */
    protected String nom;
    /**
     *prenom de l'enseignant
     */
    protected String prenom;
    /**
     *numero de telephone
     */
    protected String tel;
    /**
     *charge hebdomadaire des heures de l'enseignant
     */
    protected int chargeSem;
    /**
     *salaire mensuel
     */
    protected BigDecimal salaireMensu;
    /**
     *date engagement de l'enseignant
     */
    protected Date dateEngag;

    /**
     * constructeur parametre
     * @param id_enseignant
     * @param matricule
     * @param nom
     * @param prenom
     * @param tel
     * @param chargeSem
     * @param salaireMensu
     * @param dateEngag
     */

    public Enseignant(int id_enseignant,String matricule,String nom,String prenom,String tel,int chargeSem,BigDecimal salaireMensu,Date dateEngag){
        this.id_enseignant=id_enseignant;
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
        this.chargeSem=chargeSem;
        this.salaireMensu=salaireMensu;
        this.dateEngag=dateEngag;

    }

    /**
     *getter matricule desigantion enseignant
     *
     * @return matricule enseignant
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * setter matricule desigantion officielle de l'enseignant
     *
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * getter nom enseignant
     *
     * @return nom enseignant
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom enseignant
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter salaire mensuel de l'enseignant
     *
     * @return salaire mensuel
     */
    public BigDecimal getSalaireMensu() {
        return salaireMensu;
    }

    /**
     * setter salaire mensuel de l'enseignant
     *
     * @param salaireMensu
     */
    public void setSalaireMensu(BigDecimal salaireMensu) {
        this.salaireMensu = salaireMensu;
    }

    /**
     * getter date engagement de l'enseignant
     *
     * @return date engagement enseignant
     */
    public Date getDateEngag() {
        return dateEngag;
    }

    /**
     * setter date Engagement de l'enseigant
     *
     * @param dateEngag
     */
    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    /**
     * verification de l'egalite de deux enseignants basee sur id_enseignant
     * @param o
     * @return egalite ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant pr = (Enseignant) o;
        return id_enseignant == pr.id_enseignant;
    }

    /**
     * calcul du hashCode de enseigant
     * @return hasCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_enseignant);
    }
}
