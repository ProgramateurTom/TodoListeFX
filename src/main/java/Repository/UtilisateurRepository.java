package Repository;

import Database.Database;
import model.Liste;
import model.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurRepository {
    private Connection cnx;
    public UtilisateurRepository() {this.cnx = Database.getConnexion();}
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return false;
    }
    public Utilisateur getUtilisateurParEmail(String email) {
        String sql = "Select * from utilisateur where email = ?";
        try {
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("Utilisateur trouvé !");
                Utilisateur user = new Utilisateur(
                        rs.getInt("id_utilisateur"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("role")
                );
                return user;
            }
            System.out.println("Utilisateur non trouvé ....");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return null;
    }
    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        String sql = "Select * from utilisateur";
        System.out.println(sql);
        return null;
    }
    public ArrayList<Utilisateur> getEmailUtilisateurs(){
        String mail = "Delete * FROM utilisateur" +
                " WHERE InnerJoin(Select id_utilisateur From utilisateur)" +
                " where email = ?";
        System.out.println(mail);
        return null;
    }
    public ArrayList<Utilisateur> ModifUtilisateur(Utilisateur utilisateur) {
        String modif = "Update * From Utilisateur";
        System.out.println(modif);
        return null;
    }
}