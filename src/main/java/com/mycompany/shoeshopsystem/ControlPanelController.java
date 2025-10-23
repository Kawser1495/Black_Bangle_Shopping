/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import com.mycompany.shoeshopsystem.data.AppQuery;
import com.mycompany.shoeshopsystem.model.Items;
import com.mycompany.shoeshopsystem.model.getData;
import java.io.IOException;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class ControlPanelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showShoesTable();
        

        delBtn.setDisable(true);
    }
    
    @FXML
    private Button addBtn;
    
    @FXML
    private Button clear;

    @FXML
    private TextField brand;

    @FXML
    private TextField category;

    @FXML
    private TextField color;

    @FXML
    private Button delBtn;

    @FXML
    private Button fileBtn;

    @FXML
    private ImageView img_view;

    @FXML
    private AnchorPane main_frame;

    @FXML
    private TextField model;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField size;

    @FXML
    private RadioButton stockIn;

    @FXML
    private RadioButton stockOut;
    
    @FXML
    private TableView table_view;

    @FXML
    private TableColumn<Items, String> table_category;

    @FXML
    private TableColumn<Items, Integer> table_id;

    @FXML
    private TableColumn<Items, String> table_name;

    @FXML
    private TableColumn<Items, Integer> table_price;

    @FXML
    private TableColumn<Items, String> table_status;

   
    
    @FXML
    private Image image;
    
    @FXML
    private Button backBtn;
    
    private Items item;
    
    @FXML
    private void backButton() throws IOException {
        App.setRoot("frontPage");
    }
    
    @FXML 
    private void deleteItem(){
        AppQuery query = new AppQuery();
        Items i = new Items(this.item.getId(),name.getText(),
                    model.getText(),
                    brand.getText(),
                    Integer.parseInt(price.getText()),
                    category.getText(),
                    stockIn.getText(),
                    size.getText(),
                    color.getText(),
                    getData.Path);
        query.delItem(i);

        clear();
        showShoesTable();
    }
    
    @FXML
    private void mouseClicked(MouseEvent e){
        try{
            
            Items item = (Items) table_view.getSelectionModel().getSelectedItem();
            item = new Items(item.getId(),item.getName(),item.getModel(),item.getBrand(),item.getPrice(),item.getCategory(),item.getStatus(),item.getSize(),item.getColor(),item.getImg());
            this.item =item;
            
            name.setText(item.getName());
            model.setText(item.getModel());
            price.setText(String.valueOf(item.getPrice()));
            size.setText(item.getSize());;
            category.setText(item.getCategory());;
            brand.setText(item.getBrand());
            color.setText(item.getColor());
            
            String uri = "file:"+item.getImg();
            
            image = new Image(uri, 149, 131,false,true);
            img_view.setImage(image);
            
            if(item.getStatus()=="In Stock"){
                stockIn.setSelected(true);
            }else{
                stockOut.setSelected(false);
            }

           
            delBtn.setDisable(false);
            addBtn.setDisable(true);
            
            
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    @FXML
    private void ImportImage(){
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*jpg","*png","*jpeg"));
        File file = open.showOpenDialog(main_frame.getScene().getWindow());
        
        if(file != null){
            getData.Path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 149, 131, false, true);
            img_view.setImage(image);
        }
        
    }
    
    @FXML
    public void clear(){
        name.clear();
        model.clear();
        price.clear();
        size.clear();
        category.clear();
        brand.clear();
        color.clear();
        img_view.setImage(null);
        getData.Path = "";
        stockIn.setSelected(false);
        stockOut.setSelected(false);
        
        delBtn.setDisable(true);
        addBtn.setDisable(false);
   
    }
    
    @FXML
    private void addShoe(){
        
           String uri = getData.Path;
           uri = uri.replace("\\","\\\\");
        
            AppQuery query = new AppQuery();
            
            String Status;
            
            if(stockIn.isSelected()){
                Status = "In Stock";
            }else{
                Status = "Stock Out";
            }
            
            Items shoe = new Items(name.getText(),
                    model.getText(),
                    brand.getText(),
                    Integer.parseInt(price.getText()),
                    category.getText(),
                    Status,
                    size.getText(),
                    color.getText(),
                    uri
            );
            
            if(name.getText().isEmpty() || 
                    model.getText().isEmpty() || 
                    brand.getText().isEmpty() || 
                    category.getText().isEmpty() || 
                    Status.isEmpty() ||
                    price.getText().isEmpty() ||
                    size.getText().isEmpty() ||
                    color.getText().isEmpty()){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Blank ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please ..Fill the blank fields");
                Optional<ButtonType> option = alert.showAndWait();
                
            }else{
                
                query.addShoe(shoe);
                clear();
                showShoesTable();
            }
        
    }
    
    @FXML
    private void showShoesTable(){
        
        AppQuery query = new AppQuery();
        ObservableList<Items> list = query.showItemsTable();
        
        table_id.setCellValueFactory(new PropertyValueFactory<Items,Integer>("id"));
        table_name.setCellValueFactory(new PropertyValueFactory<Items,String>("name"));
        table_price.setCellValueFactory(new PropertyValueFactory<Items,Integer>("price"));
        table_category.setCellValueFactory(new PropertyValueFactory<Items,String>("category"));
        table_status.setCellValueFactory(new PropertyValueFactory<Items,String>("status"));
        
        table_view.setItems(list);
    }
    
    
    
}
