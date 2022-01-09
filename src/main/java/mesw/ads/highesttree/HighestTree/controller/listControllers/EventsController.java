package mesw.ads.highesttree.HighestTree.controller.listControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mesw.ads.highesttree.HighestTree.Main;
import mesw.ads.highesttree.HighestTree.controller.ListController;
import mesw.ads.highesttree.HighestTree.model.Event;
import mesw.ads.highesttree.HighestTree.model.database.export.ExportVisitor;
import mesw.ads.highesttree.HighestTree.service.EventService;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * 20/12/2021 LNeto
 * To implement the 'template' pattern, this class now
 * extends 'ListController.java'. This class is a ConcreteClass
 * in the 'template' pattern paradigm.
 */
public class EventsController extends ListController {
    private static final String VIEW = "fxml/EventsView.fxml";

    @FXML
    private TableView<Event> tableView;
    @FXML
    private TableColumn<Event, String> tableColName;

    @FXML
    private Button btnEventNew, btnEventEdit, btnEventDelete;


    // METHODS

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColName.setCellValueFactory(new PropertyValueFactory<Event, String>("Name"));
        tableView.getItems().setAll(parseEventList());
        showDetails(null);

        // Detects selection changes and shows the person's details when there is a change.
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

        btnEventNew.setVisible(!Main.isReadOnly);
        btnEventEdit.setVisible(!Main.isReadOnly);
        btnEventDelete.setVisible(!Main.isReadOnly);
    }

    private Collection<Event> parseEventList() {
        return EventService.getAllEvents();
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

    private void showDetails(Event event) {
        if (event != null) {
            gridLine1Label.setText(event.getName());
            gridLine2Label.setText(event.getStandardEvents().toString());
            gridLine3Label.setText(event.getDescription());
            gridLine4Label.setText(event.getSuperDate().returnDateString());
            gridLine5Label.setText(event.getLocation().getDescription());
            gridLine6Label.setText(event.getPersonsInvolved().toString());
            gridLine7Label.setText(event.getSource().toString());
            gridLine8Label.setText("");
            gridLine9Label.setText("");
        } else {
            gridLine1Label.setText("");
            gridLine2Label.setText("");
            gridLine3Label.setText("");
            gridLine4Label.setText("");
            gridLine5Label.setText("");
            gridLine6Label.setText("");
            gridLine7Label.setText("");
            gridLine8Label.setText("");
            gridLine9Label.setText("");
        }
    }

    public void btnExportToXML(ActionEvent actionEvent) {
        new ExportVisitor(3);
    }

    public void btnExportToCSV(ActionEvent actionEvent) {
        new ExportVisitor(6);
    }
}
