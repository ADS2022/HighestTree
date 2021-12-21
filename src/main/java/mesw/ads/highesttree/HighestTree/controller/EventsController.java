package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.model.Event;
import mesw.ads.highesttree.HighestTree.model.Location;
import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.service.EventService;
import mesw.ads.highesttree.HighestTree.service.LocationService;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class EventsController {
    @FXML
    private TableView<Event> tableView;

    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private Label nameCol, nameLabel, descriptionCol,
            descriptionLabel, dateCol, dateLabel, placeCol,
            placeLabel, personsLabel, sourceLabel,
            personsCol, sourceCol;

    @FXML
    private Button btnSceneHome, btnEventNew, btnEventEdit, btnEventDelete;

    private Collection<Event> parseEventList() {
        return EventService.getAllEvents();
    }

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

    public void btnEventNewPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Adding new Event record");
        changeScene("/fxml/EventView.fxml", actionEvent);
    }

    public void btnEventEditPress(ActionEvent actionEvent) throws IOException {
        System.out.println("Editing event record");
        changeScene("/fxml/EventView.fxml", actionEvent);
    }

    public void btnEventDeletePress(ActionEvent actionEvent) throws IOException {
        System.out.println("Deleting event record");
        //changeScene("/mesw/ads/highesttreemaven/HomeView.fxml", actionEvent);

    }


    //TODO: Events controller is asking for a interface
    //@Override
    public void initialize(URL event, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("Name"));
        tableView.getItems().setAll(parseEventList());
        showPersonDetails(null);

        // Detects selection changes and shows the person's details when there is a change.
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }


    private void showPersonDetails(Event event) {
        if (event != null) {
            nameLabel.setText(event.getName());
            descriptionLabel.setText(event.getDescription());
            dateLabel.setText(event.getSuperDate().returnDateString());
            placeLabel.setText(event.getPlace().getDescription());
            personsLabel.setText(event.getPersonsInvolved().toString());
            sourceLabel.setText(event.getSource().toString());
        } else {
            nameLabel.setText("");
            descriptionLabel.setText("");
            dateLabel.setText("");
            placeLabel.setText("");
            personsLabel.setText("");
            sourceLabel.setText("");
        }
    }
}
