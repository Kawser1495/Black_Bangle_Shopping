/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import com.mycompany.shoeshopsystem.data.MyListener;
import com.mycompany.shoeshopsystem.model.Items;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class ItemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private ImageView img_view;

    @FXML
    private Text name_label;

    @FXML
    private Text price_label;
    
    private Items item;
    
    private MyListener myListener;
    
    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(item);
        
    }
    
    public void setData(Items item, MyListener myListener){
           this.item = item;
           this.myListener = myListener;
           name_label.setText(item.getName());
           price_label.setText(String.valueOf(item.getPrice()));
           
           String uri = "file:"+item.getImg();
            
           Image image = new Image(uri, 146, 133,false,true);
           img_view.setImage(image);
    }
    
}
