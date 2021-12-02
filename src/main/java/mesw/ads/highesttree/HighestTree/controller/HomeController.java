package mesw.ads.highesttree.HighestTree.controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class HomeController {
    @FXML
    private Button btnPersonsMenu, btnEventsMenu, btnPlacesMenu;

    public void goToPersonsMenu(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource()==btnPersonsMenu){
            System.out.println("Changing to Persons scene");
            changeScene("/fxml/PersonsView.fxml", actionEvent);
        }
        else if (actionEvent.getSource()==btnEventsMenu){
            System.out.println("Changing to Events scene");
            changeScene("/fxml/EventsView.fxml", actionEvent);
        }
        else if (actionEvent.getSource()==btnPlacesMenu){
            System.out.println("Changing to Places scene");
            changeScene("/fxml/LocationsView.fxml", actionEvent);
        }

    }

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }


}