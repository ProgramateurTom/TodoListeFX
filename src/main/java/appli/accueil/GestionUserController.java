package appli.accueil;

import Repository.UtilisateurRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {
    @FXML
    private TableView<Utilisateur> tableauUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [][] colonnes = {
                {"Id Utilisateur", "idUser"},
                {"Nom", "nom"},
                {"Prénom", "prenom"},
                {"Email", "mail"},
                {"Rôle", "role"},
        };
        for ( int i = 0 ; i < colonnes.length ; i ++ ){
            //Création de la colonne avec le titre
            TableColumn<Utilisateur,String> maCol = new TableColumn<>(colonnes[i][0]);
//Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(
                    new PropertyValueFactory<Utilisateur,String>(colonnes[i][1]));
            //Ajout de la colonne dans notre tableau
            tableauUser.getColumns().add(maCol);
        }
        UtilisateurRepository userrepo = new UtilisateurRepository();
        tableauUser.getItems().addAll(userrepo.getTousLesUtilisateurs());
    }
    @FXML
    private Button Suppretion;
}
