package ecole;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import java.util.Scanner;
public class Classe {
    protected int id_classe;
    protected String sigle;
    protected int annee;
    protected String spe;
    protected   int nbreEleves;
    protected   List<Infos> info= new ArrayList<>();
    public Classe(String sigle,int annee,String spe,int nbreEleves){
        this.sigle=sigle;
        this.annee=annee;
        this.nbreEleves=nbreEleves;
        this.spe=spe;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
    }

    public int getNbreEleves() {
        return nbreEleves;
    }

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    public List<Infos> getInfo() {
        return info;
    }

    public void setInfo(List<Infos> info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o ==null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return id_classe == classe.id_classe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSigle());
    }

    public int nbreHeuresTot(){
        List<Infos> linf =new ArrayList<>();
        int nbr=0;
        for(Infos inf : info){
            nbr= nbr + inf.getNbreHeures();
        }
        return nbr;
    }
    public List<Infos> listEnseigantHeures(){
        List<Infos> lif =new ArrayList<>();
        for(Infos inf : info){
            System.out.println(inf.getPr()+" a "+inf.getNbreHeures());
        }
        return lif;
    }

    public void addCours(Infos inf,Cours ue){
        int nbr;
        nbr=inf.getNbreHeures();

    }
    public void suppCours(Cours ue){
        info.remove(ue);
        ue.setCode(null);
        ue.setIntitule(null);
    }
}
