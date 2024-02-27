package ecole;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
/**
 * Classe représentant les informations d'une classe
 * @see Classe
 * @author Rayan
 */
public class Infos {
    /**
     * id unique d'une information
     */
    protected int id_infos;
    /**
     * nombre d'heures
     */
    protected int nbreHeures;
    /**
     *Le cours dispense
     */
    protected Cours ue;
    /**
     *La salle de cours
     */
    protected Salle room;
    /**
     *L'enseignant qui donne cours
     */
    protected Enseignant pr;

    /**
     *constructeur paramétré
     * @param id_infos
     * @param nbreHeures
     */
    public Infos(int id_infos,int nbreHeures){
        this.id_infos=id_infos;
        this.nbreHeures=nbreHeures;
    }

    /**
     *getter  nombre d'heures
     *
     * @return le nombre d'heures
     */
    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     *setter  nombre d'heures
     *
     * @param nbreHeures
     */
    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     *getter cours
     *
     * @return le cours dispense
     */
    public Cours getUe() {
        return ue;
    }

    /**
     *setter cours
     *
     * @param ue
     */
    public void setUe(Cours ue) {
        this.ue = ue;
    }

    /**
     *getter salle
     *
     * @return la salle de cours
     */
    public Salle getRoom() {
        return room;
    }

    /**
     *setter salle
     *
     * @param room la salle de cours
     */
    public void setRoom(Salle room) {
        this.room = room;
    }

    /**
     *getter enseignant
     *
     * @return l'enseignant qui donne cours
     */
    public Enseignant getPr() {
        return pr;
    }

    /**
     *setter enseignant
     *
     * @param pr l'enseignant
     */
    public void setPr(Enseignant pr) {
        this.pr = pr;
    }

    /**
     *methode toString
     * @return informations completes d'une classe
     */
    @Override
    public String toString() {
        return "Le professeur "+ pr +" donne cours de "+ ue +" pendant" + nbreHeures + " dans la salle "+room;
    }

    /**
     *vérification de l'égalité de deux informations basee sur l'id info
     * @param o
     * @return egalite ou pas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Infos infos = (Infos) o;
        return id_infos == infos.id_infos;
    }

    /**
     *calcul du hashcode de info
     * @return hashCode de info
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_infos);
    }
}
