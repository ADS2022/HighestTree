package mesw.ads.highesttree.HighestTree.controller.recordControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.service.EventService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EventController implements Initializable {
    private static final String ERROR_SCREEN = "/fxml/errorScreen1.fxml";

    @FXML
    public TextField fldLoc;

    @FXML
    private TextField fldName;

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

    @FXML
    ChoiceBox cbEventType = new ChoiceBox();
    //TODo: get observable list to pass ENUM from 'Events' to thecbEventType
    // ObservableList<String> list = new ObservableList<String>();

    @FXML
    public ChoiceBox isSensitive;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.fillComboBox();
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
    //'Is sensitive info' Choisebox
    private void fillComboBox() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Block info to users"); //TRUE
        list.add("Show info to users");  //FALSE
        ObservableList<String> sensitiveLevels = FXCollections.observableArrayList(list);
        this.isSensitive.setItems(sensitiveLevels);
    }

    public void btnAddEventPress(ActionEvent actionEvent) throws IOException {
        try {
            System.out.println("Adding a new Event record");

            String name = fldName.getText();
            String place = fldLoc.getText();
            String startDate = fldStartDate.getText();
            String endDate = fldEndDate.getText();
            String description = fldDescription.getText();
            String persons = fldPersons.getText();
            String source = fldSource.getText();
            Boolean sensitive = isSensitive.equals("Block info to users");

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
