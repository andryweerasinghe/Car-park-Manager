package lk.ijse.carparkManager.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.carparkManager.bo.BOFactory;
import lk.ijse.carparkManager.bo.UserBo;
import lk.ijse.carparkManager.dto.LoginDTO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

        @FXML
        private Label register;

        @FXML
        private TextField username;
        @FXML
        private TextField password;

        UserBo userBo = (UserBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

        @FXML
        void Register(MouseEvent event) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/register_form.fxml"));
                try {
                        Parent root = fxmlLoader.load();

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);

                        // Show the signup form stage
                        stage.show();

                        // close the login form stage
                        ((Stage) register.getScene().getWindow()).close();
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

        }


        public void login(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
                String usernameText = username.getText();
                String passwordText = password.getText();

                LoginDTO loginDTO = new LoginDTO(usernameText, passwordText);

                boolean login = userBo.login(loginDTO);

                if (login) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation");
                        alert.setContentText("Login Successful!");

                        Timeline timeline = new Timeline(new KeyFrame(
                                Duration.seconds(0.8), // Adjust the duration as needed
                                event -> alert.close()));

                        // Set the cycle count to 1 so that the timeline stops after closing the alert
                        timeline.setCycleCount(1);

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main_form.fxml"));
                        try {
                                Parent root = fxmlLoader.load();

                                MainFormController mainFormController = fxmlLoader.getController(); // passing the values from the login form text fields to the main controller
                                LoginDTO loginDTO1 = userBo.getUserInfo(usernameText);
                                mainFormController.setUser(loginDTO1);

                                Stage stage = new Stage();
                                Scene scene = new Scene(root);
                                stage.setScene(scene);

                                // Show the signup form stage
                                stage.show();

                                // Show the alert
                                alert.show();

                                // Start the timeline to close the alert after the specified duration
                                timeline.play();

                                // close the login form stage
                                ((Stage) register.getScene().getWindow()).close();
                        } catch (IOException e) {
                                throw new RuntimeException(e);
                        }

                }
                else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!");
                        alert.setContentText("Invalid Authentication! Please try again");
                        alert.showAndWait();
                }
        }
    }


