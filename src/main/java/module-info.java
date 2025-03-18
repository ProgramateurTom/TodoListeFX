module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens appli.todolistfx to javafx.fxml;
    exports appli.todolistfx;
    exports appli.todolistfx.accueil;
    opens appli.todolistfx.accueil to javafx.fxml;
}