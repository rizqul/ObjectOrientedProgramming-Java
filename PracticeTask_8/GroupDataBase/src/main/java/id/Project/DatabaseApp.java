package id.Project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DatabaseApp extends Application {
    //Visual Component
    GridPane primeLayOut, groupPane, dataPane;
    VBox groupVbox, dataVbox;
    Label group1Label, group2Label, group3Label, group4Label, nameLabel, nimLabel, genderLabel;
    RadioButton group1RadioButton, group2RadioButton, group3RadioButton, group4RadioButton, maleRadioButton, femaleRadioButton;
    Button saveButton;
    Text groupText, dataText;
    TextField nameField, nimField;
    Scene primaryScene;
    ToggleGroup groupToggle, genderToggle;
    Alert alertSection;

    //Data Component
    String data = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        Group Section
            -Text 
            -Radio Button
            -Positioning
        **/

        //Text
        groupText = new Text("Kelompok");

        //Radio Button
        group1RadioButton = new RadioButton("Kelompok 1");
        group2RadioButton = new RadioButton("Kelompok 2");
        group3RadioButton = new RadioButton("Kelompok 3");
        group4RadioButton = new RadioButton("Kelompok 4");

        groupToggle = new ToggleGroup();
        
        group1RadioButton.setToggleGroup(groupToggle);
        group2RadioButton.setToggleGroup(groupToggle);
        group3RadioButton.setToggleGroup(groupToggle);
        group4RadioButton.setToggleGroup(groupToggle);

        //Positioning
        groupPane = new GridPane();
        groupVbox = new VBox();

        groupPane.setAlignment(Pos.CENTER);
        groupVbox.setAlignment(Pos.CENTER);

        groupPane.setHgap(5);
        groupPane.setVgap(5);

        groupPane.addRow(0, group1RadioButton, group2RadioButton);
        groupPane.addRow(1, group3RadioButton, group4RadioButton);

        groupVbox.getChildren().addAll(groupText, groupPane);
        groupVbox.setStyle("-fx-border-color: #ff0000;");



        /*
        Data Section
            -Text & Label
            -Radio Button
            -Text Field
            -Positioning
        **/

        //Text & Label
        dataText = new Text("Data");

        nimLabel = new Label("NIM");
        nameLabel = new Label("Nama");
        genderLabel = new Label("Jenis Kelamin");

        //Radio Button
        maleRadioButton = new RadioButton("Laki-Laki");
        femaleRadioButton = new RadioButton("Perempuan");

        genderToggle = new ToggleGroup();

        maleRadioButton.setToggleGroup(genderToggle);
        femaleRadioButton.setToggleGroup(genderToggle);

        //Text Field
        nimField = new TextField();
        nameField = new TextField();

        //Positioning
        dataPane = new GridPane();
        dataVbox = new VBox();

        dataPane.setAlignment(Pos.CENTER);
        dataVbox.setAlignment(Pos.CENTER);

        dataPane.setHgap(5);
        dataPane.setVgap(5);

        dataPane.addColumn(0, nimLabel, nameLabel, genderLabel);
        dataPane.addColumn(1, nimField, nameField, maleRadioButton,femaleRadioButton);

        dataVbox.getChildren().addAll(dataText, dataPane);
        dataVbox.setStyle("-fx-border-color: #ff0000;");

        /*
        Final Section
        -Alert
            -Button
            -Positioning
        **/

        //Alert
        alertSection = new Alert(AlertType.NONE);

        //Button
        saveButton = new Button("Save");
        saveButton.setMinSize(80, 40);
        saveButton.setOnAction(e -> {
                //Problem Action
            if (groupToggle.getSelectedToggle() == null )
            {
                alertSection.setAlertType(AlertType.WARNING);
                alertSection.setContentText("Anda Belum Memilih Kelompok");
                alertSection.show();
            } else if(nimField.getText().isEmpty())
            {
                alertSection.setAlertType(AlertType.WARNING);
                alertSection.setContentText("Anda Belum Mengisi NIM Anda");
                alertSection.show();
            } else if(nameField.getText().isEmpty())
            {
                alertSection.setAlertType(AlertType.WARNING);
                alertSection.setContentText("Anda Belum Mengisi Nama Anda");
                alertSection.show();
            } else if(genderToggle.getSelectedToggle() == null)
            {
                alertSection.setAlertType(AlertType.WARNING);
                alertSection.setContentText("Anda Belum Memilih Gender Anda");
                alertSection.show();
            }

                //NoProblem Action
            else{
                RadioButton selectedGroup = (RadioButton) groupToggle.getSelectedToggle();
                RadioButton selectedGender = (RadioButton) genderToggle.getSelectedToggle();

                data += "Nama : " + nameField.getText() + "\n";
                data += "NIM : " + nimField.getText() + "\n";
                data += "Jenis Kelamin : " + selectedGender.getText() + "\n";
                data += "Kelompok  : " + selectedGroup.getText().charAt(selectedGroup.getText().length() - 1) + "\n";

                alertSection.setAlertType(AlertType.INFORMATION);
                alertSection.setHeaderText("Information");
                alertSection.setContentText(data);
                alertSection.show();
            }

        });


        //Positioning
        primeLayOut = new GridPane();

        primeLayOut.setAlignment(Pos.CENTER);

        primeLayOut.setHgap(20);
        primeLayOut.setVgap(20);

        primeLayOut.add(groupVbox, 0, 0);
        primeLayOut.add(dataVbox, 1, 0);
        primeLayOut.add(saveButton, 1, 1);

        primaryScene = new Scene(primeLayOut, 600, 300);

        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Data Collect");
        primaryStage.show();

    }
}