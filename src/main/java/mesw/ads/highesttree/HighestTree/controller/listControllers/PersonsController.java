package mesw.ads.highesttree.HighestTree.controller.listControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mesw.ads.highesttree.HighestTree.Main;
import mesw.ads.highesttree.HighestTree.controller.ListController;
import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.model.database.export.ExportVisitor;
import mesw.ads.highesttree.HighestTree.service.PersonService;

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
public class PersonsController extends ListController {
    private static final String VIEW = "fxml/PersonsView.fxml";

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> tableColFirstName, tableColLastName;
    @FXML
    private Button btnPersonEdit, btnPersonDelete, btnPersonNew;

    // METHODS

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        tableColLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tableView.getItems().setAll(parsePersonList());
        showDetails(null);

        // Detects selection changes and shows the person's details when there is a change.
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

        btnPersonEdit.setVisible(!Main.isReadOnly);
        btnPersonDelete.setVisible(!Main.isReadOnly);
        btnPersonNew.setVisible(!Main.isReadOnly);
    }

    private Collection<Person> parsePersonList() {
        return PersonService.getAllPersons();
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

    private void showDetails(Person person) {
        if (person != null) {
            gridLine1Label.setText(person.getFirstName());
            gridLine2Label.setText(person.getLastName());
            gridLine3Label.setText(person.getNationality());
            gridLine4Label.setText(person.getSourceAsText());
            gridLine5Label.setText(person.getDescription());
            gridLine6Label.setText(person.getEventsAsText());
            gridLine7Label.setText(person.getPartnersAsText());
            gridLine8Label.setText(person.getParentsAsText());
            gridLine9Label.setText(person.getChildrenAsText());
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
        new ExportVisitor(1);
    }

    public void btnExportToCSV(ActionEvent actionEvent) {
        new ExportVisitor(4);
    }
}
