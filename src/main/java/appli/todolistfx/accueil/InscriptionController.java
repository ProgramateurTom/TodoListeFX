package appli.todolistfx.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InscriptionController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void Validation() {welcomeText.setText("Valider");}
    @FXML
    protected void Connexion() {welcomeText.setText("Connexion");}
}