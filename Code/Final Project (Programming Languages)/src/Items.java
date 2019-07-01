/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hawlet
 */
public class Items {
    // Variables for Items class
    public String items, type;
    public int price;
    
    // Constructor for Items class
    public Items() {
        this.items = "";
        this.type = "";
        this.price = 0;
    }
    
    // Constructor with parameters for Items class
    public Items(String items, String type, int price){
        this.items = items;
        this.type = type;
        this.price = price;
    }
}