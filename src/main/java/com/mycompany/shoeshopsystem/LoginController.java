/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import com.mycompany.shoeshopsystem.model.User;
import com.mycompany.shoeshopsystem.data.AppQuery;
import com.mycompany.shoeshopsystem.model.getData;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField password;
    
    @FXML
    private Button backBtn;
    

    @FXML
    private TextField username;
    
    @FXML
    private void backButton() throws IOException{
        App.setRoot("frontPage");
    }
    
    @FXML
    private void login() throws IOException{
        
        AppQuery query =new  AppQuery();
        User user = new User(username.getText(),password.getText());
        
        if(username.getText().isEmpty() || password.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Blank ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please ..Fill the blank fields");
            Optional<ButtonType> option = alert.showAndWait();
            
        }else{
            
            query.Login(user);
            
            if(getData.loginStatus){
                 getData.username = username.getText();                       
                App.setRoot("dashboard");
            }
                 
        }
        
        
    }
    
}
