/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import com.mycompany.shoeshopsystem.data.MyListener;
import com.mycompany.shoeshopsystem.model.Items;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.lang.String;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class ControlAuthController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
      @FXML
    private TextField admin_id;

    @FXML
    private Button backBtn;

    @FXML
    private TextField passkey;

    @FXML
    private Button verify;
    
    @FXML
    private void BackButton() throws IOException{
        App.setRoot("frontPage");
    }
    
    @FXML
    private void verify() throws IOException{
        
           if(Check(admin_id.getText(),passkey.getText())){
                App.setRoot("controlPanel");
           }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Admin ID and PassKey. Try Again ...");
                Optional<ButtonType> option = alert.showAndWait();
           }
           
    }
    
    public boolean Check(String x,String y){

        return "iubat2025".equals(x) && "22203".equals(y);
 
    }
    
}
