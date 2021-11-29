package mesw.ads.highesttreemaven.HighestTree.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mesw.ads.highesttreemaven.HelloApplication;


public class HomeController {
    @FXML
    private Button btnPersonsMenu, btnEventsMenu, btnPlacesMenu;

    public void goToPersonsMenu(ActionEvent actionEvent) throws IOException {

        //HERE WE ARE TRYING TO DEBUG THE PATH TO .FXML FILE
        /*HomeController shit = new HomeController();
        Class class1 = shit.getClass();
        URL url2 = class1.getResource("HomeController.java");
        System.out.println("Value URL = " + url2);*/



        if(actionEvent.getSource()==btnPersonsMenu){
            System.out.println("Changing to Persons scene");
            Stage stage = (Stage) btnPersonsMenu.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/PersonsView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (actionEvent.getSource()==btnEventsMenu){
            System.out.println("Changing to Events scene");

        }
        else if (actionEvent.getSource()==btnPlacesMenu){
            System.out.println("Changing to Places scene");

        }

    }


}
