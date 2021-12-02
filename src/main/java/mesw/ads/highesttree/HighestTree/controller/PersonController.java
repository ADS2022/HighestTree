package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.service.LocationService;
import mesw.ads.highesttree.HighestTree.service.PersonService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonController implements Initializable {
    @FXML
    private TextField fldLastName;

    @FXML
    private TextField fldFirstName;

    @FXML
    private TextField fldNationality;

    @FXML
    private TextArea fldDescription;

    @FXML
    private TextArea fldEvents;

    @FXML
    private TextArea fldParents;

    @FXML
    private TextArea fldSpouses;

    @FXML
    private TextArea fldSource;


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

    public void btnAddPersonPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding a new Person record");
        try {
            System.out.println("Adding a new Person record");
            String lastName = fldLastName.getText();
            String firstName = fldFirstName.getText();
            String nationality = fldNationality.getText();
            String description = fldDescription.getText();
            String events = fldEvents.getText();
            String parents = fldParents.getText();
            String spouses = fldSpouses.getText();
            String source = fldSource.getText();

            // Service saves location
            PersonService.save(lastName, firstName, nationality, events, source, description, parents, spouses, false);
            // Change to another scene
            changeScene("/fxml/PersonsView.fxml", actionEvent);

        } catch (Exception e) {
            e.printStackTrace();
            //this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }

    public void btnCancelPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Persons scene");
        changeScene("/fxml/PersonsView.fxml", actionEvent);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
