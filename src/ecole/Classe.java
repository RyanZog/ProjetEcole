package ecole;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Scanner;
/**
 * Classe metier de gestion d'une salle de classe
 * @see Infos
 * @version 1.0
 * @author Rayan
 */
public class Classe {
    /**
     * id unique d'une salle de classe
     */
    protected int id_classe;
    /**
     * designation d'une salle de classe
     */
    protected String sigle;
    /**
     * niveau d'etude de la classe ayant cours
     */
    protected int annee;
    /**
     * la specialite de la classe
     */
    protected String spe;
    /**
     * le nombre d'eleves de la classe
     */
    protected   int nbreEleves;
    /**
     * liste des infos par classe
     */
    protected   List<Infos> info= new ArrayList<>();
    /**
     * constructeur paramétré
     * @param id_classe identifiant d'une classe
     * @param sigle sigle d'une classe
     * @param annee le niveau d'etude de la classe
     * @param nbreEleves nombre d'eleves de la classe
     * @param spe specialite de la classe
     */
    public Classe(int id_classe, String sigle,int annee,String spe,int nbreEleves){
        this.id_classe=id_classe;
        this.sigle=sigle;
        this.annee=annee;
        this.nbreEleves=nbreEleves;
        this.spe=spe;
    }
    /**
     * getter sigle
     *
     * @return le sigle d'une classe
     */
    public String getSigle() {
        return sigle;
    }
    /**
     * setter sigle
     *
     * @param sigle designation de la classe
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
    /**
     * getter annee
     *
     * @return le niveau d'etude de la classe
     */
    public int getAnnee() {
        return annee;
    }
    /**
     * setter annee
     *
     * @param annee l'annee academique de la classe
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    /**
     * getter spe
     *
     * @return la specialite d'une classe
     */
    public String getSpe() {
        return spe;
    }
    /**
     * setter specialite celle de la classe
     *
     * @param spe la specialite d'une classe
     */
    public void setSpe(String spe) {
        this.spe = spe;
    }
    /**
     * getter nbrEleves
     *
     * @return le nombre d'eleves par classe
     */
    public int getNbreEleves() {
        return nbreEleves;
    }
    /**
     * setter nbreEleves
     *
     * @param nbreEleves le nombre d'eleves de la classe
     */
    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    /**
     * getter liste d'infos
     *
     * @return listes des infos de la classe
     */
    public List<Infos> getInfo() {
        return info;
    }

    /**
     * setter liste des infos
     *
     * @param info listes des infos
     */
    public void setInfo(List<Infos> info) {
        this.info = info;
    }
    /**
     * vérification de l'égalité de deux classes basee sur l'id de la classe
     * @param o autre commande
     * @return égalité ou pas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o ==null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return id_classe == classe.id_classe;
    }
    /**
     * calcul du hashcode de la classe
     * @return hashcode de la classe
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSigle());
    }

    /**
     *total du nombre d'heures de cours
     * @return nombre d'heures
     */
    public int nbreHeuresTot(){
        List<Infos> linf =new ArrayList<>();
        int nbr=0;
        for(Infos inf : info){
            nbr= nbr + inf.getNbreHeures();
        }
        return nbr;
    }

    /**
     *Recherche des enseignants + heures
     * @return liste des enseignants + heures de cours
     */
    public List<EnsHeure> listEnseigantHeures(){
        List<EnsHeure> leh =new ArrayList<>();
        for(Infos inf : info){
            //TODO verifier unicite1
            leh.add(new EnsHeure(inf.getPr(),inf.getNbreHeures()) );
        }
        return leh;
    }

    /**
     * Recherche des salles et des cours
     * @return liste de cours et de salle
     */
    public List<SalCours> listSalCours(){
        List<SalCours> lsc = new ArrayList<>();
        for(Infos inf : info){

            lsc.add(new SalCours(inf.getRoom(),inf.getUe()));
        }
        return lsc;
    }

    /**
     *verifie s'il y a de la place ou pas
     * @param salle salle de cours
     * @return place dispo ou pas
     */
    public boolean capacity(Salle salle){
        if(nbreEleves>salle.getCapacite()){
            return false;
        }
        return true;
    }

    /**
     * ajout d'un cours
     * @param ue le cours
     * @param inf info de la classe
     * @return ajout effectue ou pas
     */
    public boolean addCours(Cours ue,Infos inf){
        for(Infos i: info){
            //verifier pas deja present
            if(i.getUe().equals(inf.getUe()) && (i.getNbreHeures() == (inf.getNbreHeures())) ){
                return false;
            }
            i.setUe(ue);
            info.add(i);
        }
        return true;
    }

    /**
     * suppression d'un cours
     * @param ue le cours en question
     * @return suppression reussie ou non
     */
    public boolean suppCours(Cours ue){
        for(Infos i: info){
       //Est cense parcourir la liste des info un par un et verifier si egale avec le cours correspond puis retire
       //mais je n'arrive pas a correctement l'implementer
        if(i.getUe().equals(info.indexOf(ue))){
           info.remove(i.getUe());
           ue.setCode(null);
           ue.setIntitule(null);
        }
        }

        return true;
    }

    /**
     *modification cours basee sur le cours et l'enseignant
     * @param ue
     * @param pr
     */
    public void modifCours(Cours ue,Enseignant pr){
        List<Infos> li = new ArrayList<>();
        for(Infos inf : info){
            inf.setUe(ue);
            inf.setPr(pr);
            li.add(inf);
            info.add(inf);
        }

    }

    /**
     * modification cours basee sur le cours et la salle
     * @param ue
     * @param salle
     */
    public void modifCours(Cours ue,Salle salle){
        List<Infos> li = new ArrayList<>();
        for(Infos inf : info){
            inf.setUe(ue);
            inf.setRoom(salle);
            li.add(inf);
            info.add(inf);
        }

    }

    /**
     * modifiaction cours basee sur le cours et l'heure
     * @param ue
     * @param heure
     */
    public void modifCours(Cours ue,int heure){
        List<Infos> li = new ArrayList<>();
        for(Infos inf : info){
            inf.setUe(ue);
            inf.setNbreHeures(heure);
            li.add(inf);
            info.add(inf);
        }
    }

}
