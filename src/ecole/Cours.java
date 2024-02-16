package ecole;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Scanner;
public class Cours {
    protected int id_cours;
    protected String code;
    protected   String intitule;
    public Cours(String code,String intitule){
        this.code=code;
        this.intitule=intitule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours ue = (Cours) o;
        return id_cours == ue.id_cours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cours);
    }
}
