/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoeshopsystem.data;
import com.mycompany.shoeshopsystem.App;
import com.mycompany.shoeshopsystem.model.Cart;
import com.mycompany.shoeshopsystem.model.User;
import com.mycompany.shoeshopsystem.model.Items;
import com.mycompany.shoeshopsystem.model.Review;
import com.mycompany.shoeshopsystem.model.getData;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
/**
 *
 * @author Abir Hasan
 */
public class AppQuery {
    private DbConnection c = new DbConnection();
    
        public ObservableList<Review> showReviewTable(){
            ObservableList<Review> reviewList = FXCollections.observableArrayList();
            try{
                String sql = "select * from review where item_id="+getData.seletcted_item+" order by id desc";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Review x;
                while(rs.next()){
                    x = new Review(
                                rs.getInt("id"),
                                rs.getString("user_name"),
                                rs.getInt("item_id"),
                                rs.getString("comment")
                               
                               );
                               
                    reviewList.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return reviewList;
    }
    
    public void addReview(Review review){
        try{
            c.getDBConn();
            
            java.sql.PreparedStatement ps=  c.getCon().prepareStatement("insert into review(user_name,item_id,comment) values(?,?,?)");
            
            ps.setString(1,review.getUsername());
            ps.setString(2,String.valueOf(review.getItem_id()));
            ps.setString(3,review.getComment());
           

            ps.execute();
            ps.close();
            
            c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void delCart(Cart cart){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("delete from cart where cart_id=?");
            
            ps.setInt(1,cart.getCart_id());
            
            ps.execute();
            
            ps.close();
            c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public int CountBill(){
        int Bill = 0;
        try{
            
             String sql = "SELECT SUM(price) AS bill FROM cart where user='"+getData.username+"'";
               
             c.getDBConn();
             Statement st = c.getCon().createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             if (rs.next()) {
                Bill = rs.getInt("bill");
            }
            
           rs.close();
           st.close();
           c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return Bill;
    }
    
    public int CountCart(){
        int count= 0;
        try{
            
             String sql = "SELECT COUNT(cart_id) AS Total FROM cart WHERE user='"+getData.username+"'";
               
             c.getDBConn();
             Statement st = c.getCon().createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             if (rs.next()) {
                count = rs.getInt("Total");
            }
            
           rs.close();
           st.close();
           c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
    
    public ObservableList<Cart> showCartTable(){
            ObservableList<Cart> cartList = FXCollections.observableArrayList();
            try{
                String sql = "select * from cart where user='"+getData.username+"' order by cart_id desc";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Cart x;
                while(rs.next()){
                    x = new Cart(
                                rs.getInt("cart_id"),
                                rs.getString("name"),
                                rs.getString("color"),
                                rs.getString("size"),
                                rs.getString("model"),
                                rs.getInt("price"),
                                rs.getString("user")
                               );
                               
                    cartList.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return cartList;
    }
    
     public void addCart(Cart cart){
        try{
            c.getDBConn();
            
            java.sql.PreparedStatement ps=  c.getCon().prepareStatement("insert into cart(name,color,size,model,price,user) values(?,?,?,?,?,?)");
            
            ps.setString(1,cart.getName());
            ps.setString(2,cart.getColor());
            ps.setString(3,cart.getSize());
            ps.setString(4,cart.getModel());
            ps.setInt(5,cart.getPrice());
            ps.setString(6,cart.getUser());

            ps.execute();
            ps.close();
            
            c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void delItem(Items item){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("delete from items where id=?");
            
            ps.setInt(1,item.getId());
            
            ps.execute();
            
            ps.close();
            c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ObservableList<Items> showItemsTable(){
            ObservableList<Items> shoe = FXCollections.observableArrayList();
            try{
                String sql = "select * from items order by id desc";
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Items i;
                while(rs.next()){
                    i = new Items(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("model"),
                                rs.getString("brand"),
                                rs.getInt("price"),
                                rs.getString("category"),
                                rs.getString("status"),
                                rs.getString("size"),
                                rs.getString("color"),
                                rs.getString("img")
                               );
                               
                    shoe.add(i);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return shoe;
    }
    
    public void addShoe(Items shoe){
        try{
            c.getDBConn();
            
            java.sql.PreparedStatement ps=  c.getCon().prepareStatement("insert into items(name,model,brand,price,category,status,size,color,img) values(?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,shoe.getName());
            ps.setString(2,shoe.getModel());
            ps.setString(3,shoe.getBrand());
            ps.setString(4,String.valueOf(shoe.getPrice()));
            ps.setString(5,shoe.getCategory());
            ps.setString(6,shoe.getStatus());
            ps.setString(7,shoe.getSize());
            ps.setString(8,shoe.getColor());
            ps.setString(9,shoe.getImg());

            ps.execute();
            ps.close();
            
            c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addUser(User user){
        try{
            
            c.getDBConn();
            
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("insert into users(username,email,password) values(?,?,?)");
            
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            
            ps.execute();
            ps.close();
            
            c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public void Login(User user){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            
            ResultSet r = ps.executeQuery();
            if(r.next()){
                getData.loginStatus = true;
            }else{
                Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Wrong Credential");
                alert.showAndWait();
                
                getData.loginStatus = false;
                
            }
            ps.close();
            
            c.closeConnection();
            
          
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
