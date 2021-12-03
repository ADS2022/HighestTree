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

public class LocationsController {
    @FXML
    private Button btnSceneHome, btnLocationNew, btnLocationEdit, btnLocationDelete;

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

    public void btnLocationNewPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding new Location record");
        changeScene("/fxml/LocationView.fxml", actionEvent);
    }

    public void btnLocationEditPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Editing location record");
        changeScene("/fxml/LocationView.fxml", actionEvent);
    }

    public void btnLocationDeletePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Deleting location record");
        //changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);

    }
}
