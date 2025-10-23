/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import com.mycompany.shoeshopsystem.data.AppQuery;
import com.mycompany.shoeshopsystem.model.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class SignInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private Button backBtn;
    
     @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button signButton;

    @FXML
    private TextField username;
    
    @FXML
    private void BackButton() throws IOException{
        App.setRoot("frontPage");
    }
    
    @FXML
    private void addUser() throws IOException{
        
        
        
        if(username.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Blank ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please ..Do not keep empty Fields !");
            Optional<ButtonType> option = alert.showAndWait();
            
        }else{
            
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Registration Confirmation");
            dialog.setHeaderText("Are you sure to SIGN IN ?");
            dialog.initModality(Modality.APPLICATION_MODAL);

            Label label = new Label("Username : "+username.getText()+" | "+"Email : "+email.getText()+" | "+"Password : "+password.getText());
            dialog.getDialogPane().setContent(label);

            ButtonType okbtn  = new ButtonType("OK",ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelbtn  = new ButtonType("CANCEL",ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().addAll(okbtn,cancelbtn);

            Optional<ButtonType> result = dialog.showAndWait();
            
            if(result.isPresent() && result.get() == okbtn){
            
                User  user = new User(username.getText(), email.getText(), password.getText());
                AppQuery query = new AppQuery();
                
                query.addUser(user);
                App.setRoot("login");
          
            }
        }
        
        
    }
    
    

    
    
}
