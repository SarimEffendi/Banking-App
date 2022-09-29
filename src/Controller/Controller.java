package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class  Controller {

    private Stage stage;
    private Parent root;
    private Scene scene;

    protected  void backToUserDashboard(ActionEvent e){
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/UserDashboardView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }




}
