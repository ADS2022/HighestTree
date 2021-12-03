package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonsController {
    @FXML
    private Button btnSceneHome, btnPersonNew, btnPersonEdit, btnPersonDelete;

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    public void btnSceneHomePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Home scene");
        changeScene("/mesw/ads/highesttree/HighestTree/HomeView.fxml", actionEvent);
    }

    public void btnPersonNewPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding new Person record");
        changeScene("/fxml/PersonView.fxml", actionEvent);
    }

    public void btnPersonEditPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Editing person record");
        changeScene("/fxml/PersonView.fxml", actionEvent);
    }

    public void btnPersonDeletePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Deleting person record");
        //changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);

    }
}
