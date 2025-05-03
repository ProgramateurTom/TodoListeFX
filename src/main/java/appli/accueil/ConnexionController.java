package appli.accueil;

import Database.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConnexionController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField motDePasseField;
    @FXML
    protected void onHelloButtonClick(){System.out.println("Welcome to JavaFX Application!");}
    @FXML
    protected void blackAndWhiteMonsters(){System.out.println("Prepare for magic and monsters!");}
    @FXML
    protected void connexion(){System.out.println("Connectez-vous!");}
}