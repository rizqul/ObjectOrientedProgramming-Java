package tes.scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class tes extends Application {

    Stage prime;

    @Override
    public void start(Stage arg0) throws Exception {
        prime = arg0;
        prime.setTitle("tes");
        Label l1 = new Label("oi");
        VBox vb1 = new VBox();
        vb1.getChildren().add(l1);
        Scene s1 = new Scene(vb1, 200, 200);
        prime.setScene(s1);
        prime.show();



    }
    
    public static void main(String[] args) {
        launch(args);
    }
}