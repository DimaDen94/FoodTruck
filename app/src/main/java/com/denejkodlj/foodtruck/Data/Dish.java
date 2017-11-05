package com.denejkodlj.foodtruck.Data;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * Created by Dmitry on 09.10.2017.
 */

public class Dish extends SugarRecord {


    private String photo;
    @Unique
    private String title;
    private String ingredients;
    private int price;
    private int left;
    private int count;


    public Dish() {
    }

    public Dish( String photo, String title, String ingredients, int price, int left, int count) {
        this.photo = photo;
        this.title = title;
        this.ingredients = ingredients;
        this.price = price;
        this.left = left;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
