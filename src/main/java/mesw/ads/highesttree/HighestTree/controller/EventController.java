package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.service.EventService;

import java.io.IOException;

public class EventController {
    private static final String ERROR_SCREEN = "/fxml/errorScreen1.fxml";

    @FXML
    private TextField fldName;
    @FXML
    private TextArea fldPlace;
    @FXML
    private Text fldStartDate;
    @FXML
    private Text fldEndDate;
    @FXML
    private TextArea fldDescription;
    @FXML
    private TextArea fldPersons;
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

    public void btnAddEventPress(ActionEvent actionEvent) throws IOException {
        try {
            System.out.println("Adding a new Event record");

            String name = fldName.getText();
            String place = fldPlace.getText();
            String startDate = fldStartDate.getText();
            String endDate = fldEndDate.getText();
            String description = fldDescription.getText();
            String persons = fldPersons.getText();
            String source = fldSource.getText();

            EventService.save(name, place, startDate, endDate, description, persons, source);
            changeScene("/fxml/EventsView.fxml", actionEvent);
        } catch (Exception e){
            e.printStackTrace();
            this.changeScene(ERROR_SCREEN, actionEvent);
        }
    }

    public void btnCancelPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Changing to Events scene");
        changeScene("/fxml/EventsView.fxml", actionEvent);
    }


}
