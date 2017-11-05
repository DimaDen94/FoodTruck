package com.denejkodlj.foodtruck.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.denejkodlj.foodtruck.Data.Dish;
import com.denejkodlj.foodtruck.R;
import com.denejkodlj.foodtruck.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridLayoutManager mLayoutManager;
    private MainAdapter adapterMain;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterMain = new MainAdapter(this, loadDish());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterMain);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<Dish> loadDish() {
        List<Dish> dishes = new ArrayList<>();

        Dish dish1 = new Dish("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRogTFHRVpv8PxEbxqebAzMtSs_x8gIiuGVzxJsS1NZJ-ppGf_A", "плов", "рис, мясо куриное, сливочное масло", 19, 10,0);
        Dish dish2 = new Dish("https://i.ytimg.com/vi/CBzCYzU_78M/hqdefault.jpg", "пюре", "картошка, сливочное масло", 12, 10,0);
        Dish dish3 = new Dish("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHbcrH97hld1pihpY_EDa0839WkAKoqCt-4-oLlexURfEETjXbIQ", "гречка", "гречнивая каша, сливочное масло, овощи", 15, 10,0);
        Dish dish4 = new Dish("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUxTy9WNhtZGNJxAd19FNDttriXuk6FqJ2yiu8etkmNjaEyzFe", "макароны по флотски", "макароны, мясной фарш, сливочное масло", 30, 10,0);

        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);

        return dishes;
    }


}
