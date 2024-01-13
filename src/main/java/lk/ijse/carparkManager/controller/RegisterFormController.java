package lk.ijse.carparkManager.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.carparkManager.RegExPatterns.RegExPatterns;
import lk.ijse.carparkManager.bo.AddVehicleBo;
import lk.ijse.carparkManager.bo.BOFactory;
import lk.ijse.carparkManager.bo.UserBo;
import lk.ijse.carparkManager.dto.RegistrationDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;

public class RegisterFormController implements Initializable {

    public JFXButton accountCreated;
    public TextField user_id;
    @FXML
    private TextField confirm;

    @FXML
    private TextField email;

    @FXML
    private TextField first_name;

    @FXML
    private TextField mobile;

    @FXML
    private TextField password;

    @FXML
    private ChoiceBox<String> role;

    @FXML
    private TextField second_name;

    UserBo userBo = (UserBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    private final String[] roles = {"Attendant", "Manager"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(roles);
        generateId();
    }

    private void generateId() {
        try {
            String userId = userBo.generateNextUserId();
            user_id.setText(userId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void create_account(MouseEvent mouseEvent) throws Exception {
        String firstNameText = first_name.getText().trim().toLowerCase();
        String secondNameText = second_name.getText().trim().toLowerCase();
        String user_name = firstNameText + secondNameText;
        String emailText = email.getText();

        String mobileText = null;
        if (!mobile.getText().isEmpty()){
            mobileText = mobile.getText();
        }

        String passwordText = password.getText();
        String confirmText = confirm.getText();
        boolean isPasswordValid = RegExPatterns.getValidPassword().matcher(passwordText).matches();
        if (!isPasswordValid){
            new Alert(Alert.AlertType.ERROR,"Password need to contain minimum of four Characters").showAndWait();
            return;
        }
        if (first_name.getText().trim().isEmpty() || second_name.getText().trim().isEmpty() || email.getText().isEmpty() || mobile.getText().isEmpty() || password.getText().isEmpty() || confirm.getText().isEmpty() || role.getSelectionModel().getSelectedItem().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("All fields must not be empty!");
            alert.showAndWait();
        } else if (!(passwordText.equals(confirmText))) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error!");
            alert2.setContentText("Passwords do not match!");
            alert2.showAndWait();
        } else {
            Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
            alert3.setTitle("Successfully Saved!");
            alert3.setContentText(user_name + " is your username. Use it with your password to log into the system.");
            alert3.showAndWait();
            String jobRole = role.getSelectionModel().getSelectedItem();

            String userIdText = user_id.getText();
            RegistrationDTO registrationDTO = new RegistrationDTO(userIdText,firstNameText+" "+secondNameText, jobRole, emailText, mobileText, passwordText, user_name);
            userBo.save(registrationDTO);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));

            try {
                Parent root = fxmlLoader.load();

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.show();

                ((Stage) accountCreated.getScene().getWindow()).close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

