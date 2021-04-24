package id.scene;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class scene1 extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        Label l1 = new Label("hello");

        VBox vb1 = new VBox();
        vb1.getChildren().add(l1);
        vb1.setAlignment(Pos.CENTER);

        Scene sc1 = new Scene(vb1, 200, 200);
        arg0.setScene(sc1);
        arg0.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}