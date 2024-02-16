package ecole;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import java.util.Scanner;
public class Salle {
    protected int id_salle;
    protected String sigle;
    protected int capacite;
    protected List<Enseignant> pr=  new ArrayList<>();

    public Salle(String sigle,int capacite){
        this.sigle=sigle;
        this.capacite=capacite;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Enseignant> getPr() {
        return pr;
    }

    public void setPr(List<Enseignant> pr) {
        this.pr = pr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return id_salle == salle.id_salle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_salle);
    }
}
