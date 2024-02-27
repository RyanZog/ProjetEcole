package ecole;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Scanner;
/**
 * Classe metier de gestion d'un cours
 * @see Infos
 * @version 1.0
 * @author Rayan
 */
public class Cours {
    /**
     *id unique du cours
     */
    protected int id_cours;
    /**
     * code d'identifiant d'un cours
     */
    protected String code;
    /**
     * intitule d'un cours
     */
    protected   String intitule;

    /**
     * constructeur parametre
     * @param id_cours
     * @param code
     * @param intitule
     */
    public Cours(int id_cours,String code,String intitule){
        this.id_cours=id_cours;
        this.code=code;
        this.intitule=intitule;
    }

    /**
     *getter code
     *
     * @return code du cours
     */
    public String getCode() {
        return code;
    }

    /**
     *setter code
     *
     * @param code designation d'un cours
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *getter intitule du cours
     *
     * @return l'intitule du cours
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     *setter intitule
     *
     * @param intitule
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     *verification de l'egalite entre deux cours basee sur id_cours
     * @param o
     * @return egalite ou pas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours ue = (Cours) o;
        return id_cours == ue.id_cours;
    }

    /**
     *calcul du hashcode du cours
     * @return hashCode de id_cours
     */
    @Override
    public int hashCode() {
        return Objects.hash(id_cours);
    }
}
