package id.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TextReaderApp extends Application {

    // Visual Component
    Stage searchStage;
    Scene primeScene;
    Button selectButton;
    TextArea textShow;
    FileChooser textChooser;
    FileChooser.ExtensionFilter textChoserFilter;


    VBox mainLayout;
    File selectedFile;

    //Data Component
    String textRead;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Text Area
        textShow = new TextArea();
        textShow.setEditable(false);

        //Button
        selectButton = new Button("Select File");
        selectButton.setOnAction(click -> {
            try {
                textRead = choseAndReadTextFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            textShow.setText(textRead);
        });

        //Positioning
        mainLayout = new VBox();
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(selectButton, textShow);

        primeScene = new Scene(mainLayout, 400,400);

        primaryStage.setScene(primeScene);
        primaryStage.setTitle("Read txt file");
        primaryStage.show();


    }

    public String choseAndReadTextFile() throws FileNotFoundException {
        textChooser = new FileChooser();
        textChoserFilter = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        textChooser.setTitle("Open Text File");
        selectedFile = textChooser.showOpenDialog(searchStage = new Stage());

        Scanner sc = new Scanner(selectedFile);
        String text = "";

        while (sc.hasNextLine()) {
            text += sc.nextLine() + "\n";
        }

        sc.close();

        return text;
    }
    
}