package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class UserDashboardController extends Controller {

    private Stage stage;
    private Parent root;
    private Scene scene;

    public void deposit(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/DepositView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void withdraw(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/WithdrawView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void transfer(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/TransferMoneyView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void balance(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/BalanceView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void loan(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/LoanView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void back(ActionEvent e) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../View/HomeView.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
