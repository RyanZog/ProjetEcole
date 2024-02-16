package ecole;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Infos {
    protected int id_infos;
    protected   int nbreHeures;
    protected Cours ue;
    protected Salle room;
    protected Enseignant pr;
    public Infos(int nbreHeures){
        this.nbreHeures=nbreHeures;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public Cours getUe() {
        return ue;
    }

    public void setUe(Cours ue) {
        this.ue = ue;
    }

    public Salle getRoom() {
        return room;
    }

    public void setRoom(Salle room) {
        this.room = room;
    }

    public Enseignant getPr() {
        return pr;
    }

    public void setPr(Enseignant pr) {
        this.pr = pr;
    }

    @Override
    public String toString() {
        return "Le professeur "+ pr +" donne cours de "+ ue +" pendant" + nbreHeures + " dans la salle "+room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Infos infos = (Infos) o;
        return id_infos == infos.id_infos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_infos);
    }
}
