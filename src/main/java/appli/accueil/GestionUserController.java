package appli.accueil;

import Repository.UtilisateurRepository;
import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import Database.Database;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {
    @FXML
    private TableView<Utilisateur> tableauUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [][] colonnes = {
                { "Id Utilisateur","idUser" },
                { "Nom","nom" },
                { "Prénom","prenom" },
                { "Email","mail" },
                { "Rôle","role" },
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
    }
    @FXML
    private Button Suppretion;
    @FXML
    void cliqueTableauSuppretion(MouseEvent event) {
        Utilisateur selection = tableauUser.getSelectionModel().getSelectedItem();
        if (selection != null) {
            Suppretion.setDisable(false);
        }else{
            Suppretion.setDisable(true);
        }
    }
    @FXML
    private Button Modif;
    @FXML
    void cliqueTableauModif(MouseEvent event) throws IOException {
        Utilisateur selection = tableauUser.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 2) { // Vérifie si c'est un double-clic
            if (selection != null) {
                StartApplication.changeScene("user/modificationUser");
            }
        }
    }
}
