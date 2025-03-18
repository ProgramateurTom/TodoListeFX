module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens appli.todolistfx to javafx.fxml;
    exports appli.todolistfx;
    exports appli.accueil;
    opens appli.accueil to javafx.fxml;
    exports appli;
    opens appli to javafx.fxml;
    exports appli.todolistfx.accueil;
    opens appli.todolistfx.accueil to javafx.fxml;
}