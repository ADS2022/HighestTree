package mesw.ads.highesttree.HighestTree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import mesw.ads.highesttree.HighestTree.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    private static final String ERROR_SCREEN = "/fxml/errorScreen1.fxml";

    @FXML
    private Button btnPersonsMenu, btnEventsMenu, btnPlacesMenu, btnQueriesMenu;

    @FXML
    private ToggleButton tglBtnReadOnly;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tglBtnReadOnly.setSelected(Main.isReadOnly);
        setToggleButtonText();

        tglBtnReadOnly.selectedProperty().addListener((observableValue, oldValue, newValue) ->
        {
            Main.isReadOnly = newValue;
            setToggleButtonText();
        });
    }

    private void setToggleButtonText() {
        if (Main.isReadOnly) {
            tglBtnReadOnly.setText("Read-only mode is on");
        } else {
            tglBtnReadOnly.setText("Read-only mode is off");
        }
    }

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        try {
            if (actionEvent.getSource() == btnPersonsMenu) {
                System.out.println("Changing to Persons scene");
                changeScene("/fxml/PersonsView.fxml", actionEvent);
            } else if (actionEvent.getSource() == btnEventsMenu) {
                System.out.println("Changing to Events scene");
                changeScene("/fxml/EventsView.fxml", actionEvent);
            }
            else if (actionEvent.getSource()==btnPlacesMenu){
                System.out.println("Changing to Places scene");
                changeScene("/fxml/LocationsView.fxml", actionEvent);
            }else if (actionEvent.getSource()==btnQueriesMenu){
                System.out.println("Changing to Queries scene");
                changeScene("/fxml/QueriesView.fxml", actionEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.changeScene(ERROR_SCREEN, actionEvent);
        }

    }

    public void changeScene(String SceneName, ActionEvent event) throws IOException {
        Parent MainSceneParent = FXMLLoader.load(getClass().getResource(SceneName));
        Scene MainScene = new Scene(MainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(MainScene);
        window.show();
    }



}
