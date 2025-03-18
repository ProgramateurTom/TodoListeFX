package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;
import Repository.UtilisateurRepository;

import java.io.IOException;

public class LoginController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    private TextField emailField;

    @FXML
    private Label erreurLabel;

    @FXML
    private PasswordField mitDePasseField;

    @FXML
    protected void btnConnexion(ActionEvent event) {
        System.out.println("Email = "+emailField.getText());
        System.out.println("mdp = "+mitDePasseField.getText());
        String email =  emailField.getText();
        String mdp =  mitDePasseField.getText();
        if(mdp.isEmpty() ||email.isEmpty()){
            erreurLabel.setText("Erreur : veuillez remplir l'ensemble des champs");
        }else{
            Utilisateur user = utilisateurRepository.getUtilisateurParEmail(email);
            if (user == null){
                erreurLabel.setText("Les informations fournies ne permettent pas de vous identifier");
            }else if(!user.getMotDePasse().equals(mdp)){
                erreurLabel.setText("Les informations fournies ne permettent pas de vous identifier");
            }else{
                erreurLabel.setText("Connexion réusi !");
                System.out.println("Connexion réusi !");
                System.out.println("Redirection....");
            }
        }
    }

    @FXML
    protected void btnMotDePasseOublie(ActionEvent event) {

    }

    @FXML
    protected void btnInscription(ActionEvent event) throws IOException {
        System.out.println("Redirection...");
        StartApplication.changeScene("accueil/inscription");
    }

}