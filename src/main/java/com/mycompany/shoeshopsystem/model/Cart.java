/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoeshopsystem.model;

/**
 *
 * @author Abir Hasan
 */
public class Cart {
    
    private int cart_id;
    private String name;
    private String color;
    private String size;
    private String model;
    private int price;
    private String user;
    
    public Cart(int cart_id,String name,String color,String size,String model,int price,String user){
        this.cart_id = cart_id;
        this.name = name;
        this.color=color;
        this.size = size;
        this.model = model;
        this.price  =price;
        this.user = user;
    }
    
    public Cart(String name,String color,String size,String model,int price, String user){
     
        this.name = name;
        this.color=color;
        this.size = size;
        this.model = model;
        this.price  =price;
         this.user = user;
    }

    /**
     * @return the cart_id
     */
    public int getCart_id() {
        return cart_id;
    }

    /**
     * @param cart_id the cart_id to set
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    
        

    
}
