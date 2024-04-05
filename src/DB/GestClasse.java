package DB;

import MyConnection.DBConnection;
import java.sql.*;
import ecole.Classe;
import java.util.Scanner;


public class GestClasse {

    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("Connexion établie");
        do {
            System.out.println("1. Ajout\n2. Recherche\n3. Modification\n4. Suppression\n5. Tous\n6. Fin");
            System.out.print("Choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (true);
    }

    public void ajout() {
        try {
            // Ajouter une nouvelle Classe
            System.out.print("Sigle de la classe : ");
            String sigle_classe = sc.nextLine();
            System.out.print("annee d'etude de la classe ayant cours : ");
            int annee = sc.nextInt();
            while(annee<=0){
                System.out.println("Donnee invalide");
                System.out.print("annee d'etude de la classe ayant cours : ");
                 annee = sc.nextInt();
            }
            System.out.print("Specialite donne dans cette classe ");
            String specialite = sc.nextLine();
            System.out.print("Nombre d'eleves prevu  : ");
            int nbrEleves = sc.nextInt();
            while(nbrEleves<=0){
                System.out.println("Donnee invalide");
                System.out.print("annee d'etude de la classe ayant cours : ");
                nbrEleves = sc.nextInt();
            }

            String query1 = "INSERT INTO CLASSE (sigle_classe, annee, specialite, nbrEleves) VALUES (?, ?, ?, ?)";
            String query2 = "select id_classe from CLASSE where sigle_classe =?";
            try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                 PreparedStatement pstm2= dbConnect.prepareStatement(query2)) {
                pstm1.setString(1, sigle_classe);
                pstm1.setInt(2, annee);
                pstm1.setString(3,specialite);
                pstm1.setInt(4,nbrEleves );
                int result = pstm1.executeUpdate();
                System.out.println("Nouvelle classe inseree !");
                if (result == 1) {
                    pstm2.setString(1,sigle_classe);
                    ResultSet rs= pstm2.executeQuery();
                    if(rs.next()){
                        int id_classe= rs.getInt(1);
                        System.out.println("idclasse = "+id_classe);
                    }
                    else System.out.println("record introuvable");
                } else {
                    System.out.println("Echec!!Erreur lors de l'ajout de la classe.");
                }
            } catch (SQLException e) {
                System.out.println("Echec!!Erreur SQL lors de l'ajout de la classe : " + e);
            }
        } catch (Exception e) {
            System.out.println("Echec!!Erreur lors de la saisie des données de la course : " + e.getMessage());
        }
    }


    public void recherche() {
        try {
            System.out.print("Entrez l'id de la classe recherche : ");
            int idrech = sc.nextInt();
            String query = "SELECT * FROM CLASSE WHERE id_classe = ?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, idrech);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    String sigle_classe = rs.getString(2);
                    int annee = rs.getInt(3);
                    String specialite = rs.getString(4);
                    int nbrEleve = rs.getInt(5);
                } else {
                    System.out.println("Pas de correspondance trouve avec l'id " + idrech);
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors de la recherche de la course : " + e);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie de l'ID de la course : " + e.getMessage());
        }
    }

    public void modification() {
        try {
            System.out.print("Entrez l'id de la classe à modifier : ");
            int idrech = sc.nextInt();
            System.out.println("Entrez la nouvelle specialite : ");
            String spe = sc.nextLine();
            System.out.print("Entrez le nouveau nombre d'eleves : ");
            int nouveauNbr = sc.nextInt();
            System.out.println("Entrez la nouvelle specialite : ");
            String query = "UPDATE CLASSE SET specialite = ? and nbrEleves = ? WHERE idrech= ?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setString(2,spe);
                pstm.setInt(3, nouveauNbr);
                pstm.setInt(4, idrech);
                int result = pstm.executeUpdate();
                if (result != 0) {
                    System.out.println("Ligne modifiée avec succès !");
                } else {
                    System.out.println("Aucune classe trouvée avec l'id " + idrech);
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors : " + e);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie de l'id de la classe : " + e.getMessage());
        }
    }

    public void suppression() {
        try {
            System.out.print("Entrez id de la classe à supprimer : ");
            int idrech = sc.nextInt();
            String query = "DELETE FROM CLASSE WHERE idrech = ?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, idrech);
                int result = pstm.executeUpdate();
                if (result != 0) {
                    System.out.println("La classe a été supprimée avec succès !");
                } else {
                    System.out.println("Aucune classe trouvée avec l'id " + idrech);
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors de la suppression de la classe : " + e);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie de l'ID de la classe : " + e.getMessage());
        }
    }

    public void tous() {
        String query = "SELECT * FROM CLASSE";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id_classe = rs.getInt(1);
                String sigle_classe = rs.getString(2);
                int annee =  rs.getInt(3);
                String specialite = rs.getString(4);
                int nbrEleve = rs.getInt(5);
                Classe cl = new Classe(id_classe,sigle_classe,annee,specialite,nbrEleve);
                System.out.println(cl);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de la récupération de toutes les classes : " + e);
        }
    }

    public static void main(String[] args) {
        GestClasse gc = new GestClasse();
        gc.gestion();
    }
}
