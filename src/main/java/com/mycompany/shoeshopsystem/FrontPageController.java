/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class FrontPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private Button adminBtn;

//    @FXML
//    private AnchorPane dashboard_panel;

    @FXML
    private Button logBtn;

//    @FXML
//    private AnchorPane panel_left_view;

    @FXML
    private Button signBtn;
    
    @FXML
    private void logInPage() throws IOException{
        App.setRoot("login");
    }
    
    @FXML
    private void signInPage() throws IOException{
        App.setRoot("signIn");
    }
    
    @FXML
    private void ControlPanel() throws IOException{
        App.setRoot("ControlAuth");
    }
}
