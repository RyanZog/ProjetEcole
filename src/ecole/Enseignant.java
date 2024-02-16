package ecole;

import java.util.*;

public class Enseignant {
    protected int id_enseignant;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected int chargeSem;
    protected float salaireMensu;
    protected Date dateEngag;

    public Enseignant(String matricule,String nom,String prenom,String tel,int chargeSem,float salaireMensu,Date dateEngag){
        this.matricule=matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
        this.chargeSem=chargeSem;
        this.salaireMensu=salaireMensu;
        this.dateEngag=dateEngag;

    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getSalaireMensu() {
        return salaireMensu;
    }

    public void setSalaireMensu(float salaireMensu) {
        this.salaireMensu = salaireMensu;
    }

    public Date getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enseignant pr = (Enseignant) o;
        return id_enseignant == pr.id_enseignant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_enseignant);
    }
}
