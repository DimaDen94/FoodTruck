package com.denejkodlj.foodtrack;

import com.orm.SugarRecord;

/**
 * Created by Dmitry on 09.10.2017.
 */

public class Dish extends SugarRecord {

    private String photo;
    private String title;
    private String ingredients;
    private int price;
    private int left;

    public Dish() {
    }

    public Dish(String photo, String title, String ingredients, int price, int left) {
        this.photo = photo;
        this.title = title;
        this.ingredients = ingredients;
        this.price = price;
        this.left = left;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}
