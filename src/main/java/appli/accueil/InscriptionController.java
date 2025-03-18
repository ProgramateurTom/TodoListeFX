package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;
import Repository.UtilisateurRepository;

public class InscriptionController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    private PasswordField confirmationField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField motDePasseField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    void btnConnexion(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/login");
    }

    @FXML
    void btnInscription(ActionEvent event) throws IOException {
        if(confirmationField.getText().isEmpty() ||
                motDePasseField.getText().isEmpty() ||
                nomField.getText().isEmpty() ||
                prenomField.getText().isEmpty() ||
                emailField.getText().isEmpty()){
            System.out.println("il faut que tous les champs soir renseigné !");
        }else if (!confirmationField.getText().equals(motDePasseField.getText())){
            System.out.println("Les mot de passe ne correspondent pas !");
        }else {
            Utilisateur user = new Utilisateur(nomField.getText(),prenomField.getText(),emailField.getText(),motDePasseField.getText(),"utilisateur");
            boolean estInscrit = utilisateurRepository.ajouterUtilisateur(user);
            if(estInscrit){
                System.out.println("Inscription réussi !");
                StartApplication.changeScene("accueil/login");
            }else{
                System.out.println("Erreur lors de l'inscription...");
            }
        }
    }

}