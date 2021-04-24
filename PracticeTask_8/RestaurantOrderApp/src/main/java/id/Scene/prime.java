package id.Scene;


import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class prime extends Application {

    //Visual Component
    TextField tFieldAmount1, tFieldAmount2, tFieldAmount3;
    Label nameLabel1, nameLabel2, nameLabel3, priceLabel1, priceLabel2, priceLabel3;
    GridPane gPane1, gPane2;
    Text appTitle;
    Scene sc1;
    VBox verBox1;
    Button confirmBtn, backBtn;
    Image image1, image2, image3;
    ImageView imageView1, imageView2, imageView3;

    //Algorithm Component
    int menu1Price = 15000;
    int menu2Price = 20000;
    int menu3Price = 30000;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primeStage) throws Exception {

        //App Title 
        appTitle = new Text("Menu Interface");
        appTitle.setFont(Font.font("arial",FontWeight.BOLD,FontPosture.ITALIC, 30));
        appTitle.setFill(Color.BLACK);

        //menu-1
        nameLabel1 = new Label("Fried Rice");
        priceLabel1 = new Label("(Rp. "+String.valueOf(menu1Price)+" / pcs)");
        tFieldAmount1 = new TextField();
        tFieldAmount1.setPromptText("amount");
        tFieldAmount1.setMaxWidth(60);
        nameLabel1.setMnemonicParsing(true);

        //menu-2
        nameLabel2 = new Label("Tuna Melt");
        priceLabel2 = new Label("(Rp. "+String.valueOf(menu2Price)+" / pcs)");
        tFieldAmount2 = new TextField();
        tFieldAmount2.setPromptText("amount");
        tFieldAmount2.setMaxWidth(60);
        nameLabel2.setMnemonicParsing(true);

        //menu-3
        nameLabel3 = new Label("Steak");
        priceLabel3 = new Label("(Rp. "+String.valueOf(menu3Price)+" / pcs)");
        tFieldAmount3 = new TextField();
        tFieldAmount3.setPromptText("amount");
        tFieldAmount3.setMaxWidth(60);
        nameLabel3.setMnemonicParsing(true);

        //button
        confirmBtn = new Button("confirm");
        confirmBtn.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent arg0) {

                var ref = new Object(){
                    Label price1Label = new Label();
                    Label price2Label = new Label();
                    Label price3Label = new Label();
                };

                int price1 = menu1Price;
                int price2 = menu2Price;
                int price3 = menu3Price;

                int tPrice1 = Integer.parseInt(0 + tFieldAmount1.getText());
                int tPrice2 = Integer.parseInt(0 + tFieldAmount2.getText());
                int tPrice3 = Integer.parseInt(0 + tFieldAmount3.getText());

                int total = price1 * tPrice1 + price2 * tPrice2 + price3 * tPrice3;

                ref.price1Label.setText(tPrice1 + "pcs ");
                ref.price2Label.setText(tPrice2 + "pcs ");
                ref.price3Label.setText(tPrice3 + "pcs ");

                gPane2 = new GridPane();
                gPane2.setAlignment(Pos.CENTER);

                gPane2.setVgap(5);
                gPane2.setHgap(5);

                gPane2.addColumn(0, new Label("Fried rice"), new Label("Tuna Melt"), new Label("Steak"));
                gPane2.addColumn(1, ref.price1Label, ref.price2Label, ref.price3Label);
                gPane2.addColumn(2, new Label("Rp. " + tPrice1*price1), new Label("Rp. " + tPrice2*price2), new Label("Rp. " + tPrice3*price3) );
                gPane2.add(new Label("total pembayaran"),0,3 );
                gPane2.add(new Label("Rp. " + total),2,3);

                backBtn = new Button("back");
                gPane2.add(backBtn, 2, 4);

                Stage scndStage = new Stage();
                scndStage.setTitle("Payment");
                scndStage.setResizable(false);
                scndStage.initModality(Modality.APPLICATION_MODAL);
                
                Scene sc2 = new Scene(gPane2, 300, 300);
                backBtn.setOnAction(e -> {
                    scndStage.close();
                });
                scndStage.setScene(sc2);
                scndStage.showAndWait();
            }
        });

        //image added
        image1 = new Image(new FileInputStream("index.jpg"));
        imageView1 = new ImageView(image1);
        imageView1.setFitHeight(60);
        imageView1.setFitWidth(60);

        image2 = new Image(new FileInputStream("index3.jpg"));
        imageView2 = new ImageView(image2);
        imageView2.setFitHeight(60);
        imageView2.setFitWidth(60);

        image3 = new Image(new FileInputStream("index2.jpg"));
        imageView3 = new ImageView(image3);
        imageView3.setFitHeight(60);
        imageView3.setFitWidth(60);

        //Positioning
        gPane1 = new GridPane();
        gPane1.setAlignment(Pos.CENTER);

        gPane1.setVgap(5);
        gPane1.setHgap(5);

        gPane1.add(imageView1, 0, 0);
        gPane1.add(nameLabel1, 1, 0);
        gPane1.add(tFieldAmount1, 2, 0);
        gPane1.add(priceLabel1, 3, 0);

        gPane1.add(imageView2, 0, 1);
        gPane1.add(nameLabel2, 1, 1);
        gPane1.add(tFieldAmount2, 2, 1);
        gPane1.add(priceLabel2, 3, 1);

        gPane1.add(imageView3, 0, 2);
        gPane1.add(nameLabel3, 1, 2);
        gPane1.add(tFieldAmount3, 2, 2);
        gPane1.add(priceLabel3, 3, 2);

        gPane1.add(confirmBtn, 3, 3);


        verBox1 = new VBox();
        verBox1.getChildren().addAll(appTitle,gPane1);
        verBox1.setAlignment(Pos.CENTER);

        

        //Final Step
        sc1 = new Scene(verBox1, 600, 300);
        primeStage.setScene(sc1);
        primeStage.setTitle("Menu App");
        primeStage.setResizable(false);
        primeStage.show();
    }
}