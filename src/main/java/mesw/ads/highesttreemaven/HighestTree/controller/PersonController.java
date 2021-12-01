package mesw.ads.highesttreemaven.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PersonController {

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }

    public void btnSceneHomePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Home scene");
        changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);
    }

    public void btnAddPersonPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding a new Person record");
    }

    public void btnCancelPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Persons scene");
        changeScene("/fxml/PersonsView.fxml", actionEvent);
    }


}
