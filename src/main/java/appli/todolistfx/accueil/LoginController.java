package appli.todolistfx.accueil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class LoginController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {welcomeText.setText("Welcome to JavaFX Application!");}
    @FXML
    protected void blackAndWhiteMonsters() {welcomeText.setText("Prepare for magic and monsters!");}
    @FXML
    protected void connexion(){welcomeText.setText("Connectez-vous!");}
}