/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.shoeshopsystem;

import com.mycompany.shoeshopsystem.data.AppQuery;
import com.mycompany.shoeshopsystem.model.Items;
import com.mycompany.shoeshopsystem.model.getData;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import com.mycompany.shoeshopsystem.ItemController;
import com.mycompany.shoeshopsystem.data.MyListener;
import com.mycompany.shoeshopsystem.model.Cart;
import com.mycompany.shoeshopsystem.model.Review;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
    
   */
    private Image image;
    private MyListener myListener;
    private Cart cart;
    
    private List<Items> item  = new ArrayList<>();
     
    @FXML
    private GridPane grid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          displayName();
          gridShow();
          showCartTable();
          COUNT();
          Amount();
          showReviewTable();
        
//        search_area.textProperty().addListener((ObservableList,oldValue,newValue)->{
//                filter(newValue);
//        });
        
    }    
    
    public void gridShow(){
        if(item.size()<0){
            setChoosenItem(item.get(0));
        }
        myListener = new MyListener(){
            @Override
            public void onClickListener(Items item){
                setChoosenItem(item);
            }
        };
        
      
        AppQuery query = new AppQuery();
        item.addAll(query.showItemsTable());
        
        int column =0;
        int row = 1;
        
        try{
            
            for(int i=0;i<item.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            
            fxmlLoader.setLocation(getClass().getResource("/com/mycompany/shoeshopsystem/item.fxml"));
            AnchorPane anchorpane = fxmlLoader.load();
            
            ItemController itemController = fxmlLoader.getController();
            itemController.setData(item.get(i), myListener);
            
            if(column==2){
                column = 0;
                row++;
            }
            
            grid.add(anchorpane,column++,row);
            
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);
            
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
            
            GridPane.setMargin(anchorpane, new Insets(10));
 
          }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private AnchorPane cart_anchor;

    @FXML
    private Button cart_btn;

    @FXML
    private TextArea feedback_box;

    @FXML
    private TableColumn<Review,String> feedback_comment;

    @FXML
    private TableColumn<Review,String> feedback_name;

    @FXML
    private Button feedback_send;

    @FXML
    private TableView<Review> feedback_table;
    
    @FXML
    private TableView<Cart> cart_table_view;
    
    @FXML
    private TableColumn<Cart,String> name_col;
    
    @FXML
    private TableColumn<Cart,String> model_col;
    
    @FXML
    private TableColumn<Cart,String> color_col;
    
    @FXML
    private TableColumn<Cart,String> size_col;
    
    @FXML
    private TableColumn<Cart,Integer> price_col;
    

    @FXML
    private AnchorPane home_anchor;

    @FXML
    private Button home_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane product_detail_anchor;

    @FXML
    private Text shoe_brand;

    @FXML
    private Button shoe_cart_btn;

    @FXML
    private Text shoe_category;

    @FXML
    private Text shoe_color;

    @FXML
    private Text shoe_model;

    @FXML
    private Text shoe_price_label;
    
    @FXML
    private Label count_cart;
    
    @FXML
    private Label id_label;
    
    @FXML
    private Text shoe_size;

    @FXML
    private Text shoe_status;

    @FXML
    private Text shoes_name_label;

    @FXML
    private Text userShowName;
    
    @FXML
    private Text bill_label;
    
    @FXML
    private TextField search_area;
    
     @FXML
    private TextField del_item_show;
    
    @FXML 
    private ScrollPane scrollpan;
    
    @FXML
    private ImageView shoe_img_view;
    
    @FXML
    private Button cashOnDev;
    
    @FXML
    private Button OnlinePayment;
    
    @FXML
    private void CashOnDelivery(){
        try{
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cash on Delivery Message");
                alert.setHeaderText(null);
                alert.setContentText("Congratulation, Your order placed successfully");
                Optional<ButtonType> option = alert.showAndWait();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void OnlinePayment(){
        try{
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Online Payment Message");
                alert.setHeaderText(null);
                alert.setContentText("Congratulation, Payment Done");
                Optional<ButtonType> option = alert.showAndWait();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @FXML
     private void showReviewTable(){
        
        AppQuery query = new AppQuery();
        ObservableList<Review> list = query.showReviewTable();
        
        feedback_name.setCellValueFactory(new PropertyValueFactory<Review,String>("username"));
        feedback_comment.setCellValueFactory(new PropertyValueFactory<Review,String>("comment"));
       
        
        feedback_table.setItems(list);
    }
    
    @FXML 
    private void AddReview(){
        try{
            
            AppQuery query = new AppQuery();
            Review review = new Review(getData.username,Integer.parseInt(id_label.getText()),feedback_box.getText());
            query.addReview(review);
            getData.seletcted_item = Integer.parseInt(id_label.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Review Message");
            alert.setHeaderText(null);
            alert.setContentText("Your Review Post Successfully");
            Optional<ButtonType> option = alert.showAndWait();
            
            feedback_box.clear();
            showReviewTable();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML 
    private void deleteCart(){
        AppQuery query = new AppQuery();
        cart  = new Cart(this.cart.getCart_id(),del_item_show.getText(),"" ,"" ,"" ,0,"");
        query.delCart(cart);
            Amount();
            COUNT();
            showCartTable();
            del_item_show.clear();
      
    }
    
    @FXML
    private void mouseClicked(MouseEvent e){
        try{
            
            Cart cart = (Cart) cart_table_view.getSelectionModel().getSelectedItem();
            cart = new Cart(cart.getCart_id(),cart.getName(),cart.getColor(),cart.getSize(),cart.getModel(),cart.getPrice(),cart.getUser());
            this.cart =cart;
            
            del_item_show.setText(cart.getName());
            
            
            
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    @FXML
    private void Amount(){
        AppQuery query = new AppQuery();
        int value = query.CountBill();
       bill_label.setText(String.valueOf(value));
    }
    
    @FXML
    private void COUNT(){
        AppQuery query = new AppQuery();
        int value = query.CountCart();
        count_cart.setText(String.valueOf(value));
    }
   
    
    @FXML
    private void setChoosenItem(Items item){
        
        getData.seletcted_item = 0;
        home_anchor.setVisible(false);
        product_detail_anchor.setVisible(true);
        cart_anchor.setVisible(false);
        
        shoes_name_label.setText(item.getName());
        shoe_status.setText(item.getStatus());
        shoe_size.setText(item.getSize());
        shoe_price_label.setText(String.valueOf(item.getPrice()));
        shoe_model.setText(item.getModel());
        shoe_color.setText(item.getColor());
        shoe_category.setText(item.getCategory());
        shoe_brand.setText(item.getBrand());
        
         String uri = "file:"+item.getImg();
            
        image = new Image(uri, 111, 117,false,true);
        shoe_img_view.setImage(image);
        
        id_label.setText(String.valueOf(item.getId()));
        showReviewTable();
        
    }
    
    @FXML
    private void logout(){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        
        try{
             if (option.get().equals(ButtonType.OK)) {
                 getData.username= "";
                 App.setRoot("frontPage");
             }
             
        }catch(Exception e){
            e.printStackTrace();
        }          
        
    }
    
    @FXML
    private void switchPanel(ActionEvent event){
        
         if (event.getSource() == home_btn) {
             
             home_anchor.setVisible(true);
             product_detail_anchor.setVisible(false);
             cart_anchor.setVisible(false);
             
         }else if(event.getSource() == cart_btn){
             
             home_anchor.setVisible(false);
             product_detail_anchor.setVisible(false);
             cart_anchor.setVisible(true);
             
         }
    }
    
    @FXML
    private void displayName(){
        String user = getData.username;
        userShowName.setText(user);
    }
    
    @FXML 
    private void AddCart(){
        try{
            
            AppQuery query = new AppQuery();
            Cart cart = new Cart(shoes_name_label.getText(),shoe_color.getText(),shoe_size.getText(),shoe_model.getText(),Integer.parseInt(shoe_price_label.getText()),getData.username);
            query.addCart(cart);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cart Message");
            alert.setHeaderText(null);
            alert.setContentText("New Cart Saved Successfully");
            Optional<ButtonType> option = alert.showAndWait();
            
            showCartTable();
            COUNT();
            Amount();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void showCartTable(){
        
        AppQuery query = new AppQuery();
        ObservableList<Cart> list = query.showCartTable();
        
        name_col.setCellValueFactory(new PropertyValueFactory<Cart,String>("name"));
        model_col.setCellValueFactory(new PropertyValueFactory<Cart,String>("model"));
        color_col.setCellValueFactory(new PropertyValueFactory<Cart,String>("color"));
        size_col.setCellValueFactory(new PropertyValueFactory<Cart,String>("size"));
        model_col.setCellValueFactory(new PropertyValueFactory<Cart,String>("model"));
        price_col.setCellValueFactory(new PropertyValueFactory<Cart,Integer>("price"));
        
        
        cart_table_view.setItems(list);
    }
    
}
