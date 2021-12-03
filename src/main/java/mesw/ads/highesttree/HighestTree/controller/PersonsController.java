package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.model.Person;
import mesw.ads.highesttree.HighestTree.service.PersonService;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class PersonsController implements Initializable {
    @FXML
    private Button btnSceneHome, btnPersonNew, btnPersonEdit, btnPersonDelete;

    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> colFirstName;
    @FXML private TableColumn<Person, String> colLastName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tableView.getItems().setAll(parsePersonList());
    }

    private Collection<Person> parsePersonList() {
        return PersonService.getAllPersons();
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
