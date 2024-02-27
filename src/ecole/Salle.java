package ecole;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Scanner;
/**
 * Classe metier de gestion d'une salle
 * @see Infos
 * @version 1.0
 * @author Rayan
 */
public class Salle {
    /**
     * id unique d'une salle
     */
    protected int id_salle;
    /**
     * designation officielle d'une salle
     */
    protected String sigle;
    /**
     * capacite max d'une salle
     */
    protected int capacite;
    /**
     * listes des enseingants
     */
    protected List<Enseignant> pr=  new ArrayList<>();

    /**
     * constructeur parametre
     * @param id_salle
     * @param sigle
     * @param capacite
     */

    public Salle(int id_salle,String sigle,int capacite){
        this.id_salle=id_salle;
        this.sigle=sigle;
        this.capacite=capacite;
    }
    /**
     *getter sigle
     *
     * @return designation d'une salle
     */
    public String getSigle() {
        return sigle;
    }

    /**
     *setter sigle
     *
     * @param sigle
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * getter capacite
     *
     * @return capacite d'une salle
     */

    public int getCapacite() {
        return capacite;
    }

    /**
     *setter capacite
     *
     * @param capacite nombre d'eleve pouvant etre dans une salle
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     *getter liste des enseignants
     *
     * @return liste des enseigants
     */
    public List<Enseignant> getPr() {
        return pr;
    }

    /**
     *setter enseignants
     *
     * @param pr liste des enseignants
     */
    public void setPr(List<Enseignant> pr) {
        this.pr = pr;
    }

    /**
     *verifiaction de l'egalite de deux salles basee sur id_salle
     * @param o
     * @return egalite ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return id_salle == salle.id_salle;
    }

    /**
     *calcul du hashcode s'une salle
     * @return hascode id_salle
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_salle);
    }
}
