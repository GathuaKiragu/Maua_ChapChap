package com.example.kiragu.maua_chapchap.model;

/**
 * Created by gathua on 9/19/17.
 */

public class Products {

    public String product_name;
    public String category;
    public String image;
    public int quantity;
    public String description;
    public int price;

    public Products() {
    }

    public Products(String product_name, String description, String category, String image, int quantity, int price) {
        this.product_name = product_name;
        this.description = description;
        this.category = category;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
//    category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

//    Image
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

//    Image
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//    Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
//Price
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
