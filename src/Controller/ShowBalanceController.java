package Controller;

import Model.BankingModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ShowBalanceController implements Initializable {
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Label userBalance;
    @FXML
    private Label pendingBalance;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userBalance.setText(BankingModel.display(2));
        pendingBalance.setText(BankingModel.display(3));
    }
    public void back(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/UserDashboardView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
    }
}
